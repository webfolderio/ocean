package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CertificateRequestCustomAllOf
 */
@JsonPropertyOrder({ CertificateRequestCustomAllOf.JSON_PROPERTY_PRIVATE_KEY,
        CertificateRequestCustomAllOf.JSON_PROPERTY_LEAF_CERTIFICATE,
        CertificateRequestCustomAllOf.JSON_PROPERTY_CERTIFICATE_CHAIN })
public class CertificateRequestCustomAllOf {
    public static final String JSON_PROPERTY_PRIVATE_KEY = "private_key";
    private String privateKey;

    public static final String JSON_PROPERTY_LEAF_CERTIFICATE = "leaf_certificate";
    private String leafCertificate;

    public static final String JSON_PROPERTY_CERTIFICATE_CHAIN = "certificate_chain";
    private String certificateChain;

    public CertificateRequestCustomAllOf() {
    }

    public CertificateRequestCustomAllOf privateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * The contents of a PEM-formatted private-key corresponding to the SSL
     * certificate.
     *
     * @return privateKey
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PRIVATE_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getPrivateKey() {
        return privateKey;
    }

    @JsonProperty(JSON_PROPERTY_PRIVATE_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public CertificateRequestCustomAllOf leafCertificate(String leafCertificate) {
        this.leafCertificate = leafCertificate;
        return this;
    }

    /**
     * The contents of a PEM-formatted public SSL certificate.
     *
     * @return leafCertificate
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LEAF_CERTIFICATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getLeafCertificate() {
        return leafCertificate;
    }

    @JsonProperty(JSON_PROPERTY_LEAF_CERTIFICATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLeafCertificate(String leafCertificate) {
        this.leafCertificate = leafCertificate;
    }

    public CertificateRequestCustomAllOf certificateChain(String certificateChain) {
        this.certificateChain = certificateChain;
        return this;
    }

    /**
     * The full PEM-formatted trust chain between the certificate authority&#39;s
     * certificate and your domain&#39;s SSL certificate.
     *
     * @return certificateChain
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERTIFICATE_CHAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCertificateChain() {
        return certificateChain;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATE_CHAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificateChain(String certificateChain) {
        this.certificateChain = certificateChain;
    }

    /**
     * Return true if this certificate_request_custom_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificateRequestCustomAllOf certificateRequestCustomAllOf = (CertificateRequestCustomAllOf) o;
        return Objects.equals(this.privateKey, certificateRequestCustomAllOf.privateKey)
                && Objects.equals(this.leafCertificate, certificateRequestCustomAllOf.leafCertificate)
                && Objects.equals(this.certificateChain, certificateRequestCustomAllOf.certificateChain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privateKey, leafCertificate, certificateChain);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificateRequestCustomAllOf {\n");
        sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
        sb.append("    leafCertificate: ").append(toIndentedString(leafCertificate)).append("\n");
        sb.append("    certificateChain: ").append(toIndentedString(certificateChain)).append("\n");
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