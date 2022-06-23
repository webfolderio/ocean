package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ClusterlintResults
 */
@JsonPropertyOrder({ ClusterlintResults.JSON_PROPERTY_RUN_ID, ClusterlintResults.JSON_PROPERTY_REQUESTED_AT,
        ClusterlintResults.JSON_PROPERTY_COMPLETED_AT, ClusterlintResults.JSON_PROPERTY_DIAGNOSTICS })
public class ClusterlintResults {
    public static final String JSON_PROPERTY_RUN_ID = "run_id";
    private String runId;

    public static final String JSON_PROPERTY_REQUESTED_AT = "requested_at";
    private OffsetDateTime requestedAt;

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";
    private OffsetDateTime completedAt;

    public static final String JSON_PROPERTY_DIAGNOSTICS = "diagnostics";
    private List<ClusterlintResultsDiagnosticsInner> diagnostics = null;

    public ClusterlintResults() {
    }

    public ClusterlintResults runId(String runId) {
        this.runId = runId;
        return this;
    }

    /**
     * Id of the clusterlint run that can be used later to fetch the diagnostics.
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

    public ClusterlintResults requestedAt(OffsetDateTime requestedAt) {
        this.requestedAt = requestedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the schedule clusterlint run request was made.
     *
     * @return requestedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REQUESTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getRequestedAt() {
        return requestedAt;
    }

    @JsonProperty(JSON_PROPERTY_REQUESTED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRequestedAt(OffsetDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public ClusterlintResults completedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the schedule clusterlint run request was completed.
     *
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public ClusterlintResults diagnostics(List<ClusterlintResultsDiagnosticsInner> diagnostics) {
        this.diagnostics = diagnostics;
        return this;
    }

    public ClusterlintResults addDiagnosticsItem(ClusterlintResultsDiagnosticsInner diagnosticsItem) {
        if (this.diagnostics == null) {
            this.diagnostics = new ArrayList<>();
        }
        this.diagnostics.add(diagnosticsItem);
        return this;
    }

    /**
     * An array of diagnostics reporting potential problems for the given cluster.
     *
     * @return diagnostics
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DIAGNOSTICS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ClusterlintResultsDiagnosticsInner> getDiagnostics() {
        return diagnostics;
    }

    @JsonProperty(JSON_PROPERTY_DIAGNOSTICS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDiagnostics(List<ClusterlintResultsDiagnosticsInner> diagnostics) {
        this.diagnostics = diagnostics;
    }

    /**
     * Return true if this clusterlint_results object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterlintResults clusterlintResults = (ClusterlintResults) o;
        return Objects.equals(this.runId, clusterlintResults.runId)
                && Objects.equals(this.requestedAt, clusterlintResults.requestedAt)
                && Objects.equals(this.completedAt, clusterlintResults.completedAt)
                && Objects.equals(this.diagnostics, clusterlintResults.diagnostics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runId, requestedAt, completedAt, diagnostics);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterlintResults {\n");
        sb.append("    runId: ").append(toIndentedString(runId)).append("\n");
        sb.append("    requestedAt: ").append(toIndentedString(requestedAt)).append("\n");
        sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
        sb.append("    diagnostics: ").append(toIndentedString(diagnostics)).append("\n");
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