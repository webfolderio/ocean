package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * KubernetesSize
 */
@JsonPropertyOrder({ KubernetesSize.JSON_PROPERTY_NAME, KubernetesSize.JSON_PROPERTY_SLUG })
public class KubernetesSize {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public KubernetesSize() {
    }

    public KubernetesSize name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A Droplet size available for use in a Kubernetes node pool.
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

    public KubernetesSize slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The identifier for a size for use when creating a new cluster.
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
     * Return true if this kubernetes_size object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesSize kubernetesSize = (KubernetesSize) o;
        return Objects.equals(this.name, kubernetesSize.name) && Objects.equals(this.slug, kubernetesSize.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesSize {\n");
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