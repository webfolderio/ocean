package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateDomainResponse
 */
@JsonPropertyOrder({ CreateDomainResponse.JSON_PROPERTY_DOMAIN })
public class CreateDomainResponse {
    public static final String JSON_PROPERTY_DOMAIN = "domain";
    private Domain domain;

    public CreateDomainResponse() {
    }

    public CreateDomainResponse domain(Domain domain) {
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
     * Return true if this create_domain_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDomainResponse createDomainResponse = (CreateDomainResponse) o;
        return Objects.equals(this.domain, createDomainResponse.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDomainResponse {\n");
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