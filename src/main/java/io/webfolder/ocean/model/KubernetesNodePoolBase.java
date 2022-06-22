package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * KubernetesNodePoolBase
 */
@JsonPropertyOrder({ KubernetesNodePoolBase.JSON_PROPERTY_ID, KubernetesNodePoolBase.JSON_PROPERTY_NAME,
        KubernetesNodePoolBase.JSON_PROPERTY_COUNT, KubernetesNodePoolBase.JSON_PROPERTY_TAGS,
        KubernetesNodePoolBase.JSON_PROPERTY_LABELS, KubernetesNodePoolBase.JSON_PROPERTY_TAINTS,
        KubernetesNodePoolBase.JSON_PROPERTY_AUTO_SCALE, KubernetesNodePoolBase.JSON_PROPERTY_MIN_NODES,
        KubernetesNodePoolBase.JSON_PROPERTY_MAX_NODES, KubernetesNodePoolBase.JSON_PROPERTY_NODES })
public class KubernetesNodePoolBase {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_COUNT = "count";
    private Integer count;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_LABELS = "labels";
    private Object labels;

    public static final String JSON_PROPERTY_TAINTS = "taints";
    private List<KubernetesNodePoolTaint> taints = null;

    public static final String JSON_PROPERTY_AUTO_SCALE = "auto_scale";
    private Boolean autoScale;

    public static final String JSON_PROPERTY_MIN_NODES = "min_nodes";
    private Integer minNodes;

    public static final String JSON_PROPERTY_MAX_NODES = "max_nodes";
    private Integer maxNodes;

    public static final String JSON_PROPERTY_NODES = "nodes";
    private List<Node> nodes = null;

    public KubernetesNodePoolBase() {
    }

    @JsonCreator
    public KubernetesNodePoolBase(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_NODES) List<Node> nodes) {
        this();
        this.id = id;
        this.nodes = nodes;
    }

    /**
     * A unique ID that can be used to identify and reference a specific node pool.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "cdda885e-7663-40c8-bc74-3a036c66545d", value = "A unique ID that can be used to identify and reference a specific node pool.")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getId() {
        return id;
    }

    public KubernetesNodePoolBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for the node pool.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "frontend-pool", value = "A human-readable name for the node pool.")
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

    public KubernetesNodePoolBase count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * The number of Droplet instances in the node pool.
     *
     * @return count
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "3", value = "The number of Droplet instances in the node pool.")
    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getCount() {
        return count;
    }

    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCount(Integer count) {
        this.count = count;
    }

    public KubernetesNodePoolBase tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public KubernetesNodePoolBase addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array containing the tags applied to the node pool. All node pools are
     * automatically tagged &#x60;k8s&#x60;, &#x60;k8s-worker&#x60;, and
     * &#x60;k8s:$K8S_CLUSTER_ID&#x60;.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "[\"k8s\",\"k8s:bd5f5959-5e1e-4205-a714-a914373942af\",\"k8s-worker\",\"production\",\"web-team\"]", value = "An array containing the tags applied to the node pool. All node pools are automatically tagged `k8s`, `k8s-worker`, and `k8s:$K8S_CLUSTER_ID`.")
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public KubernetesNodePoolBase labels(Object labels) {
        this.labels = labels;
        return this;
    }

    /**
     * An object containing a set of Kubernetes labels. The keys and are values are
     * both user-defined.
     *
     * @return labels
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "An object containing a set of Kubernetes labels. The keys and are values are both user-defined.")
    @JsonProperty(JSON_PROPERTY_LABELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getLabels() {
        return labels;
    }

    @JsonProperty(JSON_PROPERTY_LABELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLabels(Object labels) {
        this.labels = labels;
    }

    public KubernetesNodePoolBase taints(List<KubernetesNodePoolTaint> taints) {
        this.taints = taints;
        return this;
    }

    public KubernetesNodePoolBase addTaintsItem(KubernetesNodePoolTaint taintsItem) {
        if (this.taints == null) {
            this.taints = new ArrayList<>();
        }
        this.taints.add(taintsItem);
        return this;
    }

    /**
     * An array of taints to apply to all nodes in a pool. Taints will automatically
     * be applied to all existing nodes and any subsequent nodes added to the pool.
     * When a taint is removed, it is removed from all nodes in the pool.
     *
     * @return taints
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "An array of taints to apply to all nodes in a pool. Taints will automatically be applied to all existing nodes and any subsequent nodes added to the pool. When a taint is removed, it is removed from all nodes in the pool.")
    @JsonProperty(JSON_PROPERTY_TAINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<KubernetesNodePoolTaint> getTaints() {
        return taints;
    }

    @JsonProperty(JSON_PROPERTY_TAINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTaints(List<KubernetesNodePoolTaint> taints) {
        this.taints = taints;
    }

    public KubernetesNodePoolBase autoScale(Boolean autoScale) {
        this.autoScale = autoScale;
        return this;
    }

    /**
     * A boolean value indicating whether auto-scaling is enabled for this node
     * pool.
     *
     * @return autoScale
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "A boolean value indicating whether auto-scaling is enabled for this node pool.")
    @JsonProperty(JSON_PROPERTY_AUTO_SCALE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAutoScale() {
        return autoScale;
    }

    @JsonProperty(JSON_PROPERTY_AUTO_SCALE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutoScale(Boolean autoScale) {
        this.autoScale = autoScale;
    }

    public KubernetesNodePoolBase minNodes(Integer minNodes) {
        this.minNodes = minNodes;
        return this;
    }

    /**
     * The minimum number of nodes that this node pool can be auto-scaled to. The
     * value will be &#x60;0&#x60; if &#x60;auto_scale&#x60; is set to
     * &#x60;false&#x60;.
     *
     * @return minNodes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "3", value = "The minimum number of nodes that this node pool can be auto-scaled to. The value will be `0` if `auto_scale` is set to `false`.")
    @JsonProperty(JSON_PROPERTY_MIN_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMinNodes() {
        return minNodes;
    }

    @JsonProperty(JSON_PROPERTY_MIN_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMinNodes(Integer minNodes) {
        this.minNodes = minNodes;
    }

    public KubernetesNodePoolBase maxNodes(Integer maxNodes) {
        this.maxNodes = maxNodes;
        return this;
    }

    /**
     * The maximum number of nodes that this node pool can be auto-scaled to. The
     * value will be &#x60;0&#x60; if &#x60;auto_scale&#x60; is set to
     * &#x60;false&#x60;.
     *
     * @return maxNodes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "6", value = "The maximum number of nodes that this node pool can be auto-scaled to. The value will be `0` if `auto_scale` is set to `false`.")
    @JsonProperty(JSON_PROPERTY_MAX_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMaxNodes() {
        return maxNodes;
    }

    @JsonProperty(JSON_PROPERTY_MAX_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaxNodes(Integer maxNodes) {
        this.maxNodes = maxNodes;
    }

    /**
     * An object specifying the details of a specific worker node in a node pool.
     *
     * @return nodes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "An object specifying the details of a specific worker node in a node pool.")
    @JsonProperty(JSON_PROPERTY_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Return true if this kubernetes_node_pool_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesNodePoolBase kubernetesNodePoolBase = (KubernetesNodePoolBase) o;
        return Objects.equals(this.id, kubernetesNodePoolBase.id)
                && Objects.equals(this.name, kubernetesNodePoolBase.name)
                && Objects.equals(this.count, kubernetesNodePoolBase.count)
                && Objects.equals(this.tags, kubernetesNodePoolBase.tags)
                && Objects.equals(this.labels, kubernetesNodePoolBase.labels)
                && Objects.equals(this.taints, kubernetesNodePoolBase.taints)
                && Objects.equals(this.autoScale, kubernetesNodePoolBase.autoScale)
                && Objects.equals(this.minNodes, kubernetesNodePoolBase.minNodes)
                && Objects.equals(this.maxNodes, kubernetesNodePoolBase.maxNodes)
                && Objects.equals(this.nodes, kubernetesNodePoolBase.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count, tags, labels, taints, autoScale, minNodes, maxNodes, nodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesNodePoolBase {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    taints: ").append(toIndentedString(taints)).append("\n");
        sb.append("    autoScale: ").append(toIndentedString(autoScale)).append("\n");
        sb.append("    minNodes: ").append(toIndentedString(minNodes)).append("\n");
        sb.append("    maxNodes: ").append(toIndentedString(maxNodes)).append("\n");
        sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
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
