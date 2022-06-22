package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VolumeBase
 */
@JsonPropertyOrder({ VolumeBase.JSON_PROPERTY_ID, VolumeBase.JSON_PROPERTY_DROPLET_IDS, VolumeBase.JSON_PROPERTY_NAME,
        VolumeBase.JSON_PROPERTY_DESCRIPTION, VolumeBase.JSON_PROPERTY_SIZE_GIGABYTES,
        VolumeBase.JSON_PROPERTY_CREATED_AT, VolumeBase.JSON_PROPERTY_TAGS })
public class VolumeBase {
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

    public VolumeBase() {
    }

    @JsonCreator
    public VolumeBase(@JsonProperty(JSON_PROPERTY_ID) String id,
            @JsonProperty(JSON_PROPERTY_DROPLET_IDS) List<Integer> dropletIds,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) String createdAt) {
        this();
        this.id = id;
        this.dropletIds = dropletIds;
        this.createdAt = createdAt;
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

    public VolumeBase name(String name) {
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

    public VolumeBase description(String description) {
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

    public VolumeBase sizeGigabytes(Integer sizeGigabytes) {
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

    public VolumeBase tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VolumeBase addTagsItem(String tagsItem) {
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
     * Return true if this volume_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeBase volumeBase = (VolumeBase) o;
        return Objects.equals(this.id, volumeBase.id) && Objects.equals(this.dropletIds, volumeBase.dropletIds)
                && Objects.equals(this.name, volumeBase.name)
                && Objects.equals(this.description, volumeBase.description)
                && Objects.equals(this.sizeGigabytes, volumeBase.sizeGigabytes)
                && Objects.equals(this.createdAt, volumeBase.createdAt) && Objects.equals(this.tags, volumeBase.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dropletIds, name, description, sizeGigabytes, createdAt, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeBase {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    dropletIds: ").append(toIndentedString(dropletIds)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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
