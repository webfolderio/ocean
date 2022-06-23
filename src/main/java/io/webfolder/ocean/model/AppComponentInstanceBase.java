package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppComponentInstanceBase
 */
@JsonPropertyOrder({ AppComponentInstanceBase.JSON_PROPERTY_INSTANCE_COUNT,
        AppComponentInstanceBase.JSON_PROPERTY_INSTANCE_SIZE_SLUG })
public class AppComponentInstanceBase {
    public static final String JSON_PROPERTY_INSTANCE_COUNT = "instance_count";
    private Long instanceCount = 1l;

    /**
     * The instance size to use for this component. Default: &#x60;basic-xxs&#x60;
     */
    public enum InstanceSizeSlugEnum {
        BASIC_XXS("basic-xxs"),

        BASIC_XS("basic-xs"),

        BASIC_S("basic-s"),

        BASIC_M("basic-m"),

        PROFESSIONAL_XS("professional-xs"),

        PROFESSIONAL_S("professional-s"),

        PROFESSIONAL_M("professional-m"),

        PROFESSIONAL_1L("professional-1l"),

        PROFESSIONAL_L("professional-l"),

        PROFESSIONAL_XL("professional-xl");

        private String value;

        InstanceSizeSlugEnum(String value) {
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
        public static InstanceSizeSlugEnum fromValue(String value) {
            for (InstanceSizeSlugEnum b : InstanceSizeSlugEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_INSTANCE_SIZE_SLUG = "instance_size_slug";
    private InstanceSizeSlugEnum instanceSizeSlug = InstanceSizeSlugEnum.BASIC_XXS;

    public AppComponentInstanceBase() {
    }

    public AppComponentInstanceBase instanceCount(Long instanceCount) {
        this.instanceCount = instanceCount;
        return this;
    }

    /**
     * The amount of instances that this component should be scaled to. Default: 1
     * minimum: 1
     *
     * @return instanceCount
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INSTANCE_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Long getInstanceCount() {
        return instanceCount;
    }

    @JsonProperty(JSON_PROPERTY_INSTANCE_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInstanceCount(Long instanceCount) {
        this.instanceCount = instanceCount;
    }

    public AppComponentInstanceBase instanceSizeSlug(InstanceSizeSlugEnum instanceSizeSlug) {
        this.instanceSizeSlug = instanceSizeSlug;
        return this;
    }

    /**
     * The instance size to use for this component. Default: &#x60;basic-xxs&#x60;
     *
     * @return instanceSizeSlug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZE_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public InstanceSizeSlugEnum getInstanceSizeSlug() {
        return instanceSizeSlug;
    }

    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZE_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInstanceSizeSlug(InstanceSizeSlugEnum instanceSizeSlug) {
        this.instanceSizeSlug = instanceSizeSlug;
    }

    /**
     * Return true if this app_component_instance_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppComponentInstanceBase appComponentInstanceBase = (AppComponentInstanceBase) o;
        return Objects.equals(this.instanceCount, appComponentInstanceBase.instanceCount)
                && Objects.equals(this.instanceSizeSlug, appComponentInstanceBase.instanceSizeSlug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceCount, instanceSizeSlug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppComponentInstanceBase {\n");
        sb.append("    instanceCount: ").append(toIndentedString(instanceCount)).append("\n");
        sb.append("    instanceSizeSlug: ").append(toIndentedString(instanceSizeSlug)).append("\n");
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