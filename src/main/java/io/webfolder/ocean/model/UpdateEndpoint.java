package io.webfolder.ocean.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * UpdateEndpoint
 */
@JsonPropertyOrder({ UpdateEndpoint.JSON_PROPERTY_TTL, UpdateEndpoint.JSON_PROPERTY_CERTIFICATE_ID,
        UpdateEndpoint.JSON_PROPERTY_CUSTOM_DOMAIN })
public class UpdateEndpoint {
    /**
     * The amount of time the content is cached by the CDN&#39;s edge servers in
     * seconds. TTL must be one of 60, 600, 3600, 86400, or 604800. Defaults to 3600
     * (one hour) when excluded.
     */
    public enum TtlEnum {
        NUMBER_60(60),

        NUMBER_600(600),

        NUMBER_3600(3600),

        NUMBER_86400(86400),

        NUMBER_604800(604800);

        private Integer value;

        TtlEnum(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TtlEnum fromValue(Integer value) {
            for (TtlEnum b : TtlEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TTL = "ttl";
    private TtlEnum ttl = TtlEnum.NUMBER_3600;

    public static final String JSON_PROPERTY_CERTIFICATE_ID = "certificate_id";
    private UUID certificateId;

    public static final String JSON_PROPERTY_CUSTOM_DOMAIN = "custom_domain";
    private String customDomain;

    public UpdateEndpoint() {
    }

    public UpdateEndpoint ttl(TtlEnum ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * The amount of time the content is cached by the CDN&#39;s edge servers in
     * seconds. TTL must be one of 60, 600, 3600, 86400, or 604800. Defaults to 3600
     * (one hour) when excluded.
     *
     * @return ttl
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TTL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TtlEnum getTtl() {
        return ttl;
    }

    @JsonProperty(JSON_PROPERTY_TTL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTtl(TtlEnum ttl) {
        this.ttl = ttl;
    }

    public UpdateEndpoint certificateId(UUID certificateId) {
        this.certificateId = certificateId;
        return this;
    }

    /**
     * The ID of a DigitalOcean managed TLS certificate used for SSL when a custom
     * subdomain is provided.
     *
     * @return certificateId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERTIFICATE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getCertificateId() {
        return certificateId;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificateId(UUID certificateId) {
        this.certificateId = certificateId;
    }

    public UpdateEndpoint customDomain(String customDomain) {
        this.customDomain = customDomain;
        return this;
    }

    /**
     * The fully qualified domain name (FQDN) of the custom subdomain used with the
     * CDN endpoint.
     *
     * @return customDomain
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CUSTOM_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCustomDomain() {
        return customDomain;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCustomDomain(String customDomain) {
        this.customDomain = customDomain;
    }

    /**
     * Return true if this update_endpoint object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateEndpoint updateEndpoint = (UpdateEndpoint) o;
        return Objects.equals(this.ttl, updateEndpoint.ttl)
                && Objects.equals(this.certificateId, updateEndpoint.certificateId)
                && Objects.equals(this.customDomain, updateEndpoint.customDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ttl, certificateId, customDomain);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateEndpoint {\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    certificateId: ").append(toIndentedString(certificateId)).append("\n");
        sb.append("    customDomain: ").append(toIndentedString(customDomain)).append("\n");
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