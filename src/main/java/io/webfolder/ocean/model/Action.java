package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Action
 */
@JsonPropertyOrder({ Action.JSON_PROPERTY_ID, Action.JSON_PROPERTY_STATUS, Action.JSON_PROPERTY_TYPE,
        Action.JSON_PROPERTY_STARTED_AT, Action.JSON_PROPERTY_COMPLETED_AT, Action.JSON_PROPERTY_RESOURCE_ID,
        Action.JSON_PROPERTY_RESOURCE_TYPE, Action.JSON_PROPERTY_REGION, Action.JSON_PROPERTY_REGION_SLUG })
public class Action {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    /**
     * The current status of the action. This can be \&quot;in-progress\&quot;,
     * \&quot;completed\&quot;, or \&quot;errored\&quot;.
     */
    public enum StatusEnum {
        IN_PROGRESS("in-progress"),

        COMPLETED("completed"),

        ERRORED("errored");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status = StatusEnum.IN_PROGRESS;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_STARTED_AT = "started_at";
    private OffsetDateTime startedAt;

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";
    private OffsetDateTime completedAt;

    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private Integer resourceId;

    public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
    private String resourceType;

    public static final String JSON_PROPERTY_REGION = "region";
    private Region region;

    public static final String JSON_PROPERTY_REGION_SLUG = "region_slug";
    private String regionSlug;

    public Action() {
    }

    public Action id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * A unique numeric ID that can be used to identify and reference an action.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "36804636", value = "A unique numeric ID that can be used to identify and reference an action.")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(Integer id) {
        this.id = id;
    }

    public Action status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The current status of the action. This can be \&quot;in-progress\&quot;,
     * \&quot;completed\&quot;, or \&quot;errored\&quot;.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "completed", value = "The current status of the action. This can be \"in-progress\", \"completed\", or \"errored\".")
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Action type(String type) {
        this.type = type;
        return this;
    }

    /**
     * This is the type of action that the object represents. For example, this
     * could be \&quot;transfer\&quot; to represent the state of an image transfer
     * action.
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "create", value = "This is the type of action that the object represents. For example, this could be \"transfer\" to represent the state of an image transfer action.")
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(String type) {
        this.type = type;
    }

    public Action startedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the action was initiated.
     *
     * @return startedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-11-14T16:29:21Z", value = "A time value given in ISO8601 combined date and time format that represents when the action was initiated.")
    @JsonProperty(JSON_PROPERTY_STARTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    @JsonProperty(JSON_PROPERTY_STARTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public Action completedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the action was completed.
     *
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-11-14T16:30:06Z", value = "A time value given in ISO8601 combined date and time format that represents when the action was completed.")
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

    public Action resourceId(Integer resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * A unique identifier for the resource that the action is associated with.
     *
     * @return resourceId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "3164444", value = "A unique identifier for the resource that the action is associated with.")
    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getResourceId() {
        return resourceId;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Action resourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * The type of resource that the action is associated with.
     *
     * @return resourceType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "droplet", value = "The type of resource that the action is associated with.")
    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getResourceType() {
        return resourceType;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Action region(Region region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Region getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(Region region) {
        this.region = region;
    }

    public Action regionSlug(String regionSlug) {
        this.regionSlug = regionSlug;
        return this;
    }

    /**
     * Get regionSlug
     *
     * @return regionSlug
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGION_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegionSlug() {
        return regionSlug;
    }

    @JsonProperty(JSON_PROPERTY_REGION_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegionSlug(String regionSlug) {
        this.regionSlug = regionSlug;
    }

    /**
     * Return true if this action object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Action action = (Action) o;
        return Objects.equals(this.id, action.id) && Objects.equals(this.status, action.status)
                && Objects.equals(this.type, action.type) && Objects.equals(this.startedAt, action.startedAt)
                && Objects.equals(this.completedAt, action.completedAt)
                && Objects.equals(this.resourceId, action.resourceId)
                && Objects.equals(this.resourceType, action.resourceType) && Objects.equals(this.region, action.region)
                && Objects.equals(this.regionSlug, action.regionSlug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, type, startedAt, completedAt, resourceId, resourceType, region, regionSlug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Action {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
        sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    regionSlug: ").append(toIndentedString(regionSlug)).append("\n");
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
