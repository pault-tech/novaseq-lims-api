package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * RunInfo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T00:23:41.052369500Z[Etc/UTC]")
public class RunInfo {

  private String runId;

  private String flowCellId;

  private String libraryTubeId;

  private String instrumentId;

  /**
   * Gets or Sets instrumentType
   */
  public enum InstrumentTypeEnum {
    NUMBER_0(0);

    private Integer value;

    InstrumentTypeEnum(Integer value) {
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
    public static InstrumentTypeEnum fromValue(Integer value) {
      for (InstrumentTypeEnum b : InstrumentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private InstrumentTypeEnum instrumentType;

  private String flowCellSide;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateTime;

  private String outputFolder;

  private String userName;

  public RunInfo runId(String runId) {
    this.runId = runId;
    return this;
  }

  /**
   * Get runId
   * @return runId
  */
  
  @Schema(name = "runId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("runId")
  public String getRunId() {
    return runId;
  }

  public void setRunId(String runId) {
    this.runId = runId;
  }

  public RunInfo flowCellId(String flowCellId) {
    this.flowCellId = flowCellId;
    return this;
  }

  /**
   * Get flowCellId
   * @return flowCellId
  */
  
  @Schema(name = "flowCellId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("flowCellId")
  public String getFlowCellId() {
    return flowCellId;
  }

  public void setFlowCellId(String flowCellId) {
    this.flowCellId = flowCellId;
  }

  public RunInfo libraryTubeId(String libraryTubeId) {
    this.libraryTubeId = libraryTubeId;
    return this;
  }

  /**
   * Get libraryTubeId
   * @return libraryTubeId
  */
  
  @Schema(name = "libraryTubeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libraryTubeId")
  public String getLibraryTubeId() {
    return libraryTubeId;
  }

  public void setLibraryTubeId(String libraryTubeId) {
    this.libraryTubeId = libraryTubeId;
  }

  public RunInfo instrumentId(String instrumentId) {
    this.instrumentId = instrumentId;
    return this;
  }

  /**
   * Get instrumentId
   * @return instrumentId
  */
  
  @Schema(name = "instrumentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instrumentId")
  public String getInstrumentId() {
    return instrumentId;
  }

  public void setInstrumentId(String instrumentId) {
    this.instrumentId = instrumentId;
  }

  public RunInfo instrumentType(InstrumentTypeEnum instrumentType) {
    this.instrumentType = instrumentType;
    return this;
  }

  /**
   * Get instrumentType
   * @return instrumentType
  */
  
  @Schema(name = "instrumentType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instrumentType")
  public InstrumentTypeEnum getInstrumentType() {
    return instrumentType;
  }

  public void setInstrumentType(InstrumentTypeEnum instrumentType) {
    this.instrumentType = instrumentType;
  }

  public RunInfo flowCellSide(String flowCellSide) {
    this.flowCellSide = flowCellSide;
    return this;
  }

  /**
   * Get flowCellSide
   * @return flowCellSide
  */
  
  @Schema(name = "flowCellSide", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("flowCellSide")
  public String getFlowCellSide() {
    return flowCellSide;
  }

  public void setFlowCellSide(String flowCellSide) {
    this.flowCellSide = flowCellSide;
  }

  public RunInfo dateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
  */
  @Valid 
  @Schema(name = "dateTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateTime")
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public RunInfo outputFolder(String outputFolder) {
    this.outputFolder = outputFolder;
    return this;
  }

  /**
   * Get outputFolder
   * @return outputFolder
  */
  
  @Schema(name = "outputFolder", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("outputFolder")
  public String getOutputFolder() {
    return outputFolder;
  }

  public void setOutputFolder(String outputFolder) {
    this.outputFolder = outputFolder;
  }

  public RunInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  
  @Schema(name = "userName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RunInfo runInfo = (RunInfo) o;
    return Objects.equals(this.runId, runInfo.runId) &&
        Objects.equals(this.flowCellId, runInfo.flowCellId) &&
        Objects.equals(this.libraryTubeId, runInfo.libraryTubeId) &&
        Objects.equals(this.instrumentId, runInfo.instrumentId) &&
        Objects.equals(this.instrumentType, runInfo.instrumentType) &&
        Objects.equals(this.flowCellSide, runInfo.flowCellSide) &&
        Objects.equals(this.dateTime, runInfo.dateTime) &&
        Objects.equals(this.outputFolder, runInfo.outputFolder) &&
        Objects.equals(this.userName, runInfo.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runId, flowCellId, libraryTubeId, instrumentId, instrumentType, flowCellSide, dateTime, outputFolder, userName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RunInfo {\n");
    sb.append("    runId: ").append(toIndentedString(runId)).append("\n");
    sb.append("    flowCellId: ").append(toIndentedString(flowCellId)).append("\n");
    sb.append("    libraryTubeId: ").append(toIndentedString(libraryTubeId)).append("\n");
    sb.append("    instrumentId: ").append(toIndentedString(instrumentId)).append("\n");
    sb.append("    instrumentType: ").append(toIndentedString(instrumentType)).append("\n");
    sb.append("    flowCellSide: ").append(toIndentedString(flowCellSide)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    outputFolder: ").append(toIndentedString(outputFolder)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
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

