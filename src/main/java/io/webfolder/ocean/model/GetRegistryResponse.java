package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * GetRegistryResponse
 */
@JsonPropertyOrder({ GetRegistryResponse.JSON_PROPERTY_REGISTRY })
public class GetRegistryResponse {
    public static final String JSON_PROPERTY_REGISTRY = "registry";
    private Registry registry;

    public GetRegistryResponse() {
    }

    public GetRegistryResponse registry(Registry registry) {
        this.registry = registry;
        return this;
    }

    /**
     * Get registry
     *
     * @return registry
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGISTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Registry getRegistry() {
        return registry;
    }

    @JsonProperty(JSON_PROPERTY_REGISTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    /**
     * Return true if this get_registry_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetRegistryResponse getRegistryResponse = (GetRegistryResponse) o;
        return Objects.equals(this.registry, getRegistryResponse.registry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetRegistryResponse {\n");
        sb.append("    registry: ").append(toIndentedString(registry)).append("\n");
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
