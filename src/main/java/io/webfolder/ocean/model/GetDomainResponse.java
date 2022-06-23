package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetDomainResponse
 */
@JsonPropertyOrder({ GetDomainResponse.JSON_PROPERTY_DOMAIN })
public class GetDomainResponse {
    public static final String JSON_PROPERTY_DOMAIN = "domain";
    private Domain domain;

    public GetDomainResponse() {
    }

    public GetDomainResponse domain(Domain domain) {
        this.domain = domain;
        return this;
    }

    /**
     * Get domain
     *
     * @return domain
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Domain getDomain() {
        return domain;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    /**
     * Return true if this get_domain_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDomainResponse getDomainResponse = (GetDomainResponse) o;
        return Objects.equals(this.domain, getDomainResponse.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetDomainResponse {\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
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