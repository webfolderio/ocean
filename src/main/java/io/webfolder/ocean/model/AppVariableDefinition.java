package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppVariableDefinition
 */
@JsonPropertyOrder({ AppVariableDefinition.JSON_PROPERTY_KEY, AppVariableDefinition.JSON_PROPERTY_SCOPE,
        AppVariableDefinition.JSON_PROPERTY_TYPE, AppVariableDefinition.JSON_PROPERTY_VALUE })
public class AppVariableDefinition {
    public static final String JSON_PROPERTY_KEY = "key";
    private String key;

    /**
     * - RUN_TIME: Made available only at run-time - BUILD_TIME: Made available only
     * at build-time - RUN_AND_BUILD_TIME: Made available at both build and run-time
     */
    public enum ScopeEnum {
        UNSET("UNSET"),

        RUN_TIME("RUN_TIME"),

        BUILD_TIME("BUILD_TIME"),

        RUN_AND_BUILD_TIME("RUN_AND_BUILD_TIME");

        private String value;

        ScopeEnum(String value) {
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
        public static ScopeEnum fromValue(String value) {
            for (ScopeEnum b : ScopeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_SCOPE = "scope";
    private ScopeEnum scope = ScopeEnum.RUN_AND_BUILD_TIME;

    /**
     * - GENERAL: A plain-text environment variable - SECRET: A secret encrypted
     * environment variable
     */
    public enum TypeEnum {
        GENERAL("GENERAL"),

        SECRET("SECRET");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type = TypeEnum.GENERAL;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public AppVariableDefinition() {
    }

    public AppVariableDefinition key(String key) {
        this.key = key;
        return this;
    }

    /**
     * The variable name
     *
     * @return key
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getKey() {
        return key;
    }

    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setKey(String key) {
        this.key = key;
    }

    public AppVariableDefinition scope(ScopeEnum scope) {
        this.scope = scope;
        return this;
    }

    /**
     * - RUN_TIME: Made available only at run-time - BUILD_TIME: Made available only
     * at build-time - RUN_AND_BUILD_TIME: Made available at both build and run-time
     *
     * @return scope
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ScopeEnum getScope() {
        return scope;
    }

    @JsonProperty(JSON_PROPERTY_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setScope(ScopeEnum scope) {
        this.scope = scope;
    }

    public AppVariableDefinition type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * - GENERAL: A plain-text environment variable - SECRET: A secret encrypted
     * environment variable
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public AppVariableDefinition value(String value) {
        this.value = value;
        return this;
    }

    /**
     * The value. If the type is &#x60;SECRET&#x60;, the value will be encrypted on
     * first submission. On following submissions, the encrypted value should be
     * used.
     *
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Return true if this app_variable_definition object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppVariableDefinition appVariableDefinition = (AppVariableDefinition) o;
        return Objects.equals(this.key, appVariableDefinition.key)
                && Objects.equals(this.scope, appVariableDefinition.scope)
                && Objects.equals(this.type, appVariableDefinition.type)
                && Objects.equals(this.value, appVariableDefinition.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, scope, type, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppVariableDefinition {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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