package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateCustomImageResponse
 */
@JsonPropertyOrder({ CreateCustomImageResponse.JSON_PROPERTY_IMAGE })
public class CreateCustomImageResponse {
    public static final String JSON_PROPERTY_IMAGE = "image";
    private Image image;

    public CreateCustomImageResponse() {
    }

    public CreateCustomImageResponse image(Image image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Image getImage() {
        return image;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Return true if this create_custom_image_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCustomImageResponse createCustomImageResponse = (CreateCustomImageResponse) o;
        return Objects.equals(this.image, createCustomImageResponse.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateCustomImageResponse {\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
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
