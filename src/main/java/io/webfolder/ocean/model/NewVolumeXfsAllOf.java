package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * NewVolumeXfsAllOf
 */
@JsonPropertyOrder({ NewVolumeXfsAllOf.JSON_PROPERTY_REGION, NewVolumeXfsAllOf.JSON_PROPERTY_FILESYSTEM_LABEL })
public class NewVolumeXfsAllOf {
    public static final String JSON_PROPERTY_REGION = "region";
    private RegionSlug region;

    public static final String JSON_PROPERTY_FILESYSTEM_LABEL = "filesystem_label";
    private String filesystemLabel;

    public NewVolumeXfsAllOf() {
    }

    public NewVolumeXfsAllOf region(RegionSlug region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public RegionSlug getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(RegionSlug region) {
        this.region = region;
    }

    public NewVolumeXfsAllOf filesystemLabel(String filesystemLabel) {
        this.filesystemLabel = filesystemLabel;
        return this;
    }

    /**
     * Get filesystemLabel
     *
     * @return filesystemLabel
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_FILESYSTEM_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilesystemLabel() {
        return filesystemLabel;
    }

    @JsonProperty(JSON_PROPERTY_FILESYSTEM_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilesystemLabel(String filesystemLabel) {
        this.filesystemLabel = filesystemLabel;
    }

    /**
     * Return true if this new_volume_xfs_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewVolumeXfsAllOf newVolumeXfsAllOf = (NewVolumeXfsAllOf) o;
        return Objects.equals(this.region, newVolumeXfsAllOf.region)
                && Objects.equals(this.filesystemLabel, newVolumeXfsAllOf.filesystemLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, filesystemLabel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewVolumeXfsAllOf {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    filesystemLabel: ").append(toIndentedString(filesystemLabel)).append("\n");
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
