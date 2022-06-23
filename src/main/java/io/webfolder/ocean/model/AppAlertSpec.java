package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppAlertSpec
 */
@JsonPropertyOrder({ AppAlertSpec.JSON_PROPERTY_RULE, AppAlertSpec.JSON_PROPERTY_DISABLED,
        AppAlertSpec.JSON_PROPERTY_OPERATOR, AppAlertSpec.JSON_PROPERTY_VALUE, AppAlertSpec.JSON_PROPERTY_WINDOW })
public class AppAlertSpec {
    public static final String JSON_PROPERTY_RULE = "rule";
    private AppAlertSpecRule rule = AppAlertSpecRule.UNSPECIFIED_RULE;

    public static final String JSON_PROPERTY_DISABLED = "disabled";
    private Boolean disabled;

    public static final String JSON_PROPERTY_OPERATOR = "operator";
    private AppAlertSpecOperator operator = AppAlertSpecOperator.UNSPECIFIED_OPERATOR;

    public static final String JSON_PROPERTY_VALUE = "value";
    private Float value;

    public static final String JSON_PROPERTY_WINDOW = "window";
    private AppAlertSpecWindow window = AppAlertSpecWindow.UNSPECIFIED_WINDOW;

    public AppAlertSpec() {
    }

    public AppAlertSpec rule(AppAlertSpecRule rule) {
        this.rule = rule;
        return this;
    }

    /**
     * Get rule
     *
     * @return rule
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RULE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppAlertSpecRule getRule() {
        return rule;
    }

    @JsonProperty(JSON_PROPERTY_RULE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRule(AppAlertSpecRule rule) {
        this.rule = rule;
    }

    public AppAlertSpec disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * Is the alert disabled?
     *
     * @return disabled
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDisabled() {
        return disabled;
    }

    @JsonProperty(JSON_PROPERTY_DISABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public AppAlertSpec operator(AppAlertSpecOperator operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get operator
     *
     * @return operator
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OPERATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlertSpecOperator getOperator() {
        return operator;
    }

    @JsonProperty(JSON_PROPERTY_OPERATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOperator(AppAlertSpecOperator operator) {
        this.operator = operator;
    }

    public AppAlertSpec value(Float value) {
        this.value = value;
        return this;
    }

    /**
     * Threshold value for alert
     *
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Float getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValue(Float value) {
        this.value = value;
    }

    public AppAlertSpec window(AppAlertSpecWindow window) {
        this.window = window;
        return this;
    }

    /**
     * Get window
     *
     * @return window
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WINDOW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlertSpecWindow getWindow() {
        return window;
    }

    @JsonProperty(JSON_PROPERTY_WINDOW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWindow(AppAlertSpecWindow window) {
        this.window = window;
    }

    /**
     * Return true if this app_alert_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppAlertSpec appAlertSpec = (AppAlertSpec) o;
        return Objects.equals(this.rule, appAlertSpec.rule) && Objects.equals(this.disabled, appAlertSpec.disabled)
                && Objects.equals(this.operator, appAlertSpec.operator)
                && Objects.equals(this.value, appAlertSpec.value) && Objects.equals(this.window, appAlertSpec.window);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule, disabled, operator, value, window);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppAlertSpec {\n");
        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    window: ").append(toIndentedString(window)).append("\n");
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