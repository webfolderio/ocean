package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListVpcMembersResponse
 */
@JsonPropertyOrder({ ListVpcMembersResponse.JSON_PROPERTY_MEMBERS, ListVpcMembersResponse.JSON_PROPERTY_LINKS,
        ListVpcMembersResponse.JSON_PROPERTY_META })
public class ListVpcMembersResponse {
    public static final String JSON_PROPERTY_MEMBERS = "members";
    private List<VpcMember> members = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListVpcMembersResponse() {
    }

    public ListVpcMembersResponse members(List<VpcMember> members) {
        this.members = members;
        return this;
    }

    public ListVpcMembersResponse addMembersItem(VpcMember membersItem) {
        if (this.members == null) {
            this.members = new ArrayList<>();
        }
        this.members.add(membersItem);
        return this;
    }

    /**
     * Get members
     *
     * @return members
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MEMBERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<VpcMember> getMembers() {
        return members;
    }

    @JsonProperty(JSON_PROPERTY_MEMBERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMembers(List<VpcMember> members) {
        this.members = members;
    }

    public ListVpcMembersResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListVpcMembersResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_vpc_members_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListVpcMembersResponse listVpcMembersResponse = (ListVpcMembersResponse) o;
        return Objects.equals(this.members, listVpcMembersResponse.members)
                && Objects.equals(this.links, listVpcMembersResponse.links)
                && Objects.equals(this.meta, listVpcMembersResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListVpcMembersResponse {\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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