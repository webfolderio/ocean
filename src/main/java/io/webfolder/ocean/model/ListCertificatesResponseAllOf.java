package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListCertificatesResponseAllOf
 */
@JsonPropertyOrder({ ListCertificatesResponseAllOf.JSON_PROPERTY_CERTIFICATES })
public class ListCertificatesResponseAllOf {
    public static final String JSON_PROPERTY_CERTIFICATES = "certificates";
    private List<Certificate> certificates = null;

    public ListCertificatesResponseAllOf() {
    }

    public ListCertificatesResponseAllOf certificates(List<Certificate> certificates) {
        this.certificates = certificates;
        return this;
    }

    public ListCertificatesResponseAllOf addCertificatesItem(Certificate certificatesItem) {
        if (this.certificates == null) {
            this.certificates = new ArrayList<>();
        }
        this.certificates.add(certificatesItem);
        return this;
    }

    /**
     * Get certificates
     *
     * @return certificates
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CERTIFICATES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Certificate> getCertificates() {
        return certificates;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    /**
     * Return true if this list_certificates_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListCertificatesResponseAllOf listCertificatesResponseAllOf = (ListCertificatesResponseAllOf) o;
        return Objects.equals(this.certificates, listCertificatesResponseAllOf.certificates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListCertificatesResponseAllOf {\n");
        sb.append("    certificates: ").append(toIndentedString(certificates)).append("\n");
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
