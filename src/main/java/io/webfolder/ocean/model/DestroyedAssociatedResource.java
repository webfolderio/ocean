package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An object containing information about a resource scheduled for deletion.
 */
@JsonPropertyOrder({ DestroyedAssociatedResource.JSON_PROPERTY_ID, DestroyedAssociatedResource.JSON_PROPERTY_NAME,
        DestroyedAssociatedResource.JSON_PROPERTY_DESTROYED_AT,
        DestroyedAssociatedResource.JSON_PROPERTY_ERROR_MESSAGE })
public class DestroyedAssociatedResource {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESTROYED_AT = "destroyed_at";
    private OffsetDateTime destroyedAt;

    public static final String JSON_PROPERTY_ERROR_MESSAGE = "error_message";
    private String errorMessage;

    public DestroyedAssociatedResource() {
    }

    public DestroyedAssociatedResource id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The unique identifier for the resource scheduled for deletion.
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

    public DestroyedAssociatedResource name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the resource scheduled for deletion.
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

    public DestroyedAssociatedResource destroyedAt(OffsetDateTime destroyedAt) {
        this.destroyedAt = destroyedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format indicating when
     * the resource was destroyed if the request was successful.
     *
     * @return destroyedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESTROYED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public OffsetDateTime getDestroyedAt() {
        return destroyedAt;
    }

    @JsonProperty(JSON_PROPERTY_DESTROYED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDestroyedAt(OffsetDateTime destroyedAt) {
        this.destroyedAt = destroyedAt;
    }

    public DestroyedAssociatedResource errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * A string indicating that the resource was not successfully destroyed and
     * providing additional information.
     *
     * @return errorMessage
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Return true if this destroyed_associated_resource object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DestroyedAssociatedResource destroyedAssociatedResource = (DestroyedAssociatedResource) o;
        return Objects.equals(this.id, destroyedAssociatedResource.id)
                && Objects.equals(this.name, destroyedAssociatedResource.name)
                && Objects.equals(this.destroyedAt, destroyedAssociatedResource.destroyedAt)
                && Objects.equals(this.errorMessage, destroyedAssociatedResource.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, destroyedAt, errorMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DestroyedAssociatedResource {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    destroyedAt: ").append(toIndentedString(destroyedAt)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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