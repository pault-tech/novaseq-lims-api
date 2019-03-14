using System;
using System.ComponentModel;

namespace NovaSeqLimsTool.POCOs
{
    public enum SequencingRunStatus
    {
        RunStarted,
        RunEndedByUser,
        RunErroredOut,
        RunCompletedSuccessfully
    }

    public enum SequencingInstrumentType
    {
        NovaSeq6000
    }

    public enum LoadWorkflowType
    {
        [Description("NovaSeq Standard")]
        NovaSeqStandard,

        [Description("NovaSeq Xp")]
        NovaSeqXp
    }

    [Flags]
    public enum InstrumentModes
    {
        Undefined = 0,        
        S2 = 2,
        S1 = 4,
        S4 = 0x20,
        SP = 0x40
    }

    public enum RunWorkflowType
    {
        [Description("No Index")]
        NoIndex,
        [Description("Single Index")]
        SingleIndex,
        [Description("Dual Index")]
        DualIndex,
        [Description("Custom")]
        Custom
    }

    public enum LimsErrors
    {
        GeneralLimsFailure,
        FlowCellLotNumberIssue,
        FlowCellBarcodeNotFound,
        LibraryTubeLotNumberIssue,
        LibraryTubeBarcodeNotFound,
        SbsLotNumberIssue,
        SbsBarcodeNotFound,
        ClusterLotNumberIssue,
        ClusterBarcodeNotFound,
        BufferLotNumberIssue,
        BufferBarcodeNotFound
    }
}
