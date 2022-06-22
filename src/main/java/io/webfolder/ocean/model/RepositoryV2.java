package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * RepositoryV2
 */
@JsonPropertyOrder({ RepositoryV2.JSON_PROPERTY_REGISTRY_NAME, RepositoryV2.JSON_PROPERTY_NAME,
        RepositoryV2.JSON_PROPERTY_LATEST_MANIFEST, RepositoryV2.JSON_PROPERTY_TAG_COUNT,
        RepositoryV2.JSON_PROPERTY_MANIFEST_COUNT })
public class RepositoryV2 {
    public static final String JSON_PROPERTY_REGISTRY_NAME = "registry_name";
    private String registryName;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_LATEST_MANIFEST = "latest_manifest";
    private RepositoryManifest latestManifest;

    public static final String JSON_PROPERTY_TAG_COUNT = "tag_count";
    private Integer tagCount;

    public static final String JSON_PROPERTY_MANIFEST_COUNT = "manifest_count";
    private Integer manifestCount;

    public RepositoryV2() {
    }

    public RepositoryV2 registryName(String registryName) {
        this.registryName = registryName;
        return this;
    }

    /**
     * The name of the container registry.
     *
     * @return registryName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "example", value = "The name of the container registry.")
    @JsonProperty(JSON_PROPERTY_REGISTRY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegistryName() {
        return registryName;
    }

    @JsonProperty(JSON_PROPERTY_REGISTRY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    public RepositoryV2 name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the repository.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "repo-1", value = "The name of the repository.")
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

    public RepositoryV2 latestManifest(RepositoryManifest latestManifest) {
        this.latestManifest = latestManifest;
        return this;
    }

    /**
     * Get latestManifest
     *
     * @return latestManifest
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LATEST_MANIFEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RepositoryManifest getLatestManifest() {
        return latestManifest;
    }

    @JsonProperty(JSON_PROPERTY_LATEST_MANIFEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLatestManifest(RepositoryManifest latestManifest) {
        this.latestManifest = latestManifest;
    }

    public RepositoryV2 tagCount(Integer tagCount) {
        this.tagCount = tagCount;
        return this;
    }

    /**
     * The number of tags in the repository.
     *
     * @return tagCount
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1", value = "The number of tags in the repository.")
    @JsonProperty(JSON_PROPERTY_TAG_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTagCount() {
        return tagCount;
    }

    @JsonProperty(JSON_PROPERTY_TAG_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public RepositoryV2 manifestCount(Integer manifestCount) {
        this.manifestCount = manifestCount;
        return this;
    }

    /**
     * The number of manifests in the repository.
     *
     * @return manifestCount
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1", value = "The number of manifests in the repository.")
    @JsonProperty(JSON_PROPERTY_MANIFEST_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getManifestCount() {
        return manifestCount;
    }

    @JsonProperty(JSON_PROPERTY_MANIFEST_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManifestCount(Integer manifestCount) {
        this.manifestCount = manifestCount;
    }

    /**
     * Return true if this repository_v2 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepositoryV2 repositoryV2 = (RepositoryV2) o;
        return Objects.equals(this.registryName, repositoryV2.registryName)
                && Objects.equals(this.name, repositoryV2.name)
                && Objects.equals(this.latestManifest, repositoryV2.latestManifest)
                && Objects.equals(this.tagCount, repositoryV2.tagCount)
                && Objects.equals(this.manifestCount, repositoryV2.manifestCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName, name, latestManifest, tagCount, manifestCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryV2 {\n");
        sb.append("    registryName: ").append(toIndentedString(registryName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    latestManifest: ").append(toIndentedString(latestManifest)).append("\n");
        sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
        sb.append("    manifestCount: ").append(toIndentedString(manifestCount)).append("\n");
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
