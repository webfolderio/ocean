package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppDomainSpec
 */
@JsonPropertyOrder({ AppDomainSpec.JSON_PROPERTY_DOMAIN, AppDomainSpec.JSON_PROPERTY_TYPE,
        AppDomainSpec.JSON_PROPERTY_WILDCARD, AppDomainSpec.JSON_PROPERTY_ZONE,
        AppDomainSpec.JSON_PROPERTY_MINIMUM_TLS_VERSION })
public class AppDomainSpec {
    public static final String JSON_PROPERTY_DOMAIN = "domain";
    private String domain;

    /**
     * - DEFAULT: The default &#x60;.ondigitalocean.app&#x60; domain assigned to
     * this app - PRIMARY: The primary domain for this app that is displayed as the
     * default in the control panel, used in bindable environment variables, and any
     * other places that reference an app&#39;s live URL. Only one domain may be set
     * as primary. - ALIAS: A non-primary domain
     */
    public enum TypeEnum {
        UNSPECIFIED("UNSPECIFIED"),

        DEFAULT("DEFAULT"),

        PRIMARY("PRIMARY"),

        ALIAS("ALIAS");

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
    private TypeEnum type = TypeEnum.UNSPECIFIED;

    public static final String JSON_PROPERTY_WILDCARD = "wildcard";
    private Boolean wildcard;

    public static final String JSON_PROPERTY_ZONE = "zone";
    private String zone;

    public static final String JSON_PROPERTY_MINIMUM_TLS_VERSION = "minimum_tls_version";
    private String minimumTlsVersion;

    public AppDomainSpec() {
    }

    public AppDomainSpec domain(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * The hostname for the domain
     *
     * @return domain
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDomain() {
        return domain;
    }

    @JsonProperty(JSON_PROPERTY_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDomain(String domain) {
        this.domain = domain;
    }

    public AppDomainSpec type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * - DEFAULT: The default &#x60;.ondigitalocean.app&#x60; domain assigned to
     * this app - PRIMARY: The primary domain for this app that is displayed as the
     * default in the control panel, used in bindable environment variables, and any
     * other places that reference an app&#39;s live URL. Only one domain may be set
     * as primary. - ALIAS: A non-primary domain
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

    public AppDomainSpec wildcard(Boolean wildcard) {
        this.wildcard = wildcard;
        return this;
    }

    /**
     * Indicates whether the domain includes all sub-domains, in addition to the
     * given domain
     *
     * @return wildcard
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WILDCARD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getWildcard() {
        return wildcard;
    }

    @JsonProperty(JSON_PROPERTY_WILDCARD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWildcard(Boolean wildcard) {
        this.wildcard = wildcard;
    }

    public AppDomainSpec zone(String zone) {
        this.zone = zone;
        return this;
    }

    /**
     * Optional. If the domain uses DigitalOcean DNS and you would like App Platform
     * to automatically manage it for you, set this to the name of the domain on
     * your account. For example, If the domain you are adding is
     * &#x60;app.domain.com&#x60;, the zone could be &#x60;domain.com&#x60;.
     *
     * @return zone
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getZone() {
        return zone;
    }

    @JsonProperty(JSON_PROPERTY_ZONE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setZone(String zone) {
        this.zone = zone;
    }

    public AppDomainSpec minimumTlsVersion(String minimumTlsVersion) {
        this.minimumTlsVersion = minimumTlsVersion;
        return this;
    }

    /**
     * The minimum version of TLS a client application can use to access resources
     * for the domain. Must be one of the following values wrapped within
     * quotations: &#x60;\\\&quot;1.2\\\&quot;&#x60; or
     * &#x60;\\\&quot;1.3\\\&quot;&#x60;.
     *
     * @return minimumTlsVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MINIMUM_TLS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMinimumTlsVersion() {
        return minimumTlsVersion;
    }

    @JsonProperty(JSON_PROPERTY_MINIMUM_TLS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMinimumTlsVersion(String minimumTlsVersion) {
        this.minimumTlsVersion = minimumTlsVersion;
    }

    /**
     * Return true if this app_domain_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppDomainSpec appDomainSpec = (AppDomainSpec) o;
        return Objects.equals(this.domain, appDomainSpec.domain) && Objects.equals(this.type, appDomainSpec.type)
                && Objects.equals(this.wildcard, appDomainSpec.wildcard)
                && Objects.equals(this.zone, appDomainSpec.zone)
                && Objects.equals(this.minimumTlsVersion, appDomainSpec.minimumTlsVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, type, wildcard, zone, minimumTlsVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppDomainSpec {\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    wildcard: ").append(toIndentedString(wildcard)).append("\n");
        sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
        sb.append("    minimumTlsVersion: ").append(toIndentedString(minimumTlsVersion)).append("\n");
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
