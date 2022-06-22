package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * InstallKubernetesResponse
 */
@JsonPropertyOrder({ InstallKubernetesResponse.JSON_PROPERTY_MESSAGE })
public class InstallKubernetesResponse {
    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public InstallKubernetesResponse() {
    }

    public InstallKubernetesResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * A message about the result of the request.
     *
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessage() {
        return message;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Return true if this install_kubernetes_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstallKubernetesResponse installKubernetesResponse = (InstallKubernetesResponse) o;
        return Objects.equals(this.message, installKubernetesResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstallKubernetesResponse {\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
