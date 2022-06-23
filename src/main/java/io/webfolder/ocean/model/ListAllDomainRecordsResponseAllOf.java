package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllDomainRecordsResponseAllOf
 */
@JsonPropertyOrder({ ListAllDomainRecordsResponseAllOf.JSON_PROPERTY_DOMAIN_RECORDS })
public class ListAllDomainRecordsResponseAllOf {
    public static final String JSON_PROPERTY_DOMAIN_RECORDS = "domain_records";
    private List<DomainRecord> domainRecords = null;

    public ListAllDomainRecordsResponseAllOf() {
    }

    public ListAllDomainRecordsResponseAllOf domainRecords(List<DomainRecord> domainRecords) {
        this.domainRecords = domainRecords;
        return this;
    }

    public ListAllDomainRecordsResponseAllOf addDomainRecordsItem(DomainRecord domainRecordsItem) {
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

    /**
     * Return true if this list_all_domain_records_response_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllDomainRecordsResponseAllOf listAllDomainRecordsResponseAllOf = (ListAllDomainRecordsResponseAllOf) o;
        return Objects.equals(this.domainRecords, listAllDomainRecordsResponseAllOf.domainRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainRecords);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllDomainRecordsResponseAllOf {\n");
        sb.append("    domainRecords: ").append(toIndentedString(domainRecords)).append("\n");
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