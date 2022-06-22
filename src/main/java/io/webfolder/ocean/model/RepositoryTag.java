package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RepositoryTag
 */
@JsonPropertyOrder({ RepositoryTag.JSON_PROPERTY_REGISTRY_NAME, RepositoryTag.JSON_PROPERTY_REPOSITORY,
        RepositoryTag.JSON_PROPERTY_TAG, RepositoryTag.JSON_PROPERTY_MANIFEST_DIGEST,
        RepositoryTag.JSON_PROPERTY_COMPRESSED_SIZE_BYTES, RepositoryTag.JSON_PROPERTY_SIZE_BYTES,
        RepositoryTag.JSON_PROPERTY_UPDATED_AT })
public class RepositoryTag {
    public static final String JSON_PROPERTY_REGISTRY_NAME = "registry_name";
    private String registryName;

    public static final String JSON_PROPERTY_REPOSITORY = "repository";
    private String repository;

    public static final String JSON_PROPERTY_TAG = "tag";
    private String tag;

    public static final String JSON_PROPERTY_MANIFEST_DIGEST = "manifest_digest";
    private String manifestDigest;

    public static final String JSON_PROPERTY_COMPRESSED_SIZE_BYTES = "compressed_size_bytes";
    private Integer compressedSizeBytes;

    public static final String JSON_PROPERTY_SIZE_BYTES = "size_bytes";
    private Integer sizeBytes;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public RepositoryTag() {
    }

    public RepositoryTag registryName(String registryName) {
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

    public RepositoryTag repository(String repository) {
        this.repository = repository;
        return this;
    }

    /**
     * The name of the repository.
     *
     * @return repository
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REPOSITORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRepository() {
        return repository;
    }

    @JsonProperty(JSON_PROPERTY_REPOSITORY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRepository(String repository) {
        this.repository = repository;
    }

    public RepositoryTag tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The name of the tag.
     *
     * @return tag
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTag() {
        return tag;
    }

    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTag(String tag) {
        this.tag = tag;
    }

    public RepositoryTag manifestDigest(String manifestDigest) {
        this.manifestDigest = manifestDigest;
        return this;
    }

    /**
     * The digest of the manifest associated with the tag.
     *
     * @return manifestDigest
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANIFEST_DIGEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getManifestDigest() {
        return manifestDigest;
    }

    @JsonProperty(JSON_PROPERTY_MANIFEST_DIGEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManifestDigest(String manifestDigest) {
        this.manifestDigest = manifestDigest;
    }

    public RepositoryTag compressedSizeBytes(Integer compressedSizeBytes) {
        this.compressedSizeBytes = compressedSizeBytes;
        return this;
    }

    /**
     * The compressed size of the tag in bytes.
     *
     * @return compressedSizeBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPRESSED_SIZE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getCompressedSizeBytes() {
        return compressedSizeBytes;
    }

    @JsonProperty(JSON_PROPERTY_COMPRESSED_SIZE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompressedSizeBytes(Integer compressedSizeBytes) {
        this.compressedSizeBytes = compressedSizeBytes;
    }

    public RepositoryTag sizeBytes(Integer sizeBytes) {
        this.sizeBytes = sizeBytes;
        return this;
    }

    /**
     * The uncompressed size of the tag in bytes (this size is calculated
     * asynchronously so it may not be immediately available).
     *
     * @return sizeBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSizeBytes() {
        return sizeBytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSizeBytes(Integer sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public RepositoryTag updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The time the tag was last updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Return true if this repository_tag object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepositoryTag repositoryTag = (RepositoryTag) o;
        return Objects.equals(this.registryName, repositoryTag.registryName)
                && Objects.equals(this.repository, repositoryTag.repository)
                && Objects.equals(this.tag, repositoryTag.tag)
                && Objects.equals(this.manifestDigest, repositoryTag.manifestDigest)
                && Objects.equals(this.compressedSizeBytes, repositoryTag.compressedSizeBytes)
                && Objects.equals(this.sizeBytes, repositoryTag.sizeBytes)
                && Objects.equals(this.updatedAt, repositoryTag.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName, repository, tag, manifestDigest, compressedSizeBytes, sizeBytes, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryTag {\n");
        sb.append("    registryName: ").append(toIndentedString(registryName)).append("\n");
        sb.append("    repository: ").append(toIndentedString(repository)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
        sb.append("    manifestDigest: ").append(toIndentedString(manifestDigest)).append("\n");
        sb.append("    compressedSizeBytes: ").append(toIndentedString(compressedSizeBytes)).append("\n");
        sb.append("    sizeBytes: ").append(toIndentedString(sizeBytes)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
