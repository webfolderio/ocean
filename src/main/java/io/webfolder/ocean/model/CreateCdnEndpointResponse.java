package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateCdnEndpointResponse
 */
@JsonPropertyOrder({ CreateCdnEndpointResponse.JSON_PROPERTY_ENDPOINT })
public class CreateCdnEndpointResponse {
    public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
    private CdnEndpoint endpoint;

    public CreateCdnEndpointResponse() {
    }

    public CreateCdnEndpointResponse endpoint(CdnEndpoint endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Get endpoint
     *
     * @return endpoint
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CdnEndpoint getEndpoint() {
        return endpoint;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndpoint(CdnEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Return true if this create_cdn_endpoint_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCdnEndpointResponse createCdnEndpointResponse = (CreateCdnEndpointResponse) o;
        return Objects.equals(this.endpoint, createCdnEndpointResponse.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateCdnEndpointResponse {\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
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
