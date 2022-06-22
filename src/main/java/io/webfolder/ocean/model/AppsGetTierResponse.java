package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsGetTierResponse
 */
@JsonPropertyOrder({ AppsGetTierResponse.JSON_PROPERTY_TIER })
public class AppsGetTierResponse {
    public static final String JSON_PROPERTY_TIER = "tier";
    private AppsTier tier;

    public AppsGetTierResponse() {
    }

    public AppsGetTierResponse tier(AppsTier tier) {
        this.tier = tier;
        return this;
    }

    /**
     * Get tier
     *
     * @return tier
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsTier getTier() {
        return tier;
    }

    @JsonProperty(JSON_PROPERTY_TIER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTier(AppsTier tier) {
        this.tier = tier;
    }

    /**
     * Return true if this apps_get_tier_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsGetTierResponse appsGetTierResponse = (AppsGetTierResponse) o;
        return Objects.equals(this.tier, appsGetTierResponse.tier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsGetTierResponse {\n");
        sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
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
