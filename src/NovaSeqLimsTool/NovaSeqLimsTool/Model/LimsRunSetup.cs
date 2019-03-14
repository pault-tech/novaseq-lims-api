using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;
using NovaSeqLimsTool.POCOs;

namespace NovaSeqLimsTool.Model
{
    public class LimsRunSetup : ILimsRunSetup
    {
        private const string RunMonitoringAndStorage = "RunMonitoringAndStorage";
        private const string RunMonitoringOnly = "RunMonitoringOnly";

        [JsonIgnore]
        public bool UseMonitoringAndStorage
            => BaseSpaceMode?.Equals(RunMonitoringAndStorage, StringComparison.InvariantCultureIgnoreCase) ?? false;

        [JsonIgnore]
        public string FilePath { get; set; }

        [JsonProperty(PropertyName = "run_name")]
        public string RunName { get; set; }

        [JsonProperty(PropertyName = "run_mode")]
        public InstrumentModes RunMode { get; set; }

        [JsonProperty(PropertyName = "workflow_type")]
        public RunWorkflowType WorkflowType { get; set; }

        [JsonProperty(PropertyName = "librarytube_id")]
        public string LibraryTubeId { get; set; }

        [JsonProperty(PropertyName = "paired_end")]
        public bool PairedEnd { get; set; }

        [JsonProperty(PropertyName = "read1")]
        public int Read1Cycles { get; set; }

        [JsonProperty(PropertyName = "read2")]
        public int Read2Cycles { get; set; }

        [JsonProperty(PropertyName = "index_read1")]
        public int IndexRead1Cycles { get; set; }

        [JsonProperty(PropertyName = "index_read2")]
        public int IndexRead2Cycles { get; set; }

        [JsonProperty(PropertyName = "output_folder")]
        public string OutputFolder { get; set; }

        [JsonProperty(PropertyName = "attachment")]
        public string AttachmentFile { get; set; }

        [JsonProperty(PropertyName = "samplesheet")]
        public string SamplesheetFile { get; set; }

        [JsonProperty(PropertyName = "use_basespace")]
        public bool UseBaseSpace { get; set; }

        [JsonProperty(PropertyName = "basespace_mode")]
        public string BaseSpaceMode { get; set; }

        [JsonProperty(PropertyName = "use_custom_read1_primer")]
        public bool UseCustomRead1Primer { get; set; }
        [JsonProperty(PropertyName = "use_custom_read2_primer")]
        public bool UseCustomRead2Primer { get; set; }
        [JsonProperty(PropertyName = "use_custom_index_read1_primer")]
        public bool UseCustomIndexRead1Primer { get; set; }

        [JsonProperty(PropertyName = "sample_loading_type")]
        public LoadWorkflowType SampleLoadingType { get; set; }

        [JsonProperty(PropertyName = "flowcell_id")]
        public string FlowCellId { get; set; }

        [JsonIgnore]
        public List<LimsErrors> LimsErrors { get; set; }

        /// <summary>
        /// Determine if the current settings are valid.
        /// Return list of errors, or empty list if settings are OK.
        /// </summary>
        /// <param name="nllSupported"></param>
        /// <returns></returns>
        public List<string> Validate(bool nllSupported = true)
        {
            var errors = new List<string>();
            var fileName = Path.GetFileNameWithoutExtension(FilePath);            
            if (!string.IsNullOrEmpty(SamplesheetFile) && !string.IsNullOrEmpty(AttachmentFile))
                errors.Add(CSResources.Error_AttachmentAndSamplesheet);

            if (Read1Cycles < 0 || Read2Cycles < 0 || IndexRead1Cycles < 0 || IndexRead2Cycles < 0)
                errors.Add(CSResources.Error_InvalidCycles);

            if (Read1Cycles == 0)
                errors.Add(CSResources.Error_NoRead1Cycles);

            if (PairedEnd && Read2Cycles == 0)
                errors.Add(CSResources.Error_PairedEndMismatch);

            if (!PairedEnd && Read2Cycles > 0)
                errors.Add(CSResources.Error_SingleReadMismatch);

            if (WorkflowType == RunWorkflowType.NoIndex && (IndexRead1Cycles > 0 || IndexRead2Cycles > 0))
                errors.Add(CSResources.Error_NonIndexedMismatch);

            if (WorkflowType == RunWorkflowType.SingleIndex && (IndexRead1Cycles == 0 || IndexRead2Cycles > 0))
                errors.Add(CSResources.Error_SingleIndexedMismatch);

            if (WorkflowType == RunWorkflowType.DualIndex && (IndexRead1Cycles == 0 || IndexRead2Cycles == 0))
                errors.Add(CSResources.Error_DualIndexedMismatch);

            if (BaseSpaceMode != null &&
                !BaseSpaceMode.Equals(RunMonitoringOnly, StringComparison.InvariantCultureIgnoreCase) &&
                !BaseSpaceMode.Equals(RunMonitoringAndStorage, StringComparison.InvariantCultureIgnoreCase))
                errors.Add(CSResources.Error_LimsInvalidBaseSpaceMode);

            if (!nllSupported && SampleLoadingType == LoadWorkflowType.NovaSeqXp)
            {
                // nll specified but not supported
                errors.Add(CSResources.Error_LimsXpNotSupported);
            }
            else
            {
                if (SampleLoadingType == LoadWorkflowType.NovaSeqXp)
                {
                    // flowcell must be specified
                    // filename must match flowcell
                    if (string.IsNullOrEmpty(FlowCellId))
                        errors.Add(CSResources.Error_LimsFlowCellMissing);
                    else if (!FlowCellId.Equals(fileName, StringComparison.InvariantCultureIgnoreCase))
                        errors.Add(CSResources.Error_LimsFlowCellBarcodeMismatch);
                }
                else
                {
                    if (string.IsNullOrEmpty(LibraryTubeId)) // lib must always be provided
                        errors.Add(CSResources.Error_LimsLibraryTubeMissing);

                    // filename must match library
                    if (!string.IsNullOrEmpty(LibraryTubeId) && !LibraryTubeId.Equals(fileName, StringComparison.InvariantCultureIgnoreCase))
                        errors.Add(CSResources.Error_LimsBarcodeMismatch);
                }
            }

            return errors;
        }   

        public static ILimsRunSetup LimsRunSetupFromRecipeDto(RecipeDto rp, Uri baseUri)
        {
            LoadWorkflowType type;
            Enum.TryParse(rp.SampleLoadingType, out type);
            InstrumentModes instMode;
            Enum.TryParse(rp.RunMode, out instMode);
            RunWorkflowType wft;
            Enum.TryParse(rp.WorkflowType, out wft);
            var fileName = type == LoadWorkflowType.NovaSeqStandard ? rp.LibraryTubeId : rp.FlowCellId;
            var path = $"C:\\{fileName}.json";

            // Create a local samplesheet file from the Uri
            var sampleSheetPath = rp.Samplesheet == null ? string.Empty : rp.Samplesheet.LocalPath;            

            var lrs = new LimsRunSetup
            {
                RunName = rp.RunName,
                RunMode = instMode,
                Read1Cycles = rp.Read1,
                Read2Cycles = rp.Read2,
                IndexRead1Cycles = rp.IndexRead1,
                IndexRead2Cycles = rp.IndexRead2,
                OutputFolder = rp.OutputFolder,
                SampleLoadingType = type,
                AttachmentFile = string.Empty,
                SamplesheetFile = sampleSheetPath,
                UseBaseSpace = rp.UseBasespace,
                BaseSpaceMode = rp.BasespaceMode,
                UseCustomRead1Primer = rp.UseCustomRead1Primer,
                UseCustomRead2Primer = rp.UseCustomRead2Primer,
                UseCustomIndexRead1Primer = rp.UseCustomIndexRead1Primer,
                LibraryTubeId = rp.LibraryTubeId,
                WorkflowType = wft,
                PairedEnd = rp.PairedEnd,
                FlowCellId = rp.FlowCellId,
                FilePath = path
            };
            return lrs;
        }
    }
}
