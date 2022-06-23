package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Certificate
 */
@JsonPropertyOrder({ Certificate.JSON_PROPERTY_ID, Certificate.JSON_PROPERTY_NAME, Certificate.JSON_PROPERTY_NOT_AFTER,
        Certificate.JSON_PROPERTY_SHA1_FINGERPRINT, Certificate.JSON_PROPERTY_CREATED_AT,
        Certificate.JSON_PROPERTY_DNS_NAMES, Certificate.JSON_PROPERTY_STATE, Certificate.JSON_PROPERTY_TYPE })
public class Certificate {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_NOT_AFTER = "not_after";
    private OffsetDateTime notAfter;

    public static final String JSON_PROPERTY_SHA1_FINGERPRINT = "sha1_fingerprint";
    private String sha1Fingerprint;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_DNS_NAMES = "dns_names";
    private List<String> dnsNames = null;

    /**
     * A string representing the current state of the certificate. It may be
     * &#x60;pending&#x60;, &#x60;verified&#x60;, or &#x60;error&#x60;.
     */
    public enum StateEnum {
        PENDING("pending"),

        VERIFIED("verified"),

        ERROR("error");

        private String value;

        StateEnum(String value) {
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
        public static StateEnum fromValue(String value) {
            for (StateEnum b : StateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATE = "state";
    private StateEnum state;

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

    public Certificate() {
    }

    @JsonCreator
    public Certificate(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_NOT_AFTER) OffsetDateTime notAfter,
            @JsonProperty(JSON_PROPERTY_SHA1_FINGERPRINT) String sha1Fingerprint,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_STATE) StateEnum state) {
        this();
        this.id = id;
        this.notAfter = notAfter;
        this.sha1Fingerprint = sha1Fingerprint;
        this.createdAt = createdAt;
        this.state = state;
    }

    /**
     * A unique ID that can be used to identify and reference a certificate.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    public Certificate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique human-readable name referring to a certificate.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * the certificate&#39;s expiration date.
     *
     * @return notAfter
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NOT_AFTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public OffsetDateTime getNotAfter() {
        return notAfter;
    }

    /**
     * A unique identifier generated from the SHA-1 fingerprint of the certificate.
     *
     * @return sha1Fingerprint
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SHA1_FINGERPRINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSha1Fingerprint() {
        return sha1Fingerprint;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the certificate was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Certificate dnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
        return this;
    }

    public Certificate addDnsNamesItem(String dnsNamesItem) {
        if (this.dnsNames == null) {
            this.dnsNames = new ArrayList<>();
        }
        this.dnsNames.add(dnsNamesItem);
        return this;
    }

    /**
     * An array of fully qualified domain names (FQDNs) for which the certificate
     * was issued.
     *
     * @return dnsNames
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DNS_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getDnsNames() {
        return dnsNames;
    }

    @JsonProperty(JSON_PROPERTY_DNS_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDnsNames(List<String> dnsNames) {
        this.dnsNames = dnsNames;
    }

    /**
     * A string representing the current state of the certificate. It may be
     * &#x60;pending&#x60;, &#x60;verified&#x60;, or &#x60;error&#x60;.
     *
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    public Certificate type(TypeEnum type) {
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
     * Return true if this certificate object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Certificate certificate = (Certificate) o;
        return Objects.equals(this.id, certificate.id) && Objects.equals(this.name, certificate.name)
                && Objects.equals(this.notAfter, certificate.notAfter)
                && Objects.equals(this.sha1Fingerprint, certificate.sha1Fingerprint)
                && Objects.equals(this.createdAt, certificate.createdAt)
                && Objects.equals(this.dnsNames, certificate.dnsNames) && Objects.equals(this.state, certificate.state)
                && Objects.equals(this.type, certificate.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, notAfter, sha1Fingerprint, createdAt, dnsNames, state, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Certificate {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
        sb.append("    sha1Fingerprint: ").append(toIndentedString(sha1Fingerprint)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    dnsNames: ").append(toIndentedString(dnsNames)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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