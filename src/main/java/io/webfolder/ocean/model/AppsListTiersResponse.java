package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsListTiersResponse
 */
@JsonPropertyOrder({ AppsListTiersResponse.JSON_PROPERTY_TIERS })
public class AppsListTiersResponse {
    public static final String JSON_PROPERTY_TIERS = "tiers";
    private List<AppsTier> tiers = null;

    public AppsListTiersResponse() {
    }

    public AppsListTiersResponse tiers(List<AppsTier> tiers) {
        this.tiers = tiers;
        return this;
    }

    public AppsListTiersResponse addTiersItem(AppsTier tiersItem) {
        if (this.tiers == null) {
            this.tiers = new ArrayList<>();
        }
        this.tiers.add(tiersItem);
        return this;
    }

    /**
     * Get tiers
     *
     * @return tiers
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_TIERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsTier> getTiers() {
        return tiers;
    }

    @JsonProperty(JSON_PROPERTY_TIERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTiers(List<AppsTier> tiers) {
        this.tiers = tiers;
    }

    /**
     * Return true if this apps_list_tiers_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsListTiersResponse appsListTiersResponse = (AppsListTiersResponse) o;
        return Objects.equals(this.tiers, appsListTiersResponse.tiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsListTiersResponse {\n");
        sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
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
