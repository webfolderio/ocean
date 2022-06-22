package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ImageNewCustomAllOf
 */
@JsonPropertyOrder({ ImageNewCustomAllOf.JSON_PROPERTY_URL, ImageNewCustomAllOf.JSON_PROPERTY_REGION,
        ImageNewCustomAllOf.JSON_PROPERTY_TAGS })
public class ImageNewCustomAllOf {
    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_REGION = "region";
    private RegionSlug region;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public ImageNewCustomAllOf() {
    }

    public ImageNewCustomAllOf url(String url) {
        this.url = url;
        return this;
    }

    /**
     * A URL from which the custom Linux virtual machine image may be retrieved. The
     * image it points to must be in the raw, qcow2, vhdx, vdi, or vmdk format. It
     * may be compressed using gzip or bzip2 and must be smaller than 100 GB after
     * being decompressed.
     *
     * @return url
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "http://cloud-images.ubuntu.com/minimal/releases/bionic/release/ubuntu-18.04-minimal-cloudimg-amd64.img", value = "A URL from which the custom Linux virtual machine image may be retrieved.  The image it points to must be in the raw, qcow2, vhdx, vdi, or vmdk format.  It may be compressed using gzip or bzip2 and must be smaller than 100 GB after being decompressed.")
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrl(String url) {
        this.url = url;
    }

    public ImageNewCustomAllOf region(RegionSlug region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RegionSlug getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(RegionSlug region) {
        this.region = region;
    }

    public ImageNewCustomAllOf tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ImageNewCustomAllOf addTagsItem(String tagsItem) {
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
    @ApiModelProperty(example = "[\"base-image\",\"prod\"]", value = "A flat array of tag names as strings to be applied to the resource. Tag names may be for either existing or new tags.")
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

    /**
     * Return true if this image_new_custom_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageNewCustomAllOf imageNewCustomAllOf = (ImageNewCustomAllOf) o;
        return Objects.equals(this.url, imageNewCustomAllOf.url)
                && Objects.equals(this.region, imageNewCustomAllOf.region)
                && Objects.equals(this.tags, imageNewCustomAllOf.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, region, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageNewCustomAllOf {\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
