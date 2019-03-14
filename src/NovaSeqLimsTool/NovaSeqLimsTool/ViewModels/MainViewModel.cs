using NovaSeqLimsTool.Model;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Input;

namespace NovaSeqLimsTool.ViewModels
{
    public class MainViewModel : ViewModelBase
    {
        #region Fields
        private string _error;
        private ViewModelBase[] _viewModels;
        #endregion

        #region Properties
        public string LimsUrlAddress
        {
            get => _service.LimsUrlAddress;
            set
            {
                _service.LimsUrlAddress = value;
                OnPropertyChanged();
            }
        }

        public string Error
        {
            get => _error;
            set => SetProperty(ref _error, value);
        }

        #endregion

        #region ICommands
        public ICommand VerifyUrlCommand => new AsyncCommand(Verify, CanVerify);
        public ICommand ResetCommand => new AsyncCommand(Reset, () => true);
        #endregion

        #region Constructor
        public MainViewModel(LimsService state, params ViewModelBase[] viewModels) : base(state)
        {
            _viewModels = viewModels;
            _service.PropertyChanged += (o, e) =>
            {
                if (e.PropertyName == nameof(LimsService.ErrorMessage))
                {
                    Error = _service.ErrorMessage;
                }
            };
        }
        #endregion

        #region Methods
        public async Task Verify()
        {
            try
            {
                Error = "Validating";
                var s = _service.LimsUri;
                await _service.RetrieveLoginUrl();
                Error = string.Empty;
            }
            catch (Exception e)
            {
                Error = e.Message;
            }
        }

        public bool CanVerify()
        {
            return !string.IsNullOrWhiteSpace(LimsUrlAddress);
        }

        public override async Task Reset()
        {
            LimsUrlAddress = string.Empty;

            await Task.WhenAll(_viewModels.Select(vm => vm.Reset()));

            await _service.Reset();
        }
        #endregion
    }
}
