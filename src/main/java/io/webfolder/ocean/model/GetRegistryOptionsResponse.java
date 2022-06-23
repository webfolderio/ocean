package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetRegistryOptionsResponse
 */
@JsonPropertyOrder({ GetRegistryOptionsResponse.JSON_PROPERTY_OPTIONS })
public class GetRegistryOptionsResponse {
    public static final String JSON_PROPERTY_OPTIONS = "options";
    private GetRegistryOptionsResponseOptions options;

    public GetRegistryOptionsResponse() {
    }

    public GetRegistryOptionsResponse options(GetRegistryOptionsResponseOptions options) {
        this.options = options;
        return this;
    }

    /**
     * Get options
     *
     * @return options
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OPTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public GetRegistryOptionsResponseOptions getOptions() {
        return options;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOptions(GetRegistryOptionsResponseOptions options) {
        this.options = options;
    }

    /**
     * Return true if this get_registry_options_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRegistryOptionsResponse getRegistryOptionsResponse = (GetRegistryOptionsResponse) o;
        return Objects.equals(this.options, getRegistryOptionsResponse.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRegistryOptionsResponse {\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
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