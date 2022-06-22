package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListUsersResponse
 */
@JsonPropertyOrder({ ListUsersResponse.JSON_PROPERTY_USERS })
public class ListUsersResponse {
    public static final String JSON_PROPERTY_USERS = "users";
    private List<DatabaseUser> users = null;

    public ListUsersResponse() {
    }

    public ListUsersResponse users(List<DatabaseUser> users) {
        this.users = users;
        return this;
    }

    public ListUsersResponse addUsersItem(DatabaseUser usersItem) {
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        this.users.add(usersItem);
        return this;
    }

    /**
     * Get users
     *
     * @return users
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DatabaseUser> getUsers() {
        return users;
    }

    @JsonProperty(JSON_PROPERTY_USERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsers(List<DatabaseUser> users) {
        this.users = users;
    }

    /**
     * Return true if this list_users_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListUsersResponse listUsersResponse = (ListUsersResponse) o;
        return Objects.equals(this.users, listUsersResponse.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListUsersResponse {\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
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
