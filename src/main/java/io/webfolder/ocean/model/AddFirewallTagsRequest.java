package io.webfolder.ocean.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AddFirewallTagsRequest
 */
@JsonPropertyOrder({ AddFirewallTagsRequest.JSON_PROPERTY_TAGS })
public class AddFirewallTagsRequest {
    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<Tag> tags;

    public AddFirewallTagsRequest() {
    }

    public AddFirewallTagsRequest tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get tags
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Return true if this add_firewall_tags_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddFirewallTagsRequest addFirewallTagsRequest = (AddFirewallTagsRequest) o;
        return Objects.equals(this.tags, addFirewallTagsRequest.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddFirewallTagsRequest {\n");
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
