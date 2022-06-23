package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetCaResponse
 */
@JsonPropertyOrder({ GetCaResponse.JSON_PROPERTY_CA })
public class GetCaResponse {
    public static final String JSON_PROPERTY_CA = "ca";
    private Ca ca;

    public GetCaResponse() {
    }

    public GetCaResponse ca(Ca ca) {
        this.ca = ca;
        return this;
    }

    /**
     * Get ca
     *
     * @return ca
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Ca getCa() {
        return ca;
    }

    @JsonProperty(JSON_PROPERTY_CA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCa(Ca ca) {
        this.ca = ca;
    }

    /**
     * Return true if this get_ca_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetCaResponse getCaResponse = (GetCaResponse) o;
        return Objects.equals(this.ca, getCaResponse.ca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ca);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetCaResponse {\n");
        sb.append("    ca: ").append(toIndentedString(ca)).append("\n");
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