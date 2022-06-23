package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VolumeFull
 */
@JsonPropertyOrder({ VolumeFull.JSON_PROPERTY_ID, VolumeFull.JSON_PROPERTY_DROPLET_IDS, VolumeFull.JSON_PROPERTY_NAME,
        VolumeFull.JSON_PROPERTY_DESCRIPTION, VolumeFull.JSON_PROPERTY_SIZE_GIGABYTES,
        VolumeFull.JSON_PROPERTY_CREATED_AT, VolumeFull.JSON_PROPERTY_TAGS, VolumeFull.JSON_PROPERTY_REGION,
        VolumeFull.JSON_PROPERTY_FILESYSTEM_TYPE, VolumeFull.JSON_PROPERTY_FILESYSTEM_LABEL })
public class VolumeFull {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_DROPLET_IDS = "droplet_ids";
    private List<Integer> dropletIds = null;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Integer sizeGigabytes;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private String createdAt;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_REGION = "region";
    private Object region;

    public static final String JSON_PROPERTY_FILESYSTEM_TYPE = "filesystem_type";
    private String filesystemType;

    public static final String JSON_PROPERTY_FILESYSTEM_LABEL = "filesystem_label";
    private String filesystemLabel;

    public VolumeFull() {
    }

    @JsonCreator
    public VolumeFull(@JsonProperty(JSON_PROPERTY_ID) String id,
            @JsonProperty(JSON_PROPERTY_DROPLET_IDS) List<Integer> dropletIds,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) String createdAt,
            @JsonProperty(JSON_PROPERTY_REGION) Object region) {
        this();
        this.id = id;
        this.dropletIds = dropletIds;
        this.createdAt = createdAt;
        this.region = region;
    }

    /**
     * The unique identifier for the block storage volume.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getId() {
        return id;
    }

    /**
     * An array containing the IDs of the Droplets the volume is attached to. Note
     * that at this time, a volume can only be attached to a single Droplet.
     *
     * @return dropletIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Integer> getDropletIds() {
        return dropletIds;
    }

    public VolumeFull name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for the block storage volume. Must be lowercase and be
     * composed only of numbers, letters and \&quot;-\&quot;, up to a limit of 64
     * characters. The name must begin with a letter.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public VolumeFull description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An optional free-form text field to describe a block storage volume.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public VolumeFull sizeGigabytes(Integer sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The size of the block storage volume in GiB (1024^3).
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSizeGigabytes(Integer sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the block storage volume was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedAt() {
        return createdAt;
    }

    public VolumeFull tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VolumeFull addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A flat array of tag names as strings to be applied to the resource. Tag names
     * may be for either existing or new tags.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRegion() {
        return region;
    }

    public VolumeFull filesystemType(String filesystemType) {
        this.filesystemType = filesystemType;
        return this;
    }

    /**
     * The type of filesystem currently in-use on the volume.
     *
     * @return filesystemType
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILESYSTEM_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilesystemType() {
        return filesystemType;
    }

    @JsonProperty(JSON_PROPERTY_FILESYSTEM_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilesystemType(String filesystemType) {
        this.filesystemType = filesystemType;
    }

    public VolumeFull filesystemLabel(String filesystemLabel) {
        this.filesystemLabel = filesystemLabel;
        return this;
    }

    /**
     * The label currently applied to the filesystem.
     *
     * @return filesystemLabel
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILESYSTEM_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilesystemLabel() {
        return filesystemLabel;
    }

    @JsonProperty(JSON_PROPERTY_FILESYSTEM_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilesystemLabel(String filesystemLabel) {
        this.filesystemLabel = filesystemLabel;
    }

    /**
     * Return true if this volume_full object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeFull volumeFull = (VolumeFull) o;
        return Objects.equals(this.id, volumeFull.id) && Objects.equals(this.dropletIds, volumeFull.dropletIds)
                && Objects.equals(this.name, volumeFull.name)
                && Objects.equals(this.description, volumeFull.description)
                && Objects.equals(this.sizeGigabytes, volumeFull.sizeGigabytes)
                && Objects.equals(this.createdAt, volumeFull.createdAt) && Objects.equals(this.tags, volumeFull.tags)
                && Objects.equals(this.region, volumeFull.region)
                && Objects.equals(this.filesystemType, volumeFull.filesystemType)
                && Objects.equals(this.filesystemLabel, volumeFull.filesystemLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dropletIds, name, description, sizeGigabytes, createdAt, tags, region, filesystemType,
                filesystemLabel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeFull {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    dropletIds: ").append(toIndentedString(dropletIds)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    filesystemType: ").append(toIndentedString(filesystemType)).append("\n");
        sb.append("    filesystemLabel: ").append(toIndentedString(filesystemLabel)).append("\n");
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