package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SnapshotBase
 */
@JsonPropertyOrder({ SnapshotBase.JSON_PROPERTY_NAME, SnapshotBase.JSON_PROPERTY_CREATED_AT,
        SnapshotBase.JSON_PROPERTY_REGIONS, SnapshotBase.JSON_PROPERTY_MIN_DISK_SIZE,
        SnapshotBase.JSON_PROPERTY_SIZE_GIGABYTES })
public class SnapshotBase {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<String> regions = new ArrayList<>();

    public static final String JSON_PROPERTY_MIN_DISK_SIZE = "min_disk_size";
    private Integer minDiskSize;

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Float sizeGigabytes;

    public SnapshotBase() {
    }

    public SnapshotBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable name for the snapshot.
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

    public SnapshotBase createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the snapshot was created.
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

    public SnapshotBase regions(List<String> regions) {
        this.regions = regions;
        return this;
    }

    public SnapshotBase addRegionsItem(String regionsItem) {
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * An array of the regions that the snapshot is available in. The regions are
     * represented by their identifying slug values.
     *
     * @return regions
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public SnapshotBase minDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
        return this;
    }

    /**
     * The minimum size in GB required for a volume or Droplet to use this snapshot.
     *
     * @return minDiskSize
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getMinDiskSize() {
        return minDiskSize;
    }

    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMinDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
    }

    public SnapshotBase sizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The billable size of the snapshot in gigabytes.
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Float getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    /**
     * Return true if this snapshot_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SnapshotBase snapshotBase = (SnapshotBase) o;
        return Objects.equals(this.name, snapshotBase.name) && Objects.equals(this.createdAt, snapshotBase.createdAt)
                && Objects.equals(this.regions, snapshotBase.regions)
                && Objects.equals(this.minDiskSize, snapshotBase.minDiskSize)
                && Objects.equals(this.sizeGigabytes, snapshotBase.sizeGigabytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, regions, minDiskSize, sizeGigabytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SnapshotBase {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    minDiskSize: ").append(toIndentedString(minDiskSize)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
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