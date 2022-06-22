package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An embedded object containing key value pairs of resource type and resource
 * statistics. It also includes a count of the total number of resources tagged
 * with the current tag as well as a &#x60;last_tagged_uri&#x60; attribute set
 * to the last resource tagged with the current tag.
 */
@ApiModel(description = "An embedded object containing key value pairs of resource type and resource statistics. It also includes a count of the total number of resources tagged with the current tag as well as a `last_tagged_uri` attribute set to the last resource tagged with the current tag.")
@JsonPropertyOrder({ TagResources.JSON_PROPERTY_COUNT, TagResources.JSON_PROPERTY_LAST_TAGGED_URI,
        TagResources.JSON_PROPERTY_DROPLETS, TagResources.JSON_PROPERTY_IMGAGES, TagResources.JSON_PROPERTY_VOLUMES,
        TagResources.JSON_PROPERTY_VOLUME_SNAPSHOTS, TagResources.JSON_PROPERTY_DATABASES })
public class TagResources {
    public static final String JSON_PROPERTY_COUNT = "count";
    private Integer count;

    public static final String JSON_PROPERTY_LAST_TAGGED_URI = "last_tagged_uri";
    private String lastTaggedUri;

    public static final String JSON_PROPERTY_DROPLETS = "droplets";
    private TagMetadata droplets;

    public static final String JSON_PROPERTY_IMGAGES = "imgages";
    private TagMetadata imgages;

    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private TagMetadata volumes;

    public static final String JSON_PROPERTY_VOLUME_SNAPSHOTS = "volume_snapshots";
    private TagMetadata volumeSnapshots;

    public static final String JSON_PROPERTY_DATABASES = "databases";
    private TagMetadata databases;

    public TagResources() {
    }

    public TagResources count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * The number of tagged objects for this type of resource. minimum: 0
     *
     * @return count
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "5", value = "The number of tagged objects for this type of resource.")
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

    public TagResources lastTaggedUri(String lastTaggedUri) {
        this.lastTaggedUri = lastTaggedUri;
        return this;
    }

    /**
     * The URI for the last tagged object for this type of resource.
     *
     * @return lastTaggedUri
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "https://api.digitalocean.com/v2/images/7555620", value = "The URI for the last tagged object for this type of resource.")
    @JsonProperty(JSON_PROPERTY_LAST_TAGGED_URI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastTaggedUri() {
        return lastTaggedUri;
    }

    @JsonProperty(JSON_PROPERTY_LAST_TAGGED_URI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastTaggedUri(String lastTaggedUri) {
        this.lastTaggedUri = lastTaggedUri;
    }

    public TagResources droplets(TagMetadata droplets) {
        this.droplets = droplets;
        return this;
    }

    /**
     * Get droplets
     *
     * @return droplets
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TagMetadata getDroplets() {
        return droplets;
    }

    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplets(TagMetadata droplets) {
        this.droplets = droplets;
    }

    public TagResources imgages(TagMetadata imgages) {
        this.imgages = imgages;
        return this;
    }

    /**
     * Get imgages
     *
     * @return imgages
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IMGAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TagMetadata getImgages() {
        return imgages;
    }

    @JsonProperty(JSON_PROPERTY_IMGAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setImgages(TagMetadata imgages) {
        this.imgages = imgages;
    }

    public TagResources volumes(TagMetadata volumes) {
        this.volumes = volumes;
        return this;
    }

    /**
     * Get volumes
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TagMetadata getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumes(TagMetadata volumes) {
        this.volumes = volumes;
    }

    public TagResources volumeSnapshots(TagMetadata volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    /**
     * Get volumeSnapshots
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TagMetadata getVolumeSnapshots() {
        return volumeSnapshots;
    }

    @JsonProperty(JSON_PROPERTY_VOLUME_SNAPSHOTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVolumeSnapshots(TagMetadata volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
    }

    public TagResources databases(TagMetadata databases) {
        this.databases = databases;
        return this;
    }

    /**
     * Get databases
     *
     * @return databases
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TagMetadata getDatabases() {
        return databases;
    }

    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDatabases(TagMetadata databases) {
        this.databases = databases;
    }

    /**
     * Return true if this tag_resources object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagResources tagResources = (TagResources) o;
        return Objects.equals(this.count, tagResources.count)
                && Objects.equals(this.lastTaggedUri, tagResources.lastTaggedUri)
                && Objects.equals(this.droplets, tagResources.droplets)
                && Objects.equals(this.imgages, tagResources.imgages)
                && Objects.equals(this.volumes, tagResources.volumes)
                && Objects.equals(this.volumeSnapshots, tagResources.volumeSnapshots)
                && Objects.equals(this.databases, tagResources.databases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, lastTaggedUri, droplets, imgages, volumes, volumeSnapshots, databases);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagResources {\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    lastTaggedUri: ").append(toIndentedString(lastTaggedUri)).append("\n");
        sb.append("    droplets: ").append(toIndentedString(droplets)).append("\n");
        sb.append("    imgages: ").append(toIndentedString(imgages)).append("\n");
        sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
        sb.append("    volumeSnapshots: ").append(toIndentedString(volumeSnapshots)).append("\n");
        sb.append("    databases: ").append(toIndentedString(databases)).append("\n");
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
