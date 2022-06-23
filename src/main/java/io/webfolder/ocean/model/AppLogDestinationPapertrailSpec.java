package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Papertrail configuration.
 */
@JsonPropertyOrder({ AppLogDestinationPapertrailSpec.JSON_PROPERTY_ENDPOINT })
public class AppLogDestinationPapertrailSpec {
    public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
    private String endpoint;

    public AppLogDestinationPapertrailSpec() {
    }

    public AppLogDestinationPapertrailSpec endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Papertrail syslog endpoint.
     *
     * @return endpoint
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Return true if this app_log_destination_papertrail_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppLogDestinationPapertrailSpec appLogDestinationPapertrailSpec = (AppLogDestinationPapertrailSpec) o;
        return Objects.equals(this.endpoint, appLogDestinationPapertrailSpec.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppLogDestinationPapertrailSpec {\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
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