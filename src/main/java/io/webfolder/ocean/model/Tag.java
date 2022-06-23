package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A tag is a label that can be applied to a resource (currently Droplets,
 * Images, Volumes, Volume Snapshots, and Database clusters) in order to better
 * organize or facilitate the lookups and actions on it. Tags have two
 * attributes: a user defined &#x60;name&#x60; attribute and an embedded
 * &#x60;resources&#x60; attribute with information about resources that have
 * been tagged.
 */
@JsonPropertyOrder({ Tag.JSON_PROPERTY_NAME, Tag.JSON_PROPERTY_RESOURCES })
public class Tag {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private TagResources resources;

    public Tag() {
    }

    public Tag name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the tag. Tags may contain letters, numbers, colons, dashes, and
     * underscores. There is a limit of 255 characters per tag. **Note:** Tag names
     * are case stable, which means the capitalization you use when you first create
     * a tag is canonical. When working with tags in the API, you must use the
     * tag&#39;s canonical capitalization. For example, if you create a tag named
     * \&quot;PROD\&quot;, the URL to add that tag to a resource would be
     * &#x60;https://api.digitalocean.com/v2/tags/PROD/resources&#x60; (not
     * &#x60;/v2/tags/prod/resources&#x60;). Tagged resources in the control panel
     * will always display the canonical capitalization. For example, if you create
     * a tag named \&quot;PROD\&quot;, you can tag resources in the control panel by
     * entering \&quot;prod\&quot;. The tag will still display with its canonical
     * capitalization, \&quot;PROD\&quot;.
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

    public Tag resources(TagResources resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Get resources
     *
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public TagResources getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResources(TagResources resources) {
        this.resources = resources;
    }

    /**
     * Return true if this tag object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tag tag = (Tag) o;
        return Objects.equals(this.name, tag.name) && Objects.equals(this.resources, tag.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, resources);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tag {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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