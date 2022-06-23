package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * KubernetesNodePoolTaint
 */
@JsonPropertyOrder({ KubernetesNodePoolTaint.JSON_PROPERTY_KEY, KubernetesNodePoolTaint.JSON_PROPERTY_VALUE,
        KubernetesNodePoolTaint.JSON_PROPERTY_EFFECT })
public class KubernetesNodePoolTaint {
    public static final String JSON_PROPERTY_KEY = "key";
    private String key;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    /**
     * How the node reacts to pods that it won&#39;t tolerate. Available effect
     * values are &#x60;NoSchedule&#x60;, &#x60;PreferNoSchedule&#x60;, and
     * &#x60;NoExecute&#x60;.
     */
    public enum EffectEnum {
        NOSCHEDULE("NoSchedule"),

        PREFERNOSCHEDULE("PreferNoSchedule"),

        NOEXECUTE("NoExecute");

        private String value;

        EffectEnum(String value) {
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
        public static EffectEnum fromValue(String value) {
            for (EffectEnum b : EffectEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_EFFECT = "effect";
    private EffectEnum effect;

    public KubernetesNodePoolTaint() {
    }

    public KubernetesNodePoolTaint key(String key) {
        this.key = key;
        return this;
    }

    /**
     * An arbitrary string. The &#x60;key&#x60; and &#x60;value&#x60; fields of the
     * &#x60;taint&#x60; object form a key-value pair. For example, if the value of
     * the &#x60;key&#x60; field is \&quot;special\&quot; and the value of the
     * &#x60;value&#x60; field is \&quot;gpu\&quot;, the key value pair would be
     * &#x60;special&#x3D;gpu&#x60;.
     *
     * @return key
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getKey() {
        return key;
    }

    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKey(String key) {
        this.key = key;
    }

    public KubernetesNodePoolTaint value(String value) {
        this.value = value;
        return this;
    }

    /**
     * An arbitrary string. The &#x60;key&#x60; and &#x60;value&#x60; fields of the
     * &#x60;taint&#x60; object form a key-value pair. For example, if the value of
     * the &#x60;key&#x60; field is \&quot;special\&quot; and the value of the
     * &#x60;value&#x60; field is \&quot;gpu\&quot;, the key value pair would be
     * &#x60;special&#x3D;gpu&#x60;.
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

    public KubernetesNodePoolTaint effect(EffectEnum effect) {
        this.effect = effect;
        return this;
    }

    /**
     * How the node reacts to pods that it won&#39;t tolerate. Available effect
     * values are &#x60;NoSchedule&#x60;, &#x60;PreferNoSchedule&#x60;, and
     * &#x60;NoExecute&#x60;.
     *
     * @return effect
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EFFECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public EffectEnum getEffect() {
        return effect;
    }

    @JsonProperty(JSON_PROPERTY_EFFECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEffect(EffectEnum effect) {
        this.effect = effect;
    }

    /**
     * Return true if this kubernetes_node_pool_taint object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesNodePoolTaint kubernetesNodePoolTaint = (KubernetesNodePoolTaint) o;
        return Objects.equals(this.key, kubernetesNodePoolTaint.key)
                && Objects.equals(this.value, kubernetesNodePoolTaint.value)
                && Objects.equals(this.effect, kubernetesNodePoolTaint.effect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, effect);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesNodePoolTaint {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    effect: ").append(toIndentedString(effect)).append("\n");
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