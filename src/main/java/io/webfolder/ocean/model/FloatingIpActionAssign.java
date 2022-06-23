package io.webfolder.ocean.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.webfolder.ocean.client.internal.JSON;

/**
 * FloatingIpActionAssign
 */
@JsonPropertyOrder({ FloatingIpActionAssign.JSON_PROPERTY_DROPLET_ID })
@JsonIgnoreProperties(value = "type", // ignore manually set type, it will be automatically
                                      // generated by Jackson during serialization
        allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = FloatingIpActionAssign.class, name = "assign"),
        @JsonSubTypes.Type(value = FloatingIpActionUnassign.class, name = "unassign"), })

public class FloatingIpActionAssign extends FloatingIpActionType {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public FloatingIpActionAssign() {
    }

    public FloatingIpActionAssign dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The ID of the Droplet that the floating IP will be assigned to.
     *
     * @return dropletId
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getDropletId() {
        return dropletId;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDropletId(Integer dropletId) {
        this.dropletId = dropletId;
    }

    /**
     * Return true if this floating_ip_action_assign object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatingIpActionAssign floatingIpActionAssign = (FloatingIpActionAssign) o;
        return Objects.equals(this.dropletId, floatingIpActionAssign.dropletId) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FloatingIpActionAssign {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    dropletId: ").append(toIndentedString(dropletId)).append("\n");
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

    static {
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("assign", FloatingIpActionAssign.class);
        mappings.put("unassign", FloatingIpActionUnassign.class);
        mappings.put("floating_ip_action_assign", FloatingIpActionAssign.class);
        JSON.registerDiscriminator(FloatingIpActionAssign.class, "type", mappings);
    }
}