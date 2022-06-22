package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Snapshot
 */
@JsonPropertyOrder({ Snapshot.JSON_PROPERTY_ID, Snapshot.JSON_PROPERTY_NAME, Snapshot.JSON_PROPERTY_CREATED_AT,
        Snapshot.JSON_PROPERTY_REGIONS, Snapshot.JSON_PROPERTY_MIN_DISK_SIZE, Snapshot.JSON_PROPERTY_SIZE_GIGABYTES,
        Snapshot.JSON_PROPERTY_RESOURCE_ID, Snapshot.JSON_PROPERTY_RESOURCE_TYPE, Snapshot.JSON_PROPERTY_TAGS })
public class Snapshot {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<String> regions = new ArrayList<>();

    public static final String JSON_PROPERTY_MIN_DISK_SIZE = "min_disk_size";
    private Integer minDiskSize;

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Float sizeGigabytes;

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

    public Snapshot() {
    }

    public Snapshot id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The unique identifier for the snapshot.
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "6372321", required = true, value = "The unique identifier for the snapshot.")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(String id) {
        this.id = id;
    }

    public Snapshot name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for the snapshot.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "web-01-1595954862243", required = true, value = "A human-readable name for the snapshot.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public Snapshot createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the snapshot was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "2020-07-28T16:47:44Z", required = true, value = "A time value given in ISO8601 combined date and time format that represents when the snapshot was created.")
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Snapshot regions(List<String> regions) {
        this.regions = regions;
        return this;
    }

    public Snapshot addRegionsItem(String regionsItem) {
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * An array of the regions that the snapshot is available in. The regions are
     * represented by their identifying slug values.
     *
     * @return regions
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "[\"nyc3\",\"sfo3\"]", required = true, value = "An array of the regions that the snapshot is available in. The regions are represented by their identifying slug values.")
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public Snapshot minDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
        return this;
    }

    /**
     * The minimum size in GB required for a volume or Droplet to use this snapshot.
     *
     * @return minDiskSize
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "25", required = true, value = "The minimum size in GB required for a volume or Droplet to use this snapshot.")
    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getMinDiskSize() {
        return minDiskSize;
    }

    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMinDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
    }

    public Snapshot sizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The billable size of the snapshot in gigabytes.
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "2.34", required = true, value = "The billable size of the snapshot in gigabytes.")
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    public Snapshot resourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * The unique identifier for the resource that the snapshot originated from.
     *
     * @return resourceId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "200776916", required = true, value = "The unique identifier for the resource that the snapshot originated from.")
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

    public Snapshot resourceType(ResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * The type of resource that the snapshot originated from.
     *
     * @return resourceType
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "droplet", required = true, value = "The type of resource that the snapshot originated from.")
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

    public Snapshot tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Snapshot addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of Tags the snapshot has been tagged with.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"web\",\"env:prod\"]", required = true, value = "An array of Tags the snapshot has been tagged with.")
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
     * Return true if this snapshot object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Snapshot snapshot = (Snapshot) o;
        return Objects.equals(this.id, snapshot.id) && Objects.equals(this.name, snapshot.name)
                && Objects.equals(this.createdAt, snapshot.createdAt) && Objects.equals(this.regions, snapshot.regions)
                && Objects.equals(this.minDiskSize, snapshot.minDiskSize)
                && Objects.equals(this.sizeGigabytes, snapshot.sizeGigabytes)
                && Objects.equals(this.resourceId, snapshot.resourceId)
                && Objects.equals(this.resourceType, snapshot.resourceType) && Objects.equals(this.tags, snapshot.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, regions, minDiskSize, sizeGigabytes, resourceId, resourceType, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Snapshot {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    minDiskSize: ").append(toIndentedString(minDiskSize)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
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
