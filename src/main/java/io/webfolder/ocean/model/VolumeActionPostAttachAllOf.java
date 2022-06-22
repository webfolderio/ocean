package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * VolumeActionPostAttachAllOf
 */
@JsonPropertyOrder({ VolumeActionPostAttachAllOf.JSON_PROPERTY_DROPLET_ID,
        VolumeActionPostAttachAllOf.JSON_PROPERTY_TAGS })
public class VolumeActionPostAttachAllOf {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public VolumeActionPostAttachAllOf() {
    }

    public VolumeActionPostAttachAllOf dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The unique identifier for the Droplet the volume will be attached or detached
     * from.
     *
     * @return dropletId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "11612190", required = true, value = "The unique identifier for the Droplet the volume will be attached or detached from.")
    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getDropletId() {
        return dropletId;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDropletId(Integer dropletId) {
        this.dropletId = dropletId;
    }

    public VolumeActionPostAttachAllOf tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VolumeActionPostAttachAllOf addTagsItem(String tagsItem) {
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
    @ApiModelProperty(example = "[\"base-image\",\"prod\"]", value = "A flat array of tag names as strings to be applied to the resource. Tag names may be for either existing or new tags.")
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
     * Return true if this volume_action_post_attach_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionPostAttachAllOf volumeActionPostAttachAllOf = (VolumeActionPostAttachAllOf) o;
        return Objects.equals(this.dropletId, volumeActionPostAttachAllOf.dropletId)
                && Objects.equals(this.tags, volumeActionPostAttachAllOf.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionPostAttachAllOf {\n");
        sb.append("    dropletId: ").append(toIndentedString(dropletId)).append("\n");
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
