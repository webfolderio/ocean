package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetImagesListResponseAllOf
 */
@JsonPropertyOrder({ GetImagesListResponseAllOf.JSON_PROPERTY_IMAGES })
public class GetImagesListResponseAllOf {
    public static final String JSON_PROPERTY_IMAGES = "images";
    private List<Image> images = new ArrayList<>();

    public GetImagesListResponseAllOf() {
    }

    public GetImagesListResponseAllOf images(List<Image> images) {
        this.images = images;
        return this;
    }

    public GetImagesListResponseAllOf addImagesItem(Image imagesItem) {
        this.images.add(imagesItem);
        return this;
    }

    /**
     * Get images
     *
     * @return images
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_IMAGES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty(JSON_PROPERTY_IMAGES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * Return true if this get_images_list_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetImagesListResponseAllOf getImagesListResponseAllOf = (GetImagesListResponseAllOf) o;
        return Objects.equals(this.images, getImagesListResponseAllOf.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(images);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetImagesListResponseAllOf {\n");
        sb.append("    images: ").append(toIndentedString(images)).append("\n");
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