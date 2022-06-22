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
 * Image
 */
@JsonPropertyOrder({ Image.JSON_PROPERTY_ID, Image.JSON_PROPERTY_NAME, Image.JSON_PROPERTY_TYPE,
        Image.JSON_PROPERTY_DISTRIBUTION, Image.JSON_PROPERTY_SLUG, Image.JSON_PROPERTY_PUBLIC,
        Image.JSON_PROPERTY_REGIONS, Image.JSON_PROPERTY_CREATED_AT, Image.JSON_PROPERTY_MIN_DISK_SIZE,
        Image.JSON_PROPERTY_SIZE_GIGABYTES, Image.JSON_PROPERTY_DESCRIPTION, Image.JSON_PROPERTY_TAGS,
        Image.JSON_PROPERTY_STATUS, Image.JSON_PROPERTY_ERROR_MESSAGE })
public class Image {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * Describes the kind of image. It may be one of &#x60;base&#x60;,
     * &#x60;snapshot&#x60;, &#x60;backup&#x60;, &#x60;custom&#x60;, or
     * &#x60;admin&#x60;. Respectively, this specifies whether an image is a
     * DigitalOcean base OS image, user-generated Droplet snapshot, automatically
     * created Droplet backup, user-provided virtual machine image, or an image used
     * for DigitalOcean managed resources (e.g. DOKS worker nodes).
     */
    public enum TypeEnum {
        BASE("base"),

        SNAPSHOT("snapshot"),

        BACKUP("backup"),

        CUSTOM("custom"),

        ADMIN("admin");

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

    public static final String JSON_PROPERTY_DISTRIBUTION = "distribution";
    private Distribution distribution;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    private Boolean _public;

    public static final String JSON_PROPERTY_REGIONS = "regions";
    private List<RegionSlug> regions = null;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_MIN_DISK_SIZE = "min_disk_size";
    private Integer minDiskSize;

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private Float sizeGigabytes;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    /**
     * A status string indicating the state of a custom image. This may be
     * &#x60;NEW&#x60;, &#x60;available&#x60;, &#x60;pending&#x60;,
     * &#x60;deleted&#x60;, or &#x60;retired&#x60;.
     */
    public enum StatusEnum {
        NEW("NEW"),

        AVAILABLE("available"),

        PENDING("pending"),

        DELETED("deleted"),

        RETIRED("retired");

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

    public static final String JSON_PROPERTY_ERROR_MESSAGE = "error_message";
    private String errorMessage;

    public Image() {
    }

    @JsonCreator
    public Image(@JsonProperty(JSON_PROPERTY_ID) Integer id) {
        this();
        this.id = id;
    }

    /**
     * A unique number that can be used to identify and reference a specific image.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getId() {
        return id;
    }

    public Image name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The display name that has been given to an image. This is what is shown in
     * the control panel and is generally a descriptive title for the image in
     * question.
     *
     * @return name
     **/
    @javax.annotation.Nullable
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

    public Image type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Describes the kind of image. It may be one of &#x60;base&#x60;,
     * &#x60;snapshot&#x60;, &#x60;backup&#x60;, &#x60;custom&#x60;, or
     * &#x60;admin&#x60;. Respectively, this specifies whether an image is a
     * DigitalOcean base OS image, user-generated Droplet snapshot, automatically
     * created Droplet backup, user-provided virtual machine image, or an image used
     * for DigitalOcean managed resources (e.g. DOKS worker nodes).
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Image distribution(Distribution distribution) {
        this.distribution = distribution;
        return this;
    }

    /**
     * Get distribution
     *
     * @return distribution
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISTRIBUTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Distribution getDistribution() {
        return distribution;
    }

    @JsonProperty(JSON_PROPERTY_DISTRIBUTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public Image slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * A uniquely identifying string that is associated with each of the
     * DigitalOcean-provided public images. These can be used to reference a public
     * image as an alternative to the numeric id.
     *
     * @return slug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSlug() {
        return slug;
    }

    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Image _public(Boolean _public) {
        this._public = _public;
        return this;
    }

    /**
     * This is a boolean value that indicates whether the image in question is
     * public or not. An image that is public is available to all accounts. A
     * non-public image is only accessible from your account.
     *
     * @return _public
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PUBLIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty(JSON_PROPERTY_PUBLIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public Image regions(List<RegionSlug> regions) {
        this.regions = regions;
        return this;
    }

    public Image addRegionsItem(RegionSlug regionsItem) {
        if (this.regions == null) {
            this.regions = new ArrayList<>();
        }
        this.regions.add(regionsItem);
        return this;
    }

    /**
     * This attribute is an array of the regions that the image is available in. The
     * regions are represented by their identifying slug values.
     *
     * @return regions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<RegionSlug> getRegions() {
        return regions;
    }

    @JsonProperty(JSON_PROPERTY_REGIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegions(List<RegionSlug> regions) {
        this.regions = regions;
    }

    public Image createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the image was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Image minDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
        return this;
    }

    /**
     * The minimum disk size in GB required for a Droplet to use this image.
     * minimum: 0
     *
     * @return minDiskSize
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getMinDiskSize() {
        return minDiskSize;
    }

    @JsonProperty(JSON_PROPERTY_MIN_DISK_SIZE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMinDiskSize(Integer minDiskSize) {
        this.minDiskSize = minDiskSize;
    }

    public Image sizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The size of the image in gigabytes.
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Float getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSizeGigabytes(Float sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    public Image description(String description) {
        this.description = description;
        return this;
    }

    /**
     * An optional free-form text field to describe an image.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public Image tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Image addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A flat array of tag names as strings to be applied to the resource. Tag names
     * may be for either existing or new tags.
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

    public Image status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * A status string indicating the state of a custom image. This may be
     * &#x60;NEW&#x60;, &#x60;available&#x60;, &#x60;pending&#x60;,
     * &#x60;deleted&#x60;, or &#x60;retired&#x60;.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Image errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * A string containing information about errors that may occur when importing a
     * custom image.
     *
     * @return errorMessage
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Return true if this image object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(this.id, image.id) && Objects.equals(this.name, image.name)
                && Objects.equals(this.type, image.type) && Objects.equals(this.distribution, image.distribution)
                && Objects.equals(this.slug, image.slug) && Objects.equals(this._public, image._public)
                && Objects.equals(this.regions, image.regions) && Objects.equals(this.createdAt, image.createdAt)
                && Objects.equals(this.minDiskSize, image.minDiskSize)
                && Objects.equals(this.sizeGigabytes, image.sizeGigabytes)
                && Objects.equals(this.description, image.description) && Objects.equals(this.tags, image.tags)
                && Objects.equals(this.status, image.status) && Objects.equals(this.errorMessage, image.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, distribution, slug, _public, regions, createdAt, minDiskSize, sizeGigabytes,
                description, tags, status, errorMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Image {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    distribution: ").append(toIndentedString(distribution)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
        sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
        sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    minDiskSize: ").append(toIndentedString(minDiskSize)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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
