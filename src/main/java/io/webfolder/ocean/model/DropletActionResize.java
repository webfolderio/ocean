package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * DropletActionResize
 */
@JsonPropertyOrder({ DropletActionResize.JSON_PROPERTY_TYPE, DropletActionResize.JSON_PROPERTY_DISK,
        DropletActionResize.JSON_PROPERTY_SIZE })
public class DropletActionResize {
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

    public static final String JSON_PROPERTY_DISK = "disk";
    private Boolean disk;

    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public DropletActionResize() {
    }

    public DropletActionResize type(TypeEnum type) {
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

    public DropletActionResize disk(Boolean disk) {
        this.disk = disk;
        return this;
    }

    /**
     * When &#x60;true&#x60;, the Droplet&#39;s disk will be resized in addition to
     * its RAM and CPU. This is a permanent change and cannot be reversed as a
     * Droplet&#39;s disk size cannot be decreased.
     *
     * @return disk
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDisk() {
        return disk;
    }

    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisk(Boolean disk) {
        this.disk = disk;
    }

    public DropletActionResize size(String size) {
        this.size = size;
        return this;
    }

    /**
     * The slug identifier for the size to which you wish to resize the Droplet.
     *
     * @return size
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Return true if this droplet_action_resize object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionResize dropletActionResize = (DropletActionResize) o;
        return Objects.equals(this.type, dropletActionResize.type)
                && Objects.equals(this.disk, dropletActionResize.disk)
                && Objects.equals(this.size, dropletActionResize.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, disk, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionResize {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
