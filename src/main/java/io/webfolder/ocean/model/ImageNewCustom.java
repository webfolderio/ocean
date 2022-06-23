package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ImageNewCustom
 */
@JsonPropertyOrder({ ImageNewCustom.JSON_PROPERTY_NAME, ImageNewCustom.JSON_PROPERTY_DISTRIBUTION,
        ImageNewCustom.JSON_PROPERTY_DESCRIPTION, ImageNewCustom.JSON_PROPERTY_URL, ImageNewCustom.JSON_PROPERTY_REGION,
        ImageNewCustom.JSON_PROPERTY_TAGS })
public class ImageNewCustom {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DISTRIBUTION = "distribution";
    private Distribution distribution;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_REGION = "region";
    private RegionSlug region;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public ImageNewCustom() {
    }

    public ImageNewCustom name(String name) {
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

    public ImageNewCustom distribution(Distribution distribution) {
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

    public ImageNewCustom description(String description) {
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

    public ImageNewCustom url(String url) {
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
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUrl(String url) {
        this.url = url;
    }

    public ImageNewCustom region(RegionSlug region) {
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

    public RegionSlug getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(RegionSlug region) {
        this.region = region;
    }

    public ImageNewCustom tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ImageNewCustom addTagsItem(String tagsItem) {
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

    /**
     * Return true if this image_new_custom object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImageNewCustom imageNewCustom = (ImageNewCustom) o;
        return Objects.equals(this.name, imageNewCustom.name)
                && Objects.equals(this.distribution, imageNewCustom.distribution)
                && Objects.equals(this.description, imageNewCustom.description)
                && Objects.equals(this.url, imageNewCustom.url) && Objects.equals(this.region, imageNewCustom.region)
                && Objects.equals(this.tags, imageNewCustom.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distribution, description, url, region, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImageNewCustom {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    distribution: ").append(toIndentedString(distribution)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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