package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ImageActionTransfer
 */
@JsonPropertyOrder({ ImageActionTransfer.JSON_PROPERTY_TYPE, ImageActionTransfer.JSON_PROPERTY_REGION })
public class ImageActionTransfer {
    /**
     * The action to be taken on the image. Can be either &#x60;convert&#x60; or
     * &#x60;transfer&#x60;.
     */
    public enum TypeEnum {
        CONVERT("convert"),

        TRANSFER("transfer");

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

    public ImageActionTransfer() {
    }

    public ImageActionTransfer type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The action to be taken on the image. Can be either &#x60;convert&#x60; or
     * &#x60;transfer&#x60;.
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

    public ImageActionTransfer region(RegionSlug region) {
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
     * Return true if this image_action_transfer object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageActionTransfer imageActionTransfer = (ImageActionTransfer) o;
        return Objects.equals(this.type, imageActionTransfer.type)
                && Objects.equals(this.region, imageActionTransfer.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageActionTransfer {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
