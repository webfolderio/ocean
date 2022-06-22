package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsListRegionsResponse
 */
@JsonPropertyOrder({ AppsListRegionsResponse.JSON_PROPERTY_REGIONS })
public class AppsListRegionsResponse {
    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<AppsRegion> regions = null;

    public AppsListRegionsResponse() {
    }

    public AppsListRegionsResponse regions(List<AppsRegion> regions) {
        this.regions = regions;
        return this;
    }

    public AppsListRegionsResponse addRegionsItem(AppsRegion regionsItem) {
        if (this.regions == null) {
            this.regions = new ArrayList<>();
        }
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * Get regions
     *
     * @return regions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsRegion> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegions(List<AppsRegion> regions) {
        this.regions = regions;
    }

    /**
     * Return true if this apps_list_regions_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsListRegionsResponse appsListRegionsResponse = (AppsListRegionsResponse) o;
        return Objects.equals(this.regions, appsListRegionsResponse.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsListRegionsResponse {\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
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
