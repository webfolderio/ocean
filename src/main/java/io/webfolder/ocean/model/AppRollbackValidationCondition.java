package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppRollbackValidationCondition
 */
@JsonPropertyOrder({ AppRollbackValidationCondition.JSON_PROPERTY_CODE,
        AppRollbackValidationCondition.JSON_PROPERTY_MESSAGE, AppRollbackValidationCondition.JSON_PROPERTY_COMPONENTS })
public class AppRollbackValidationCondition {
    /**
     * A code identifier that represents the failing condition. Failing conditions:
     * - &#x60;incompatible_phase&#x60; - indicates that the deployment&#39;s phase
     * is not suitable for rollback. - &#x60;incompatible_result&#x60; - indicates
     * that the deployment&#39;s result is not suitable for rollback. -
     * &#x60;exceeded_revision_limit&#x60; - indicates that the app has exceeded the
     * rollback revision limits for its tier. - &#x60;app_pinned&#x60; - indicates
     * that there is already a rollback in progress and the app is pinned. -
     * &#x60;database_config_conflict&#x60; - indicates that the deployment&#39;s
     * database config is different than the current config. -
     * &#x60;region_conflict&#x60; - indicates that the deployment&#39;s region
     * differs from the current app region. Warning conditions: -
     * &#x60;static_site_requires_rebuild&#x60; - indicates that the deployment
     * contains at least one static site that will require a rebuild. -
     * &#x60;image_source_missing_digest&#x60; - indicates that the deployment
     * contains at least one component with an image source that is missing a
     * digest.
     */
    public enum CodeEnum {
        INCOMPATIBLE_PHASE("incompatible_phase"),

        INCOMPATIBLE_RESULT("incompatible_result"),

        EXCEEDED_REVISION_LIMIT("exceeded_revision_limit"),

        APP_PINNED("app_pinned"),

        DATABASE_CONFIG_CONFLICT("database_config_conflict"),

        REGION_CONFLICT("region_conflict"),

        STATIC_SITE_REQUIRES_REBUILD("static_site_requires_rebuild"),

        IMAGE_SOURCE_MISSING_DIGEST("image_source_missing_digest");

        private String value;

        CodeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CodeEnum fromValue(String value) {
            for (CodeEnum b : CodeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_CODE = "code";
    private CodeEnum code;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_COMPONENTS = "components";
    private List<String> components = null;

    public AppRollbackValidationCondition() {
    }

    public AppRollbackValidationCondition code(CodeEnum code) {
        this.code = code;
        return this;
    }

    /**
     * A code identifier that represents the failing condition. Failing conditions:
     * - &#x60;incompatible_phase&#x60; - indicates that the deployment&#39;s phase
     * is not suitable for rollback. - &#x60;incompatible_result&#x60; - indicates
     * that the deployment&#39;s result is not suitable for rollback. -
     * &#x60;exceeded_revision_limit&#x60; - indicates that the app has exceeded the
     * rollback revision limits for its tier. - &#x60;app_pinned&#x60; - indicates
     * that there is already a rollback in progress and the app is pinned. -
     * &#x60;database_config_conflict&#x60; - indicates that the deployment&#39;s
     * database config is different than the current config. -
     * &#x60;region_conflict&#x60; - indicates that the deployment&#39;s region
     * differs from the current app region. Warning conditions: -
     * &#x60;static_site_requires_rebuild&#x60; - indicates that the deployment
     * contains at least one static site that will require a rebuild. -
     * &#x60;image_source_missing_digest&#x60; - indicates that the deployment
     * contains at least one component with an image source that is missing a
     * digest.
     *
     * @return code
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public CodeEnum getCode() {
        return code;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCode(CodeEnum code) {
        this.code = code;
    }

    public AppRollbackValidationCondition message(String message) {
        this.message = message;
        return this;
    }

    /**
     * A human-readable message describing the failing condition.
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

    public AppRollbackValidationCondition components(List<String> components) {
        this.components = components;
        return this;
    }

    public AppRollbackValidationCondition addComponentsItem(String componentsItem) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(componentsItem);
        return this;
    }

    /**
     * Get components
     *
     * @return components
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPONENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getComponents() {
        return components;
    }

    @JsonProperty(JSON_PROPERTY_COMPONENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setComponents(List<String> components) {
        this.components = components;
    }

    /**
     * Return true if this app_rollback_validation_condition object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppRollbackValidationCondition appRollbackValidationCondition = (AppRollbackValidationCondition) o;
        return Objects.equals(this.code, appRollbackValidationCondition.code)
                && Objects.equals(this.message, appRollbackValidationCondition.message)
                && Objects.equals(this.components, appRollbackValidationCondition.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, components);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppRollbackValidationCondition {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    components: ").append(toIndentedString(components)).append("\n");
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