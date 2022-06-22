package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * DropletActionRename
 */
@JsonPropertyOrder({ DropletActionRename.JSON_PROPERTY_TYPE, DropletActionRename.JSON_PROPERTY_NAME })
public class DropletActionRename {
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

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public DropletActionRename() {
    }

    public DropletActionRename type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of action to initiate for the Droplet.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "reboot", required = true, value = "The type of action to initiate for the Droplet.")
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

    public DropletActionRename name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The new name for the Droplet.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "nifty-new-name", value = "The new name for the Droplet.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true if this droplet_action_rename object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionRename dropletActionRename = (DropletActionRename) o;
        return Objects.equals(this.type, dropletActionRename.type)
                && Objects.equals(this.name, dropletActionRename.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionRename {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
