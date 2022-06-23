package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Registry
 */
@JsonPropertyOrder({ Registry.JSON_PROPERTY_NAME, Registry.JSON_PROPERTY_CREATED_AT, Registry.JSON_PROPERTY_REGION,
        Registry.JSON_PROPERTY_STORAGE_USAGE_BYTES, Registry.JSON_PROPERTY_STORAGE_USAGE_BYTES_UPDATED_AT,
        Registry.JSON_PROPERTY_SUBSCRIPTION })
public class Registry {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_STORAGE_USAGE_BYTES = "storage_usage_bytes";
    private Integer storageUsageBytes;

    public static final String JSON_PROPERTY_STORAGE_USAGE_BYTES_UPDATED_AT = "storage_usage_bytes_updated_at";
    private OffsetDateTime storageUsageBytesUpdatedAt;

    public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
    private RegistrySubscription subscription;

    public Registry() {
    }

    @JsonCreator
    public Registry(@JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_STORAGE_USAGE_BYTES) Integer storageUsageBytes,
            @JsonProperty(JSON_PROPERTY_STORAGE_USAGE_BYTES_UPDATED_AT) OffsetDateTime storageUsageBytesUpdatedAt) {
        this();
        this.createdAt = createdAt;
        this.storageUsageBytes = storageUsageBytes;
        this.storageUsageBytesUpdatedAt = storageUsageBytesUpdatedAt;
    }

    public Registry name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A globally unique name for the container registry. Must be lowercase and be
     * composed only of numbers, letters and &#x60;-&#x60;, up to a limit of 63
     * characters.
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

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the registry was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Registry region(String region) {
        this.region = region;
        return this;
    }

    /**
     * Slug of the region where registry data is stored
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * The amount of storage used in the registry in bytes.
     *
     * @return storageUsageBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STORAGE_USAGE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getStorageUsageBytes() {
        return storageUsageBytes;
    }

    /**
     * The time at which the storage usage was updated. Storage usage is calculated
     * asynchronously, and may not immediately reflect pushes to the registry.
     *
     * @return storageUsageBytesUpdatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STORAGE_USAGE_BYTES_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getStorageUsageBytesUpdatedAt() {
        return storageUsageBytesUpdatedAt;
    }

    public Registry subscription(RegistrySubscription subscription) {
        this.subscription = subscription;
        return this;
    }

    /**
     * Get subscription
     *
     * @return subscription
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RegistrySubscription getSubscription() {
        return subscription;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscription(RegistrySubscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Return true if this registry object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Registry registry = (Registry) o;
        return Objects.equals(this.name, registry.name) && Objects.equals(this.createdAt, registry.createdAt)
                && Objects.equals(this.region, registry.region)
                && Objects.equals(this.storageUsageBytes, registry.storageUsageBytes)
                && Objects.equals(this.storageUsageBytesUpdatedAt, registry.storageUsageBytesUpdatedAt)
                && Objects.equals(this.subscription, registry.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, region, storageUsageBytes, storageUsageBytesUpdatedAt, subscription);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Registry {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    storageUsageBytes: ").append(toIndentedString(storageUsageBytes)).append("\n");
        sb.append("    storageUsageBytesUpdatedAt: ").append(toIndentedString(storageUsageBytesUpdatedAt)).append("\n");
        sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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