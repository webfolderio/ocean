package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DataDog configuration.
 */
@JsonPropertyOrder({ AppLogDestinationDatadogSpec.JSON_PROPERTY_ENDPOINT,
        AppLogDestinationDatadogSpec.JSON_PROPERTY_API_KEY })
public class AppLogDestinationDatadogSpec {
    public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
    private String endpoint;

    public static final String JSON_PROPERTY_API_KEY = "api_key";
    private String apiKey;

    public AppLogDestinationDatadogSpec() {
    }

    public AppLogDestinationDatadogSpec endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /**
     * Datadog HTTP log intake endpoint.
     *
     * @return endpoint
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public AppLogDestinationDatadogSpec apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Datadog API key.
     *
     * @return apiKey
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_API_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty(JSON_PROPERTY_API_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Return true if this app_log_destination_datadog_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppLogDestinationDatadogSpec appLogDestinationDatadogSpec = (AppLogDestinationDatadogSpec) o;
        return Objects.equals(this.endpoint, appLogDestinationDatadogSpec.endpoint)
                && Objects.equals(this.apiKey, appLogDestinationDatadogSpec.apiKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoint, apiKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppLogDestinationDatadogSpec {\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
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
