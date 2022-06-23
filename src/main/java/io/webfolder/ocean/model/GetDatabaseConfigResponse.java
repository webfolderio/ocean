package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetDatabaseConfigResponse
 */
@JsonPropertyOrder({ GetDatabaseConfigResponse.JSON_PROPERTY_CONFIG })
public class GetDatabaseConfigResponse {
    public static final String JSON_PROPERTY_CONFIG = "config";
    private GetDatabaseConfigResponseConfig config;

    public GetDatabaseConfigResponse() {
    }

    public GetDatabaseConfigResponse config(GetDatabaseConfigResponseConfig config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CONFIG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public GetDatabaseConfigResponseConfig getConfig() {
        return config;
    }

    @JsonProperty(JSON_PROPERTY_CONFIG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setConfig(GetDatabaseConfigResponseConfig config) {
        this.config = config;
    }

    /**
     * Return true if this get_database_config_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetDatabaseConfigResponse getDatabaseConfigResponse = (GetDatabaseConfigResponse) o;
        return Objects.equals(this.config, getDatabaseConfigResponse.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetDatabaseConfigResponse {\n");
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