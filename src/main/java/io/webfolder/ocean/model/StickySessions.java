package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object specifying sticky sessions settings for the load balancer.
 */
@JsonPropertyOrder({ StickySessions.JSON_PROPERTY_TYPE, StickySessions.JSON_PROPERTY_COOKIE_NAME,
        StickySessions.JSON_PROPERTY_COOKIE_TTL_SECONDS })
public class StickySessions {
    /**
     * An attribute indicating how and if requests from a client will be
     * persistently served by the same backend Droplet. The possible values are
     * &#x60;cookies&#x60; or &#x60;none&#x60;.
     */
    public enum TypeEnum {
        COOKIES("cookies"),

        NONE("none");

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
    private TypeEnum type = TypeEnum.NONE;

    public static final String JSON_PROPERTY_COOKIE_NAME = "cookie_name";
    private String cookieName;

    public static final String JSON_PROPERTY_COOKIE_TTL_SECONDS = "cookie_ttl_seconds";
    private Integer cookieTtlSeconds;

    public StickySessions() {
    }

    public StickySessions type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * An attribute indicating how and if requests from a client will be
     * persistently served by the same backend Droplet. The possible values are
     * &#x60;cookies&#x60; or &#x60;none&#x60;.
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

    public StickySessions cookieName(String cookieName) {
        this.cookieName = cookieName;
        return this;
    }

    /**
     * The name of the cookie sent to the client. This attribute is only returned
     * when using &#x60;cookies&#x60; for the sticky sessions type.
     *
     * @return cookieName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COOKIE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCookieName() {
        return cookieName;
    }

    @JsonProperty(JSON_PROPERTY_COOKIE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public StickySessions cookieTtlSeconds(Integer cookieTtlSeconds) {
        this.cookieTtlSeconds = cookieTtlSeconds;
        return this;
    }

    /**
     * The number of seconds until the cookie set by the load balancer expires. This
     * attribute is only returned when using &#x60;cookies&#x60; for the sticky
     * sessions type.
     *
     * @return cookieTtlSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COOKIE_TTL_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getCookieTtlSeconds() {
        return cookieTtlSeconds;
    }

    @JsonProperty(JSON_PROPERTY_COOKIE_TTL_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCookieTtlSeconds(Integer cookieTtlSeconds) {
        this.cookieTtlSeconds = cookieTtlSeconds;
    }

    /**
     * Return true if this sticky_sessions object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StickySessions stickySessions = (StickySessions) o;
        return Objects.equals(this.type, stickySessions.type)
                && Objects.equals(this.cookieName, stickySessions.cookieName)
                && Objects.equals(this.cookieTtlSeconds, stickySessions.cookieTtlSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cookieName, cookieTtlSeconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StickySessions {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    cookieName: ").append(toIndentedString(cookieName)).append("\n");
        sb.append("    cookieTtlSeconds: ").append(toIndentedString(cookieTtlSeconds)).append("\n");
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