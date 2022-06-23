package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsTier
 */
@JsonPropertyOrder({ AppsTier.JSON_PROPERTY_BUILD_SECONDS, AppsTier.JSON_PROPERTY_EGRESS_BANDWIDTH_BYTES,
        AppsTier.JSON_PROPERTY_NAME, AppsTier.JSON_PROPERTY_SLUG, AppsTier.JSON_PROPERTY_STORAGE_BYTES })
public class AppsTier {
    public static final String JSON_PROPERTY_BUILD_SECONDS = "build_seconds";
    private String buildSeconds;

    public static final String JSON_PROPERTY_EGRESS_BANDWIDTH_BYTES = "egress_bandwidth_bytes";
    private String egressBandwidthBytes;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_STORAGE_BYTES = "storage_bytes";
    private String storageBytes;

    public AppsTier() {
    }

    public AppsTier buildSeconds(String buildSeconds) {
        this.buildSeconds = buildSeconds;
        return this;
    }

    /**
     * Get buildSeconds
     *
     * @return buildSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BUILD_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getBuildSeconds() {
        return buildSeconds;
    }

    @JsonProperty(JSON_PROPERTY_BUILD_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBuildSeconds(String buildSeconds) {
        this.buildSeconds = buildSeconds;
    }

    public AppsTier egressBandwidthBytes(String egressBandwidthBytes) {
        this.egressBandwidthBytes = egressBandwidthBytes;
        return this;
    }

    /**
     * Get egressBandwidthBytes
     *
     * @return egressBandwidthBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EGRESS_BANDWIDTH_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getEgressBandwidthBytes() {
        return egressBandwidthBytes;
    }

    @JsonProperty(JSON_PROPERTY_EGRESS_BANDWIDTH_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEgressBandwidthBytes(String egressBandwidthBytes) {
        this.egressBandwidthBytes = egressBandwidthBytes;
    }

    public AppsTier name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
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

    public AppsTier slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * Get slug
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

    public AppsTier storageBytes(String storageBytes) {
        this.storageBytes = storageBytes;
        return this;
    }

    /**
     * Get storageBytes
     *
     * @return storageBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STORAGE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStorageBytes() {
        return storageBytes;
    }

    @JsonProperty(JSON_PROPERTY_STORAGE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStorageBytes(String storageBytes) {
        this.storageBytes = storageBytes;
    }

    /**
     * Return true if this apps_tier object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsTier appsTier = (AppsTier) o;
        return Objects.equals(this.buildSeconds, appsTier.buildSeconds)
                && Objects.equals(this.egressBandwidthBytes, appsTier.egressBandwidthBytes)
                && Objects.equals(this.name, appsTier.name) && Objects.equals(this.slug, appsTier.slug)
                && Objects.equals(this.storageBytes, appsTier.storageBytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildSeconds, egressBandwidthBytes, name, slug, storageBytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsTier {\n");
        sb.append("    buildSeconds: ").append(toIndentedString(buildSeconds)).append("\n");
        sb.append("    egressBandwidthBytes: ").append(toIndentedString(egressBandwidthBytes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    storageBytes: ").append(toIndentedString(storageBytes)).append("\n");
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