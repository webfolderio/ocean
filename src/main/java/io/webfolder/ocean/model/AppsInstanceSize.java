package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsInstanceSize
 */
@JsonPropertyOrder({ AppsInstanceSize.JSON_PROPERTY_CPU_TYPE, AppsInstanceSize.JSON_PROPERTY_CPUS,
        AppsInstanceSize.JSON_PROPERTY_MEMORY_BYTES, AppsInstanceSize.JSON_PROPERTY_NAME,
        AppsInstanceSize.JSON_PROPERTY_SLUG, AppsInstanceSize.JSON_PROPERTY_TIER_DOWNGRADE_TO,
        AppsInstanceSize.JSON_PROPERTY_TIER_SLUG, AppsInstanceSize.JSON_PROPERTY_TIER_UPGRADE_TO,
        AppsInstanceSize.JSON_PROPERTY_USD_PER_MONTH, AppsInstanceSize.JSON_PROPERTY_USD_PER_SECOND })
public class AppsInstanceSize {
    public static final String JSON_PROPERTY_CPU_TYPE = "cpu_type";
    private InstanceSizeCpuType cpuType = InstanceSizeCpuType.UNSPECIFIED;

    public static final String JSON_PROPERTY_CPUS = "cpus";
    private String cpus;

    public static final String JSON_PROPERTY_MEMORY_BYTES = "memory_bytes";
    private String memoryBytes;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_TIER_DOWNGRADE_TO = "tier_downgrade_to";
    private String tierDowngradeTo;

    public static final String JSON_PROPERTY_TIER_SLUG = "tier_slug";
    private String tierSlug;

    public static final String JSON_PROPERTY_TIER_UPGRADE_TO = "tier_upgrade_to";
    private String tierUpgradeTo;

    public static final String JSON_PROPERTY_USD_PER_MONTH = "usd_per_month";
    private String usdPerMonth;

    public static final String JSON_PROPERTY_USD_PER_SECOND = "usd_per_second";
    private String usdPerSecond;

    public AppsInstanceSize() {
    }

    public AppsInstanceSize cpuType(InstanceSizeCpuType cpuType) {
        this.cpuType = cpuType;
        return this;
    }

    /**
     * Get cpuType
     *
     * @return cpuType
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CPU_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InstanceSizeCpuType getCpuType() {
        return cpuType;
    }

    @JsonProperty(JSON_PROPERTY_CPU_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCpuType(InstanceSizeCpuType cpuType) {
        this.cpuType = cpuType;
    }

    public AppsInstanceSize cpus(String cpus) {
        this.cpus = cpus;
        return this;
    }

    /**
     * Get cpus
     *
     * @return cpus
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CPUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCpus() {
        return cpus;
    }

    @JsonProperty(JSON_PROPERTY_CPUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCpus(String cpus) {
        this.cpus = cpus;
    }

    public AppsInstanceSize memoryBytes(String memoryBytes) {
        this.memoryBytes = memoryBytes;
        return this;
    }

    /**
     * Get memoryBytes
     *
     * @return memoryBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MEMORY_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMemoryBytes() {
        return memoryBytes;
    }

    @JsonProperty(JSON_PROPERTY_MEMORY_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMemoryBytes(String memoryBytes) {
        this.memoryBytes = memoryBytes;
    }

    public AppsInstanceSize name(String name) {
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

    public AppsInstanceSize slug(String slug) {
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

    public AppsInstanceSize tierDowngradeTo(String tierDowngradeTo) {
        this.tierDowngradeTo = tierDowngradeTo;
        return this;
    }

    /**
     * Get tierDowngradeTo
     *
     * @return tierDowngradeTo
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER_DOWNGRADE_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTierDowngradeTo() {
        return tierDowngradeTo;
    }

    @JsonProperty(JSON_PROPERTY_TIER_DOWNGRADE_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTierDowngradeTo(String tierDowngradeTo) {
        this.tierDowngradeTo = tierDowngradeTo;
    }

    public AppsInstanceSize tierSlug(String tierSlug) {
        this.tierSlug = tierSlug;
        return this;
    }

    /**
     * Get tierSlug
     *
     * @return tierSlug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTierSlug() {
        return tierSlug;
    }

    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTierSlug(String tierSlug) {
        this.tierSlug = tierSlug;
    }

    public AppsInstanceSize tierUpgradeTo(String tierUpgradeTo) {
        this.tierUpgradeTo = tierUpgradeTo;
        return this;
    }

    /**
     * Get tierUpgradeTo
     *
     * @return tierUpgradeTo
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER_UPGRADE_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTierUpgradeTo() {
        return tierUpgradeTo;
    }

    @JsonProperty(JSON_PROPERTY_TIER_UPGRADE_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTierUpgradeTo(String tierUpgradeTo) {
        this.tierUpgradeTo = tierUpgradeTo;
    }

    public AppsInstanceSize usdPerMonth(String usdPerMonth) {
        this.usdPerMonth = usdPerMonth;
        return this;
    }

    /**
     * Get usdPerMonth
     *
     * @return usdPerMonth
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USD_PER_MONTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUsdPerMonth() {
        return usdPerMonth;
    }

    @JsonProperty(JSON_PROPERTY_USD_PER_MONTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsdPerMonth(String usdPerMonth) {
        this.usdPerMonth = usdPerMonth;
    }

    public AppsInstanceSize usdPerSecond(String usdPerSecond) {
        this.usdPerSecond = usdPerSecond;
        return this;
    }

    /**
     * Get usdPerSecond
     *
     * @return usdPerSecond
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USD_PER_SECOND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUsdPerSecond() {
        return usdPerSecond;
    }

    @JsonProperty(JSON_PROPERTY_USD_PER_SECOND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsdPerSecond(String usdPerSecond) {
        this.usdPerSecond = usdPerSecond;
    }

    /**
     * Return true if this apps_instance_size object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsInstanceSize appsInstanceSize = (AppsInstanceSize) o;
        return Objects.equals(this.cpuType, appsInstanceSize.cpuType)
                && Objects.equals(this.cpus, appsInstanceSize.cpus)
                && Objects.equals(this.memoryBytes, appsInstanceSize.memoryBytes)
                && Objects.equals(this.name, appsInstanceSize.name) && Objects.equals(this.slug, appsInstanceSize.slug)
                && Objects.equals(this.tierDowngradeTo, appsInstanceSize.tierDowngradeTo)
                && Objects.equals(this.tierSlug, appsInstanceSize.tierSlug)
                && Objects.equals(this.tierUpgradeTo, appsInstanceSize.tierUpgradeTo)
                && Objects.equals(this.usdPerMonth, appsInstanceSize.usdPerMonth)
                && Objects.equals(this.usdPerSecond, appsInstanceSize.usdPerSecond);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpuType, cpus, memoryBytes, name, slug, tierDowngradeTo, tierSlug, tierUpgradeTo,
                usdPerMonth, usdPerSecond);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsInstanceSize {\n");
        sb.append("    cpuType: ").append(toIndentedString(cpuType)).append("\n");
        sb.append("    cpus: ").append(toIndentedString(cpus)).append("\n");
        sb.append("    memoryBytes: ").append(toIndentedString(memoryBytes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    tierDowngradeTo: ").append(toIndentedString(tierDowngradeTo)).append("\n");
        sb.append("    tierSlug: ").append(toIndentedString(tierSlug)).append("\n");
        sb.append("    tierUpgradeTo: ").append(toIndentedString(tierUpgradeTo)).append("\n");
        sb.append("    usdPerMonth: ").append(toIndentedString(usdPerMonth)).append("\n");
        sb.append("    usdPerSecond: ").append(toIndentedString(usdPerSecond)).append("\n");
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
