package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.Reagent;
import org.openapitools.model.RunInfo;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SequencingRunStatusDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T00:23:41.052369500Z[Etc/UTC]")
public class SequencingRunStatusDto {

  private RunInfo runInfo;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    NUMBER_0(0),
    
    NUMBER_1(1),
    
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

  @Valid
  private List<@Valid Reagent> reagents;

  private Integer currentCycle;

  private Integer currentRead;

  private String instrumentControlSoftwareVersion;

  private String rtaVersion;

  private String firmwareVersion;

  public SequencingRunStatusDto runInfo(RunInfo runInfo) {
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

  public SequencingRunStatusDto status(StatusEnum status) {
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

  public SequencingRunStatusDto reagents(List<@Valid Reagent> reagents) {
    this.reagents = reagents;
    return this;
  }

  public SequencingRunStatusDto addReagentsItem(Reagent reagentsItem) {
    if (this.reagents == null) {
      this.reagents = new ArrayList<>();
    }
    this.reagents.add(reagentsItem);
    return this;
  }

  /**
   * Get reagents
   * @return reagents
  */
  @Valid 
  @Schema(name = "reagents", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reagents")
  public List<@Valid Reagent> getReagents() {
    return reagents;
  }

  public void setReagents(List<@Valid Reagent> reagents) {
    this.reagents = reagents;
  }

  public SequencingRunStatusDto currentCycle(Integer currentCycle) {
    this.currentCycle = currentCycle;
    return this;
  }

  /**
   * Get currentCycle
   * @return currentCycle
  */
  
  @Schema(name = "currentCycle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentCycle")
  public Integer getCurrentCycle() {
    return currentCycle;
  }

  public void setCurrentCycle(Integer currentCycle) {
    this.currentCycle = currentCycle;
  }

  public SequencingRunStatusDto currentRead(Integer currentRead) {
    this.currentRead = currentRead;
    return this;
  }

  /**
   * Get currentRead
   * @return currentRead
  */
  
  @Schema(name = "currentRead", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentRead")
  public Integer getCurrentRead() {
    return currentRead;
  }

  public void setCurrentRead(Integer currentRead) {
    this.currentRead = currentRead;
  }

  public SequencingRunStatusDto instrumentControlSoftwareVersion(String instrumentControlSoftwareVersion) {
    this.instrumentControlSoftwareVersion = instrumentControlSoftwareVersion;
    return this;
  }

  /**
   * Get instrumentControlSoftwareVersion
   * @return instrumentControlSoftwareVersion
  */
  
  @Schema(name = "instrumentControlSoftwareVersion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instrumentControlSoftwareVersion")
  public String getInstrumentControlSoftwareVersion() {
    return instrumentControlSoftwareVersion;
  }

  public void setInstrumentControlSoftwareVersion(String instrumentControlSoftwareVersion) {
    this.instrumentControlSoftwareVersion = instrumentControlSoftwareVersion;
  }

  public SequencingRunStatusDto rtaVersion(String rtaVersion) {
    this.rtaVersion = rtaVersion;
    return this;
  }

  /**
   * Get rtaVersion
   * @return rtaVersion
  */
  
  @Schema(name = "rtaVersion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rtaVersion")
  public String getRtaVersion() {
    return rtaVersion;
  }

  public void setRtaVersion(String rtaVersion) {
    this.rtaVersion = rtaVersion;
  }

  public SequencingRunStatusDto firmwareVersion(String firmwareVersion) {
    this.firmwareVersion = firmwareVersion;
    return this;
  }

  /**
   * Get firmwareVersion
   * @return firmwareVersion
  */
  
  @Schema(name = "firmwareVersion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firmwareVersion")
  public String getFirmwareVersion() {
    return firmwareVersion;
  }

  public void setFirmwareVersion(String firmwareVersion) {
    this.firmwareVersion = firmwareVersion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SequencingRunStatusDto sequencingRunStatusDto = (SequencingRunStatusDto) o;
    return Objects.equals(this.runInfo, sequencingRunStatusDto.runInfo) &&
        Objects.equals(this.status, sequencingRunStatusDto.status) &&
        Objects.equals(this.reagents, sequencingRunStatusDto.reagents) &&
        Objects.equals(this.currentCycle, sequencingRunStatusDto.currentCycle) &&
        Objects.equals(this.currentRead, sequencingRunStatusDto.currentRead) &&
        Objects.equals(this.instrumentControlSoftwareVersion, sequencingRunStatusDto.instrumentControlSoftwareVersion) &&
        Objects.equals(this.rtaVersion, sequencingRunStatusDto.rtaVersion) &&
        Objects.equals(this.firmwareVersion, sequencingRunStatusDto.firmwareVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runInfo, status, reagents, currentCycle, currentRead, instrumentControlSoftwareVersion, rtaVersion, firmwareVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SequencingRunStatusDto {\n");
    sb.append("    runInfo: ").append(toIndentedString(runInfo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reagents: ").append(toIndentedString(reagents)).append("\n");
    sb.append("    currentCycle: ").append(toIndentedString(currentCycle)).append("\n");
    sb.append("    currentRead: ").append(toIndentedString(currentRead)).append("\n");
    sb.append("    instrumentControlSoftwareVersion: ").append(toIndentedString(instrumentControlSoftwareVersion)).append("\n");
    sb.append("    rtaVersion: ").append(toIndentedString(rtaVersion)).append("\n");
    sb.append("    firmwareVersion: ").append(toIndentedString(firmwareVersion)).append("\n");
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

