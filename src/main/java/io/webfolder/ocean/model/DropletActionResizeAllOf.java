package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletActionResizeAllOf
 */
@JsonPropertyOrder({ DropletActionResizeAllOf.JSON_PROPERTY_DISK, DropletActionResizeAllOf.JSON_PROPERTY_SIZE })
public class DropletActionResizeAllOf {
    public static final String JSON_PROPERTY_DISK = "disk";
    private Boolean disk;

    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public DropletActionResizeAllOf() {
    }

    public DropletActionResizeAllOf disk(Boolean disk) {
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

    public DropletActionResizeAllOf size(String size) {
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
     * Return true if this droplet_action_resize_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionResizeAllOf dropletActionResizeAllOf = (DropletActionResizeAllOf) o;
        return Objects.equals(this.disk, dropletActionResizeAllOf.disk)
                && Objects.equals(this.size, dropletActionResizeAllOf.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disk, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionResizeAllOf {\n");
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