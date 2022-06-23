package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An objects containing information about a resource associated with a Droplet.
 */
@JsonPropertyOrder({ AssociatedResource.JSON_PROPERTY_ID, AssociatedResource.JSON_PROPERTY_NAME,
        AssociatedResource.JSON_PROPERTY_COST })
public class AssociatedResource {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_COST = "cost";
    private String cost;

    public AssociatedResource() {
    }

    public AssociatedResource id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The unique identifier for the resource associated with the Droplet.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public AssociatedResource name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the resource associated with the Droplet.
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

    public AssociatedResource cost(String cost) {
        this.cost = cost;
        return this;
    }

    /**
     * The cost of the resource in USD per month if the resource is retained after
     * the Droplet is destroyed.
     *
     * @return cost
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCost() {
        return cost;
    }

    @JsonProperty(JSON_PROPERTY_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * Return true if this associated_resource object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssociatedResource associatedResource = (AssociatedResource) o;
        return Objects.equals(this.id, associatedResource.id) && Objects.equals(this.name, associatedResource.name)
                && Objects.equals(this.cost, associatedResource.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssociatedResource {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
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