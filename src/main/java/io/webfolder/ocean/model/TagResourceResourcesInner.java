package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * TagResourceResourcesInner
 */
@JsonPropertyOrder({ TagResourceResourcesInner.JSON_PROPERTY_RESOURCE_ID,
        TagResourceResourcesInner.JSON_PROPERTY_RESOURCE_TYPE })
public class TagResourceResourcesInner {
    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private String resourceId;

    /**
     * The type of the resource.
     */
    public enum ResourceTypeEnum {
        DROPLET("droplet"),

        IMAGE("image"),

        VOLUME("volume"),

        VOLUME_SNAPSHOT("volume_snapshot");

        private String value;

        ResourceTypeEnum(String value) {
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
        public static ResourceTypeEnum fromValue(String value) {
            for (ResourceTypeEnum b : ResourceTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
    private ResourceTypeEnum resourceType;

    public TagResourceResourcesInner() {
    }

    public TagResourceResourcesInner resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * The identifier of a resource.
     *
     * @return resourceId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public TagResourceResourcesInner resourceType(ResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * The type of the resource.
     *
     * @return resourceType
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ResourceTypeEnum getResourceType() {
        return resourceType;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceType(ResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * Return true if this tag_resource_resources_inner object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagResourceResourcesInner tagResourceResourcesInner = (TagResourceResourcesInner) o;
        return Objects.equals(this.resourceId, tagResourceResourcesInner.resourceId)
                && Objects.equals(this.resourceType, tagResourceResourcesInner.resourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, resourceType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagResourceResourcesInner {\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
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