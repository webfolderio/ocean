package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * GarbageCollection
 */
@JsonPropertyOrder({ GarbageCollection.JSON_PROPERTY_UUID, GarbageCollection.JSON_PROPERTY_REGISTRY_NAME,
        GarbageCollection.JSON_PROPERTY_STATUS, GarbageCollection.JSON_PROPERTY_CREATED_AT,
        GarbageCollection.JSON_PROPERTY_UPDATED_AT, GarbageCollection.JSON_PROPERTY_BLOBS_DELETED,
        GarbageCollection.JSON_PROPERTY_FREED_BYTES })
public class GarbageCollection {
    public static final String JSON_PROPERTY_UUID = "uuid";
    private String uuid;

    public static final String JSON_PROPERTY_REGISTRY_NAME = "registry_name";
    private String registryName;

    /**
     * The current status of this garbage collection.
     */
    public enum StatusEnum {
        REQUESTED("requested"),

        WAITING_FOR_WRITE_JWTS_TO_EXPIRE("waiting for write JWTs to expire"),

        SCANNING_MANIFESTS("scanning manifests"),

        DELETING_UNREFERENCED_BLOBS("deleting unreferenced blobs"),

        CANCELLING("cancelling"),

        FAILED("failed"),

        SUCCEEDED("succeeded"),

        CANCELLED("cancelled");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_BLOBS_DELETED = "blobs_deleted";
    private Integer blobsDeleted;

    public static final String JSON_PROPERTY_FREED_BYTES = "freed_bytes";
    private Integer freedBytes;

    public GarbageCollection() {
    }

    public GarbageCollection uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * A string specifying the UUID of the garbage collection.
     *
     * @return uuid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "eff0feee-49c7-4e8f-ba5c-a320c109c8a8", value = "A string specifying the UUID of the garbage collection.")
    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUuid() {
        return uuid;
    }

    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public GarbageCollection registryName(String registryName) {
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

    public GarbageCollection status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The current status of this garbage collection.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "requested", value = "The current status of this garbage collection.")
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public GarbageCollection createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The time the garbage collection was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-10-30T21:03:24Z", value = "The time the garbage collection was created.")
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public GarbageCollection updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The time the garbage collection was last updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-10-30T21:03:44Z", value = "The time the garbage collection was last updated.")
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

    public GarbageCollection blobsDeleted(Integer blobsDeleted) {
        this.blobsDeleted = blobsDeleted;
        return this;
    }

    /**
     * The number of blobs deleted as a result of this garbage collection.
     *
     * @return blobsDeleted
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "42", value = "The number of blobs deleted as a result of this garbage collection.")
    @JsonProperty(JSON_PROPERTY_BLOBS_DELETED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getBlobsDeleted() {
        return blobsDeleted;
    }

    @JsonProperty(JSON_PROPERTY_BLOBS_DELETED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBlobsDeleted(Integer blobsDeleted) {
        this.blobsDeleted = blobsDeleted;
    }

    public GarbageCollection freedBytes(Integer freedBytes) {
        this.freedBytes = freedBytes;
        return this;
    }

    /**
     * The number of bytes freed as a result of this garbage collection.
     *
     * @return freedBytes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "667", value = "The number of bytes freed as a result of this garbage collection.")
    @JsonProperty(JSON_PROPERTY_FREED_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getFreedBytes() {
        return freedBytes;
    }

    @JsonProperty(JSON_PROPERTY_FREED_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFreedBytes(Integer freedBytes) {
        this.freedBytes = freedBytes;
    }

    /**
     * Return true if this garbage_collection object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GarbageCollection garbageCollection = (GarbageCollection) o;
        return Objects.equals(this.uuid, garbageCollection.uuid)
                && Objects.equals(this.registryName, garbageCollection.registryName)
                && Objects.equals(this.status, garbageCollection.status)
                && Objects.equals(this.createdAt, garbageCollection.createdAt)
                && Objects.equals(this.updatedAt, garbageCollection.updatedAt)
                && Objects.equals(this.blobsDeleted, garbageCollection.blobsDeleted)
                && Objects.equals(this.freedBytes, garbageCollection.freedBytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, registryName, status, createdAt, updatedAt, blobsDeleted, freedBytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GarbageCollection {\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    registryName: ").append(toIndentedString(registryName)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    blobsDeleted: ").append(toIndentedString(blobsDeleted)).append("\n");
        sb.append("    freedBytes: ").append(toIndentedString(freedBytes)).append("\n");
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
