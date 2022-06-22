package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RunClusterlintResponse
 */
@JsonPropertyOrder({ RunClusterlintResponse.JSON_PROPERTY_RUN_ID })
public class RunClusterlintResponse {
    public static final String JSON_PROPERTY_RUN_ID = "run_id";
    private String runId;

    public RunClusterlintResponse() {
    }

    public RunClusterlintResponse runId(String runId) {
        this.runId = runId;
        return this;
    }

    /**
     * ID of the clusterlint run that can be used later to fetch the diagnostics.
     *
     * @return runId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RUN_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRunId() {
        return runId;
    }

    @JsonProperty(JSON_PROPERTY_RUN_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRunId(String runId) {
        this.runId = runId;
    }

    /**
     * Return true if this run_clusterlint_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RunClusterlintResponse runClusterlintResponse = (RunClusterlintResponse) o;
        return Objects.equals(this.runId, runClusterlintResponse.runId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RunClusterlintResponse {\n");
        sb.append("    runId: ").append(toIndentedString(runId)).append("\n");
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
