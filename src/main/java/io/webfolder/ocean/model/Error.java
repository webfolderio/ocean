package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Error
 */
@JsonPropertyOrder({ Error.JSON_PROPERTY_ID, Error.JSON_PROPERTY_MESSAGE, Error.JSON_PROPERTY_REQUEST_ID })
public class Error {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_REQUEST_ID = "request_id";
    private String requestId;

    public Error() {
    }

    public Error id(String id) {
        this.id = id;
        return this;
    }

    /**
     * A short identifier corresponding to the HTTP status code returned. For
     * example, the ID for a response returning a 404 status code would be
     * \&quot;not_found.\&quot;
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(String id) {
        this.id = id;
    }

    public Error message(String message) {
        this.message = message;
        return this;
    }

    /**
     * A message providing additional information about the error, including details
     * to help resolve it when possible.
     *
     * @return message
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getMessage() {
        return message;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMessage(String message) {
        this.message = message;
    }

    public Error requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Optionally, some endpoints may include a request ID that should be provided
     * when reporting bugs or opening support tickets to help identify the issue.
     *
     * @return requestId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REQUEST_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty(JSON_PROPERTY_REQUEST_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Return true if this error object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(this.id, error.id) && Objects.equals(this.message, error.message)
                && Objects.equals(this.requestId, error.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, requestId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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