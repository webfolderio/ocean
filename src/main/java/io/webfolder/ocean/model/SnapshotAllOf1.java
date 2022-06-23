package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * SnapshotAllOf1
 */
@JsonPropertyOrder({ SnapshotAllOf1.JSON_PROPERTY_RESOURCE_ID, SnapshotAllOf1.JSON_PROPERTY_RESOURCE_TYPE,
        SnapshotAllOf1.JSON_PROPERTY_TAGS })
public class SnapshotAllOf1 {
    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private String resourceId;

    /**
     * The type of resource that the snapshot originated from.
     */
    public enum ResourceTypeEnum {
        DROPLET("droplet"),

        VOLUME("volume");

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

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = new ArrayList<>();

    public SnapshotAllOf1() {
    }

    public SnapshotAllOf1 resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * The unique identifier for the resource that the snapshot originated from.
     *
     * @return resourceId
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public SnapshotAllOf1 resourceType(ResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * The type of resource that the snapshot originated from.
     *
     * @return resourceType
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ResourceTypeEnum getResourceType() {
        return resourceType;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setResourceType(ResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
    }

    public SnapshotAllOf1 tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public SnapshotAllOf1 addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of Tags the snapshot has been tagged with.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this snapshot_allOf_1 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SnapshotAllOf1 snapshotAllOf1 = (SnapshotAllOf1) o;
        return Objects.equals(this.resourceId, snapshotAllOf1.resourceId)
                && Objects.equals(this.resourceType, snapshotAllOf1.resourceType)
                && Objects.equals(this.tags, snapshotAllOf1.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceId, resourceType, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SnapshotAllOf1 {\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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