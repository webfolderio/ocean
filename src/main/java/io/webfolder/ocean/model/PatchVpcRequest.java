package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PatchVpcRequest
 */
@JsonPropertyOrder({ PatchVpcRequest.JSON_PROPERTY_NAME, PatchVpcRequest.JSON_PROPERTY_DESCRIPTION,
        PatchVpcRequest.JSON_PROPERTY_DEFAULT })
public class PatchVpcRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_DEFAULT = "default";
    private Boolean _default;

    public PatchVpcRequest() {
    }

    public PatchVpcRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the VPC. Must be unique and may only contain alphanumeric
     * characters, dashes, and periods.
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

    public PatchVpcRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free-form text field for describing the VPC&#39;s purpose. It may be a
     * maximum of 255 characters.
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

    public PatchVpcRequest _default(Boolean _default) {
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
     * Return true if this patch_vpc_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatchVpcRequest patchVpcRequest = (PatchVpcRequest) o;
        return Objects.equals(this.name, patchVpcRequest.name)
                && Objects.equals(this.description, patchVpcRequest.description)
                && Objects.equals(this._default, patchVpcRequest._default);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, _default);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PatchVpcRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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