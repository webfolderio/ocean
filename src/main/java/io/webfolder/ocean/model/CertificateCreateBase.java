package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * CertificateCreateBase
 */
@JsonPropertyOrder({ CertificateCreateBase.JSON_PROPERTY_NAME, CertificateCreateBase.JSON_PROPERTY_TYPE })
public class CertificateCreateBase {
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

    public CertificateCreateBase() {
    }

    public CertificateCreateBase name(String name) {
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

    public CertificateCreateBase type(TypeEnum type) {
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

    /**
     * Return true if this certificate_create_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CertificateCreateBase certificateCreateBase = (CertificateCreateBase) o;
        return Objects.equals(this.name, certificateCreateBase.name)
                && Objects.equals(this.type, certificateCreateBase.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CertificateCreateBase {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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