package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsCorsPolicy
 */
@JsonPropertyOrder({ AppsCorsPolicy.JSON_PROPERTY_ALLOW_ORIGINS, AppsCorsPolicy.JSON_PROPERTY_ALLOW_METHODS,
        AppsCorsPolicy.JSON_PROPERTY_ALLOW_HEADERS, AppsCorsPolicy.JSON_PROPERTY_EXPOSE_HEADERS,
        AppsCorsPolicy.JSON_PROPERTY_MAX_AGE, AppsCorsPolicy.JSON_PROPERTY_ALLOW_CREDENTIALS })
public class AppsCorsPolicy {
    public static final String JSON_PROPERTY_ALLOW_ORIGINS = "allow_origins";
    private List<AppsStringMatch> allowOrigins = null;

    public static final String JSON_PROPERTY_ALLOW_METHODS = "allow_methods";
    private List<String> allowMethods = null;

    public static final String JSON_PROPERTY_ALLOW_HEADERS = "allow_headers";
    private List<String> allowHeaders = null;

    public static final String JSON_PROPERTY_EXPOSE_HEADERS = "expose_headers";
    private List<String> exposeHeaders = null;

    public static final String JSON_PROPERTY_MAX_AGE = "max_age";
    private String maxAge;

    public static final String JSON_PROPERTY_ALLOW_CREDENTIALS = "allow_credentials";
    private Boolean allowCredentials;

    public AppsCorsPolicy() {
    }

    public AppsCorsPolicy allowOrigins(List<AppsStringMatch> allowOrigins) {
        this.allowOrigins = allowOrigins;
        return this;
    }

    public AppsCorsPolicy addAllowOriginsItem(AppsStringMatch allowOriginsItem) {
        if (this.allowOrigins == null) {
            this.allowOrigins = new ArrayList<>();
        }
        this.allowOrigins.add(allowOriginsItem);
        return this;
    }

    /**
     * The set of allowed CORS origins.
     *
     * @return allowOrigins
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALLOW_ORIGINS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppsStringMatch> getAllowOrigins() {
        return allowOrigins;
    }

    @JsonProperty(JSON_PROPERTY_ALLOW_ORIGINS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAllowOrigins(List<AppsStringMatch> allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    public AppsCorsPolicy allowMethods(List<String> allowMethods) {
        this.allowMethods = allowMethods;
        return this;
    }

    public AppsCorsPolicy addAllowMethodsItem(String allowMethodsItem) {
        if (this.allowMethods == null) {
            this.allowMethods = new ArrayList<>();
        }
        this.allowMethods.add(allowMethodsItem);
        return this;
    }

    /**
     * The set of allowed HTTP methods. This configures the
     * &#x60;Access-Control-Allow-Methods&#x60; header.
     *
     * @return allowMethods
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALLOW_METHODS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getAllowMethods() {
        return allowMethods;
    }

    @JsonProperty(JSON_PROPERTY_ALLOW_METHODS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAllowMethods(List<String> allowMethods) {
        this.allowMethods = allowMethods;
    }

    public AppsCorsPolicy allowHeaders(List<String> allowHeaders) {
        this.allowHeaders = allowHeaders;
        return this;
    }

    public AppsCorsPolicy addAllowHeadersItem(String allowHeadersItem) {
        if (this.allowHeaders == null) {
            this.allowHeaders = new ArrayList<>();
        }
        this.allowHeaders.add(allowHeadersItem);
        return this;
    }

    /**
     * The set of allowed HTTP request headers. This configures the
     * &#x60;Access-Control-Allow-Headers&#x60; header.
     *
     * @return allowHeaders
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALLOW_HEADERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getAllowHeaders() {
        return allowHeaders;
    }

    @JsonProperty(JSON_PROPERTY_ALLOW_HEADERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAllowHeaders(List<String> allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    public AppsCorsPolicy exposeHeaders(List<String> exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
        return this;
    }

    public AppsCorsPolicy addExposeHeadersItem(String exposeHeadersItem) {
        if (this.exposeHeaders == null) {
            this.exposeHeaders = new ArrayList<>();
        }
        this.exposeHeaders.add(exposeHeadersItem);
        return this;
    }

    /**
     * The set of HTTP response headers that browsers are allowed to access. This
     * configures the &#x60;Access-Control-Expose-Headers&#x60; header.
     *
     * @return exposeHeaders
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPOSE_HEADERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getExposeHeaders() {
        return exposeHeaders;
    }

    @JsonProperty(JSON_PROPERTY_EXPOSE_HEADERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExposeHeaders(List<String> exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
    }

    public AppsCorsPolicy maxAge(String maxAge) {
        this.maxAge = maxAge;
        return this;
    }

    /**
     * An optional duration specifying how long browsers can cache the results of a
     * preflight request. This configures the &#x60;Access-Control-Max-Age&#x60;
     * header.
     *
     * @return maxAge
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX_AGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMaxAge() {
        return maxAge;
    }

    @JsonProperty(JSON_PROPERTY_MAX_AGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public AppsCorsPolicy allowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
        return this;
    }

    /**
     * Whether browsers should expose the response to the client-side JavaScript
     * code when the request’s credentials mode is include. This configures the
     * &#x60;Access-Control-Allow-Credentials&#x60; header.
     *
     * @return allowCredentials
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ALLOW_CREDENTIALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    @JsonProperty(JSON_PROPERTY_ALLOW_CREDENTIALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    /**
     * Return true if this apps_cors_policy object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsCorsPolicy appsCorsPolicy = (AppsCorsPolicy) o;
        return Objects.equals(this.allowOrigins, appsCorsPolicy.allowOrigins)
                && Objects.equals(this.allowMethods, appsCorsPolicy.allowMethods)
                && Objects.equals(this.allowHeaders, appsCorsPolicy.allowHeaders)
                && Objects.equals(this.exposeHeaders, appsCorsPolicy.exposeHeaders)
                && Objects.equals(this.maxAge, appsCorsPolicy.maxAge)
                && Objects.equals(this.allowCredentials, appsCorsPolicy.allowCredentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowOrigins, allowMethods, allowHeaders, exposeHeaders, maxAge, allowCredentials);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsCorsPolicy {\n");
        sb.append("    allowOrigins: ").append(toIndentedString(allowOrigins)).append("\n");
        sb.append("    allowMethods: ").append(toIndentedString(allowMethods)).append("\n");
        sb.append("    allowHeaders: ").append(toIndentedString(allowHeaders)).append("\n");
        sb.append("    exposeHeaders: ").append(toIndentedString(exposeHeaders)).append("\n");
        sb.append("    maxAge: ").append(toIndentedString(maxAge)).append("\n");
        sb.append("    allowCredentials: ").append(toIndentedString(allowCredentials)).append("\n");
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