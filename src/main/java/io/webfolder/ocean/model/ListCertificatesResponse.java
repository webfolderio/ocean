package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListCertificatesResponse
 */
@JsonPropertyOrder({ ListCertificatesResponse.JSON_PROPERTY_CERTIFICATES, ListCertificatesResponse.JSON_PROPERTY_LINKS,
        ListCertificatesResponse.JSON_PROPERTY_META })
public class ListCertificatesResponse {
    public static final String JSON_PROPERTY_CERTIFICATES = "certificates";
    private List<Certificate> certificates = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListCertificatesResponse() {
    }

    public ListCertificatesResponse certificates(List<Certificate> certificates) {
        this.certificates = certificates;
        return this;
    }

    public ListCertificatesResponse addCertificatesItem(Certificate certificatesItem) {
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

    public ListCertificatesResponse links(PageLinks links) {
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

    public ListCertificatesResponse meta(MetaMeta meta) {
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
     * Return true if this list_certificates_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListCertificatesResponse listCertificatesResponse = (ListCertificatesResponse) o;
        return Objects.equals(this.certificates, listCertificatesResponse.certificates)
                && Objects.equals(this.links, listCertificatesResponse.links)
                && Objects.equals(this.meta, listCertificatesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificates, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListCertificatesResponse {\n");
        sb.append("    certificates: ").append(toIndentedString(certificates)).append("\n");
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
