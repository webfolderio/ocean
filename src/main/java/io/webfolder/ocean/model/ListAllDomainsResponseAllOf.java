package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllDomainsResponseAllOf
 */
@JsonPropertyOrder({ ListAllDomainsResponseAllOf.JSON_PROPERTY_DOMAINS })
public class ListAllDomainsResponseAllOf {
    public static final String JSON_PROPERTY_DOMAINS = "domains";
    private List<Domain> domains = new ArrayList<>();

    public ListAllDomainsResponseAllOf() {
    }

    public ListAllDomainsResponseAllOf domains(List<Domain> domains) {
        this.domains = domains;
        return this;
    }

    public ListAllDomainsResponseAllOf addDomainsItem(Domain domainsItem) {
        this.domains.add(domainsItem);
        return this;
    }

    /**
     * Array of volumes.
     *
     * @return domains
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "Array of volumes.")
    @JsonProperty(JSON_PROPERTY_DOMAINS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Domain> getDomains() {
        return domains;
    }

    @JsonProperty(JSON_PROPERTY_DOMAINS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    /**
     * Return true if this list_all_domains_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDomainsResponseAllOf listAllDomainsResponseAllOf = (ListAllDomainsResponseAllOf) o;
        return Objects.equals(this.domains, listAllDomainsResponseAllOf.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domains);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDomainsResponseAllOf {\n");
        sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
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
