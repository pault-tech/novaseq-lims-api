using NovaSeqLimsTool.Model;
using NovaSeqLimsTool.POCOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Input;

namespace NovaSeqLimsTool.ViewModels
{
    public class GetRecipeViewModel : ViewModelBase
    {
        #region Fields
        private string _recipeDto;
        private string _flowCellId;
        private string _librarySerialNumber;
        private string _recipeValidationResult;
        private string _runMode;
        #endregion

        #region Properties
        public string Response
        {
            get => _recipeDto;
            set => SetProperty(ref _recipeDto, value);
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
        public string RecipeValidationResult
        {
            get => _recipeValidationResult;
            set => SetProperty(ref _recipeValidationResult, value);
        }
        public string RunMode
        {
            get => _runMode;
            set => SetProperty(ref _runMode, value);
        }
        public IEnumerable<string> SupportedModes => Enum.GetNames(typeof(InstrumentModes)).Where(n => n != InstrumentModes.Undefined.ToString());
        #endregion

        #region ICommands
        public ICommand GetRecipe => new AsyncCommand(GetRecipeDto, () => true);        
        #endregion

        #region Constructor
        public GetRecipeViewModel(LimsService state) : base(state)
        {
            RunMode = InstrumentModes.S4.ToString();
        }
        #endregion

        #region Methods
        private async Task GetRecipeDto()
        {
            try
            {
                var reagents = LimsService.GetReagents(RunMode);
                var recipeResponse = await _service.GetRecipeDto(FlowCellId, LibrarySerialNumber, reagents);
                Response = recipeResponse?.ToString() ?? string.Empty;
                var errors = await _service.ValidateRecipe();

                if (errors.Count > 0)
                {
                    RecipeValidationResult = String.Join("\n", errors);
                }
                else
                {
                    RecipeValidationResult = "Ok";
                }
            }
            catch (LimsResponseErrorException e)
            {
                Response = e.ToString();
            }
            catch (Exception e)
            {
                _service.ErrorMessage = e.Message;
            }
        }

        public override async Task Reset()
        {
            Response = string.Empty;
            FlowCellId = string.Empty;
            RecipeValidationResult = string.Empty;
            LibrarySerialNumber = string.Empty;
            RunMode = InstrumentModes.S4.ToString();
        }
        #endregion
    }
}
