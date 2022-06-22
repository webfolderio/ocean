package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CertificateRequestLetsEncrypt
 */
@JsonPropertyOrder({ CertificateRequestLetsEncrypt.JSON_PROPERTY_NAME, CertificateRequestLetsEncrypt.JSON_PROPERTY_TYPE,
        CertificateRequestLetsEncrypt.JSON_PROPERTY_DNS_NAMES })
public class CertificateRequestLetsEncrypt {
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

    public static final String JSON_PROPERTY_DNS_NAMES = "dns_names";
    private List<String> dnsNames = new ArrayList<>();

    public CertificateRequestLetsEncrypt() {
    }

    public CertificateRequestLetsEncrypt name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique human-readable name referring to a certificate.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "web-cert-01", required = true, value = "A unique human-readable name referring to a certificate.")
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

    public CertificateRequestLetsEncrypt type(TypeEnum type) {
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
    @ApiModelProperty(example = "lets_encrypt", value = "A string representing the type of the certificate. The value will be `custom` for a user-uploaded certificate or `lets_encrypt` for one automatically generated with Let's Encrypt.")
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

    public CertificateRequestLetsEncrypt dnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
        return this;
    }

    public CertificateRequestLetsEncrypt addDnsNamesItem(String dnsNamesItem) {
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
    @ApiModelProperty(example = "[\"www.example.com\",\"example.com\"]", required = true, value = "An array of fully qualified domain names (FQDNs) for which the certificate was issued. A certificate covering all subdomains can be issued using a wildcard (e.g. `*.example.com`).")
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
     * Return true if this certificate_request_lets_encrypt object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificateRequestLetsEncrypt certificateRequestLetsEncrypt = (CertificateRequestLetsEncrypt) o;
        return Objects.equals(this.name, certificateRequestLetsEncrypt.name)
                && Objects.equals(this.type, certificateRequestLetsEncrypt.type)
                && Objects.equals(this.dnsNames, certificateRequestLetsEncrypt.dnsNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, dnsNames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificateRequestLetsEncrypt {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
