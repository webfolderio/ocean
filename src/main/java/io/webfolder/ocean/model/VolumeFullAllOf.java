package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * VolumeFullAllOf
 */
@JsonPropertyOrder({ VolumeFullAllOf.JSON_PROPERTY_REGION, VolumeFullAllOf.JSON_PROPERTY_FILESYSTEM_TYPE,
        VolumeFullAllOf.JSON_PROPERTY_FILESYSTEM_LABEL })
public class VolumeFullAllOf {
    public static final String JSON_PROPERTY_REGION = "region";
    private Object region;

    public static final String JSON_PROPERTY_FILESYSTEM_TYPE = "filesystem_type";
    private String filesystemType;

    public static final String JSON_PROPERTY_FILESYSTEM_LABEL = "filesystem_label";
    private String filesystemLabel;

    public VolumeFullAllOf() {
    }

    @JsonCreator
    public VolumeFullAllOf(@JsonProperty(JSON_PROPERTY_REGION) Object region) {
        this();
        this.region = region;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "{\"name\":\"New York 1\",\"slug\":\"nyc1\",\"sizes\":[\"s-1vcpu-1gb\",\"s-1vcpu-2gb\",\"s-1vcpu-3gb\",\"s-2vcpu-2gb\",\"s-3vcpu-1gb\",\"s-2vcpu-4gb\",\"s-4vcpu-8gb\",\"s-6vcpu-16gb\",\"s-8vcpu-32gb\",\"s-12vcpu-48gb\",\"s-16vcpu-64gb\",\"s-20vcpu-96gb\",\"s-24vcpu-128gb\",\"s-32vcpu-192gb\"],\"features\":[\"private_networking\",\"backups\",\"ipv6\",\"metadata\"],\"available\":true}", value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRegion() {
        return region;
    }

    public VolumeFullAllOf filesystemType(String filesystemType) {
        this.filesystemType = filesystemType;
        return this;
    }

    /**
     * The type of filesystem currently in-use on the volume.
     *
     * @return filesystemType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "ext4", value = "The type of filesystem currently in-use on the volume.")
    @JsonProperty(JSON_PROPERTY_FILESYSTEM_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilesystemType() {
        return filesystemType;
    }

    @JsonProperty(JSON_PROPERTY_FILESYSTEM_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilesystemType(String filesystemType) {
        this.filesystemType = filesystemType;
    }

    public VolumeFullAllOf filesystemLabel(String filesystemLabel) {
        this.filesystemLabel = filesystemLabel;
        return this;
    }

    /**
     * The label currently applied to the filesystem.
     *
     * @return filesystemLabel
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "example", value = "The label currently applied to the filesystem.")
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
     * Return true if this volume_full_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeFullAllOf volumeFullAllOf = (VolumeFullAllOf) o;
        return Objects.equals(this.region, volumeFullAllOf.region)
                && Objects.equals(this.filesystemType, volumeFullAllOf.filesystemType)
                && Objects.equals(this.filesystemLabel, volumeFullAllOf.filesystemLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, filesystemType, filesystemLabel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeFullAllOf {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    filesystemType: ").append(toIndentedString(filesystemType)).append("\n");
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
