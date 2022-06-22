package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDropletKernelsResponseAllOf
 */
@JsonPropertyOrder({ ListDropletKernelsResponseAllOf.JSON_PROPERTY_KERNELS })
public class ListDropletKernelsResponseAllOf {
    public static final String JSON_PROPERTY_KERNELS = "kernels";
    private List<Kernel> kernels = null;

    public ListDropletKernelsResponseAllOf() {
    }

    public ListDropletKernelsResponseAllOf kernels(List<Kernel> kernels) {
        this.kernels = kernels;
        return this;
    }

    public ListDropletKernelsResponseAllOf addKernelsItem(Kernel kernelsItem) {
        if (this.kernels == null) {
            this.kernels = new ArrayList<>();
        }
        this.kernels.add(kernelsItem);
        return this;
    }

    /**
     * Get kernels
     *
     * @return kernels
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KERNELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Kernel> getKernels() {
        return kernels;
    }

    @JsonProperty(JSON_PROPERTY_KERNELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKernels(List<Kernel> kernels) {
        this.kernels = kernels;
    }

    /**
     * Return true if this list_droplet_kernels_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletKernelsResponseAllOf listDropletKernelsResponseAllOf = (ListDropletKernelsResponseAllOf) o;
        return Objects.equals(this.kernels, listDropletKernelsResponseAllOf.kernels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kernels);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletKernelsResponseAllOf {\n");
        sb.append("    kernels: ").append(toIndentedString(kernels)).append("\n");
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
