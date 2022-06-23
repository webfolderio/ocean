package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletActionChangeKernelAllOf
 */
@JsonPropertyOrder({ DropletActionChangeKernelAllOf.JSON_PROPERTY_KERNEL })
public class DropletActionChangeKernelAllOf {
    public static final String JSON_PROPERTY_KERNEL = "kernel";
    private Integer kernel;

    public DropletActionChangeKernelAllOf() {
    }

    public DropletActionChangeKernelAllOf kernel(Integer kernel) {
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
     * Return true if this droplet_action_change_kernel_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletActionChangeKernelAllOf dropletActionChangeKernelAllOf = (DropletActionChangeKernelAllOf) o;
        return Objects.equals(this.kernel, dropletActionChangeKernelAllOf.kernel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kernel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletActionChangeKernelAllOf {\n");
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