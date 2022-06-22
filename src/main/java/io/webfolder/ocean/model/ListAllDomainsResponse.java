package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllDomainsResponse
 */
@JsonPropertyOrder({ ListAllDomainsResponse.JSON_PROPERTY_DOMAINS, ListAllDomainsResponse.JSON_PROPERTY_LINKS,
        ListAllDomainsResponse.JSON_PROPERTY_META })
public class ListAllDomainsResponse {
    public static final String JSON_PROPERTY_DOMAINS = "domains";
    private List<Domain> domains = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllDomainsResponse() {
    }

    public ListAllDomainsResponse domains(List<Domain> domains) {
        this.domains = domains;
        return this;
    }

    public ListAllDomainsResponse addDomainsItem(Domain domainsItem) {
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

    public ListAllDomainsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListAllDomainsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_all_domains_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDomainsResponse listAllDomainsResponse = (ListAllDomainsResponse) o;
        return Objects.equals(this.domains, listAllDomainsResponse.domains)
                && Objects.equals(this.links, listAllDomainsResponse.links)
                && Objects.equals(this.meta, listAllDomainsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domains, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDomainsResponse {\n");
        sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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
