package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ImageActionTransferAllOf
 */
@JsonPropertyOrder({ ImageActionTransferAllOf.JSON_PROPERTY_REGION })
public class ImageActionTransferAllOf {
    public static final String JSON_PROPERTY_REGION = "region";
    private RegionSlug region;

    public ImageActionTransferAllOf() {
    }

    public ImageActionTransferAllOf region(RegionSlug region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public RegionSlug getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(RegionSlug region) {
        this.region = region;
    }

    /**
     * Return true if this image_action_transfer_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageActionTransferAllOf imageActionTransferAllOf = (ImageActionTransferAllOf) o;
        return Objects.equals(this.region, imageActionTransferAllOf.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageActionTransferAllOf {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
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