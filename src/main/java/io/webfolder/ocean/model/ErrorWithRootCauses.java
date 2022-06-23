package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ErrorWithRootCauses
 */
@JsonPropertyOrder({ ErrorWithRootCauses.JSON_PROPERTY_ERROR, ErrorWithRootCauses.JSON_PROPERTY_MESSAGES,
        ErrorWithRootCauses.JSON_PROPERTY_ROOT_CAUSES })
public class ErrorWithRootCauses {
    public static final String JSON_PROPERTY_ERROR = "error";
    private String error;

    public static final String JSON_PROPERTY_MESSAGES = "messages";
    private List<String> messages = null;

    public static final String JSON_PROPERTY_ROOT_CAUSES = "root_causes";
    private List<String> rootCauses = new ArrayList<>();

    public ErrorWithRootCauses() {
    }

    public ErrorWithRootCauses error(String error) {
        this.error = error;
        return this;
    }

    /**
     * A message providing information about the error.
     *
     * @return error
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ERROR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getError() {
        return error;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setError(String error) {
        this.error = error;
    }

    public ErrorWithRootCauses messages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    public ErrorWithRootCauses addMessagesItem(String messagesItem) {
        if (this.messages == null) {
            this.messages = new ArrayList<>();
        }
        this.messages.add(messagesItem);
        return this;
    }

    /**
     * A list of legacy error messages.
     *
     * @return messages
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getMessages() {
        return messages;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public ErrorWithRootCauses rootCauses(List<String> rootCauses) {
        this.rootCauses = rootCauses;
        return this;
    }

    public ErrorWithRootCauses addRootCausesItem(String rootCausesItem) {
        this.rootCauses.add(rootCausesItem);
        return this;
    }

    /**
     * A list of underlying causes for the error, including details to help resolve
     * it when possible.
     *
     * @return rootCauses
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ROOT_CAUSES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getRootCauses() {
        return rootCauses;
    }

    @JsonProperty(JSON_PROPERTY_ROOT_CAUSES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRootCauses(List<String> rootCauses) {
        this.rootCauses = rootCauses;
    }

    /**
     * Return true if this error_with_root_causes object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorWithRootCauses errorWithRootCauses = (ErrorWithRootCauses) o;
        return Objects.equals(this.error, errorWithRootCauses.error)
                && Objects.equals(this.messages, errorWithRootCauses.messages)
                && Objects.equals(this.rootCauses, errorWithRootCauses.rootCauses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, messages, rootCauses);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorWithRootCauses {\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
        sb.append("    rootCauses: ").append(toIndentedString(rootCauses)).append("\n");
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