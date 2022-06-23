package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * DropletActionChangeKernel
 */
@JsonPropertyOrder({ DropletActionChangeKernel.JSON_PROPERTY_TYPE, DropletActionChangeKernel.JSON_PROPERTY_KERNEL })
public class DropletActionChangeKernel {
    /**
     * The type of action to initiate for the Droplet.
     */
    public enum TypeEnum {
        ENABLE_BACKUPS("enable_backups"),

        DISABLE_BACKUPS("disable_backups"),

        REBOOT("reboot"),

        POWER_CYCLE("power_cycle"),

        SHUTDOWN("shutdown"),

        POWER_OFF("power_off"),

        POWER_ON("power_on"),

        RESTORE("restore"),

        PASSWORD_RESET("password_reset"),

        RESIZE("resize"),

        REBUILD("rebuild"),

        RENAME("rename"),

        CHANGE_KERNEL("change_kernel"),

        ENABLE_IPV6("enable_ipv6"),

        SNAPSHOT("snapshot");

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
    private TypeEnum type;

    public static final String JSON_PROPERTY_KERNEL = "kernel";
    private Integer kernel;

    public DropletActionChangeKernel() {
    }

    public DropletActionChangeKernel type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of action to initiate for the Droplet.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public DropletActionChangeKernel kernel(Integer kernel) {
        this.kernel = kernel;
        return this;
    }

    /**
     * A unique number used to identify and reference a specific kernel.
     *
     * @return kernel
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KERNEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getKernel() {
        return kernel;
    }

    @JsonProperty(JSON_PROPERTY_KERNEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKernel(Integer kernel) {
        this.kernel = kernel;
    }

    /**
     * Return true if this droplet_action_change_kernel object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionChangeKernel dropletActionChangeKernel = (DropletActionChangeKernel) o;
        return Objects.equals(this.type, dropletActionChangeKernel.type)
                && Objects.equals(this.kernel, dropletActionChangeKernel.kernel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, kernel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionChangeKernel {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    kernel: ").append(toIndentedString(kernel)).append("\n");
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