package io.webfolder.ocean.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The links object contains the &#x60;self&#x60; object, which contains the
 * resource relationship.
 */
@JsonPropertyOrder({ ResourceLinks.JSON_PROPERTY_SELF })
public class ResourceLinks {
    public static final String JSON_PROPERTY_SELF = "self";
    private URI self;

    public ResourceLinks() {
    }

    public ResourceLinks self(URI self) {
        this.self = self;
        return this;
    }

    /**
     * A URI that can be used to retrieve the resource.
     *
     * @return self
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SELF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public URI getSelf() {
        return self;
    }

    @JsonProperty(JSON_PROPERTY_SELF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSelf(URI self) {
        this.self = self;
    }

    /**
     * Return true if this resource_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResourceLinks resourceLinks = (ResourceLinks) o;
        return Objects.equals(this.self, resourceLinks.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResourceLinks {\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
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