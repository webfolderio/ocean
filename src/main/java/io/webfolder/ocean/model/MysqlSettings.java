package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * MysqlSettings
 */
@JsonPropertyOrder({ MysqlSettings.JSON_PROPERTY_AUTH_PLUGIN })
public class MysqlSettings {
    /**
     * A string specifying the authentication method to be used for connections to
     * the MySQL user account. The valid values are
     * &#x60;mysql_native_password&#x60; or &#x60;caching_sha2_password&#x60;. If
     * excluded when creating a new user, the default for the version of MySQL in
     * use will be used. As of MySQL 8.0, the default is
     * &#x60;caching_sha2_password&#x60;.
     */
    public enum AuthPluginEnum {
        MYSQL_NATIVE_PASSWORD("mysql_native_password"),

        CACHING_SHA2_PASSWORD("caching_sha2_password");

        private String value;

        AuthPluginEnum(String value) {
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
        public static AuthPluginEnum fromValue(String value) {
            for (AuthPluginEnum b : AuthPluginEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_AUTH_PLUGIN = "auth_plugin";
    private AuthPluginEnum authPlugin;

    public MysqlSettings() {
    }

    public MysqlSettings authPlugin(AuthPluginEnum authPlugin) {
        this.authPlugin = authPlugin;
        return this;
    }

    /**
     * A string specifying the authentication method to be used for connections to
     * the MySQL user account. The valid values are
     * &#x60;mysql_native_password&#x60; or &#x60;caching_sha2_password&#x60;. If
     * excluded when creating a new user, the default for the version of MySQL in
     * use will be used. As of MySQL 8.0, the default is
     * &#x60;caching_sha2_password&#x60;.
     *
     * @return authPlugin
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "mysql_native_password", required = true, value = "A string specifying the authentication method to be used for connections to the MySQL user account. The valid values are `mysql_native_password` or `caching_sha2_password`. If excluded when creating a new user, the default for the version of MySQL in use will be used. As of MySQL 8.0, the default is `caching_sha2_password`. ")
    @JsonProperty(JSON_PROPERTY_AUTH_PLUGIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public AuthPluginEnum getAuthPlugin() {
        return authPlugin;
    }

    @JsonProperty(JSON_PROPERTY_AUTH_PLUGIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAuthPlugin(AuthPluginEnum authPlugin) {
        this.authPlugin = authPlugin;
    }

    /**
     * Return true if this mysql_settings object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MysqlSettings mysqlSettings = (MysqlSettings) o;
        return Objects.equals(this.authPlugin, mysqlSettings.authPlugin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authPlugin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MysqlSettings {\n");
        sb.append("    authPlugin: ").append(toIndentedString(authPlugin)).append("\n");
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
