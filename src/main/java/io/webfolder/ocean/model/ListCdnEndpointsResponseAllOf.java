package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListCdnEndpointsResponseAllOf
 */
@JsonPropertyOrder({ ListCdnEndpointsResponseAllOf.JSON_PROPERTY_ENDPOINTS })
public class ListCdnEndpointsResponseAllOf {
    public static final String JSON_PROPERTY_ENDPOINTS = "endpoints";
    private List<CdnEndpoint> endpoints = null;

    public ListCdnEndpointsResponseAllOf() {
    }

    public ListCdnEndpointsResponseAllOf endpoints(List<CdnEndpoint> endpoints) {
        this.endpoints = endpoints;
        return this;
    }

    public ListCdnEndpointsResponseAllOf addEndpointsItem(CdnEndpoint endpointsItem) {
        if (this.endpoints == null) {
            this.endpoints = new ArrayList<>();
        }
        this.endpoints.add(endpointsItem);
        return this;
    }

    /**
     * Get endpoints
     *
     * @return endpoints
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ENDPOINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<CdnEndpoint> getEndpoints() {
        return endpoints;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndpoints(List<CdnEndpoint> endpoints) {
        this.endpoints = endpoints;
    }

    /**
     * Return true if this list_cdn_endpoints_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListCdnEndpointsResponseAllOf listCdnEndpointsResponseAllOf = (ListCdnEndpointsResponseAllOf) o;
        return Objects.equals(this.endpoints, listCdnEndpointsResponseAllOf.endpoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListCdnEndpointsResponseAllOf {\n");
        sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
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
