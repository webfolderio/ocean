package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsGetInstanceSizeResponse
 */
@JsonPropertyOrder({ AppsGetInstanceSizeResponse.JSON_PROPERTY_INSTANCE_SIZE })
public class AppsGetInstanceSizeResponse {
    public static final String JSON_PROPERTY_INSTANCE_SIZE = "instance_size";
    private AppsInstanceSize instanceSize;

    public AppsGetInstanceSizeResponse() {
    }

    public AppsGetInstanceSizeResponse instanceSize(AppsInstanceSize instanceSize) {
        this.instanceSize = instanceSize;
        return this;
    }

    /**
     * Get instanceSize
     *
     * @return instanceSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppsInstanceSize getInstanceSize() {
        return instanceSize;
    }

    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInstanceSize(AppsInstanceSize instanceSize) {
        this.instanceSize = instanceSize;
    }

    /**
     * Return true if this apps_get_instance_size_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsGetInstanceSizeResponse appsGetInstanceSizeResponse = (AppsGetInstanceSizeResponse) o;
        return Objects.equals(this.instanceSize, appsGetInstanceSizeResponse.instanceSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsGetInstanceSizeResponse {\n");
        sb.append("    instanceSize: ").append(toIndentedString(instanceSize)).append("\n");
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