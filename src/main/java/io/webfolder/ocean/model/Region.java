package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Region
 */
@JsonPropertyOrder({ Region.JSON_PROPERTY_NAME, Region.JSON_PROPERTY_SLUG, Region.JSON_PROPERTY_FEATURES,
        Region.JSON_PROPERTY_AVAILABLE, Region.JSON_PROPERTY_SIZES })
public class Region {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_FEATURES = "features";
    private List<String> features = new ArrayList<>();

    public static final String JSON_PROPERTY_AVAILABLE = "available";
    private Boolean available;

    public static final String JSON_PROPERTY_SIZES = "sizes";
    private List<String> sizes = new ArrayList<>();

    public Region() {
    }

    public Region name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name of the region. This will be a full name that is used in the
     * control panel and other interfaces.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public Region slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * A human-readable string that is used as a unique identifier for each region.
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

    public Region features(List<String> features) {
        this.features = features;
        return this;
    }

    public Region addFeaturesItem(String featuresItem) {
        this.features.add(featuresItem);
        return this;
    }

    /**
     * This attribute is set to an array which contains features available in this
     * region
     *
     * @return features
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_FEATURES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty(JSON_PROPERTY_FEATURES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Region available(Boolean available) {
        this.available = available;
        return this;
    }

    /**
     * This is a boolean value that represents whether new Droplets can be created
     * in this region.
     *
     * @return available
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getAvailable() {
        return available;
    }

    @JsonProperty(JSON_PROPERTY_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Region sizes(List<String> sizes) {
        this.sizes = sizes;
        return this;
    }

    public Region addSizesItem(String sizesItem) {
        this.sizes.add(sizesItem);
        return this;
    }

    /**
     * This attribute is set to an array which contains the identifying slugs for
     * the sizes available in this region.
     *
     * @return sizes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getSizes() {
        return sizes;
    }

    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    /**
     * Return true if this region object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Region region = (Region) o;
        return Objects.equals(this.name, region.name) && Objects.equals(this.slug, region.slug)
                && Objects.equals(this.features, region.features) && Objects.equals(this.available, region.available)
                && Objects.equals(this.sizes, region.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug, features, available, sizes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Region {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    features: ").append(toIndentedString(features)).append("\n");
        sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    sizes: ").append(toIndentedString(sizes)).append("\n");
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