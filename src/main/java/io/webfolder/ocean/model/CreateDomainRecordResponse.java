package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateDomainRecordResponse
 */
@JsonPropertyOrder({ CreateDomainRecordResponse.JSON_PROPERTY_DOMAIN_RECORD })
public class CreateDomainRecordResponse {
    public static final String JSON_PROPERTY_DOMAIN_RECORD = "domain_record";
    private DomainRecord domainRecord;

    public CreateDomainRecordResponse() {
    }

    public CreateDomainRecordResponse domainRecord(DomainRecord domainRecord) {
        this.domainRecord = domainRecord;
        return this;
    }

    /**
     * Get domainRecord
     *
     * @return domainRecord
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOMAIN_RECORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DomainRecord getDomainRecord() {
        return domainRecord;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN_RECORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDomainRecord(DomainRecord domainRecord) {
        this.domainRecord = domainRecord;
    }

    /**
     * Return true if this create_domain_record_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDomainRecordResponse createDomainRecordResponse = (CreateDomainRecordResponse) o;
        return Objects.equals(this.domainRecord, createDomainRecordResponse.domainRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainRecord);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDomainRecordResponse {\n");
        sb.append("    domainRecord: ").append(toIndentedString(domainRecord)).append("\n");
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