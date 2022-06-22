package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * RepositoryBlob
 */
@JsonPropertyOrder({ RepositoryBlob.JSON_PROPERTY_DIGEST, RepositoryBlob.JSON_PROPERTY_COMPRESSED_SIZE_BYTES })
public class RepositoryBlob {
    public static final String JSON_PROPERTY_DIGEST = "digest";
    private String digest;

    public static final String JSON_PROPERTY_COMPRESSED_SIZE_BYTES = "compressed_size_bytes";
    private Integer compressedSizeBytes;

    public RepositoryBlob() {
    }

    public RepositoryBlob digest(String digest) {
        this.digest = digest;
        return this;
    }

    /**
     * The digest of the blob
     *
     * @return digest
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "sha256:cb8a924afdf0229ef7515d9e5b3024e23b3eb03ddbba287f4a19c6ac90b8d221", value = "The digest of the blob")
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

    public RepositoryBlob compressedSizeBytes(Integer compressedSizeBytes) {
        this.compressedSizeBytes = compressedSizeBytes;
        return this;
    }

    /**
     * The compressed size of the blob in bytes.
     *
     * @return compressedSizeBytes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2803255", value = "The compressed size of the blob in bytes.")
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

    /**
     * Return true if this repository_blob object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepositoryBlob repositoryBlob = (RepositoryBlob) o;
        return Objects.equals(this.digest, repositoryBlob.digest)
                && Objects.equals(this.compressedSizeBytes, repositoryBlob.compressedSizeBytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digest, compressedSizeBytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryBlob {\n");
        sb.append("    digest: ").append(toIndentedString(digest)).append("\n");
        sb.append("    compressedSizeBytes: ").append(toIndentedString(compressedSizeBytes)).append("\n");
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
