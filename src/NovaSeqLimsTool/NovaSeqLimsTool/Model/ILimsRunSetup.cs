using System.Collections.Generic;
using NovaSeqLimsTool.POCOs;

namespace NovaSeqLimsTool.Model
{
    public interface ILimsRunSetup
    {
        bool UseMonitoringAndStorage { get; }
        string FilePath { get; set; }
        string RunName { get; set; }
        InstrumentModes RunMode { get; set; }
        RunWorkflowType WorkflowType { get; set; }
        string LibraryTubeId { get; set; }
        bool PairedEnd { get; set; }
        int Read1Cycles { get; set; }
        int Read2Cycles { get; set; }
        int IndexRead1Cycles { get; set; }
        int IndexRead2Cycles { get; set; }
        string OutputFolder { get; set; }
        string AttachmentFile { get; set; }
        string SamplesheetFile { get; set; }
        bool UseBaseSpace { get; set; }
        string BaseSpaceMode { get; set; }
        bool UseCustomRead1Primer { get; set; }
        bool UseCustomRead2Primer { get; set; }
        bool UseCustomIndexRead1Primer { get; set; }
        LoadWorkflowType SampleLoadingType { get; set; }
        string FlowCellId { get; set; }
        List<LimsErrors> LimsErrors { get; set; }

        List<string> Validate(bool nllSupported = true);
    }
}
