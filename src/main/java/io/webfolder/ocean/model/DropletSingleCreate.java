package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DropletSingleCreate
 */
@JsonPropertyOrder({ DropletSingleCreate.JSON_PROPERTY_NAME, DropletSingleCreate.JSON_PROPERTY_REGION,
        DropletSingleCreate.JSON_PROPERTY_SIZE, DropletSingleCreate.JSON_PROPERTY_IMAGE,
        DropletSingleCreate.JSON_PROPERTY_SSH_KEYS, DropletSingleCreate.JSON_PROPERTY_BACKUPS,
        DropletSingleCreate.JSON_PROPERTY_IPV6, DropletSingleCreate.JSON_PROPERTY_MONITORING,
        DropletSingleCreate.JSON_PROPERTY_TAGS, DropletSingleCreate.JSON_PROPERTY_USER_DATA,
        DropletSingleCreate.JSON_PROPERTY_PRIVATE_NETWORKING, DropletSingleCreate.JSON_PROPERTY_VPC_UUID,
        DropletSingleCreate.JSON_PROPERTY_WITH_DROPLET_AGENT })
public class DropletSingleCreate {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public static final String JSON_PROPERTY_IMAGE = "image";
    private DropletCreateImage image;

    public static final String JSON_PROPERTY_SSH_KEYS = "ssh_keys";
    private List<DropletCreateSshKeysInner> sshKeys = null;

    public static final String JSON_PROPERTY_BACKUPS = "backups";
    private Boolean backups = false;

    public static final String JSON_PROPERTY_IPV6 = "ipv6";
    private Boolean ipv6 = false;

    public static final String JSON_PROPERTY_MONITORING = "monitoring";
    private Boolean monitoring = false;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_USER_DATA = "user_data";
    private String userData;

    public static final String JSON_PROPERTY_PRIVATE_NETWORKING = "private_networking";
    private Boolean privateNetworking = false;

    public static final String JSON_PROPERTY_VPC_UUID = "vpc_uuid";
    private String vpcUuid;

    public static final String JSON_PROPERTY_WITH_DROPLET_AGENT = "with_droplet_agent";
    private Boolean withDropletAgent;

    public DropletSingleCreate() {
    }

    public DropletSingleCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable string you wish to use when displaying the Droplet name.
     * The name, if set to a domain name managed in the DigitalOcean DNS management
     * system, will configure a PTR record for the Droplet. The name set during
     * creation will also determine the hostname for the Droplet in its internal
     * configuration.
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

    public DropletSingleCreate region(String region) {
        this.region = region;
        return this;
    }

    /**
     * The slug identifier for the region that you wish to deploy the Droplet in.
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

    public DropletSingleCreate size(String size) {
        this.size = size;
        return this;
    }

    /**
     * The slug identifier for the size that you wish to select for this Droplet.
     *
     * @return size
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSize(String size) {
        this.size = size;
    }

    public DropletSingleCreate image(DropletCreateImage image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DropletCreateImage getImage() {
        return image;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setImage(DropletCreateImage image) {
        this.image = image;
    }

    public DropletSingleCreate sshKeys(List<DropletCreateSshKeysInner> sshKeys) {
        this.sshKeys = sshKeys;
        return this;
    }

    public DropletSingleCreate addSshKeysItem(DropletCreateSshKeysInner sshKeysItem) {
        if (this.sshKeys == null) {
            this.sshKeys = new ArrayList<>();
        }
        this.sshKeys.add(sshKeysItem);
        return this;
    }

    /**
     * An array containing the IDs or fingerprints of the SSH keys that you wish to
     * embed in the Droplet&#39;s root account upon creation.
     *
     * @return sshKeys
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SSH_KEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DropletCreateSshKeysInner> getSshKeys() {
        return sshKeys;
    }

    @JsonProperty(JSON_PROPERTY_SSH_KEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSshKeys(List<DropletCreateSshKeysInner> sshKeys) {
        this.sshKeys = sshKeys;
    }

    public DropletSingleCreate backups(Boolean backups) {
        this.backups = backups;
        return this;
    }

    /**
     * A boolean indicating whether automated backups should be enabled for the
     * Droplet.
     *
     * @return backups
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getBackups() {
        return backups;
    }

    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackups(Boolean backups) {
        this.backups = backups;
    }

    public DropletSingleCreate ipv6(Boolean ipv6) {
        this.ipv6 = ipv6;
        return this;
    }

    /**
     * A boolean indicating whether to enable IPv6 on the Droplet.
     *
     * @return ipv6
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IPV6)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIpv6() {
        return ipv6;
    }

    @JsonProperty(JSON_PROPERTY_IPV6)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIpv6(Boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public DropletSingleCreate monitoring(Boolean monitoring) {
        this.monitoring = monitoring;
        return this;
    }

    /**
     * A boolean indicating whether to install the DigitalOcean agent for
     * monitoring.
     *
     * @return monitoring
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MONITORING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getMonitoring() {
        return monitoring;
    }

    @JsonProperty(JSON_PROPERTY_MONITORING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMonitoring(Boolean monitoring) {
        this.monitoring = monitoring;
    }

    public DropletSingleCreate tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DropletSingleCreate addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A flat array of tag names as strings to apply to the Droplet after it is
     * created. Tag names can either be existing or new tags.
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

    public DropletSingleCreate userData(String userData) {
        this.userData = userData;
        return this;
    }

    /**
     * A string containing &#39;user data&#39; which may be used to configure the
     * Droplet on first boot, often a &#39;cloud-config&#39; file or Bash script. It
     * must be plain text and may not exceed 64 KiB in size.
     *
     * @return userData
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserData() {
        return userData;
    }

    @JsonProperty(JSON_PROPERTY_USER_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserData(String userData) {
        this.userData = userData;
    }

    public DropletSingleCreate privateNetworking(Boolean privateNetworking) {
        this.privateNetworking = privateNetworking;
        return this;
    }

    /**
     * This parameter has been deprecated. Use &#x60;vpc_uuid&#x60; instead to
     * specify a VPC network for the Droplet. If no &#x60;vpc_uuid&#x60; is
     * provided, the Droplet will be placed in your account&#39;s default VPC for
     * the region.
     *
     * @return privateNetworking
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIVATE_NETWORKING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPrivateNetworking() {
        return privateNetworking;
    }

    @JsonProperty(JSON_PROPERTY_PRIVATE_NETWORKING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrivateNetworking(Boolean privateNetworking) {
        this.privateNetworking = privateNetworking;
    }

    public DropletSingleCreate vpcUuid(String vpcUuid) {
        this.vpcUuid = vpcUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the Droplet will be
     * assigned. If excluded, the Droplet will be assigned to your account&#39;s
     * default VPC for the region.
     *
     * @return vpcUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVpcUuid() {
        return vpcUuid;
    }

    @JsonProperty(JSON_PROPERTY_VPC_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpcUuid(String vpcUuid) {
        this.vpcUuid = vpcUuid;
    }

    public DropletSingleCreate withDropletAgent(Boolean withDropletAgent) {
        this.withDropletAgent = withDropletAgent;
        return this;
    }

    /**
     * A boolean indicating whether to install the DigitalOcean agent used for
     * providing access to the Droplet web console in the control panel. By default,
     * the agent is installed on new Droplets but installation errors (i.e. OS not
     * supported) are ignored. To prevent it from being installed, set to
     * &#x60;false&#x60;. To make installation errors fatal, explicitly set it to
     * &#x60;true&#x60;.
     *
     * @return withDropletAgent
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WITH_DROPLET_AGENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getWithDropletAgent() {
        return withDropletAgent;
    }

    @JsonProperty(JSON_PROPERTY_WITH_DROPLET_AGENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWithDropletAgent(Boolean withDropletAgent) {
        this.withDropletAgent = withDropletAgent;
    }

    /**
     * Return true if this droplet_single_create object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletSingleCreate dropletSingleCreate = (DropletSingleCreate) o;
        return Objects.equals(this.name, dropletSingleCreate.name)
                && Objects.equals(this.region, dropletSingleCreate.region)
                && Objects.equals(this.size, dropletSingleCreate.size)
                && Objects.equals(this.image, dropletSingleCreate.image)
                && Objects.equals(this.sshKeys, dropletSingleCreate.sshKeys)
                && Objects.equals(this.backups, dropletSingleCreate.backups)
                && Objects.equals(this.ipv6, dropletSingleCreate.ipv6)
                && Objects.equals(this.monitoring, dropletSingleCreate.monitoring)
                && Objects.equals(this.tags, dropletSingleCreate.tags)
                && Objects.equals(this.userData, dropletSingleCreate.userData)
                && Objects.equals(this.privateNetworking, dropletSingleCreate.privateNetworking)
                && Objects.equals(this.vpcUuid, dropletSingleCreate.vpcUuid)
                && Objects.equals(this.withDropletAgent, dropletSingleCreate.withDropletAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, size, image, sshKeys, backups, ipv6, monitoring, tags, userData,
                privateNetworking, vpcUuid, withDropletAgent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletSingleCreate {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
        sb.append("    backups: ").append(toIndentedString(backups)).append("\n");
        sb.append("    ipv6: ").append(toIndentedString(ipv6)).append("\n");
        sb.append("    monitoring: ").append(toIndentedString(monitoring)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
        sb.append("    privateNetworking: ").append(toIndentedString(privateNetworking)).append("\n");
        sb.append("    vpcUuid: ").append(toIndentedString(vpcUuid)).append("\n");
        sb.append("    withDropletAgent: ").append(toIndentedString(withDropletAgent)).append("\n");
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
