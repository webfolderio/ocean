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
 * DropletSnapshot
 */
@JsonPropertyOrder({ DropletSnapshot.JSON_PROPERTY_ID, DropletSnapshot.JSON_PROPERTY_NAME,
        DropletSnapshot.JSON_PROPERTY_CREATED_AT, DropletSnapshot.JSON_PROPERTY_REGIONS,
        DropletSnapshot.JSON_PROPERTY_MIN_DISK_SIZE, DropletSnapshot.JSON_PROPERTY_SIZE_GIGABYTES,
        DropletSnapshot.JSON_PROPERTY_TYPE })
public class DropletSnapshot {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

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

    /**
     * Describes the kind of image. It may be one of &#x60;snapshot&#x60; or
     * &#x60;backup&#x60;. This specifies whether an image is a user-generated
     * Droplet snapshot or automatically created Droplet backup.
     */
    public enum TypeEnum {
        SNAPSHOT("snapshot"),

        BACKUP("backup");

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

    public DropletSnapshot() {
    }

    public DropletSnapshot id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * The unique identifier for the snapshot or backup.
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

    public DropletSnapshot name(String name) {
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

    public DropletSnapshot createdAt(OffsetDateTime createdAt) {
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

    public DropletSnapshot regions(List<String> regions) {
        this.regions = regions;
        return this;
    }

    public DropletSnapshot addRegionsItem(String regionsItem) {
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

    public DropletSnapshot minDiskSize(Integer minDiskSize) {
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

    public DropletSnapshot sizeGigabytes(Float sizeGigabytes) {
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

    public DropletSnapshot type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Describes the kind of image. It may be one of &#x60;snapshot&#x60; or
     * &#x60;backup&#x60;. This specifies whether an image is a user-generated
     * Droplet snapshot or automatically created Droplet backup.
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

    /**
     * Return true if this droplet_snapshot object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletSnapshot dropletSnapshot = (DropletSnapshot) o;
        return Objects.equals(this.id, dropletSnapshot.id) && Objects.equals(this.name, dropletSnapshot.name)
                && Objects.equals(this.createdAt, dropletSnapshot.createdAt)
                && Objects.equals(this.regions, dropletSnapshot.regions)
                && Objects.equals(this.minDiskSize, dropletSnapshot.minDiskSize)
                && Objects.equals(this.sizeGigabytes, dropletSnapshot.sizeGigabytes)
                && Objects.equals(this.type, dropletSnapshot.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, regions, minDiskSize, sizeGigabytes, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletSnapshot {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    minDiskSize: ").append(toIndentedString(minDiskSize)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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