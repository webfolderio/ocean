package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ImageUpdate
 */
@JsonPropertyOrder({ ImageUpdate.JSON_PROPERTY_NAME, ImageUpdate.JSON_PROPERTY_DISTRIBUTION,
        ImageUpdate.JSON_PROPERTY_DESCRIPTION })
public class ImageUpdate {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DISTRIBUTION = "distribution";
    private Distribution distribution;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public ImageUpdate() {
    }

    public ImageUpdate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name that has been given to an image. This is what is shown in
     * the control panel and is generally a descriptive title for the image in
     * question.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public ImageUpdate distribution(Distribution distribution) {
        this.distribution = distribution;
        return this;
    }

    /**
     * Get distribution
     *
     * @return distribution
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISTRIBUTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Distribution getDistribution() {
        return distribution;
    }

    @JsonProperty(JSON_PROPERTY_DISTRIBUTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public ImageUpdate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An optional free-form text field to describe an image.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return true if this image_update object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageUpdate imageUpdate = (ImageUpdate) o;
        return Objects.equals(this.name, imageUpdate.name)
                && Objects.equals(this.distribution, imageUpdate.distribution)
                && Objects.equals(this.description, imageUpdate.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distribution, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageUpdate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    distribution: ").append(toIndentedString(distribution)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
