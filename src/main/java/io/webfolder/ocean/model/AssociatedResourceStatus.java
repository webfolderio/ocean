package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An objects containing information about a resources scheduled for deletion.
 */
@ApiModel(description = "An objects containing information about a resources scheduled for deletion.")
@JsonPropertyOrder({ AssociatedResourceStatus.JSON_PROPERTY_DROPLET, AssociatedResourceStatus.JSON_PROPERTY_RESOURCES,
        AssociatedResourceStatus.JSON_PROPERTY_COMPLETED_AT, AssociatedResourceStatus.JSON_PROPERTY_FAILURES })
public class AssociatedResourceStatus {
    public static final String JSON_PROPERTY_DROPLET = "droplet";
    private DestroyedAssociatedResource droplet;

    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private AssociatedResourceStatusResources resources;

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";
    private OffsetDateTime completedAt;

    public static final String JSON_PROPERTY_FAILURES = "failures";
    private Integer failures;

    public AssociatedResourceStatus() {
    }

    public AssociatedResourceStatus droplet(DestroyedAssociatedResource droplet) {
        this.droplet = droplet;
        return this;
    }

    /**
     * Get droplet
     *
     * @return droplet
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DestroyedAssociatedResource getDroplet() {
        return droplet;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplet(DestroyedAssociatedResource droplet) {
        this.droplet = droplet;
    }

    public AssociatedResourceStatus resources(AssociatedResourceStatusResources resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Get resources
     *
     * @return resources
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AssociatedResourceStatusResources getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResources(AssociatedResourceStatusResources resources) {
        this.resources = resources;
    }

    public AssociatedResourceStatus completedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format indicating when
     * the requested action was completed.
     *
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-04-01T18:11:49Z", value = "A time value given in ISO8601 combined date and time format indicating when the requested action was completed.")
    @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public AssociatedResourceStatus failures(Integer failures) {
        this.failures = failures;
        return this;
    }

    /**
     * A count of the associated resources that failed to be destroyed, if any.
     *
     * @return failures
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "0", value = "A count of the associated resources that failed to be destroyed, if any.")
    @JsonProperty(JSON_PROPERTY_FAILURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getFailures() {
        return failures;
    }

    @JsonProperty(JSON_PROPERTY_FAILURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    /**
     * Return true if this associated_resource_status object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssociatedResourceStatus associatedResourceStatus = (AssociatedResourceStatus) o;
        return Objects.equals(this.droplet, associatedResourceStatus.droplet)
                && Objects.equals(this.resources, associatedResourceStatus.resources)
                && Objects.equals(this.completedAt, associatedResourceStatus.completedAt)
                && Objects.equals(this.failures, associatedResourceStatus.failures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplet, resources, completedAt, failures);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssociatedResourceStatus {\n");
        sb.append("    droplet: ").append(toIndentedString(droplet)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
        sb.append("    failures: ").append(toIndentedString(failures)).append("\n");
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
