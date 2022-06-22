package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * KubernetesNodePoolSize
 */
@JsonPropertyOrder({ KubernetesNodePoolSize.JSON_PROPERTY_SIZE })
public class KubernetesNodePoolSize {
    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public KubernetesNodePoolSize() {
    }

    public KubernetesNodePoolSize size(String size) {
        this.size = size;
        return this;
    }

    /**
     * The slug identifier for the type of Droplet used as workers in the node pool.
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
     * Return true if this kubernetes_node_pool_size object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesNodePoolSize kubernetesNodePoolSize = (KubernetesNodePoolSize) o;
        return Objects.equals(this.size, kubernetesNodePoolSize.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesNodePoolSize {\n");
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
