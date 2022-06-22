package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * KubernetesOptionsOptions
 */
@JsonPropertyOrder({ KubernetesOptionsOptions.JSON_PROPERTY_REGIONS, KubernetesOptionsOptions.JSON_PROPERTY_VERSIONS,
        KubernetesOptionsOptions.JSON_PROPERTY_SIZES })
public class KubernetesOptionsOptions {
    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<KubernetesRegion> regions = null;

    public static final String JSON_PROPERTY_VERSIONS = "versions";
    private List<KubernetesVersion> versions = null;

    public static final String JSON_PROPERTY_SIZES = "sizes";
    private List<KubernetesSize> sizes = null;

    public KubernetesOptionsOptions() {
    }

    public KubernetesOptionsOptions regions(List<KubernetesRegion> regions) {
        this.regions = regions;
        return this;
    }

    public KubernetesOptionsOptions addRegionsItem(KubernetesRegion regionsItem) {
        if (this.regions == null) {
            this.regions = new ArrayList<>();
        }
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * Get regions
     *
     * @return regions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<KubernetesRegion> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegions(List<KubernetesRegion> regions) {
        this.regions = regions;
    }

    public KubernetesOptionsOptions versions(List<KubernetesVersion> versions) {
        this.versions = versions;
        return this;
    }

    public KubernetesOptionsOptions addVersionsItem(KubernetesVersion versionsItem) {
        if (this.versions == null) {
            this.versions = new ArrayList<>();
        }
        this.versions.add(versionsItem);
        return this;
    }

    /**
     * Get versions
     *
     * @return versions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<KubernetesVersion> getVersions() {
        return versions;
    }

    @JsonProperty(JSON_PROPERTY_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersions(List<KubernetesVersion> versions) {
        this.versions = versions;
    }

    public KubernetesOptionsOptions sizes(List<KubernetesSize> sizes) {
        this.sizes = sizes;
        return this;
    }

    public KubernetesOptionsOptions addSizesItem(KubernetesSize sizesItem) {
        if (this.sizes == null) {
            this.sizes = new ArrayList<>();
        }
        this.sizes.add(sizesItem);
        return this;
    }

    /**
     * Get sizes
     *
     * @return sizes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<KubernetesSize> getSizes() {
        return sizes;
    }

    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSizes(List<KubernetesSize> sizes) {
        this.sizes = sizes;
    }

    /**
     * Return true if this kubernetes_options_options object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesOptionsOptions kubernetesOptionsOptions = (KubernetesOptionsOptions) o;
        return Objects.equals(this.regions, kubernetesOptionsOptions.regions)
                && Objects.equals(this.versions, kubernetesOptionsOptions.versions)
                && Objects.equals(this.sizes, kubernetesOptionsOptions.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regions, versions, sizes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesOptionsOptions {\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
