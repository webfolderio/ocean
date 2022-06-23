package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * CertificateRequestCustom
 */
@JsonPropertyOrder({ CertificateRequestCustom.JSON_PROPERTY_NAME, CertificateRequestCustom.JSON_PROPERTY_TYPE,
        CertificateRequestCustom.JSON_PROPERTY_PRIVATE_KEY, CertificateRequestCustom.JSON_PROPERTY_LEAF_CERTIFICATE,
        CertificateRequestCustom.JSON_PROPERTY_CERTIFICATE_CHAIN })
public class CertificateRequestCustom {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * A string representing the type of the certificate. The value will be
     * &#x60;custom&#x60; for a user-uploaded certificate or
     * &#x60;lets_encrypt&#x60; for one automatically generated with Let&#39;s
     * Encrypt.
     */
    public enum TypeEnum {
        CUSTOM("custom"),

        LETS_ENCRYPT("lets_encrypt");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public static final String JSON_PROPERTY_PRIVATE_KEY = "private_key";
    private String privateKey;

    public static final String JSON_PROPERTY_LEAF_CERTIFICATE = "leaf_certificate";
    private String leafCertificate;

    public static final String JSON_PROPERTY_CERTIFICATE_CHAIN = "certificate_chain";
    private String certificateChain;

    public CertificateRequestCustom() {
    }

    public CertificateRequestCustom name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique human-readable name referring to a certificate.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public CertificateRequestCustom type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * A string representing the type of the certificate. The value will be
     * &#x60;custom&#x60; for a user-uploaded certificate or
     * &#x60;lets_encrypt&#x60; for one automatically generated with Let&#39;s
     * Encrypt.
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public CertificateRequestCustom privateKey(String privateKey) {
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

    public CertificateRequestCustom leafCertificate(String leafCertificate) {
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

    public CertificateRequestCustom certificateChain(String certificateChain) {
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
     * Return true if this certificate_request_custom object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificateRequestCustom certificateRequestCustom = (CertificateRequestCustom) o;
        return Objects.equals(this.name, certificateRequestCustom.name)
                && Objects.equals(this.type, certificateRequestCustom.type)
                && Objects.equals(this.privateKey, certificateRequestCustom.privateKey)
                && Objects.equals(this.leafCertificate, certificateRequestCustom.leafCertificate)
                && Objects.equals(this.certificateChain, certificateRequestCustom.certificateChain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, privateKey, leafCertificate, certificateChain);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificateRequestCustom {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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