package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * GetRegistryOptionsResponseOptionsSubscriptionTiersInner
 */
@JsonPropertyOrder({ GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_NAME,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_SLUG,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_INCLUDED_REPOSITORIES,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_INCLUDED_STORAGE_BYTES,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_ALLOW_STORAGE_OVERAGE,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_INCLUDED_BANDWIDTH_BYTES,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_MONTHLY_PRICE_IN_CENTS,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_STORAGE_OVERAGE_PRICE_IN_CENTS,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_ELIGIBLE,
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner.JSON_PROPERTY_ELIGIBILITY_REASONS })
public class GetRegistryOptionsResponseOptionsSubscriptionTiersInner {
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

    public static final String JSON_PROPERTY_ELIGIBLE = "eligible";
    private Boolean eligible;

    /**
     * Gets or Sets eligibilityReasons
     */
    public enum EligibilityReasonsEnum {
        OVERREPOSITORYLIMIT("OverRepositoryLimit"),

        OVERSTORAGELIMIT("OverStorageLimit");

        private String value;

        EligibilityReasonsEnum(String value) {
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
        public static EligibilityReasonsEnum fromValue(String value) {
            for (EligibilityReasonsEnum b : EligibilityReasonsEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ELIGIBILITY_REASONS = "eligibility_reasons";
    private List<EligibilityReasonsEnum> eligibilityReasons = null;

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner() {
    }

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner name(String name) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner slug(String slug) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner includedRepositories(Integer includedRepositories) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner includedStorageBytes(Integer includedStorageBytes) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner allowStorageOverage(Boolean allowStorageOverage) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner includedBandwidthBytes(
            Integer includedBandwidthBytes) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner monthlyPriceInCents(Integer monthlyPriceInCents) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner storageOveragePriceInCents(
            Integer storageOveragePriceInCents) {
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

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner eligible(Boolean eligible) {
        this.eligible = eligible;
        return this;
    }

    /**
     * A boolean indicating whether your account it eligible to use a certain
     * subscription tier.
     *
     * @return eligible
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ELIGIBLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEligible() {
        return eligible;
    }

    @JsonProperty(JSON_PROPERTY_ELIGIBLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner eligibilityReasons(
            List<EligibilityReasonsEnum> eligibilityReasons) {
        this.eligibilityReasons = eligibilityReasons;
        return this;
    }

    public GetRegistryOptionsResponseOptionsSubscriptionTiersInner addEligibilityReasonsItem(
            EligibilityReasonsEnum eligibilityReasonsItem) {
        if (this.eligibilityReasons == null) {
            this.eligibilityReasons = new ArrayList<>();
        }
        this.eligibilityReasons.add(eligibilityReasonsItem);
        return this;
    }

    /**
     * If your account is not eligible to use a certain subscription tier, this will
     * include a list of reasons that prevent you from using the tier.
     *
     * @return eligibilityReasons
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ELIGIBILITY_REASONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<EligibilityReasonsEnum> getEligibilityReasons() {
        return eligibilityReasons;
    }

    @JsonProperty(JSON_PROPERTY_ELIGIBILITY_REASONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEligibilityReasons(List<EligibilityReasonsEnum> eligibilityReasons) {
        this.eligibilityReasons = eligibilityReasons;
    }

    /**
     * Return true if this
     * get_registry_options_response_options_subscription_tiers_inner object is
     * equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRegistryOptionsResponseOptionsSubscriptionTiersInner getRegistryOptionsResponseOptionsSubscriptionTiersInner = (GetRegistryOptionsResponseOptionsSubscriptionTiersInner) o;
        return Objects.equals(this.name, getRegistryOptionsResponseOptionsSubscriptionTiersInner.name)
                && Objects.equals(this.slug, getRegistryOptionsResponseOptionsSubscriptionTiersInner.slug)
                && Objects.equals(this.includedRepositories,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.includedRepositories)
                && Objects.equals(this.includedStorageBytes,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.includedStorageBytes)
                && Objects.equals(this.allowStorageOverage,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.allowStorageOverage)
                && Objects.equals(this.includedBandwidthBytes,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.includedBandwidthBytes)
                && Objects.equals(this.monthlyPriceInCents,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.monthlyPriceInCents)
                && Objects.equals(this.storageOveragePriceInCents,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.storageOveragePriceInCents)
                && Objects.equals(this.eligible, getRegistryOptionsResponseOptionsSubscriptionTiersInner.eligible)
                && Objects.equals(this.eligibilityReasons,
                        getRegistryOptionsResponseOptionsSubscriptionTiersInner.eligibilityReasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug, includedRepositories, includedStorageBytes, allowStorageOverage,
                includedBandwidthBytes, monthlyPriceInCents, storageOveragePriceInCents, eligible, eligibilityReasons);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRegistryOptionsResponseOptionsSubscriptionTiersInner {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    includedRepositories: ").append(toIndentedString(includedRepositories)).append("\n");
        sb.append("    includedStorageBytes: ").append(toIndentedString(includedStorageBytes)).append("\n");
        sb.append("    allowStorageOverage: ").append(toIndentedString(allowStorageOverage)).append("\n");
        sb.append("    includedBandwidthBytes: ").append(toIndentedString(includedBandwidthBytes)).append("\n");
        sb.append("    monthlyPriceInCents: ").append(toIndentedString(monthlyPriceInCents)).append("\n");
        sb.append("    storageOveragePriceInCents: ").append(toIndentedString(storageOveragePriceInCents)).append("\n");
        sb.append("    eligible: ").append(toIndentedString(eligible)).append("\n");
        sb.append("    eligibilityReasons: ").append(toIndentedString(eligibilityReasons)).append("\n");
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