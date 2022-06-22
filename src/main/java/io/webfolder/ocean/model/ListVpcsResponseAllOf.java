package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListVpcsResponseAllOf
 */
@JsonPropertyOrder({ ListVpcsResponseAllOf.JSON_PROPERTY_VPCS })
public class ListVpcsResponseAllOf {
    public static final String JSON_PROPERTY_VPCS = "vpcs";
    private List<Vpc> vpcs = null;

    public ListVpcsResponseAllOf() {
    }

    public ListVpcsResponseAllOf vpcs(List<Vpc> vpcs) {
        this.vpcs = vpcs;
        return this;
    }

    public ListVpcsResponseAllOf addVpcsItem(Vpc vpcsItem) {
        if (this.vpcs == null) {
            this.vpcs = new ArrayList<>();
        }
        this.vpcs.add(vpcsItem);
        return this;
    }

    /**
     * Get vpcs
     *
     * @return vpcs
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VPCS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Vpc> getVpcs() {
        return vpcs;
    }

    @JsonProperty(JSON_PROPERTY_VPCS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpcs(List<Vpc> vpcs) {
        this.vpcs = vpcs;
    }

    /**
     * Return true if this list_vpcs_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListVpcsResponseAllOf listVpcsResponseAllOf = (ListVpcsResponseAllOf) o;
        return Objects.equals(this.vpcs, listVpcsResponseAllOf.vpcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vpcs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListVpcsResponseAllOf {\n");
        sb.append("    vpcs: ").append(toIndentedString(vpcs)).append("\n");
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
