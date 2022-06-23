package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Cluster
 */
@JsonPropertyOrder({ Cluster.JSON_PROPERTY_ID, Cluster.JSON_PROPERTY_NAME, Cluster.JSON_PROPERTY_REGION,
        Cluster.JSON_PROPERTY_VERSION, Cluster.JSON_PROPERTY_CLUSTER_SUBNET, Cluster.JSON_PROPERTY_SERVICE_SUBNET,
        Cluster.JSON_PROPERTY_VPC_UUID, Cluster.JSON_PROPERTY_IPV4, Cluster.JSON_PROPERTY_ENDPOINT,
        Cluster.JSON_PROPERTY_TAGS, Cluster.JSON_PROPERTY_NODE_POOLS, Cluster.JSON_PROPERTY_MAINTENANCE_POLICY,
        Cluster.JSON_PROPERTY_AUTO_UPGRADE, Cluster.JSON_PROPERTY_STATUS, Cluster.JSON_PROPERTY_CREATED_AT,
        Cluster.JSON_PROPERTY_UPDATED_AT, Cluster.JSON_PROPERTY_SURGE_UPGRADE, Cluster.JSON_PROPERTY_HA,
        Cluster.JSON_PROPERTY_REGISTRY_ENABLED })
public class Cluster {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public static final String JSON_PROPERTY_CLUSTER_SUBNET = "cluster_subnet";
    private String clusterSubnet;

    public static final String JSON_PROPERTY_SERVICE_SUBNET = "service_subnet";
    private String serviceSubnet;

    public static final String JSON_PROPERTY_VPC_UUID = "vpc_uuid";
    private UUID vpcUuid;

    public static final String JSON_PROPERTY_IPV4 = "ipv4";
    private String ipv4;

    public static final String JSON_PROPERTY_ENDPOINT = "endpoint";
    private String endpoint;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_NODE_POOLS = "node_pools";
    private List<KubernetesNodePool> nodePools = new ArrayList<>();

    public static final String JSON_PROPERTY_MAINTENANCE_POLICY = "maintenance_policy";
    private MaintenancePolicy maintenancePolicy;

    public static final String JSON_PROPERTY_AUTO_UPGRADE = "auto_upgrade";
    private Boolean autoUpgrade = false;

    public static final String JSON_PROPERTY_STATUS = "status";
    private ClusterStatus status;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_SURGE_UPGRADE = "surge_upgrade";
    private Boolean surgeUpgrade = false;

    public static final String JSON_PROPERTY_HA = "ha";
    private Boolean ha = false;

    public static final String JSON_PROPERTY_REGISTRY_ENABLED = "registry_enabled";
    private Boolean registryEnabled;

    public Cluster() {
    }

    @JsonCreator
    public Cluster(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_CLUSTER_SUBNET) String clusterSubnet,
            @JsonProperty(JSON_PROPERTY_SERVICE_SUBNET) String serviceSubnet,
            @JsonProperty(JSON_PROPERTY_IPV4) String ipv4, @JsonProperty(JSON_PROPERTY_ENDPOINT) String endpoint,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_UPDATED_AT) OffsetDateTime updatedAt,
            @JsonProperty(JSON_PROPERTY_REGISTRY_ENABLED) Boolean registryEnabled) {
        this();
        this.id = id;
        this.clusterSubnet = clusterSubnet;
        this.serviceSubnet = serviceSubnet;
        this.ipv4 = ipv4;
        this.endpoint = endpoint;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.registryEnabled = registryEnabled;
    }

    /**
     * A unique ID that can be used to identify and reference a Kubernetes cluster.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    public Cluster name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for a Kubernetes cluster.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public Cluster region(String region) {
        this.region = region;
        return this;
    }

    /**
     * The slug identifier for the region where the Kubernetes cluster is located.
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(String region) {
        this.region = region;
    }

    public Cluster version(String version) {
        this.version = version;
        return this;
    }

    /**
     * The slug identifier for the version of Kubernetes used for the cluster. If
     * set to a minor version (e.g. \&quot;1.14\&quot;), the latest version within
     * it will be used (e.g. \&quot;1.14.6-do.1\&quot;); if set to
     * \&quot;latest\&quot;, the latest published version will be used. See the
     * &#x60;/v2/kubernetes/options&#x60; endpoint to find all currently available
     * versions.
     *
     * @return version
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * The range of IP addresses in the overlay network of the Kubernetes cluster in
     * CIDR notation.
     *
     * @return clusterSubnet
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLUSTER_SUBNET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getClusterSubnet() {
        return clusterSubnet;
    }

    /**
     * The range of assignable IP addresses for services running in the Kubernetes
     * cluster in CIDR notation.
     *
     * @return serviceSubnet
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVICE_SUBNET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getServiceSubnet() {
        return serviceSubnet;
    }

    public Cluster vpcUuid(UUID vpcUuid) {
        this.vpcUuid = vpcUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the Kubernetes cluster is
     * assigned.
     *
     * @return vpcUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getVpcUuid() {
        return vpcUuid;
    }

    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpcUuid(UUID vpcUuid) {
        this.vpcUuid = vpcUuid;
    }

    /**
     * The public IPv4 address of the Kubernetes master node. This will not be set
     * if high availability is configured on the cluster (v1.21+)
     *
     * @return ipv4
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IPV4)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIpv4() {
        return ipv4;
    }

    /**
     * The base URL of the API server on the Kubernetes master node.
     *
     * @return endpoint
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENDPOINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEndpoint() {
        return endpoint;
    }

    public Cluster tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Cluster addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of tags applied to the Kubernetes cluster. All clusters are
     * automatically tagged &#x60;k8s&#x60; and &#x60;k8s:$K8S_CLUSTER_ID&#x60;.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
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

    public Cluster nodePools(List<KubernetesNodePool> nodePools) {
        this.nodePools = nodePools;
        return this;
    }

    public Cluster addNodePoolsItem(KubernetesNodePool nodePoolsItem) {
        this.nodePools.add(nodePoolsItem);
        return this;
    }

    /**
     * An object specifying the details of the worker nodes available to the
     * Kubernetes cluster.
     *
     * @return nodePools
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NODE_POOLS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<KubernetesNodePool> getNodePools() {
        return nodePools;
    }

    @JsonProperty(JSON_PROPERTY_NODE_POOLS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNodePools(List<KubernetesNodePool> nodePools) {
        this.nodePools = nodePools;
    }

    public Cluster maintenancePolicy(MaintenancePolicy maintenancePolicy) {
        this.maintenancePolicy = maintenancePolicy;
        return this;
    }

    /**
     * Get maintenancePolicy
     *
     * @return maintenancePolicy
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MaintenancePolicy getMaintenancePolicy() {
        return maintenancePolicy;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_POLICY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenancePolicy(MaintenancePolicy maintenancePolicy) {
        this.maintenancePolicy = maintenancePolicy;
    }

    public Cluster autoUpgrade(Boolean autoUpgrade) {
        this.autoUpgrade = autoUpgrade;
        return this;
    }

    /**
     * A boolean value indicating whether the cluster will be automatically upgraded
     * to new patch releases during its maintenance window.
     *
     * @return autoUpgrade
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTO_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getAutoUpgrade() {
        return autoUpgrade;
    }

    @JsonProperty(JSON_PROPERTY_AUTO_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAutoUpgrade(Boolean autoUpgrade) {
        this.autoUpgrade = autoUpgrade;
    }

    public Cluster status(ClusterStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ClusterStatus getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(ClusterStatus status) {
        this.status = status;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the Kubernetes cluster was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the Kubernetes cluster was last updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Cluster surgeUpgrade(Boolean surgeUpgrade) {
        this.surgeUpgrade = surgeUpgrade;
        return this;
    }

    /**
     * A boolean value indicating whether surge upgrade is enabled/disabled for the
     * cluster. Surge upgrade makes cluster upgrades fast and reliable by bringing
     * up new nodes before destroying the outdated nodes.
     *
     * @return surgeUpgrade
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SURGE_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSurgeUpgrade() {
        return surgeUpgrade;
    }

    @JsonProperty(JSON_PROPERTY_SURGE_UPGRADE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSurgeUpgrade(Boolean surgeUpgrade) {
        this.surgeUpgrade = surgeUpgrade;
    }

    public Cluster ha(Boolean ha) {
        this.ha = ha;
        return this;
    }

    /**
     * A boolean value indicating whether the control plane is run in a highly
     * available configuration in the cluster. Highly available control planes incur
     * less downtime.
     *
     * @return ha
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getHa() {
        return ha;
    }

    @JsonProperty(JSON_PROPERTY_HA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHa(Boolean ha) {
        this.ha = ha;
    }

    /**
     * A read-only boolean value indicating if a container registry is integrated
     * with the cluster.
     *
     * @return registryEnabled
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGISTRY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRegistryEnabled() {
        return registryEnabled;
    }

    /**
     * Return true if this cluster object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cluster cluster = (Cluster) o;
        return Objects.equals(this.id, cluster.id) && Objects.equals(this.name, cluster.name)
                && Objects.equals(this.region, cluster.region) && Objects.equals(this.version, cluster.version)
                && Objects.equals(this.clusterSubnet, cluster.clusterSubnet)
                && Objects.equals(this.serviceSubnet, cluster.serviceSubnet)
                && Objects.equals(this.vpcUuid, cluster.vpcUuid) && Objects.equals(this.ipv4, cluster.ipv4)
                && Objects.equals(this.endpoint, cluster.endpoint) && Objects.equals(this.tags, cluster.tags)
                && Objects.equals(this.nodePools, cluster.nodePools)
                && Objects.equals(this.maintenancePolicy, cluster.maintenancePolicy)
                && Objects.equals(this.autoUpgrade, cluster.autoUpgrade) && Objects.equals(this.status, cluster.status)
                && Objects.equals(this.createdAt, cluster.createdAt)
                && Objects.equals(this.updatedAt, cluster.updatedAt)
                && Objects.equals(this.surgeUpgrade, cluster.surgeUpgrade) && Objects.equals(this.ha, cluster.ha)
                && Objects.equals(this.registryEnabled, cluster.registryEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, version, clusterSubnet, serviceSubnet, vpcUuid, ipv4, endpoint, tags,
                nodePools, maintenancePolicy, autoUpgrade, status, createdAt, updatedAt, surgeUpgrade, ha,
                registryEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cluster {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    clusterSubnet: ").append(toIndentedString(clusterSubnet)).append("\n");
        sb.append("    serviceSubnet: ").append(toIndentedString(serviceSubnet)).append("\n");
        sb.append("    vpcUuid: ").append(toIndentedString(vpcUuid)).append("\n");
        sb.append("    ipv4: ").append(toIndentedString(ipv4)).append("\n");
        sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    nodePools: ").append(toIndentedString(nodePools)).append("\n");
        sb.append("    maintenancePolicy: ").append(toIndentedString(maintenancePolicy)).append("\n");
        sb.append("    autoUpgrade: ").append(toIndentedString(autoUpgrade)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    surgeUpgrade: ").append(toIndentedString(surgeUpgrade)).append("\n");
        sb.append("    ha: ").append(toIndentedString(ha)).append("\n");
        sb.append("    registryEnabled: ").append(toIndentedString(registryEnabled)).append("\n");
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