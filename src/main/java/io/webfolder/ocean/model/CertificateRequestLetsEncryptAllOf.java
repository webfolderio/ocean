package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CertificateRequestLetsEncryptAllOf
 */
@JsonPropertyOrder({ CertificateRequestLetsEncryptAllOf.JSON_PROPERTY_DNS_NAMES })
public class CertificateRequestLetsEncryptAllOf {
    public static final String JSON_PROPERTY_DNS_NAMES = "dns_names";
    private List<String> dnsNames = new ArrayList<>();

    public CertificateRequestLetsEncryptAllOf() {
    }

    public CertificateRequestLetsEncryptAllOf dnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
        return this;
    }

    public CertificateRequestLetsEncryptAllOf addDnsNamesItem(String dnsNamesItem) {
        this.dnsNames.add(dnsNamesItem);
        return this;
    }

    /**
     * An array of fully qualified domain names (FQDNs) for which the certificate
     * was issued. A certificate covering all subdomains can be issued using a
     * wildcard (e.g. &#x60;*.example.com&#x60;).
     *
     * @return dnsNames
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DNS_NAMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getDnsNames() {
        return dnsNames;
    }

    @JsonProperty(JSON_PROPERTY_DNS_NAMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    /**
     * Return true if this certificate_request_lets_encrypt_allOf object is equal to
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
        CertificateRequestLetsEncryptAllOf certificateRequestLetsEncryptAllOf = (CertificateRequestLetsEncryptAllOf) o;
        return Objects.equals(this.dnsNames, certificateRequestLetsEncryptAllOf.dnsNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dnsNames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificateRequestLetsEncryptAllOf {\n");
        sb.append("    dnsNames: ").append(toIndentedString(dnsNames)).append("\n");
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