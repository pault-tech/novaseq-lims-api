using NovaSeqLimsTool.HttpExtensions;
using NovaSeqLimsTool.Model;
using NovaSeqLimsTool.POCOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Input;

namespace NovaSeqLimsTool.ViewModels
{
    public class RunAllViewModel : ViewModelBase
    {
        #region Fields
        private CancellationTokenSource _cts;
        private string _currentDto;
        private string _flowCellId;
        private string _librarySerialNumber;
        private int _currentCycle;
        private SequencingRunStatus _endingStatus;
        private bool _running;
        private string _recipeDtoValidationResult;
        private string _runMode;
        #endregion

        #region Properties
        public string CurrentDto
        {
            get => _currentDto;
            set => SetProperty(ref _currentDto, value);
        }

        public string FlowCellId
        {
            get => _flowCellId;
            set => SetProperty(ref _flowCellId, value);
        }

        public string LibrarySerialNumber
        {
            get => _librarySerialNumber;
            set => SetProperty(ref _librarySerialNumber, value);
        }

        public SequencingRunStatus EndingStatus
        {
            get => _endingStatus;
            set => SetProperty(ref _endingStatus, value);
        }

        public bool Running
        {
            get => _running;
            set => SetProperty(ref _running, value);
        }

        public string RecipeDtoValidationResult
        {
            get => _recipeDtoValidationResult;
            set => SetProperty(ref _recipeDtoValidationResult, value);
        }

        public string RunMode
        {
            get => _runMode;
            set => SetProperty(ref _runMode, value);
        }

        public IEnumerable<string> SupportedModes => Enum.GetNames(typeof(InstrumentModes)).Where(n => n != InstrumentModes.Undefined.ToString());
        #endregion

        #region ICommands
        public ICommand StartRunningCommand => new AsyncCommand(StartOperation, () => Running == false);
        public ICommand StopRunningCommand => new AsyncCommand(StopOperation, () => Running == true);
        #endregion

        #region Constructor
        public RunAllViewModel(LimsService state) : base(state)
        {
            _cts = new CancellationTokenSource();

            RunMode = InstrumentModes.S4.ToString();
        }
        #endregion

        #region Methods
        private async Task StopOperation()
        {
            Running = false;
            _cts.Cancel();
        }

        private async Task StartOperation()
        {
            try
            {
                Running = true;
                var token = _cts.Token;
                _currentCycle = 0;

                var client = HttpClientExtensions.GetAuthenticatedClient(_service.LimsToken);

                token.ThrowIfCancellationRequested();

                var reagents = LimsService.GetReagents(RunMode);
                var recipeResponse = await _service.GetRecipeDto(FlowCellId, LibrarySerialNumber, reagents, token);
                var recipeValidationErrors = await _service.ValidateRecipe();
                if (recipeValidationErrors.Count > 0)                
                    RecipeDtoValidationResult = String.Join("\n", recipeValidationErrors);                
                else
                    RecipeDtoValidationResult = "Ok";


                CurrentDto = recipeResponse.ToString();
                token.ThrowIfCancellationRequested();

                await Task.Delay(1000, token);

                token.ThrowIfCancellationRequested();

                await NotifyLims(client, SequencingRunStatus.RunStarted, recipeResponse.RunMode, token);

                token.ThrowIfCancellationRequested();

                await Task.Delay(2000, token);

                var end = EndingStatus == SequencingRunStatus.RunStarted ? SequencingRunStatus.RunCompletedSuccessfully : EndingStatus;
                await NotifyLims(client, end, recipeResponse.RunMode, token);
            }
            catch (OperationCanceledException)
            {
                var client = HttpClientExtensions.GetAuthenticatedClient(_service.LimsToken);
                await NotifyLims(client, SequencingRunStatus.RunEndedByUser, "", CancellationToken.None);
            }
            catch (LimsResponseErrorException e)
            {
                CurrentDto = e.ToString();
            }
            catch (Exception e)
            {
                _service.ErrorMessage = e.Message;
            }
            finally
            {
                Running = false;
            }
        }

        private async Task NotifyLims(HttpClient client, SequencingRunStatus status, String runMode, CancellationToken token)
        {

            var runInfo = new RunInfo
            {
                RunId = "Run 1",
                FlowCellId = FlowCellId,
                LibraryTubeId = LibrarySerialNumber,
                InstrumentId = "NovaSeq1",
                InstrumentType = SequencingInstrumentType.NovaSeq6000,
                FlowCellSide = "Left",
                DateTime = DateTime.Now,
                OutputFolder = "C:\\",
                UserName = "User1"
            };

            var reagents = LimsService.GetReagents(runMode);

            var srsDto = new SequencingRunStatusDto
            {
                RunInfo = runInfo,
                Status = status,
                Reagents = reagents,
                CurrentCycle = ++_currentCycle,
                CurrentRead = 1,
                InstrumentControlSoftwareVersion = "1.2.3",
                RtaVersion = "0.0.2",
                FirmwareVersion = "6.0.4"
            };
            try
            {
                token.ThrowIfCancellationRequested();
                CurrentDto = srsDto.ToString();
                await _service.SendRunProgress(srsDto, token);
                token.ThrowIfCancellationRequested();
                if (status == SequencingRunStatus.RunCompletedSuccessfully)
                {
                    token.ThrowIfCancellationRequested();
                    var srm = CreateRunMetrics(runInfo, status);
                    await _service.SubmitMetrics(srm, token);
                    token.ThrowIfCancellationRequested();
                }
            }
            catch (OperationCanceledException)
            {
                throw;
            }
            catch (Exception e)
            {
                _service.ErrorMessage = e.Message;
            }
        }

        private SequencingRunMetrics CreateRunMetrics(RunInfo runInfo, SequencingRunStatus status)
        {
            var srm = new SequencingRunMetrics
            {
                RunInfo = runInfo,
                Status = status
            };
            return srm;
        }

        public override async Task Reset()
        {
            CurrentDto = string.Empty;

            FlowCellId = string.Empty;
            LibrarySerialNumber = string.Empty;

            EndingStatus = new SequencingRunStatus();
            Running = false;
            RecipeDtoValidationResult = string.Empty;
    }
        #endregion
    }
}
