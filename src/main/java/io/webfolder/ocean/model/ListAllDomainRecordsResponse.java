package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllDomainRecordsResponse
 */
@JsonPropertyOrder({ ListAllDomainRecordsResponse.JSON_PROPERTY_DOMAIN_RECORDS,
        ListAllDomainRecordsResponse.JSON_PROPERTY_LINKS, ListAllDomainRecordsResponse.JSON_PROPERTY_META })
public class ListAllDomainRecordsResponse {
    public static final String JSON_PROPERTY_DOMAIN_RECORDS = "domain_records";
    private List<DomainRecord> domainRecords = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllDomainRecordsResponse() {
    }

    public ListAllDomainRecordsResponse domainRecords(List<DomainRecord> domainRecords) {
        this.domainRecords = domainRecords;
        return this;
    }

    public ListAllDomainRecordsResponse addDomainRecordsItem(DomainRecord domainRecordsItem) {
        if (this.domainRecords == null) {
            this.domainRecords = new ArrayList<>();
        }
        this.domainRecords.add(domainRecordsItem);
        return this;
    }

    /**
     * Get domainRecords
     *
     * @return domainRecords
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOMAIN_RECORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<DomainRecord> getDomainRecords() {
        return domainRecords;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN_RECORDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDomainRecords(List<DomainRecord> domainRecords) {
        this.domainRecords = domainRecords;
    }

    public ListAllDomainRecordsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
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

    public ListAllDomainRecordsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
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
     * Return true if this list_all_domain_records_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDomainRecordsResponse listAllDomainRecordsResponse = (ListAllDomainRecordsResponse) o;
        return Objects.equals(this.domainRecords, listAllDomainRecordsResponse.domainRecords)
                && Objects.equals(this.links, listAllDomainRecordsResponse.links)
                && Objects.equals(this.meta, listAllDomainRecordsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainRecords, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDomainRecordsResponse {\n");
        sb.append("    domainRecords: ").append(toIndentedString(domainRecords)).append("\n");
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