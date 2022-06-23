package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllRegionsResponseAllOf
 */
@JsonPropertyOrder({ ListAllRegionsResponseAllOf.JSON_PROPERTY_REGIONS })
public class ListAllRegionsResponseAllOf {
    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<Region> regions = new ArrayList<>();

    public ListAllRegionsResponseAllOf() {
    }

    public ListAllRegionsResponseAllOf regions(List<Region> regions) {
        this.regions = regions;
        return this;
    }

    public ListAllRegionsResponseAllOf addRegionsItem(Region regionsItem) {
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * Get regions
     *
     * @return regions
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Region> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    /**
     * Return true if this list_all_regions_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllRegionsResponseAllOf listAllRegionsResponseAllOf = (ListAllRegionsResponseAllOf) o;
        return Objects.equals(this.regions, listAllRegionsResponseAllOf.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllRegionsResponseAllOf {\n");
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