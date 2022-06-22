package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletActionRebuildAllOf
 */
@JsonPropertyOrder({ DropletActionRebuildAllOf.JSON_PROPERTY_IMAGE })
public class DropletActionRebuildAllOf {
    public static final String JSON_PROPERTY_IMAGE = "image";
    private String image;

    public DropletActionRebuildAllOf() {
    }

    public DropletActionRebuildAllOf image(String image) {
        this.image = image;
        return this;
    }

    /**
     * The image ID of a public or private image or the slug identifier for a public
     * image. The Droplet will be rebuilt using this image as its base.
     *
     * @return image
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getImage() {
        return image;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Return true if this droplet_action_rebuild_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionRebuildAllOf dropletActionRebuildAllOf = (DropletActionRebuildAllOf) o;
        return Objects.equals(this.image, dropletActionRebuildAllOf.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionRebuildAllOf {\n");
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
