using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using NovaSeqLimsTool.HttpExtensions;
using NovaSeqLimsTool.POCOs;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Runtime.CompilerServices;
using System.Threading;
using System.Threading.Tasks;

namespace NovaSeqLimsTool.Model
{
    public class LimsService : INotifyPropertyChanged
    {
        #region Fields
        private string _errorMessage;
        private string _limsUrlAddress;
        private string _limsLoginAddress;
        private string _limsToken;
        private string _limsUserName;
        private RecipeDto _recipeDto;
        public static string LoginUrl = "Illumina/Sequencer/v2/sequencing-run/login";
        public static string RecipeUrl = "Illumina/Sequencer/v2/sequencing-run/recipe/novaseq";
        public static string RunProgressUrl = "Illumina/Sequencer/v2/sequencing-run/update";
        public static string RunMetricUrl = "Illumina/Sequencer/v2/sequencing-run/metrics";
        public event PropertyChangedEventHandler PropertyChanged;
        #endregion

        #region Properties
        public string ErrorMessage
        {
            get => _errorMessage;
            set
            {
                _errorMessage = value;
                OnPropertyChanged();
            }
        }

        public string LimsUrlAddress
        {
            get => _limsUrlAddress;
            set
            {
                _limsUrlAddress = value;
                OnPropertyChanged();
            }
        }

        public Uri LimsUri { get => LimsUrlAddress == null ? null : new Uri(LimsUrlAddress); }

        public string LimsLoginAddress
        {
            get => _limsLoginAddress;
            set
            {
                _limsLoginAddress = value;
                OnPropertyChanged();
            }
        }

        public Uri LimsLoginUri { get => LimsLoginAddress == null ? null : new Uri(LimsLoginAddress); }

        public string LimsToken
        {
            get => _limsToken;
            set
            {
                _limsToken = value;
                OnPropertyChanged();
            }
        }

        public string LimsUserName
        {
            get => _limsUserName;
            set
            {
                _limsUserName = value;
                OnPropertyChanged();
            }
        }

        #endregion

        #region Methods
        public static List<Reagent> GetReagents(string runMode)
        {
            var fcdate = DateTime.Now;
            var sbsdate = DateTime.Now;
            var ltdate = DateTime.Now;
            var cdate = DateTime.Now;
            var bdate = DateTime.Now;
            var sbcycles = 151;
            var ccycles = 151;
            var bcycles = 151;

            return new List<Reagent>
            {
                //Flow Cell
                new Reagent
                {
                    Name = "Flow Cell",
                    ExpirationDate = fcdate,
                    LotNumber = "1234",
                    SerialNumber = "5764",
                    PartNumber = "12341344",
                    Mode = runMode
                },
                new Reagent
                {
                    Name = "SBS",
                    ExpirationDate = sbsdate,
                    LotNumber = "346345",
                    SerialNumber = "46758736",
                    PartNumber = "12342456",
                    Mode = runMode,
                    Cycles = sbcycles
                },
                new Reagent
                {
                    Name = "Library Tube",
                    ExpirationDate = ltdate,
                    LotNumber = "45782724",
                    SerialNumber = "1345156",
                    PartNumber = "13461346",
                    Mode = runMode
                },
                new Reagent
                {
                    Name = "Cluster",
                    ExpirationDate = cdate,
                    LotNumber = "32478217",
                    SerialNumber = "10971",
                    PartNumber = "209726789",
                    Mode = runMode,
                    Cycles = ccycles
                },
                new Reagent
                {
                    Name = "Buffer",
                    ExpirationDate = bdate,
                    LotNumber = "6549851",
                    SerialNumber = "75637",
                    PartNumber = "6454",
                    Mode = runMode,
                    Cycles = bcycles
                }
            };
        }

        public async Task Reset()
        {
            ErrorMessage = null;
            LimsLoginAddress = null;
            LimsUserName = string.Empty;
            LimsToken = string.Empty;
        }

        public async Task<string> RetrieveLoginUrl()
        {
            if (LimsUri == null)
            {
                return string.Empty;
            }
            var client = GetNoAuthClient();
            LimsLoginAddress = await client?.GetAsync<string>(new Uri(LimsUri, LoginUrl));
            return LimsLoginAddress;
        }

        public async Task<RecipeDto> GetRecipeDto(string flowCellId, string librarySerialNumber, IEnumerable<Reagent> reagents, CancellationToken token = default(CancellationToken))
        {
            var client = GetAuthClient();
            var response = await client?.PostAsyncWithErrorHandling<RecipeIdentifier, RecipeDto>(new Uri(LimsUri, RecipeUrl),
                    new RecipeIdentifier
                    {
                        FlowCellId = flowCellId,
                        LibraryContainerId = librarySerialNumber,
                        Reagents = reagents
                    }, async r => await CheckResponse(r), token);
            _recipeDto = response;
            return response;
        }

        public async Task<List<string>> ValidateRecipe()
        {
            if (_recipeDto == null)
                throw new ApplicationException("Null Recipe DTO");
            
            var runSetup = LimsRunSetup.LimsRunSetupFromRecipeDto(_recipeDto, LimsUri);
            return runSetup.Validate();
        }

        public async Task<Tuple<string,string>> DownloadSamplesheetAsync()
        {
            if(_recipeDto == null)
                throw new ApplicationException("Null Recipe DTO");
            
            var autHttpClient = GetAuthClient();
            // Create a local samplesheet file from the Uri
            var sampleSheetPath = _recipeDto.Samplesheet == null ? string.Empty : _recipeDto.Samplesheet.AbsolutePath;
            var sampleSheetDownloadPath = String.Empty;

            // If RecipeDto.Samplesheet is an URI, then download it to the output folder, and use that local path as the samplesheet
            if (_recipeDto.Samplesheet != null && !_recipeDto.Samplesheet.IsFile)
            {
                sampleSheetDownloadPath = Path.Combine(_recipeDto.OutputFolder, @"downloadedSamplesheet.csv");

                if (_recipeDto.RequireSampleSheetAuthentication && autHttpClient != null)
                {
                    using (var request = new HttpRequestMessage(HttpMethod.Get, _recipeDto.Samplesheet))
                    {
                        using (Stream contentStream = autHttpClient.SendAsync(request).GetAwaiter().GetResult().Content.ReadAsStreamAsync().GetAwaiter().GetResult(),
                            stream = new FileStream(sampleSheetDownloadPath, FileMode.Create, FileAccess.Write, FileShare.None))
                        {
                            contentStream.CopyTo(stream);
                        }
                    }
                }
                else
                {
                    var webClient = new WebClient();
                    webClient.DownloadFile(_recipeDto.Samplesheet, sampleSheetDownloadPath);
                }
            }
            
            return new Tuple<string, string>(sampleSheetPath, sampleSheetDownloadPath);
        }

        public async Task SubmitMetrics(SequencingRunMetrics srm, CancellationToken token = default(CancellationToken))
        {
            var client = GetAuthClient();
            var response = await client.PostAsync<SequencingRunMetrics, HttpResponseMessage>(new Uri(LimsUri, RunMetricUrl), srm, token);
            response?.EnsureSuccessStatusCode();
        }

        public async Task SendRunProgress(SequencingRunStatusDto srs, CancellationToken token = default(CancellationToken))
        {
            var client = GetAuthClient();
            var response = await client.PostAsync<SequencingRunStatusDto, HttpResponseMessage>(new Uri(LimsUri, RunProgressUrl), srs, token);
            response?.EnsureSuccessStatusCode();
        }

        private HttpClient GetNoAuthClient()
        {
            return HttpClientExtensions.CreateJson();
        }

        private void VerifyAuthorized()
        {
            if (string.IsNullOrWhiteSpace(LimsToken))
            {
                throw new ArgumentException("Not logged in or authorized");
            }
        }

        private HttpClient GetAuthClient()
        {
            VerifyAuthorized();
            return HttpClientExtensions.GetAuthenticatedClient(LimsToken);
        }

        private async Task CheckResponse(HttpResponseMessage response)
        {
            if (((int)response.StatusCode) >= 400 && ((int)response.StatusCode) < 500)
            {
                List<LimsErrors> errors = null;

                try
                {
                    var responseString = await response.Content.ReadAsStringAsync().ConfigureAwait(false);
                    errors = JsonConvert.DeserializeObject<List<LimsErrors>>(responseString, new StringEnumConverter());
                }
                finally
                {
                    // if we didn't get any valid LimsErrors, just use the catch-all
                    if (errors == null || errors.Count == 0)
                    {
                        errors = new List<LimsErrors> { LimsErrors.GeneralLimsFailure };
                    }

                    throw new LimsResponseErrorException(errors);
                }
            }
        }

        /// <summary>
        /// Raises the PropertyChanged event for a given property
        /// </summary>
        /// <param name="propertyName"></param>
        protected virtual void OnPropertyChanged([CallerMemberName]string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
        #endregion
    }

    public class LimsResponseErrorException : Exception
    {
        public List<LimsErrors> LimsErrors { get; private set; }

        public LimsResponseErrorException(List<LimsErrors> errors)
        {
            LimsErrors = errors;
        }

        public override string ToString()
        {
            return String.Join("\n", LimsErrors);
        }
    }
}
