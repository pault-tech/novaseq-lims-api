package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.model.RunInfo;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SequencingRunMetrics
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T00:23:41.052369500Z[Etc/UTC]")
public class SequencingRunMetrics {

  private RunInfo runInfo;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    NUMBER_null(null),
    
    NUMBER_2(2),
    
    NUMBER_3(3);

    private Integer value;

    StatusEnum(Integer value) {
      this.value = value;
    }

    @JsonValue
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(Integer value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private Float yieldPfR1;

  private Float yieldPfR2;

  private Float readsPfR1;

  private Float readsPfR2;

  private Float clusterDensityR1;

  private Float clusterDensityR2;

  private Float percentPfR1;

  private Float percentPfR2;

  private Float percentGreaterThanQ30R1;

  private Float percentGreaterThanQ30R2;

  private Float intensityCycle1R1;

  private Float intensityCycle1R2;

  private Float percentAlignedR1;

  private Float percentAlignedR2;

  private Float percentErrorRateR1;

  private Float percentErrorRateR2;

  private Float percentPhasingR1;

  private Float percentPhasingR2;

  private Float percentPrePhasingR1;

  private Float percentPrePhasingR2;

  public SequencingRunMetrics runInfo(RunInfo runInfo) {
    this.runInfo = runInfo;
    return this;
  }

  /**
   * Get runInfo
   * @return runInfo
  */
  @Valid 
  @Schema(name = "runInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("runInfo")
  public RunInfo getRunInfo() {
    return runInfo;
  }

  public void setRunInfo(RunInfo runInfo) {
    this.runInfo = runInfo;
  }

  public SequencingRunMetrics status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SequencingRunMetrics yieldPfR1(Float yieldPfR1) {
    this.yieldPfR1 = yieldPfR1;
    return this;
  }

  /**
   * Get yieldPfR1
   * @return yieldPfR1
  */
  
  @Schema(name = "yieldPfR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yieldPfR1")
  public Float getYieldPfR1() {
    return yieldPfR1;
  }

  public void setYieldPfR1(Float yieldPfR1) {
    this.yieldPfR1 = yieldPfR1;
  }

  public SequencingRunMetrics yieldPfR2(Float yieldPfR2) {
    this.yieldPfR2 = yieldPfR2;
    return this;
  }

  /**
   * Get yieldPfR2
   * @return yieldPfR2
  */
  
  @Schema(name = "yieldPfR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yieldPfR2")
  public Float getYieldPfR2() {
    return yieldPfR2;
  }

  public void setYieldPfR2(Float yieldPfR2) {
    this.yieldPfR2 = yieldPfR2;
  }

  public SequencingRunMetrics readsPfR1(Float readsPfR1) {
    this.readsPfR1 = readsPfR1;
    return this;
  }

  /**
   * Get readsPfR1
   * @return readsPfR1
  */
  
  @Schema(name = "readsPfR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("readsPfR1")
  public Float getReadsPfR1() {
    return readsPfR1;
  }

  public void setReadsPfR1(Float readsPfR1) {
    this.readsPfR1 = readsPfR1;
  }

  public SequencingRunMetrics readsPfR2(Float readsPfR2) {
    this.readsPfR2 = readsPfR2;
    return this;
  }

  /**
   * Get readsPfR2
   * @return readsPfR2
  */
  
  @Schema(name = "readsPfR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("readsPfR2")
  public Float getReadsPfR2() {
    return readsPfR2;
  }

  public void setReadsPfR2(Float readsPfR2) {
    this.readsPfR2 = readsPfR2;
  }

  public SequencingRunMetrics clusterDensityR1(Float clusterDensityR1) {
    this.clusterDensityR1 = clusterDensityR1;
    return this;
  }

  /**
   * Get clusterDensityR1
   * @return clusterDensityR1
  */
  
  @Schema(name = "clusterDensityR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clusterDensityR1")
  public Float getClusterDensityR1() {
    return clusterDensityR1;
  }

  public void setClusterDensityR1(Float clusterDensityR1) {
    this.clusterDensityR1 = clusterDensityR1;
  }

  public SequencingRunMetrics clusterDensityR2(Float clusterDensityR2) {
    this.clusterDensityR2 = clusterDensityR2;
    return this;
  }

  /**
   * Get clusterDensityR2
   * @return clusterDensityR2
  */
  
  @Schema(name = "clusterDensityR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clusterDensityR2")
  public Float getClusterDensityR2() {
    return clusterDensityR2;
  }

  public void setClusterDensityR2(Float clusterDensityR2) {
    this.clusterDensityR2 = clusterDensityR2;
  }

  public SequencingRunMetrics percentPfR1(Float percentPfR1) {
    this.percentPfR1 = percentPfR1;
    return this;
  }

  /**
   * Get percentPfR1
   * @return percentPfR1
  */
  
  @Schema(name = "percentPfR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPfR1")
  public Float getPercentPfR1() {
    return percentPfR1;
  }

  public void setPercentPfR1(Float percentPfR1) {
    this.percentPfR1 = percentPfR1;
  }

  public SequencingRunMetrics percentPfR2(Float percentPfR2) {
    this.percentPfR2 = percentPfR2;
    return this;
  }

  /**
   * Get percentPfR2
   * @return percentPfR2
  */
  
  @Schema(name = "percentPfR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPfR2")
  public Float getPercentPfR2() {
    return percentPfR2;
  }

  public void setPercentPfR2(Float percentPfR2) {
    this.percentPfR2 = percentPfR2;
  }

  public SequencingRunMetrics percentGreaterThanQ30R1(Float percentGreaterThanQ30R1) {
    this.percentGreaterThanQ30R1 = percentGreaterThanQ30R1;
    return this;
  }

  /**
   * Get percentGreaterThanQ30R1
   * @return percentGreaterThanQ30R1
  */
  
  @Schema(name = "percentGreaterThanQ30R1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentGreaterThanQ30R1")
  public Float getPercentGreaterThanQ30R1() {
    return percentGreaterThanQ30R1;
  }

  public void setPercentGreaterThanQ30R1(Float percentGreaterThanQ30R1) {
    this.percentGreaterThanQ30R1 = percentGreaterThanQ30R1;
  }

  public SequencingRunMetrics percentGreaterThanQ30R2(Float percentGreaterThanQ30R2) {
    this.percentGreaterThanQ30R2 = percentGreaterThanQ30R2;
    return this;
  }

  /**
   * Get percentGreaterThanQ30R2
   * @return percentGreaterThanQ30R2
  */
  
  @Schema(name = "percentGreaterThanQ30R2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentGreaterThanQ30R2")
  public Float getPercentGreaterThanQ30R2() {
    return percentGreaterThanQ30R2;
  }

  public void setPercentGreaterThanQ30R2(Float percentGreaterThanQ30R2) {
    this.percentGreaterThanQ30R2 = percentGreaterThanQ30R2;
  }

  public SequencingRunMetrics intensityCycle1R1(Float intensityCycle1R1) {
    this.intensityCycle1R1 = intensityCycle1R1;
    return this;
  }

  /**
   * Get intensityCycle1R1
   * @return intensityCycle1R1
  */
  
  @Schema(name = "intensityCycle1R1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("intensityCycle1R1")
  public Float getIntensityCycle1R1() {
    return intensityCycle1R1;
  }

  public void setIntensityCycle1R1(Float intensityCycle1R1) {
    this.intensityCycle1R1 = intensityCycle1R1;
  }

  public SequencingRunMetrics intensityCycle1R2(Float intensityCycle1R2) {
    this.intensityCycle1R2 = intensityCycle1R2;
    return this;
  }

  /**
   * Get intensityCycle1R2
   * @return intensityCycle1R2
  */
  
  @Schema(name = "intensityCycle1R2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("intensityCycle1R2")
  public Float getIntensityCycle1R2() {
    return intensityCycle1R2;
  }

  public void setIntensityCycle1R2(Float intensityCycle1R2) {
    this.intensityCycle1R2 = intensityCycle1R2;
  }

  public SequencingRunMetrics percentAlignedR1(Float percentAlignedR1) {
    this.percentAlignedR1 = percentAlignedR1;
    return this;
  }

  /**
   * Get percentAlignedR1
   * @return percentAlignedR1
  */
  
  @Schema(name = "percentAlignedR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentAlignedR1")
  public Float getPercentAlignedR1() {
    return percentAlignedR1;
  }

  public void setPercentAlignedR1(Float percentAlignedR1) {
    this.percentAlignedR1 = percentAlignedR1;
  }

  public SequencingRunMetrics percentAlignedR2(Float percentAlignedR2) {
    this.percentAlignedR2 = percentAlignedR2;
    return this;
  }

  /**
   * Get percentAlignedR2
   * @return percentAlignedR2
  */
  
  @Schema(name = "percentAlignedR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentAlignedR2")
  public Float getPercentAlignedR2() {
    return percentAlignedR2;
  }

  public void setPercentAlignedR2(Float percentAlignedR2) {
    this.percentAlignedR2 = percentAlignedR2;
  }

  public SequencingRunMetrics percentErrorRateR1(Float percentErrorRateR1) {
    this.percentErrorRateR1 = percentErrorRateR1;
    return this;
  }

  /**
   * Get percentErrorRateR1
   * @return percentErrorRateR1
  */
  
  @Schema(name = "percentErrorRateR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentErrorRateR1")
  public Float getPercentErrorRateR1() {
    return percentErrorRateR1;
  }

  public void setPercentErrorRateR1(Float percentErrorRateR1) {
    this.percentErrorRateR1 = percentErrorRateR1;
  }

  public SequencingRunMetrics percentErrorRateR2(Float percentErrorRateR2) {
    this.percentErrorRateR2 = percentErrorRateR2;
    return this;
  }

  /**
   * Get percentErrorRateR2
   * @return percentErrorRateR2
  */
  
  @Schema(name = "percentErrorRateR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentErrorRateR2")
  public Float getPercentErrorRateR2() {
    return percentErrorRateR2;
  }

  public void setPercentErrorRateR2(Float percentErrorRateR2) {
    this.percentErrorRateR2 = percentErrorRateR2;
  }

  public SequencingRunMetrics percentPhasingR1(Float percentPhasingR1) {
    this.percentPhasingR1 = percentPhasingR1;
    return this;
  }

  /**
   * Get percentPhasingR1
   * @return percentPhasingR1
  */
  
  @Schema(name = "percentPhasingR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPhasingR1")
  public Float getPercentPhasingR1() {
    return percentPhasingR1;
  }

  public void setPercentPhasingR1(Float percentPhasingR1) {
    this.percentPhasingR1 = percentPhasingR1;
  }

  public SequencingRunMetrics percentPhasingR2(Float percentPhasingR2) {
    this.percentPhasingR2 = percentPhasingR2;
    return this;
  }

  /**
   * Get percentPhasingR2
   * @return percentPhasingR2
  */
  
  @Schema(name = "percentPhasingR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPhasingR2")
  public Float getPercentPhasingR2() {
    return percentPhasingR2;
  }

  public void setPercentPhasingR2(Float percentPhasingR2) {
    this.percentPhasingR2 = percentPhasingR2;
  }

  public SequencingRunMetrics percentPrePhasingR1(Float percentPrePhasingR1) {
    this.percentPrePhasingR1 = percentPrePhasingR1;
    return this;
  }

  /**
   * Get percentPrePhasingR1
   * @return percentPrePhasingR1
  */
  
  @Schema(name = "percentPrePhasingR1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPrePhasingR1")
  public Float getPercentPrePhasingR1() {
    return percentPrePhasingR1;
  }

  public void setPercentPrePhasingR1(Float percentPrePhasingR1) {
    this.percentPrePhasingR1 = percentPrePhasingR1;
  }

  public SequencingRunMetrics percentPrePhasingR2(Float percentPrePhasingR2) {
    this.percentPrePhasingR2 = percentPrePhasingR2;
    return this;
  }

  /**
   * Get percentPrePhasingR2
   * @return percentPrePhasingR2
  */
  
  @Schema(name = "percentPrePhasingR2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentPrePhasingR2")
  public Float getPercentPrePhasingR2() {
    return percentPrePhasingR2;
  }

  public void setPercentPrePhasingR2(Float percentPrePhasingR2) {
    this.percentPrePhasingR2 = percentPrePhasingR2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SequencingRunMetrics sequencingRunMetrics = (SequencingRunMetrics) o;
    return Objects.equals(this.runInfo, sequencingRunMetrics.runInfo) &&
        Objects.equals(this.status, sequencingRunMetrics.status) &&
        Objects.equals(this.yieldPfR1, sequencingRunMetrics.yieldPfR1) &&
        Objects.equals(this.yieldPfR2, sequencingRunMetrics.yieldPfR2) &&
        Objects.equals(this.readsPfR1, sequencingRunMetrics.readsPfR1) &&
        Objects.equals(this.readsPfR2, sequencingRunMetrics.readsPfR2) &&
        Objects.equals(this.clusterDensityR1, sequencingRunMetrics.clusterDensityR1) &&
        Objects.equals(this.clusterDensityR2, sequencingRunMetrics.clusterDensityR2) &&
        Objects.equals(this.percentPfR1, sequencingRunMetrics.percentPfR1) &&
        Objects.equals(this.percentPfR2, sequencingRunMetrics.percentPfR2) &&
        Objects.equals(this.percentGreaterThanQ30R1, sequencingRunMetrics.percentGreaterThanQ30R1) &&
        Objects.equals(this.percentGreaterThanQ30R2, sequencingRunMetrics.percentGreaterThanQ30R2) &&
        Objects.equals(this.intensityCycle1R1, sequencingRunMetrics.intensityCycle1R1) &&
        Objects.equals(this.intensityCycle1R2, sequencingRunMetrics.intensityCycle1R2) &&
        Objects.equals(this.percentAlignedR1, sequencingRunMetrics.percentAlignedR1) &&
        Objects.equals(this.percentAlignedR2, sequencingRunMetrics.percentAlignedR2) &&
        Objects.equals(this.percentErrorRateR1, sequencingRunMetrics.percentErrorRateR1) &&
        Objects.equals(this.percentErrorRateR2, sequencingRunMetrics.percentErrorRateR2) &&
        Objects.equals(this.percentPhasingR1, sequencingRunMetrics.percentPhasingR1) &&
        Objects.equals(this.percentPhasingR2, sequencingRunMetrics.percentPhasingR2) &&
        Objects.equals(this.percentPrePhasingR1, sequencingRunMetrics.percentPrePhasingR1) &&
        Objects.equals(this.percentPrePhasingR2, sequencingRunMetrics.percentPrePhasingR2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runInfo, status, yieldPfR1, yieldPfR2, readsPfR1, readsPfR2, clusterDensityR1, clusterDensityR2, percentPfR1, percentPfR2, percentGreaterThanQ30R1, percentGreaterThanQ30R2, intensityCycle1R1, intensityCycle1R2, percentAlignedR1, percentAlignedR2, percentErrorRateR1, percentErrorRateR2, percentPhasingR1, percentPhasingR2, percentPrePhasingR1, percentPrePhasingR2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SequencingRunMetrics {\n");
    sb.append("    runInfo: ").append(toIndentedString(runInfo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    yieldPfR1: ").append(toIndentedString(yieldPfR1)).append("\n");
    sb.append("    yieldPfR2: ").append(toIndentedString(yieldPfR2)).append("\n");
    sb.append("    readsPfR1: ").append(toIndentedString(readsPfR1)).append("\n");
    sb.append("    readsPfR2: ").append(toIndentedString(readsPfR2)).append("\n");
    sb.append("    clusterDensityR1: ").append(toIndentedString(clusterDensityR1)).append("\n");
    sb.append("    clusterDensityR2: ").append(toIndentedString(clusterDensityR2)).append("\n");
    sb.append("    percentPfR1: ").append(toIndentedString(percentPfR1)).append("\n");
    sb.append("    percentPfR2: ").append(toIndentedString(percentPfR2)).append("\n");
    sb.append("    percentGreaterThanQ30R1: ").append(toIndentedString(percentGreaterThanQ30R1)).append("\n");
    sb.append("    percentGreaterThanQ30R2: ").append(toIndentedString(percentGreaterThanQ30R2)).append("\n");
    sb.append("    intensityCycle1R1: ").append(toIndentedString(intensityCycle1R1)).append("\n");
    sb.append("    intensityCycle1R2: ").append(toIndentedString(intensityCycle1R2)).append("\n");
    sb.append("    percentAlignedR1: ").append(toIndentedString(percentAlignedR1)).append("\n");
    sb.append("    percentAlignedR2: ").append(toIndentedString(percentAlignedR2)).append("\n");
    sb.append("    percentErrorRateR1: ").append(toIndentedString(percentErrorRateR1)).append("\n");
    sb.append("    percentErrorRateR2: ").append(toIndentedString(percentErrorRateR2)).append("\n");
    sb.append("    percentPhasingR1: ").append(toIndentedString(percentPhasingR1)).append("\n");
    sb.append("    percentPhasingR2: ").append(toIndentedString(percentPhasingR2)).append("\n");
    sb.append("    percentPrePhasingR1: ").append(toIndentedString(percentPrePhasingR1)).append("\n");
    sb.append("    percentPrePhasingR2: ").append(toIndentedString(percentPrePhasingR2)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

