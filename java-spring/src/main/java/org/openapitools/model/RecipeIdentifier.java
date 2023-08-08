package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.Reagent;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * RecipeIdentifier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-08T00:23:41.052369500Z[Etc/UTC]")
public class RecipeIdentifier {

  private String flowCellId;

  private String libraryContainerId;

  @Valid
  private List<@Valid Reagent> reagents;

  public RecipeIdentifier flowCellId(String flowCellId) {
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

  public RecipeIdentifier libraryContainerId(String libraryContainerId) {
    this.libraryContainerId = libraryContainerId;
    return this;
  }

  /**
   * Get libraryContainerId
   * @return libraryContainerId
  */
  
  @Schema(name = "libraryContainerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libraryContainerId")
  public String getLibraryContainerId() {
    return libraryContainerId;
  }

  public void setLibraryContainerId(String libraryContainerId) {
    this.libraryContainerId = libraryContainerId;
  }

  public RecipeIdentifier reagents(List<@Valid Reagent> reagents) {
    this.reagents = reagents;
    return this;
  }

  public RecipeIdentifier addReagentsItem(Reagent reagentsItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipeIdentifier recipeIdentifier = (RecipeIdentifier) o;
    return Objects.equals(this.flowCellId, recipeIdentifier.flowCellId) &&
        Objects.equals(this.libraryContainerId, recipeIdentifier.libraryContainerId) &&
        Objects.equals(this.reagents, recipeIdentifier.reagents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flowCellId, libraryContainerId, reagents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipeIdentifier {\n");
    sb.append("    flowCellId: ").append(toIndentedString(flowCellId)).append("\n");
    sb.append("    libraryContainerId: ").append(toIndentedString(libraryContainerId)).append("\n");
    sb.append("    reagents: ").append(toIndentedString(reagents)).append("\n");
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

