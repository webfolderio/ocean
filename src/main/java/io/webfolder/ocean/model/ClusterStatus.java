package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object containing a &#x60;state&#x60; attribute whose value is set to a
 * string indicating the current status of the cluster.
 */
@JsonPropertyOrder({ ClusterStatus.JSON_PROPERTY_STATE, ClusterStatus.JSON_PROPERTY_MESSAGE })
public class ClusterStatus {
    /**
     * A string indicating the current status of the cluster.
     */
    public enum StateEnum {
        RUNNING("running"),

        PROVISIONING("provisioning"),

        DEGRADED("degraded"),

        ERROR("error"),

        DELETED("deleted"),

        UPGRADING("upgrading"),

        DELETING("deleting");

        private String value;

        StateEnum(String value) {
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
        public static StateEnum fromValue(String value) {
            for (StateEnum b : StateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATE = "state";
    private StateEnum state;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public ClusterStatus() {
    }

    public ClusterStatus state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * A string indicating the current status of the cluster.
     *
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(StateEnum state) {
        this.state = state;
    }

    public ClusterStatus message(String message) {
        this.message = message;
        return this;
    }

    /**
     * An optional message providing additional information about the current
     * cluster state.
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

    /**
     * Return true if this cluster_status object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterStatus clusterStatus = (ClusterStatus) o;
        return Objects.equals(this.state, clusterStatus.state) && Objects.equals(this.message, clusterStatus.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterStatus {\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
