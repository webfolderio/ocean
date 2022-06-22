package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * VolumeActionPostResize
 */
@JsonPropertyOrder({ VolumeActionPostResize.JSON_PROPERTY_TYPE, VolumeActionPostResize.JSON_PROPERTY_REGION,
        VolumeActionPostResize.JSON_PROPERTY_SIZE_GIGABYTES })
public class VolumeActionPostResize {
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

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Integer sizeGigabytes;

    public VolumeActionPostResize() {
    }

    public VolumeActionPostResize type(TypeEnum type) {
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

    public VolumeActionPostResize region(RegionSlug region) {
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

    public VolumeActionPostResize sizeGigabytes(Integer sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The new size of the block storage volume in GiB (1024^3). maximum: 16384
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizeGigabytes(Integer sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    /**
     * Return true if this volume_action_post_resize object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionPostResize volumeActionPostResize = (VolumeActionPostResize) o;
        return Objects.equals(this.type, volumeActionPostResize.type)
                && Objects.equals(this.region, volumeActionPostResize.region)
                && Objects.equals(this.sizeGigabytes, volumeActionPostResize.sizeGigabytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, region, sizeGigabytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionPostResize {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
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
