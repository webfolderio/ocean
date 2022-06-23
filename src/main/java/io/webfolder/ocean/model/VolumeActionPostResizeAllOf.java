package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VolumeActionPostResizeAllOf
 */
@JsonPropertyOrder({ VolumeActionPostResizeAllOf.JSON_PROPERTY_SIZE_GIGABYTES })
public class VolumeActionPostResizeAllOf {
    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Integer sizeGigabytes;

    public VolumeActionPostResizeAllOf() {
    }

    public VolumeActionPostResizeAllOf sizeGigabytes(Integer sizeGigabytes) {
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
     * Return true if this volume_action_post_resize_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionPostResizeAllOf volumeActionPostResizeAllOf = (VolumeActionPostResizeAllOf) o;
        return Objects.equals(this.sizeGigabytes, volumeActionPostResizeAllOf.sizeGigabytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeGigabytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionPostResizeAllOf {\n");
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