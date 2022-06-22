package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetRegistryOptionsResponseOptions
 */
@JsonPropertyOrder({ GetRegistryOptionsResponseOptions.JSON_PROPERTY_AVAILABLE_REGIONS,
        GetRegistryOptionsResponseOptions.JSON_PROPERTY_SUBSCRIPTION_TIERS })
public class GetRegistryOptionsResponseOptions {
    public static final String JSON_PROPERTY_AVAILABLE_REGIONS = "available_regions";
    private List<String> availableRegions = null;

    public static final String JSON_PROPERTY_SUBSCRIPTION_TIERS = "subscription_tiers";
    private List<GetRegistryOptionsResponseOptionsSubscriptionTiersInner> subscriptionTiers = null;

    public GetRegistryOptionsResponseOptions() {
    }

    public GetRegistryOptionsResponseOptions availableRegions(List<String> availableRegions) {
        this.availableRegions = availableRegions;
        return this;
    }

    public GetRegistryOptionsResponseOptions addAvailableRegionsItem(String availableRegionsItem) {
        if (this.availableRegions == null) {
            this.availableRegions = new ArrayList<>();
        }
        this.availableRegions.add(availableRegionsItem);
        return this;
    }

    /**
     * Get availableRegions
     *
     * @return availableRegions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"nyc3\"]", value = "")
    @JsonProperty(JSON_PROPERTY_AVAILABLE_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getAvailableRegions() {
        return availableRegions;
    }

    @JsonProperty(JSON_PROPERTY_AVAILABLE_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAvailableRegions(List<String> availableRegions) {
        this.availableRegions = availableRegions;
    }

    public GetRegistryOptionsResponseOptions subscriptionTiers(
            List<GetRegistryOptionsResponseOptionsSubscriptionTiersInner> subscriptionTiers) {
        this.subscriptionTiers = subscriptionTiers;
        return this;
    }

    public GetRegistryOptionsResponseOptions addSubscriptionTiersItem(
            GetRegistryOptionsResponseOptionsSubscriptionTiersInner subscriptionTiersItem) {
        if (this.subscriptionTiers == null) {
            this.subscriptionTiers = new ArrayList<>();
        }
        this.subscriptionTiers.add(subscriptionTiersItem);
        return this;
    }

    /**
     * Get subscriptionTiers
     *
     * @return subscriptionTiers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TIERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<GetRegistryOptionsResponseOptionsSubscriptionTiersInner> getSubscriptionTiers() {
        return subscriptionTiers;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TIERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscriptionTiers(List<GetRegistryOptionsResponseOptionsSubscriptionTiersInner> subscriptionTiers) {
        this.subscriptionTiers = subscriptionTiers;
    }

    /**
     * Return true if this get_registry_options_response_options object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRegistryOptionsResponseOptions getRegistryOptionsResponseOptions = (GetRegistryOptionsResponseOptions) o;
        return Objects.equals(this.availableRegions, getRegistryOptionsResponseOptions.availableRegions)
                && Objects.equals(this.subscriptionTiers, getRegistryOptionsResponseOptions.subscriptionTiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableRegions, subscriptionTiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRegistryOptionsResponseOptions {\n");
        sb.append("    availableRegions: ").append(toIndentedString(availableRegions)).append("\n");
        sb.append("    subscriptionTiers: ").append(toIndentedString(subscriptionTiers)).append("\n");
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
