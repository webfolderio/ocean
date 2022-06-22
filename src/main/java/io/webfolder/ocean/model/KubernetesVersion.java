package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * KubernetesVersion
 */
@JsonPropertyOrder({ KubernetesVersion.JSON_PROPERTY_SLUG, KubernetesVersion.JSON_PROPERTY_KUBERNETES_VERSION,
        KubernetesVersion.JSON_PROPERTY_SUPPORTED_FEATURES })
public class KubernetesVersion {
    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_KUBERNETES_VERSION = "kubernetes_version";
    private String kubernetesVersion;

    public static final String JSON_PROPERTY_SUPPORTED_FEATURES = "supported_features";
    private List<String> supportedFeatures = null;

    public KubernetesVersion() {
    }

    public KubernetesVersion slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The slug identifier for an available version of Kubernetes for use when
     * creating or updating a cluster. The string contains both the upstream version
     * of Kubernetes as well as the DigitalOcean revision.
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

    public KubernetesVersion kubernetesVersion(String kubernetesVersion) {
        this.kubernetesVersion = kubernetesVersion;
        return this;
    }

    /**
     * The upstream version string for the version of Kubernetes provided by a given
     * slug.
     *
     * @return kubernetesVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KUBERNETES_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getKubernetesVersion() {
        return kubernetesVersion;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesVersion(String kubernetesVersion) {
        this.kubernetesVersion = kubernetesVersion;
    }

    public KubernetesVersion supportedFeatures(List<String> supportedFeatures) {
        this.supportedFeatures = supportedFeatures;
        return this;
    }

    public KubernetesVersion addSupportedFeaturesItem(String supportedFeaturesItem) {
        if (this.supportedFeatures == null) {
            this.supportedFeatures = new ArrayList<>();
        }
        this.supportedFeatures.add(supportedFeaturesItem);
        return this;
    }

    /**
     * The features available with the version of Kubernetes provided by a given
     * slug.
     *
     * @return supportedFeatures
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUPPORTED_FEATURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getSupportedFeatures() {
        return supportedFeatures;
    }

    @JsonProperty(JSON_PROPERTY_SUPPORTED_FEATURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSupportedFeatures(List<String> supportedFeatures) {
        this.supportedFeatures = supportedFeatures;
    }

    /**
     * Return true if this kubernetes_version object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesVersion kubernetesVersion = (KubernetesVersion) o;
        return Objects.equals(this.slug, kubernetesVersion.slug)
                && Objects.equals(this.kubernetesVersion, kubernetesVersion.kubernetesVersion)
                && Objects.equals(this.supportedFeatures, kubernetesVersion.supportedFeatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slug, kubernetesVersion, supportedFeatures);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesVersion {\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    kubernetesVersion: ").append(toIndentedString(kubernetesVersion)).append("\n");
        sb.append("    supportedFeatures: ").append(toIndentedString(supportedFeatures)).append("\n");
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
