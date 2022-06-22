package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ImageActionBase
 */
@JsonPropertyOrder({ ImageActionBase.JSON_PROPERTY_TYPE })
public class ImageActionBase {
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

    public ImageActionBase() {
    }

    public ImageActionBase type(TypeEnum type) {
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
    @ApiModelProperty(example = "convert", required = true, value = "The action to be taken on the image. Can be either `convert` or `transfer`.")
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

    /**
     * Return true if this image_action_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageActionBase imageActionBase = (ImageActionBase) o;
        return Objects.equals(this.type, imageActionBase.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageActionBase {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
