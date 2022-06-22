package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * KubernetesRegion
 */
@JsonPropertyOrder({ KubernetesRegion.JSON_PROPERTY_NAME, KubernetesRegion.JSON_PROPERTY_SLUG })
public class KubernetesRegion {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public KubernetesRegion() {
    }

    public KubernetesRegion name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A DigitalOcean region where Kubernetes is available.
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

    public KubernetesRegion slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The identifier for a region for use when creating a new cluster.
     *
     * @return slug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSlug() {
        return slug;
    }

    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * Return true if this kubernetes_region object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesRegion kubernetesRegion = (KubernetesRegion) o;
        return Objects.equals(this.name, kubernetesRegion.name) && Objects.equals(this.slug, kubernetesRegion.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesRegion {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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
