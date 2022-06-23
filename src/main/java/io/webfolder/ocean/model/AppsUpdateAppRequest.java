package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsUpdateAppRequest
 */
@JsonPropertyOrder({ AppsUpdateAppRequest.JSON_PROPERTY_SPEC })
public class AppsUpdateAppRequest {
    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppSpec spec;

    public AppsUpdateAppRequest() {
    }

    public AppsUpdateAppRequest spec(AppSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public AppSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSpec(AppSpec spec) {
        this.spec = spec;
    }

    /**
     * Return true if this apps_update_app_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsUpdateAppRequest appsUpdateAppRequest = (AppsUpdateAppRequest) o;
        return Objects.equals(this.spec, appsUpdateAppRequest.spec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spec);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsUpdateAppRequest {\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
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