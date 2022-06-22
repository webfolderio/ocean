package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListVpcMembersResponseAllOf
 */
@JsonPropertyOrder({ ListVpcMembersResponseAllOf.JSON_PROPERTY_MEMBERS })
public class ListVpcMembersResponseAllOf {
    public static final String JSON_PROPERTY_MEMBERS = "members";
    private List<VpcMember> members = null;

    public ListVpcMembersResponseAllOf() {
    }

    public ListVpcMembersResponseAllOf members(List<VpcMember> members) {
        this.members = members;
        return this;
    }

    public ListVpcMembersResponseAllOf addMembersItem(VpcMember membersItem) {
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

    /**
     * Return true if this list_vpc_members_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListVpcMembersResponseAllOf listVpcMembersResponseAllOf = (ListVpcMembersResponseAllOf) o;
        return Objects.equals(this.members, listVpcMembersResponseAllOf.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListVpcMembersResponseAllOf {\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
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
