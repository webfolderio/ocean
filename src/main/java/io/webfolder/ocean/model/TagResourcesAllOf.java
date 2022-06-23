package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * TagResourcesAllOf
 */
@JsonPropertyOrder({ TagResourcesAllOf.JSON_PROPERTY_DROPLETS, TagResourcesAllOf.JSON_PROPERTY_IMGAGES,
        TagResourcesAllOf.JSON_PROPERTY_VOLUMES, TagResourcesAllOf.JSON_PROPERTY_VOLUME_SNAPSHOTS,
        TagResourcesAllOf.JSON_PROPERTY_DATABASES })
public class TagResourcesAllOf {
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

    public TagResourcesAllOf() {
    }

    public TagResourcesAllOf droplets(TagMetadata droplets) {
        this.droplets = droplets;
        return this;
    }

    /**
     * Get droplets
     *
     * @return droplets
     **/
    @javax.annotation.Nullable
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

    public TagResourcesAllOf imgages(TagMetadata imgages) {
        this.imgages = imgages;
        return this;
    }

    /**
     * Get imgages
     *
     * @return imgages
     **/
    @javax.annotation.Nullable
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

    public TagResourcesAllOf volumes(TagMetadata volumes) {
        this.volumes = volumes;
        return this;
    }

    /**
     * Get volumes
     *
     * @return volumes
     **/
    @javax.annotation.Nullable
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

    public TagResourcesAllOf volumeSnapshots(TagMetadata volumeSnapshots) {
        this.volumeSnapshots = volumeSnapshots;
        return this;
    }

    /**
     * Get volumeSnapshots
     *
     * @return volumeSnapshots
     **/
    @javax.annotation.Nullable
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

    public TagResourcesAllOf databases(TagMetadata databases) {
        this.databases = databases;
        return this;
    }

    /**
     * Get databases
     *
     * @return databases
     **/
    @javax.annotation.Nullable
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
     * Return true if this tag_resources_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagResourcesAllOf tagResourcesAllOf = (TagResourcesAllOf) o;
        return Objects.equals(this.droplets, tagResourcesAllOf.droplets)
                && Objects.equals(this.imgages, tagResourcesAllOf.imgages)
                && Objects.equals(this.volumes, tagResourcesAllOf.volumes)
                && Objects.equals(this.volumeSnapshots, tagResourcesAllOf.volumeSnapshots)
                && Objects.equals(this.databases, tagResourcesAllOf.databases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplets, imgages, volumes, volumeSnapshots, databases);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagResourcesAllOf {\n");
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