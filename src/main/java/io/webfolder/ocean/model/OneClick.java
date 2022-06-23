package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * OneClick
 */
@JsonPropertyOrder({ OneClick.JSON_PROPERTY_SLUG, OneClick.JSON_PROPERTY_TYPE })
public class OneClick {
    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public OneClick() {
    }

    public OneClick slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The slug identifier for the 1-Click application.
     *
     * @return slug
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getSlug() {
        return slug;
    }

    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public OneClick type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the 1-Click application.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Return true if this 1_click object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OneClick _1click = (OneClick) o;
        return Objects.equals(this.slug, _1click.slug) && Objects.equals(this.type, _1click.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OneClick {\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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