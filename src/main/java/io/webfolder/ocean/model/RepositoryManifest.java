package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RepositoryManifest
 */
@JsonPropertyOrder({ RepositoryManifest.JSON_PROPERTY_REGISTRY_NAME, RepositoryManifest.JSON_PROPERTY_REPOSITORY,
        RepositoryManifest.JSON_PROPERTY_DIGEST, RepositoryManifest.JSON_PROPERTY_COMPRESSED_SIZE_BYTES,
        RepositoryManifest.JSON_PROPERTY_SIZE_BYTES, RepositoryManifest.JSON_PROPERTY_UPDATED_AT,
        RepositoryManifest.JSON_PROPERTY_TAGS, RepositoryManifest.JSON_PROPERTY_BLOBS })
public class RepositoryManifest {
    public static final String JSON_PROPERTY_REGISTRY_NAME = "registry_name";
    private String registryName;

    public static final String JSON_PROPERTY_REPOSITORY = "repository";
    private String repository;

    public static final String JSON_PROPERTY_DIGEST = "digest";
    private String digest;

    public static final String JSON_PROPERTY_COMPRESSED_SIZE_BYTES = "compressed_size_bytes";
    private Integer compressedSizeBytes;

    public static final String JSON_PROPERTY_SIZE_BYTES = "size_bytes";
    private Integer sizeBytes;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_BLOBS = "blobs";
    private List<RepositoryBlob> blobs = null;

    public RepositoryManifest() {
    }

    public RepositoryManifest registryName(String registryName) {
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

    public RepositoryManifest repository(String repository) {
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

    public RepositoryManifest digest(String digest) {
        this.digest = digest;
        return this;
    }

    /**
     * The manifest digest
     *
     * @return digest
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DIGEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDigest() {
        return digest;
    }

    @JsonProperty(JSON_PROPERTY_DIGEST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDigest(String digest) {
        this.digest = digest;
    }

    public RepositoryManifest compressedSizeBytes(Integer compressedSizeBytes) {
        this.compressedSizeBytes = compressedSizeBytes;
        return this;
    }

    /**
     * The compressed size of the manifest in bytes.
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

    public RepositoryManifest sizeBytes(Integer sizeBytes) {
        this.sizeBytes = sizeBytes;
        return this;
    }

    /**
     * The uncompressed size of the manifest in bytes (this size is calculated
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

    public RepositoryManifest updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The time the manifest was last updated.
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

    public RepositoryManifest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public RepositoryManifest addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * All tags associated with this manifest
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public RepositoryManifest blobs(List<RepositoryBlob> blobs) {
        this.blobs = blobs;
        return this;
    }

    public RepositoryManifest addBlobsItem(RepositoryBlob blobsItem) {
        if (this.blobs == null) {
            this.blobs = new ArrayList<>();
        }
        this.blobs.add(blobsItem);
        return this;
    }

    /**
     * All blobs associated with this manifest
     *
     * @return blobs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BLOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<RepositoryBlob> getBlobs() {
        return blobs;
    }

    @JsonProperty(JSON_PROPERTY_BLOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBlobs(List<RepositoryBlob> blobs) {
        this.blobs = blobs;
    }

    /**
     * Return true if this repository_manifest object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepositoryManifest repositoryManifest = (RepositoryManifest) o;
        return Objects.equals(this.registryName, repositoryManifest.registryName)
                && Objects.equals(this.repository, repositoryManifest.repository)
                && Objects.equals(this.digest, repositoryManifest.digest)
                && Objects.equals(this.compressedSizeBytes, repositoryManifest.compressedSizeBytes)
                && Objects.equals(this.sizeBytes, repositoryManifest.sizeBytes)
                && Objects.equals(this.updatedAt, repositoryManifest.updatedAt)
                && Objects.equals(this.tags, repositoryManifest.tags)
                && Objects.equals(this.blobs, repositoryManifest.blobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryName, repository, digest, compressedSizeBytes, sizeBytes, updatedAt, tags, blobs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryManifest {\n");
        sb.append("    registryName: ").append(toIndentedString(registryName)).append("\n");
        sb.append("    repository: ").append(toIndentedString(repository)).append("\n");
        sb.append("    digest: ").append(toIndentedString(digest)).append("\n");
        sb.append("    compressedSizeBytes: ").append(toIndentedString(compressedSizeBytes)).append("\n");
        sb.append("    sizeBytes: ").append(toIndentedString(sizeBytes)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    blobs: ").append(toIndentedString(blobs)).append("\n");
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