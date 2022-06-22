package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * VpcDefault
 */
@JsonPropertyOrder({ VpcDefault.JSON_PROPERTY_DEFAULT })
public class VpcDefault {
    public static final String JSON_PROPERTY_DEFAULT = "default";
    private Boolean _default;

    public VpcDefault() {
    }

    public VpcDefault _default(Boolean _default) {
        this._default = _default;
        return this;
    }

    /**
     * A boolean value indicating whether or not the VPC is the default network for
     * the region. All applicable resources are placed into the default VPC network
     * unless otherwise specified during their creation. The &#x60;default&#x60;
     * field cannot be unset from &#x60;true&#x60;. If you want to set a new default
     * VPC network, update the &#x60;default&#x60; field of another VPC network in
     * the same region. The previous network&#39;s &#x60;default&#x60; field will be
     * set to &#x60;false&#x60; when a new default VPC has been defined.
     *
     * @return _default
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "A boolean value indicating whether or not the VPC is the default network for the region. All applicable resources are placed into the default VPC network unless otherwise specified during their creation. The `default` field cannot be unset from `true`. If you want to set a new default VPC network, update the `default` field of another VPC network in the same region. The previous network's `default` field will be set to `false` when a new default VPC has been defined.")
    @JsonProperty(JSON_PROPERTY_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDefault() {
        return _default;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     * Return true if this vpc_default object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VpcDefault vpcDefault = (VpcDefault) o;
        return Objects.equals(this._default, vpcDefault._default);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_default);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VpcDefault {\n");
        sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
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
