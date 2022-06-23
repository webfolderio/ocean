package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VolumeActionAllOf
 */
@JsonPropertyOrder({ VolumeActionAllOf.JSON_PROPERTY_TYPE, VolumeActionAllOf.JSON_PROPERTY_RESOURCE_ID })
public class VolumeActionAllOf {
    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private Integer resourceId;

    public VolumeActionAllOf() {
    }

    public VolumeActionAllOf type(String type) {
        this.type = type;
        return this;
    }

    /**
     * This is the type of action that the object represents. For example, this
     * could be \&quot;attach_volume\&quot; to represent the state of a volume
     * attach action.
     *
     * @return type
     **/
    @javax.annotation.Nullable
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

    public VolumeActionAllOf resourceId(Integer resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get resourceId
     *
     * @return resourceId
     **/
    @javax.annotation.Nullable
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

    /**
     * Return true if this volume_action_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionAllOf volumeActionAllOf = (VolumeActionAllOf) o;
        return Objects.equals(this.type, volumeActionAllOf.type)
                && Objects.equals(this.resourceId, volumeActionAllOf.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, resourceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionAllOf {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
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