using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Windows.Input;
using NovaSeqLimsTool.Model;

namespace NovaSeqLimsTool.ViewModels
{
    public class SamplesheetViewModel : ViewModelBase
    {
        #region Fields

        private string _samplesheetSourcePath;
        private string _samplesheetDownloadPath;
        #endregion

        #region Properties

        public string SamplesheetSourcePath
        {
            get => _samplesheetSourcePath;
            set => SetProperty(ref _samplesheetSourcePath, value);
        }
        public string SamplesheetDownloadPath
        {
            get => _samplesheetDownloadPath;
            set => SetProperty(ref _samplesheetDownloadPath, value);
        }
        #endregion

        #region ICommands
        public ICommand DownloadSamplesheet => new AsyncCommand(DownloadSampleSheet, () => true);
        #endregion

        #region Constructor

        public SamplesheetViewModel(LimsService state) : base(state) { }
        #endregion

        #region Methods
        public async Task DownloadSampleSheet()
        {
            try
            {
                var samplesheet = await _service.DownloadSamplesheetAsync();
                SamplesheetSourcePath = samplesheet.Item1;
                SamplesheetDownloadPath = samplesheet.Item2;
            }
            catch (Exception ex)
            {
                _service.ErrorMessage = ex.Message;
            }
        }

        public override async Task Reset()
        {
            SamplesheetSourcePath = String.Empty;
            SamplesheetDownloadPath = String.Empty;
        }
        #endregion        
    }
}
