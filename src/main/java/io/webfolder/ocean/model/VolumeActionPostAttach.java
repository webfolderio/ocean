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
 * VolumeActionPostAttach
 */
@JsonPropertyOrder({ VolumeActionPostAttach.JSON_PROPERTY_TYPE, VolumeActionPostAttach.JSON_PROPERTY_REGION,
        VolumeActionPostAttach.JSON_PROPERTY_DROPLET_ID, VolumeActionPostAttach.JSON_PROPERTY_TAGS })
public class VolumeActionPostAttach {
    /**
     * The volume action to initiate.
     */
    public enum TypeEnum {
        ATTACH("attach"),

        DETACH("detach"),

        RESIZE("resize");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public static final String JSON_PROPERTY_REGION = "region";
    private RegionSlug region;

    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public VolumeActionPostAttach() {
    }

    public VolumeActionPostAttach type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The volume action to initiate.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public VolumeActionPostAttach region(RegionSlug region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RegionSlug getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(RegionSlug region) {
        this.region = region;
    }

    public VolumeActionPostAttach dropletId(Integer dropletId) {
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

    public VolumeActionPostAttach tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public VolumeActionPostAttach addTagsItem(String tagsItem) {
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
     * Return true if this volume_action_post_attach object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionPostAttach volumeActionPostAttach = (VolumeActionPostAttach) o;
        return Objects.equals(this.type, volumeActionPostAttach.type)
                && Objects.equals(this.region, volumeActionPostAttach.region)
                && Objects.equals(this.dropletId, volumeActionPostAttach.dropletId)
                && Objects.equals(this.tags, volumeActionPostAttach.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, region, dropletId, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionPostAttach {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
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
