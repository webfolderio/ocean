package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetImagesListResponse
 */
@JsonPropertyOrder({ GetImagesListResponse.JSON_PROPERTY_IMAGES, GetImagesListResponse.JSON_PROPERTY_LINKS,
        GetImagesListResponse.JSON_PROPERTY_META })
public class GetImagesListResponse {
    public static final String JSON_PROPERTY_IMAGES = "images";
    private List<Image> images = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public GetImagesListResponse() {
    }

    public GetImagesListResponse images(List<Image> images) {
        this.images = images;
        return this;
    }

    public GetImagesListResponse addImagesItem(Image imagesItem) {
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

    public GetImagesListResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public GetImagesListResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this get_images_list_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetImagesListResponse getImagesListResponse = (GetImagesListResponse) o;
        return Objects.equals(this.images, getImagesListResponse.images)
                && Objects.equals(this.links, getImagesListResponse.links)
                && Objects.equals(this.meta, getImagesListResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(images, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetImagesListResponse {\n");
        sb.append("    images: ").append(toIndentedString(images)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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