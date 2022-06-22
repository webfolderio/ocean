package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ClusterlintResultsDiagnosticsInner
 */
@JsonPropertyOrder({ ClusterlintResultsDiagnosticsInner.JSON_PROPERTY_CHECK_NAME,
        ClusterlintResultsDiagnosticsInner.JSON_PROPERTY_SEVERITY,
        ClusterlintResultsDiagnosticsInner.JSON_PROPERTY_MESSAGE,
        ClusterlintResultsDiagnosticsInner.JSON_PROPERTY_OBJECT })
public class ClusterlintResultsDiagnosticsInner {
    public static final String JSON_PROPERTY_CHECK_NAME = "check_name";
    private String checkName;

    public static final String JSON_PROPERTY_SEVERITY = "severity";
    private String severity;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_OBJECT = "object";
    private ClusterlintResultsDiagnosticsInnerObject _object;

    public ClusterlintResultsDiagnosticsInner() {
    }

    public ClusterlintResultsDiagnosticsInner checkName(String checkName) {
        this.checkName = checkName;
        return this;
    }

    /**
     * The clusterlint check that resulted in the diagnostic.
     *
     * @return checkName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CHECK_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCheckName() {
        return checkName;
    }

    @JsonProperty(JSON_PROPERTY_CHECK_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public ClusterlintResultsDiagnosticsInner severity(String severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Can be one of error, warning or suggestion.
     *
     * @return severity
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEVERITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSeverity() {
        return severity;
    }

    @JsonProperty(JSON_PROPERTY_SEVERITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public ClusterlintResultsDiagnosticsInner message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Feedback about the object for users to fix.
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

    public ClusterlintResultsDiagnosticsInner _object(ClusterlintResultsDiagnosticsInnerObject _object) {
        this._object = _object;
        return this;
    }

    /**
     * Get _object
     *
     * @return _object
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OBJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ClusterlintResultsDiagnosticsInnerObject getObject() {
        return _object;
    }

    @JsonProperty(JSON_PROPERTY_OBJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setObject(ClusterlintResultsDiagnosticsInnerObject _object) {
        this._object = _object;
    }

    /**
     * Return true if this clusterlint_results_diagnostics_inner object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterlintResultsDiagnosticsInner clusterlintResultsDiagnosticsInner = (ClusterlintResultsDiagnosticsInner) o;
        return Objects.equals(this.checkName, clusterlintResultsDiagnosticsInner.checkName)
                && Objects.equals(this.severity, clusterlintResultsDiagnosticsInner.severity)
                && Objects.equals(this.message, clusterlintResultsDiagnosticsInner.message)
                && Objects.equals(this._object, clusterlintResultsDiagnosticsInner._object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkName, severity, message, _object);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterlintResultsDiagnosticsInner {\n");
        sb.append("    checkName: ").append(toIndentedString(checkName)).append("\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
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
