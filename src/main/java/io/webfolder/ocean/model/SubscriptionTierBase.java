package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SubscriptionTierBase
 */
@JsonPropertyOrder({ SubscriptionTierBase.JSON_PROPERTY_NAME, SubscriptionTierBase.JSON_PROPERTY_SLUG,
        SubscriptionTierBase.JSON_PROPERTY_INCLUDED_REPOSITORIES,
        SubscriptionTierBase.JSON_PROPERTY_INCLUDED_STORAGE_BYTES,
        SubscriptionTierBase.JSON_PROPERTY_ALLOW_STORAGE_OVERAGE,
        SubscriptionTierBase.JSON_PROPERTY_INCLUDED_BANDWIDTH_BYTES,
        SubscriptionTierBase.JSON_PROPERTY_MONTHLY_PRICE_IN_CENTS,
        SubscriptionTierBase.JSON_PROPERTY_STORAGE_OVERAGE_PRICE_IN_CENTS })
public class SubscriptionTierBase {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_INCLUDED_REPOSITORIES = "included_repositories";
    private Integer includedRepositories;

    public static final String JSON_PROPERTY_INCLUDED_STORAGE_BYTES = "included_storage_bytes";
    private Integer includedStorageBytes;

    public static final String JSON_PROPERTY_ALLOW_STORAGE_OVERAGE = "allow_storage_overage";
    private Boolean allowStorageOverage;

    public static final String JSON_PROPERTY_INCLUDED_BANDWIDTH_BYTES = "included_bandwidth_bytes";
    private Integer includedBandwidthBytes;

    public static final String JSON_PROPERTY_MONTHLY_PRICE_IN_CENTS = "monthly_price_in_cents";
    private Integer monthlyPriceInCents;

    public static final String JSON_PROPERTY_STORAGE_OVERAGE_PRICE_IN_CENTS = "storage_overage_price_in_cents";
    private Integer storageOveragePriceInCents;

    public SubscriptionTierBase() {
    }

    public SubscriptionTierBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the subscription tier.
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

    public SubscriptionTierBase slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * The slug identifier of the subscription tier.
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

    public SubscriptionTierBase includedRepositories(Integer includedRepositories) {
        this.includedRepositories = includedRepositories;
        return this;
    }

    /**
     * The number of repositories included in the subscription tier. &#x60;0&#x60;
     * indicates that the subscription tier includes unlimited repositories.
     *
     * @return includedRepositories
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDED_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getIncludedRepositories() {
        return includedRepositories;
    }

    @JsonProperty(JSON_PROPERTY_INCLUDED_REPOSITORIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIncludedRepositories(Integer includedRepositories) {
        this.includedRepositories = includedRepositories;
    }

    public SubscriptionTierBase includedStorageBytes(Integer includedStorageBytes) {
        this.includedStorageBytes = includedStorageBytes;
        return this;
    }

    /**
     * The amount of storage included in the subscription tier in bytes.
     *
     * @return includedStorageBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDED_STORAGE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getIncludedStorageBytes() {
        return includedStorageBytes;
    }

    @JsonProperty(JSON_PROPERTY_INCLUDED_STORAGE_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIncludedStorageBytes(Integer includedStorageBytes) {
        this.includedStorageBytes = includedStorageBytes;
    }

    public SubscriptionTierBase allowStorageOverage(Boolean allowStorageOverage) {
        this.allowStorageOverage = allowStorageOverage;
        return this;
    }

    /**
     * A boolean indicating whether the subscription tier supports additional
     * storage above what is included in the base plan at an additional cost per GiB
     * used.
     *
     * @return allowStorageOverage
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALLOW_STORAGE_OVERAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAllowStorageOverage() {
        return allowStorageOverage;
    }

    @JsonProperty(JSON_PROPERTY_ALLOW_STORAGE_OVERAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAllowStorageOverage(Boolean allowStorageOverage) {
        this.allowStorageOverage = allowStorageOverage;
    }

    public SubscriptionTierBase includedBandwidthBytes(Integer includedBandwidthBytes) {
        this.includedBandwidthBytes = includedBandwidthBytes;
        return this;
    }

    /**
     * The amount of outbound data transfer included in the subscription tier in
     * bytes.
     *
     * @return includedBandwidthBytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDED_BANDWIDTH_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getIncludedBandwidthBytes() {
        return includedBandwidthBytes;
    }

    @JsonProperty(JSON_PROPERTY_INCLUDED_BANDWIDTH_BYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIncludedBandwidthBytes(Integer includedBandwidthBytes) {
        this.includedBandwidthBytes = includedBandwidthBytes;
    }

    public SubscriptionTierBase monthlyPriceInCents(Integer monthlyPriceInCents) {
        this.monthlyPriceInCents = monthlyPriceInCents;
        return this;
    }

    /**
     * The monthly cost of the subscription tier in cents.
     *
     * @return monthlyPriceInCents
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE_IN_CENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMonthlyPriceInCents() {
        return monthlyPriceInCents;
    }

    @JsonProperty(JSON_PROPERTY_MONTHLY_PRICE_IN_CENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMonthlyPriceInCents(Integer monthlyPriceInCents) {
        this.monthlyPriceInCents = monthlyPriceInCents;
    }

    public SubscriptionTierBase storageOveragePriceInCents(Integer storageOveragePriceInCents) {
        this.storageOveragePriceInCents = storageOveragePriceInCents;
        return this;
    }

    /**
     * The price paid in cents per GiB for additional storage beyond what is
     * included in the subscription plan.
     *
     * @return storageOveragePriceInCents
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STORAGE_OVERAGE_PRICE_IN_CENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getStorageOveragePriceInCents() {
        return storageOveragePriceInCents;
    }

    @JsonProperty(JSON_PROPERTY_STORAGE_OVERAGE_PRICE_IN_CENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStorageOveragePriceInCents(Integer storageOveragePriceInCents) {
        this.storageOveragePriceInCents = storageOveragePriceInCents;
    }

    /**
     * Return true if this subscription_tier_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscriptionTierBase subscriptionTierBase = (SubscriptionTierBase) o;
        return Objects.equals(this.name, subscriptionTierBase.name)
                && Objects.equals(this.slug, subscriptionTierBase.slug)
                && Objects.equals(this.includedRepositories, subscriptionTierBase.includedRepositories)
                && Objects.equals(this.includedStorageBytes, subscriptionTierBase.includedStorageBytes)
                && Objects.equals(this.allowStorageOverage, subscriptionTierBase.allowStorageOverage)
                && Objects.equals(this.includedBandwidthBytes, subscriptionTierBase.includedBandwidthBytes)
                && Objects.equals(this.monthlyPriceInCents, subscriptionTierBase.monthlyPriceInCents)
                && Objects.equals(this.storageOveragePriceInCents, subscriptionTierBase.storageOveragePriceInCents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug, includedRepositories, includedStorageBytes, allowStorageOverage,
                includedBandwidthBytes, monthlyPriceInCents, storageOveragePriceInCents);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubscriptionTierBase {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    includedRepositories: ").append(toIndentedString(includedRepositories)).append("\n");
        sb.append("    includedStorageBytes: ").append(toIndentedString(includedStorageBytes)).append("\n");
        sb.append("    allowStorageOverage: ").append(toIndentedString(allowStorageOverage)).append("\n");
        sb.append("    includedBandwidthBytes: ").append(toIndentedString(includedBandwidthBytes)).append("\n");
        sb.append("    monthlyPriceInCents: ").append(toIndentedString(monthlyPriceInCents)).append("\n");
        sb.append("    storageOveragePriceInCents: ").append(toIndentedString(storageOveragePriceInCents)).append("\n");
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