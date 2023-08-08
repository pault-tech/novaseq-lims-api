package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Reagent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T00:23:41.052369500Z[Etc/UTC]")
public class Reagent {

  private String name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expirationDate;

  private String lotNumber;

  private String serialNumber;

  private String partNumber;

  private String mode;

  private Integer cycles;

  public Reagent name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Reagent expirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  */
  @Valid 
  @Schema(name = "expirationDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expirationDate")
  public OffsetDateTime getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(OffsetDateTime expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Reagent lotNumber(String lotNumber) {
    this.lotNumber = lotNumber;
    return this;
  }

  /**
   * Get lotNumber
   * @return lotNumber
  */
  
  @Schema(name = "lotNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lotNumber")
  public String getLotNumber() {
    return lotNumber;
  }

  public void setLotNumber(String lotNumber) {
    this.lotNumber = lotNumber;
  }

  public Reagent serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Get serialNumber
   * @return serialNumber
  */
  
  @Schema(name = "serialNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("serialNumber")
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Reagent partNumber(String partNumber) {
    this.partNumber = partNumber;
    return this;
  }

  /**
   * Get partNumber
   * @return partNumber
  */
  
  @Schema(name = "partNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partNumber")
  public String getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(String partNumber) {
    this.partNumber = partNumber;
  }

  public Reagent mode(String mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
  */
  
  @Schema(name = "mode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mode")
  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Reagent cycles(Integer cycles) {
    this.cycles = cycles;
    return this;
  }

  /**
   * Get cycles
   * @return cycles
  */
  
  @Schema(name = "cycles", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cycles")
  public Integer getCycles() {
    return cycles;
  }

  public void setCycles(Integer cycles) {
    this.cycles = cycles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reagent reagent = (Reagent) o;
    return Objects.equals(this.name, reagent.name) &&
        Objects.equals(this.expirationDate, reagent.expirationDate) &&
        Objects.equals(this.lotNumber, reagent.lotNumber) &&
        Objects.equals(this.serialNumber, reagent.serialNumber) &&
        Objects.equals(this.partNumber, reagent.partNumber) &&
        Objects.equals(this.mode, reagent.mode) &&
        Objects.equals(this.cycles, reagent.cycles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, expirationDate, lotNumber, serialNumber, partNumber, mode, cycles);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reagent {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    lotNumber: ").append(toIndentedString(lotNumber)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    partNumber: ").append(toIndentedString(partNumber)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    cycles: ").append(toIndentedString(cycles)).append("\n");
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

