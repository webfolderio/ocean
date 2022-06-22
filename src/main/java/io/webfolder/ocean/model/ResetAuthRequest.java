package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ResetAuthRequest
 */
@JsonPropertyOrder({ ResetAuthRequest.JSON_PROPERTY_MYSQL_SETTINGS })
public class ResetAuthRequest {
    public static final String JSON_PROPERTY_MYSQL_SETTINGS = "mysql_settings";
    private MysqlSettings mysqlSettings;

    public ResetAuthRequest() {
    }

    public ResetAuthRequest mysqlSettings(MysqlSettings mysqlSettings) {
        this.mysqlSettings = mysqlSettings;
        return this;
    }

    /**
     * Get mysqlSettings
     *
     * @return mysqlSettings
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_MYSQL_SETTINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MysqlSettings getMysqlSettings() {
        return mysqlSettings;
    }

    @JsonProperty(JSON_PROPERTY_MYSQL_SETTINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMysqlSettings(MysqlSettings mysqlSettings) {
        this.mysqlSettings = mysqlSettings;
    }

    /**
     * Return true if this reset_auth_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResetAuthRequest resetAuthRequest = (ResetAuthRequest) o;
        return Objects.equals(this.mysqlSettings, resetAuthRequest.mysqlSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mysqlSettings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResetAuthRequest {\n");
        sb.append("    mysqlSettings: ").append(toIndentedString(mysqlSettings)).append("\n");
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
