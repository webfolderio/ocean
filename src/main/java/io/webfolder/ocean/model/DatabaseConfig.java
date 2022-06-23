package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DatabaseConfig
 */
@JsonPropertyOrder({ DatabaseConfig.JSON_PROPERTY_CONFIG })
public class DatabaseConfig {
    public static final String JSON_PROPERTY_CONFIG = "config";
    private GetDatabaseConfigResponseConfig config;

    public DatabaseConfig() {
    }

    public DatabaseConfig config(GetDatabaseConfigResponseConfig config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONFIG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public GetDatabaseConfigResponseConfig getConfig() {
        return config;
    }

    @JsonProperty(JSON_PROPERTY_CONFIG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConfig(GetDatabaseConfigResponseConfig config) {
        this.config = config;
    }

    /**
     * Return true if this database_config object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseConfig databaseConfig = (DatabaseConfig) o;
        return Objects.equals(this.config, databaseConfig.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseConfig {\n");
        sb.append("    config: ").append(toIndentedString(config)).append("\n");
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