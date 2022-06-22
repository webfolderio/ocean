package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * PGBouncer connection pooling settings
 */
@JsonPropertyOrder({ Pgbouncer.JSON_PROPERTY_SERVER_RESET_QUERY_ALWAYS,
        Pgbouncer.JSON_PROPERTY_IGNORE_STARTUP_PARAMETERS, Pgbouncer.JSON_PROPERTY_MIN_POOL_SIZE,
        Pgbouncer.JSON_PROPERTY_SERVER_LIFETIME, Pgbouncer.JSON_PROPERTY_SERVER_IDLE_TIMEOUT,
        Pgbouncer.JSON_PROPERTY_AUTODB_POOL_SIZE, Pgbouncer.JSON_PROPERTY_AUTODB_POOL_MODE,
        Pgbouncer.JSON_PROPERTY_AUTODB_MAX_DB_CONNECTIONS, Pgbouncer.JSON_PROPERTY_AUTODB_IDLE_TIMEOUT })
public class Pgbouncer {
    public static final String JSON_PROPERTY_SERVER_RESET_QUERY_ALWAYS = "server_reset_query_always";
    private Boolean serverResetQueryAlways;

    /**
     * Enum of parameters to ignore when given in startup packet.
     */
    public enum IgnoreStartupParametersEnum {
        EXTRA_FLOAT_DIGITS("extra_float_digits"),

        SEARCH_PATH("search_path");

        private String value;

        IgnoreStartupParametersEnum(String value) {
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
        public static IgnoreStartupParametersEnum fromValue(String value) {
            for (IgnoreStartupParametersEnum b : IgnoreStartupParametersEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_IGNORE_STARTUP_PARAMETERS = "ignore_startup_parameters";
    private List<IgnoreStartupParametersEnum> ignoreStartupParameters = null;

    public static final String JSON_PROPERTY_MIN_POOL_SIZE = "min_pool_size";
    private Integer minPoolSize;

    public static final String JSON_PROPERTY_SERVER_LIFETIME = "server_lifetime";
    private Integer serverLifetime;

    public static final String JSON_PROPERTY_SERVER_IDLE_TIMEOUT = "server_idle_timeout";
    private Integer serverIdleTimeout;

    public static final String JSON_PROPERTY_AUTODB_POOL_SIZE = "autodb_pool_size";
    private Integer autodbPoolSize;

    /**
     * PGBouncer pool mode
     */
    public enum AutodbPoolModeEnum {
        SESSION("session"),

        TRANSACTION("transaction"),

        STATEMENT("statement");

        private String value;

        AutodbPoolModeEnum(String value) {
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
        public static AutodbPoolModeEnum fromValue(String value) {
            for (AutodbPoolModeEnum b : AutodbPoolModeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_AUTODB_POOL_MODE = "autodb_pool_mode";
    private AutodbPoolModeEnum autodbPoolMode;

    public static final String JSON_PROPERTY_AUTODB_MAX_DB_CONNECTIONS = "autodb_max_db_connections";
    private Integer autodbMaxDbConnections;

    public static final String JSON_PROPERTY_AUTODB_IDLE_TIMEOUT = "autodb_idle_timeout";
    private Integer autodbIdleTimeout;

    public Pgbouncer() {
    }

    public Pgbouncer serverResetQueryAlways(Boolean serverResetQueryAlways) {
        this.serverResetQueryAlways = serverResetQueryAlways;
        return this;
    }

    /**
     * Run server_reset_query (DISCARD ALL) in all pooling modes.
     *
     * @return serverResetQueryAlways
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVER_RESET_QUERY_ALWAYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getServerResetQueryAlways() {
        return serverResetQueryAlways;
    }

    @JsonProperty(JSON_PROPERTY_SERVER_RESET_QUERY_ALWAYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServerResetQueryAlways(Boolean serverResetQueryAlways) {
        this.serverResetQueryAlways = serverResetQueryAlways;
    }

    public Pgbouncer ignoreStartupParameters(List<IgnoreStartupParametersEnum> ignoreStartupParameters) {
        this.ignoreStartupParameters = ignoreStartupParameters;
        return this;
    }

    public Pgbouncer addIgnoreStartupParametersItem(IgnoreStartupParametersEnum ignoreStartupParametersItem) {
        if (this.ignoreStartupParameters == null) {
            this.ignoreStartupParameters = new ArrayList<>();
        }
        this.ignoreStartupParameters.add(ignoreStartupParametersItem);
        return this;
    }

    /**
     * List of parameters to ignore when given in startup packet.
     *
     * @return ignoreStartupParameters
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IGNORE_STARTUP_PARAMETERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<IgnoreStartupParametersEnum> getIgnoreStartupParameters() {
        return ignoreStartupParameters;
    }

    @JsonProperty(JSON_PROPERTY_IGNORE_STARTUP_PARAMETERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIgnoreStartupParameters(List<IgnoreStartupParametersEnum> ignoreStartupParameters) {
        this.ignoreStartupParameters = ignoreStartupParameters;
    }

    public Pgbouncer minPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
        return this;
    }

    /**
     * If current server connections are below this number, adds more. Improves
     * behavior when usual load comes suddenly back after period of total
     * inactivity. The value is effectively capped at the pool size. minimum: 0
     * maximum: 10000
     *
     * @return minPoolSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MIN_POOL_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    @JsonProperty(JSON_PROPERTY_MIN_POOL_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public Pgbouncer serverLifetime(Integer serverLifetime) {
        this.serverLifetime = serverLifetime;
        return this;
    }

    /**
     * The pooler closes any unused server connection that has been connected longer
     * than this amount of seconds. minimum: 60 maximum: 86400
     *
     * @return serverLifetime
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVER_LIFETIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getServerLifetime() {
        return serverLifetime;
    }

    @JsonProperty(JSON_PROPERTY_SERVER_LIFETIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServerLifetime(Integer serverLifetime) {
        this.serverLifetime = serverLifetime;
    }

    public Pgbouncer serverIdleTimeout(Integer serverIdleTimeout) {
        this.serverIdleTimeout = serverIdleTimeout;
        return this;
    }

    /**
     * Drops server connections if they have been idle more than this many seconds.
     * If 0, timeout is disabled. minimum: 0 maximum: 86400
     *
     * @return serverIdleTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVER_IDLE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getServerIdleTimeout() {
        return serverIdleTimeout;
    }

    @JsonProperty(JSON_PROPERTY_SERVER_IDLE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServerIdleTimeout(Integer serverIdleTimeout) {
        this.serverIdleTimeout = serverIdleTimeout;
    }

    public Pgbouncer autodbPoolSize(Integer autodbPoolSize) {
        this.autodbPoolSize = autodbPoolSize;
        return this;
    }

    /**
     * If non-zero, automatically creates a pool of that size per user when a pool
     * doesn&#39;t exist. minimum: 0 maximum: 10000
     *
     * @return autodbPoolSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTODB_POOL_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutodbPoolSize() {
        return autodbPoolSize;
    }

    @JsonProperty(JSON_PROPERTY_AUTODB_POOL_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutodbPoolSize(Integer autodbPoolSize) {
        this.autodbPoolSize = autodbPoolSize;
    }

    public Pgbouncer autodbPoolMode(AutodbPoolModeEnum autodbPoolMode) {
        this.autodbPoolMode = autodbPoolMode;
        return this;
    }

    /**
     * PGBouncer pool mode
     *
     * @return autodbPoolMode
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTODB_POOL_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AutodbPoolModeEnum getAutodbPoolMode() {
        return autodbPoolMode;
    }

    @JsonProperty(JSON_PROPERTY_AUTODB_POOL_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutodbPoolMode(AutodbPoolModeEnum autodbPoolMode) {
        this.autodbPoolMode = autodbPoolMode;
    }

    public Pgbouncer autodbMaxDbConnections(Integer autodbMaxDbConnections) {
        this.autodbMaxDbConnections = autodbMaxDbConnections;
        return this;
    }

    /**
     * Only allows a maximum this many server connections per database (regardless
     * of user). If 0, allows unlimited connections. minimum: 0 maximum: 2147483647
     *
     * @return autodbMaxDbConnections
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTODB_MAX_DB_CONNECTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutodbMaxDbConnections() {
        return autodbMaxDbConnections;
    }

    @JsonProperty(JSON_PROPERTY_AUTODB_MAX_DB_CONNECTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutodbMaxDbConnections(Integer autodbMaxDbConnections) {
        this.autodbMaxDbConnections = autodbMaxDbConnections;
    }

    public Pgbouncer autodbIdleTimeout(Integer autodbIdleTimeout) {
        this.autodbIdleTimeout = autodbIdleTimeout;
        return this;
    }

    /**
     * If the automatically-created database pools have been unused this many
     * seconds, they are freed. If 0, timeout is disabled. minimum: 0 maximum: 86400
     *
     * @return autodbIdleTimeout
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTODB_IDLE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAutodbIdleTimeout() {
        return autodbIdleTimeout;
    }

    @JsonProperty(JSON_PROPERTY_AUTODB_IDLE_TIMEOUT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutodbIdleTimeout(Integer autodbIdleTimeout) {
        this.autodbIdleTimeout = autodbIdleTimeout;
    }

    /**
     * Return true if this pgbouncer object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pgbouncer pgbouncer = (Pgbouncer) o;
        return Objects.equals(this.serverResetQueryAlways, pgbouncer.serverResetQueryAlways)
                && Objects.equals(this.ignoreStartupParameters, pgbouncer.ignoreStartupParameters)
                && Objects.equals(this.minPoolSize, pgbouncer.minPoolSize)
                && Objects.equals(this.serverLifetime, pgbouncer.serverLifetime)
                && Objects.equals(this.serverIdleTimeout, pgbouncer.serverIdleTimeout)
                && Objects.equals(this.autodbPoolSize, pgbouncer.autodbPoolSize)
                && Objects.equals(this.autodbPoolMode, pgbouncer.autodbPoolMode)
                && Objects.equals(this.autodbMaxDbConnections, pgbouncer.autodbMaxDbConnections)
                && Objects.equals(this.autodbIdleTimeout, pgbouncer.autodbIdleTimeout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverResetQueryAlways, ignoreStartupParameters, minPoolSize, serverLifetime,
                serverIdleTimeout, autodbPoolSize, autodbPoolMode, autodbMaxDbConnections, autodbIdleTimeout);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Pgbouncer {\n");
        sb.append("    serverResetQueryAlways: ").append(toIndentedString(serverResetQueryAlways)).append("\n");
        sb.append("    ignoreStartupParameters: ").append(toIndentedString(ignoreStartupParameters)).append("\n");
        sb.append("    minPoolSize: ").append(toIndentedString(minPoolSize)).append("\n");
        sb.append("    serverLifetime: ").append(toIndentedString(serverLifetime)).append("\n");
        sb.append("    serverIdleTimeout: ").append(toIndentedString(serverIdleTimeout)).append("\n");
        sb.append("    autodbPoolSize: ").append(toIndentedString(autodbPoolSize)).append("\n");
        sb.append("    autodbPoolMode: ").append(toIndentedString(autodbPoolMode)).append("\n");
        sb.append("    autodbMaxDbConnections: ").append(toIndentedString(autodbMaxDbConnections)).append("\n");
        sb.append("    autodbIdleTimeout: ").append(toIndentedString(autodbIdleTimeout)).append("\n");
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
