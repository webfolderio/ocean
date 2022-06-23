package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Logtail configuration.
 */
@JsonPropertyOrder({ AppLogDestinationLogtailSpec.JSON_PROPERTY_TOKEN })
public class AppLogDestinationLogtailSpec {
    public static final String JSON_PROPERTY_TOKEN = "token";
    private String token;

    public AppLogDestinationLogtailSpec() {
    }

    public AppLogDestinationLogtailSpec token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Logtail token.
     *
     * @return token
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getToken() {
        return token;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Return true if this app_log_destination_logtail_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppLogDestinationLogtailSpec appLogDestinationLogtailSpec = (AppLogDestinationLogtailSpec) o;
        return Objects.equals(this.token, appLogDestinationLogtailSpec.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppLogDestinationLogtailSpec {\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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