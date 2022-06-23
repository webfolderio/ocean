package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * EvictionPolicy
 */
@JsonPropertyOrder({ EvictionPolicy.JSON_PROPERTY_EVICTION_POLICY })
public class EvictionPolicy {
    /**
     * A string specifying the desired eviction policy for the Redis cluster.
     */
    public enum EvictionPolicyEnum {
        NOEVICTION("noeviction"),

        ALLKEYS_LRU("allkeys_lru"),

        ALLKEYS_RANDOM("allkeys_random"),

        VOLATILE_LRU("volatile_lru"),

        VOLATILE_RANDOM("volatile_random"),

        VOLATILE_TTL("volatile_ttl");

        private String value;

        EvictionPolicyEnum(String value) {
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
        public static EvictionPolicyEnum fromValue(String value) {
            for (EvictionPolicyEnum b : EvictionPolicyEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_EVICTION_POLICY = "eviction_policy";
    private EvictionPolicyEnum evictionPolicy;

    public EvictionPolicy() {
    }

    public EvictionPolicy evictionPolicy(EvictionPolicyEnum evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
        return this;
    }

    /**
     * A string specifying the desired eviction policy for the Redis cluster.
     *
     * @return evictionPolicy
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EVICTION_POLICY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public EvictionPolicyEnum getEvictionPolicy() {
        return evictionPolicy;
    }

    @JsonProperty(JSON_PROPERTY_EVICTION_POLICY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEvictionPolicy(EvictionPolicyEnum evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    /**
     * Return true if this eviction_policy object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EvictionPolicy evictionPolicy = (EvictionPolicy) o;
        return Objects.equals(this.evictionPolicy, evictionPolicy.evictionPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evictionPolicy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EvictionPolicy {\n");
        sb.append("    evictionPolicy: ").append(toIndentedString(evictionPolicy)).append("\n");
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