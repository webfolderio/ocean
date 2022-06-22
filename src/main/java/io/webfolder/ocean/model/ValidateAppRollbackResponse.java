package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ValidateAppRollbackResponse
 */
@JsonPropertyOrder({ ValidateAppRollbackResponse.JSON_PROPERTY_VALID, ValidateAppRollbackResponse.JSON_PROPERTY_ERROR,
        ValidateAppRollbackResponse.JSON_PROPERTY_WARNINGS })
public class ValidateAppRollbackResponse {
    public static final String JSON_PROPERTY_VALID = "valid";
    private Boolean valid;

    public static final String JSON_PROPERTY_ERROR = "error";
    private ValidateAppRollbackResponseError error;

    public static final String JSON_PROPERTY_WARNINGS = "warnings";
    private List<AppRollbackValidationCondition> warnings = null;

    public ValidateAppRollbackResponse() {
    }

    public ValidateAppRollbackResponse valid(Boolean valid) {
        this.valid = valid;
        return this;
    }

    /**
     * Indicates whether the app can be rolled back to the specified deployment.
     *
     * @return valid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VALID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getValid() {
        return valid;
    }

    @JsonProperty(JSON_PROPERTY_VALID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public ValidateAppRollbackResponse error(ValidateAppRollbackResponseError error) {
        this.error = error;
        return this;
    }

    /**
     * Get error
     *
     * @return error
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ValidateAppRollbackResponseError getError() {
        return error;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setError(ValidateAppRollbackResponseError error) {
        this.error = error;
    }

    public ValidateAppRollbackResponse warnings(List<AppRollbackValidationCondition> warnings) {
        this.warnings = warnings;
        return this;
    }

    public ValidateAppRollbackResponse addWarningsItem(AppRollbackValidationCondition warningsItem) {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        this.warnings.add(warningsItem);
        return this;
    }

    /**
     * Contains a list of warnings that may cause the rollback to run under unideal
     * circumstances.
     *
     * @return warnings
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WARNINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppRollbackValidationCondition> getWarnings() {
        return warnings;
    }

    @JsonProperty(JSON_PROPERTY_WARNINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWarnings(List<AppRollbackValidationCondition> warnings) {
        this.warnings = warnings;
    }

    /**
     * Return true if this validate_app_rollback_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidateAppRollbackResponse validateAppRollbackResponse = (ValidateAppRollbackResponse) o;
        return Objects.equals(this.valid, validateAppRollbackResponse.valid)
                && Objects.equals(this.error, validateAppRollbackResponse.error)
                && Objects.equals(this.warnings, validateAppRollbackResponse.warnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valid, error, warnings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ValidateAppRollbackResponse {\n");
        sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
