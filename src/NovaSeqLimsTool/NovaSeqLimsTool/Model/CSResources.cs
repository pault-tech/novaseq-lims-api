namespace NovaSeqLimsTool.Model
{
    public class CSResources
    {        
        public static string Error_AttachmentAndSamplesheet => "Both samplesheet and attachment are specified in the LIMS file. To continue, specify either samplesheet or attachment.";
        public static string Error_InvalidCycles => "Invalid cycles specified";
        public static string Error_NoRead1Cycles => "No Read 1 cycles specified";
        public static string Error_PairedEndMismatch => "Read 2 cycles should be specified for a paired end run";
        public static string Error_SingleReadMismatch => "Read 2 cycles should not be specified for a single read run";
        public static string Error_NonIndexedMismatch => "Index cycles should not be specified for a non indexed run";
        public static string Error_SingleIndexedMismatch => "Invalid index cycles specified for a single indexed run";
        public static string Error_DualIndexedMismatch => "Invalid index cycles specified for a dual indexed run";
        public static string Error_LimsInvalidBaseSpaceMode => "Invalid BaseSpace mode";
        public static string Error_LimsXpNotSupported => "NovaSeq Xp is not enabled";
        public static string Error_LimsFlowCellMissing => "Invalid SampleLoadingType: The flow cell ID is not specified in the file";
        public static string Error_LimsFlowCellBarcodeMismatch => "The flow cell ID in file does not match";
        public static string Error_LimsLibraryTubeMissing => "Invalid SampleLoadingType: The library tube ID is not specified in the file";
        public static string Error_LimsBarcodeMismatch => "The library tube ID in file does not match";
    }
}