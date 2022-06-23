package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * CdnEndpoint
 */
@JsonPropertyOrder({ CdnEndpoint.JSON_PROPERTY_ID, CdnEndpoint.JSON_PROPERTY_ORIGIN, CdnEndpoint.JSON_PROPERTY_ENDPOINT,
        CdnEndpoint.JSON_PROPERTY_TTL, CdnEndpoint.JSON_PROPERTY_CERTIFICATE_ID,
        CdnEndpoint.JSON_PROPERTY_CUSTOM_DOMAIN, CdnEndpoint.JSON_PROPERTY_CREATED_AT })
public class CdnEndpoint {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_ORIGIN = "origin";
    private String origin;

    public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
    private String endpoint;

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

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public CdnEndpoint() {
    }

    @JsonCreator
    public CdnEndpoint(@JsonProperty(JSON_PROPERTY_ID) UUID id, @JsonProperty(JSON_PROPERTY_ENDPOINT) String endpoint,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.id = id;
        this.endpoint = endpoint;
        this.createdAt = createdAt;
    }

    /**
     * A unique ID that can be used to identify and reference a CDN endpoint.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    public CdnEndpoint origin(String origin) {
        this.origin = origin;
        return this;
    }

    /**
     * The fully qualified domain name (FQDN) for the origin server which provides
     * the content for the CDN. This is currently restricted to a Space.
     *
     * @return origin
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ORIGIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getOrigin() {
        return origin;
    }

    @JsonProperty(JSON_PROPERTY_ORIGIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * The fully qualified domain name (FQDN) from which the CDN-backed content is
     * served.
     *
     * @return endpoint
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getEndpoint() {
        return endpoint;
    }

    public CdnEndpoint ttl(TtlEnum ttl) {
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

    public CdnEndpoint certificateId(UUID certificateId) {
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

    public CdnEndpoint customDomain(String customDomain) {
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
     * A time value given in ISO8601 combined date and time format that represents
     * when the CDN endpoint was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Return true if this cdn_endpoint object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CdnEndpoint cdnEndpoint = (CdnEndpoint) o;
        return Objects.equals(this.id, cdnEndpoint.id) && Objects.equals(this.origin, cdnEndpoint.origin)
                && Objects.equals(this.endpoint, cdnEndpoint.endpoint) && Objects.equals(this.ttl, cdnEndpoint.ttl)
                && Objects.equals(this.certificateId, cdnEndpoint.certificateId)
                && Objects.equals(this.customDomain, cdnEndpoint.customDomain)
                && Objects.equals(this.createdAt, cdnEndpoint.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, endpoint, ttl, certificateId, customDomain, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CdnEndpoint {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    certificateId: ").append(toIndentedString(certificateId)).append("\n");
        sb.append("    customDomain: ").append(toIndentedString(customDomain)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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