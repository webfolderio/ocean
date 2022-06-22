package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetUserInformationResponse
 */
@JsonPropertyOrder({ GetUserInformationResponse.JSON_PROPERTY_ACCOUNT })
public class GetUserInformationResponse {
    public static final String JSON_PROPERTY_ACCOUNT = "account";
    private Account account;

    public GetUserInformationResponse() {
    }

    public GetUserInformationResponse account(Account account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     *
     * @return account
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ACCOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Account getAccount() {
        return account;
    }

    @JsonProperty(JSON_PROPERTY_ACCOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Return true if this get_user_information_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetUserInformationResponse getUserInformationResponse = (GetUserInformationResponse) o;
        return Objects.equals(this.account, getUserInformationResponse.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUserInformationResponse {\n");
        sb.append("    account: ").append(toIndentedString(account)).append("\n");
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
