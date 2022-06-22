package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * FloatingIpRegion
 */
@JsonPropertyOrder({ FloatingIpRegion.JSON_PROPERTY_NAME, FloatingIpRegion.JSON_PROPERTY_SLUG,
        FloatingIpRegion.JSON_PROPERTY_FEATURES, FloatingIpRegion.JSON_PROPERTY_AVAILABLE,
        FloatingIpRegion.JSON_PROPERTY_SIZES })
public class FloatingIpRegion {
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

    public FloatingIpRegion() {
    }

    public FloatingIpRegion name(String name) {
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
    @ApiModelProperty(example = "New York 3", required = true, value = "The display name of the region.  This will be a full name that is used in the control panel and other interfaces.")
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

    public FloatingIpRegion slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * A human-readable string that is used as a unique identifier for each region.
     *
     * @return slug
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "nyc3", required = true, value = "A human-readable string that is used as a unique identifier for each region.")
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

    public FloatingIpRegion features(List<String> features) {
        this.features = features;
        return this;
    }

    public FloatingIpRegion addFeaturesItem(String featuresItem) {
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
    @ApiModelProperty(example = "[\"private_networking\",\"backups\",\"ipv6\",\"metadata\",\"install_agent\",\"storage\",\"image_transfer\"]", required = true, value = "This attribute is set to an array which contains features available in this region")
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

    public FloatingIpRegion available(Boolean available) {
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
    @ApiModelProperty(example = "true", required = true, value = "This is a boolean value that represents whether new Droplets can be created in this region.")
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

    public FloatingIpRegion sizes(List<String> sizes) {
        this.sizes = sizes;
        return this;
    }

    public FloatingIpRegion addSizesItem(String sizesItem) {
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
    @ApiModelProperty(example = "[\"s-1vcpu-1gb\",\"s-1vcpu-2gb\",\"s-1vcpu-3gb\",\"s-2vcpu-2gb\",\"s-3vcpu-1gb\",\"s-2vcpu-4gb\",\"s-4vcpu-8gb\",\"s-6vcpu-16gb\",\"s-8vcpu-32gb\",\"s-12vcpu-48gb\",\"s-16vcpu-64gb\",\"s-20vcpu-96gb\",\"s-24vcpu-128gb\",\"s-32vcpu-192g\"]", required = true, value = "This attribute is set to an array which contains the identifying slugs for the sizes available in this region.")
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
     * Return true if this floating_ip_region object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatingIpRegion floatingIpRegion = (FloatingIpRegion) o;
        return Objects.equals(this.name, floatingIpRegion.name) && Objects.equals(this.slug, floatingIpRegion.slug)
                && Objects.equals(this.features, floatingIpRegion.features)
                && Objects.equals(this.available, floatingIpRegion.available)
                && Objects.equals(this.sizes, floatingIpRegion.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug, features, available, sizes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FloatingIpRegion {\n");
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
