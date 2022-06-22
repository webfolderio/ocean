package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Droplet
 */
@JsonPropertyOrder({ Droplet.JSON_PROPERTY_ID, Droplet.JSON_PROPERTY_NAME, Droplet.JSON_PROPERTY_MEMORY,
        Droplet.JSON_PROPERTY_VCPUS, Droplet.JSON_PROPERTY_DISK, Droplet.JSON_PROPERTY_LOCKED,
        Droplet.JSON_PROPERTY_STATUS, Droplet.JSON_PROPERTY_KERNEL, Droplet.JSON_PROPERTY_CREATED_AT,
        Droplet.JSON_PROPERTY_FEATURES, Droplet.JSON_PROPERTY_BACKUP_IDS, Droplet.JSON_PROPERTY_NEXT_BACKUP_WINDOW,
        Droplet.JSON_PROPERTY_SNAPSHOT_IDS, Droplet.JSON_PROPERTY_IMAGE, Droplet.JSON_PROPERTY_VOLUME_IDS,
        Droplet.JSON_PROPERTY_SIZE, Droplet.JSON_PROPERTY_SIZE_SLUG, Droplet.JSON_PROPERTY_NETWORKS,
        Droplet.JSON_PROPERTY_REGION, Droplet.JSON_PROPERTY_TAGS, Droplet.JSON_PROPERTY_VPC_UUID })
public class Droplet {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_MEMORY = "memory";
    private Integer memory;

    public static final String JSON_PROPERTY_VCPUS = "vcpus";
    private Integer vcpus;

    public static final String JSON_PROPERTY_DISK = "disk";
    private Integer disk;

    public static final String JSON_PROPERTY_LOCKED = "locked";
    private Boolean locked;

    /**
     * A status string indicating the state of the Droplet instance. This may be
     * \&quot;new\&quot;, \&quot;active\&quot;, \&quot;off\&quot;, or
     * \&quot;archive\&quot;.
     */
    public enum StatusEnum {
        NEW("new"),

        ACTIVE("active"),

        OFF("off"),

        ARCHIVE("archive");

        private String value;

        StatusEnum(String value) {
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
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status;

    public static final String JSON_PROPERTY_KERNEL = "kernel";
    private Kernel kernel;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_FEATURES = "features";
    private List<String> features = new ArrayList<>();

    public static final String JSON_PROPERTY_BACKUP_IDS = "backup_ids";
    private List<Integer> backupIds = new ArrayList<>();

    public static final String JSON_PROPERTY_NEXT_BACKUP_WINDOW = "next_backup_window";
    private DropletNextBackupWindow nextBackupWindow;

    public static final String JSON_PROPERTY_SNAPSHOT_IDS = "snapshot_ids";
    private List<Integer> snapshotIds = new ArrayList<>();

    public static final String JSON_PROPERTY_IMAGE = "image";
    private Image image;

    public static final String JSON_PROPERTY_VOLUME_IDS = "volume_ids";
    private List<String> volumeIds = new ArrayList<>();

    public static final String JSON_PROPERTY_SIZE = "size";
    private Size size;

    public static final String JSON_PROPERTY_SIZE_SLUG = "size_slug";
    private String sizeSlug;

    public static final String JSON_PROPERTY_NETWORKS = "networks";
    private DropletNetworks networks;

    public static final String JSON_PROPERTY_REGION = "region";
    private Region region;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = new ArrayList<>();

    public static final String JSON_PROPERTY_VPC_UUID = "vpc_uuid";
    private String vpcUuid;

    public Droplet() {
    }

    public Droplet id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * A unique identifier for each Droplet instance. This is automatically
     * generated upon Droplet creation.
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(Integer id) {
        this.id = id;
    }

    public Droplet name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable name set for the Droplet instance.
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

    public Droplet memory(Integer memory) {
        this.memory = memory;
        return this;
    }

    /**
     * Memory of the Droplet in megabytes.
     *
     * @return memory
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_MEMORY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getMemory() {
        return memory;
    }

    @JsonProperty(JSON_PROPERTY_MEMORY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Droplet vcpus(Integer vcpus) {
        this.vcpus = vcpus;
        return this;
    }

    /**
     * The number of virtual CPUs.
     *
     * @return vcpus
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VCPUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getVcpus() {
        return vcpus;
    }

    @JsonProperty(JSON_PROPERTY_VCPUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVcpus(Integer vcpus) {
        this.vcpus = vcpus;
    }

    public Droplet disk(Integer disk) {
        this.disk = disk;
        return this;
    }

    /**
     * The size of the Droplet&#39;s disk in gigabytes.
     *
     * @return disk
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getDisk() {
        return disk;
    }

    @JsonProperty(JSON_PROPERTY_DISK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDisk(Integer disk) {
        this.disk = disk;
    }

    public Droplet locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    /**
     * A boolean value indicating whether the Droplet has been locked, preventing
     * actions by users.
     *
     * @return locked
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LOCKED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getLocked() {
        return locked;
    }

    @JsonProperty(JSON_PROPERTY_LOCKED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Droplet status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * A status string indicating the state of the Droplet instance. This may be
     * \&quot;new\&quot;, \&quot;active\&quot;, \&quot;off\&quot;, or
     * \&quot;archive\&quot;.
     *
     * @return status
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Droplet kernel(Kernel kernel) {
        this.kernel = kernel;
        return this;
    }

    /**
     * Get kernel
     *
     * @return kernel
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KERNEL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Kernel getKernel() {
        return kernel;
    }

    @JsonProperty(JSON_PROPERTY_KERNEL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }

    public Droplet createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the Droplet was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Droplet features(List<String> features) {
        this.features = features;
        return this;
    }

    public Droplet addFeaturesItem(String featuresItem) {
        this.features.add(featuresItem);
        return this;
    }

    /**
     * An array of features enabled on this Droplet.
     *
     * @return features
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_FEATURES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty(JSON_PROPERTY_FEATURES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Droplet backupIds(List<Integer> backupIds) {
        this.backupIds = backupIds;
        return this;
    }

    public Droplet addBackupIdsItem(Integer backupIdsItem) {
        this.backupIds.add(backupIdsItem);
        return this;
    }

    /**
     * An array of backup IDs of any backups that have been taken of the Droplet
     * instance. Droplet backups are enabled at the time of the instance creation.
     *
     * @return backupIds
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_BACKUP_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Integer> getBackupIds() {
        return backupIds;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setBackupIds(List<Integer> backupIds) {
        this.backupIds = backupIds;
    }

    public Droplet nextBackupWindow(DropletNextBackupWindow nextBackupWindow) {
        this.nextBackupWindow = nextBackupWindow;
        return this;
    }

    /**
     * Get nextBackupWindow
     *
     * @return nextBackupWindow
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NEXT_BACKUP_WINDOW)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DropletNextBackupWindow getNextBackupWindow() {
        return nextBackupWindow;
    }

    @JsonProperty(JSON_PROPERTY_NEXT_BACKUP_WINDOW)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNextBackupWindow(DropletNextBackupWindow nextBackupWindow) {
        this.nextBackupWindow = nextBackupWindow;
    }

    public Droplet snapshotIds(List<Integer> snapshotIds) {
        this.snapshotIds = snapshotIds;
        return this;
    }

    public Droplet addSnapshotIdsItem(Integer snapshotIdsItem) {
        this.snapshotIds.add(snapshotIdsItem);
        return this;
    }

    /**
     * An array of snapshot IDs of any snapshots created from the Droplet instance.
     *
     * @return snapshotIds
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SNAPSHOT_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Integer> getSnapshotIds() {
        return snapshotIds;
    }

    @JsonProperty(JSON_PROPERTY_SNAPSHOT_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSnapshotIds(List<Integer> snapshotIds) {
        this.snapshotIds = snapshotIds;
    }

    public Droplet image(Image image) {
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

    public Image getImage() {
        return image;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setImage(Image image) {
        this.image = image;
    }

    public Droplet volumeIds(List<String> volumeIds) {
        this.volumeIds = volumeIds;
        return this;
    }

    public Droplet addVolumeIdsItem(String volumeIdsItem) {
        this.volumeIds.add(volumeIdsItem);
        return this;
    }

    /**
     * A flat array including the unique identifier for each Block Storage volume
     * attached to the Droplet.
     *
     * @return volumeIds
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VOLUME_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getVolumeIds() {
        return volumeIds;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVolumeIds(List<String> volumeIds) {
        this.volumeIds = volumeIds;
    }

    public Droplet size(Size size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     *
     * @return size
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Size getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSize(Size size) {
        this.size = size;
    }

    public Droplet sizeSlug(String sizeSlug) {
        this.sizeSlug = sizeSlug;
        return this;
    }

    /**
     * The unique slug identifier for the size of this Droplet.
     *
     * @return sizeSlug
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getSizeSlug() {
        return sizeSlug;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_SLUG)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizeSlug(String sizeSlug) {
        this.sizeSlug = sizeSlug;
    }

    public Droplet networks(DropletNetworks networks) {
        this.networks = networks;
        return this;
    }

    /**
     * Get networks
     *
     * @return networks
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NETWORKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DropletNetworks getNetworks() {
        return networks;
    }

    @JsonProperty(JSON_PROPERTY_NETWORKS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNetworks(DropletNetworks networks) {
        this.networks = networks;
    }

    public Droplet region(Region region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Region getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(Region region) {
        this.region = region;
    }

    public Droplet tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Droplet addTagsItem(String tagsItem) {
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of Tags the Droplet has been tagged with.
     *
     * @return tags
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Droplet vpcUuid(String vpcUuid) {
        this.vpcUuid = vpcUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the Droplet is assigned.
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

    /**
     * Return true if this droplet object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Droplet droplet = (Droplet) o;
        return Objects.equals(this.id, droplet.id) && Objects.equals(this.name, droplet.name)
                && Objects.equals(this.memory, droplet.memory) && Objects.equals(this.vcpus, droplet.vcpus)
                && Objects.equals(this.disk, droplet.disk) && Objects.equals(this.locked, droplet.locked)
                && Objects.equals(this.status, droplet.status) && Objects.equals(this.kernel, droplet.kernel)
                && Objects.equals(this.createdAt, droplet.createdAt) && Objects.equals(this.features, droplet.features)
                && Objects.equals(this.backupIds, droplet.backupIds)
                && Objects.equals(this.nextBackupWindow, droplet.nextBackupWindow)
                && Objects.equals(this.snapshotIds, droplet.snapshotIds) && Objects.equals(this.image, droplet.image)
                && Objects.equals(this.volumeIds, droplet.volumeIds) && Objects.equals(this.size, droplet.size)
                && Objects.equals(this.sizeSlug, droplet.sizeSlug) && Objects.equals(this.networks, droplet.networks)
                && Objects.equals(this.region, droplet.region) && Objects.equals(this.tags, droplet.tags)
                && Objects.equals(this.vpcUuid, droplet.vpcUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, memory, vcpus, disk, locked, status, kernel, createdAt, features, backupIds,
                nextBackupWindow, snapshotIds, image, volumeIds, size, sizeSlug, networks, region, tags, vpcUuid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Droplet {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
        sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
        sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    kernel: ").append(toIndentedString(kernel)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    features: ").append(toIndentedString(features)).append("\n");
        sb.append("    backupIds: ").append(toIndentedString(backupIds)).append("\n");
        sb.append("    nextBackupWindow: ").append(toIndentedString(nextBackupWindow)).append("\n");
        sb.append("    snapshotIds: ").append(toIndentedString(snapshotIds)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    volumeIds: ").append(toIndentedString(volumeIds)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    sizeSlug: ").append(toIndentedString(sizeSlug)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    vpcUuid: ").append(toIndentedString(vpcUuid)).append("\n");
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
