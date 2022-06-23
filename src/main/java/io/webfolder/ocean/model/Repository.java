package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Repository
 */
@JsonPropertyOrder({ Repository.JSON_PROPERTY_REGISTRY_NAME, Repository.JSON_PROPERTY_NAME,
        Repository.JSON_PROPERTY_LATEST_TAG, Repository.JSON_PROPERTY_TAG_COUNT })
public class Repository {
    public static final String JSON_PROPERTY_REGISTRY_NAME = "registry_name";
    private String registryName;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_LATEST_TAG = "latest_tag";
    private RepositoryTag latestTag;

    public static final String JSON_PROPERTY_TAG_COUNT = "tag_count";
    private Integer tagCount;

    public Repository() {
    }

    public Repository registryName(String registryName) {
        this.registryName = registryName;
        return this;
    }

    /**
     * The name of the container registry.
     *
     * @return registryName
     **/
    @javax.annotation.Nullable
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

    public Repository name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the repository.
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

    public Repository latestTag(RepositoryTag latestTag) {
        this.latestTag = latestTag;
        return this;
    }

    /**
     * Get latestTag
     *
     * @return latestTag
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LATEST_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RepositoryTag getLatestTag() {
        return latestTag;
    }

    @JsonProperty(JSON_PROPERTY_LATEST_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLatestTag(RepositoryTag latestTag) {
        this.latestTag = latestTag;
    }

    public Repository tagCount(Integer tagCount) {
        this.tagCount = tagCount;
        return this;
    }

    /**
     * The number of tags in the repository.
     *
     * @return tagCount
     **/
    @javax.annotation.Nullable
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

    /**
     * Return true if this repository object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Repository repository = (Repository) o;
        return Objects.equals(this.registryName, repository.registryName) && Objects.equals(this.name, repository.name)
                && Objects.equals(this.latestTag, repository.latestTag)
                && Objects.equals(this.tagCount, repository.tagCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName, name, latestTag, tagCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Repository {\n");
        sb.append("    registryName: ").append(toIndentedString(registryName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    latestTag: ").append(toIndentedString(latestTag)).append("\n");
        sb.append("    tagCount: ").append(toIndentedString(tagCount)).append("\n");
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