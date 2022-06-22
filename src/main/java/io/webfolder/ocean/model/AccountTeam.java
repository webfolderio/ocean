package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * When authorized in a team context, includes information about the current
 * team.
 */
@ApiModel(description = "When authorized in a team context, includes information about the current team.")
@JsonPropertyOrder({ AccountTeam.JSON_PROPERTY_UUID, AccountTeam.JSON_PROPERTY_NAME })
public class AccountTeam {
    public static final String JSON_PROPERTY_UUID = "uuid";
    private String uuid;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public AccountTeam() {
    }

    public AccountTeam uuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * The unique universal identifier for the current team.
     *
     * @return uuid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "5df3e3004a17e242b7c20ca6c9fc25b701a47ece", value = "The unique universal identifier for the current team.")
    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUuid() {
        return uuid;
    }

    @JsonProperty(JSON_PROPERTY_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AccountTeam name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name for the current team.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "My Team", value = "The name for the current team.")
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

    /**
     * Return true if this account_team object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountTeam accountTeam = (AccountTeam) o;
        return Objects.equals(this.uuid, accountTeam.uuid) && Objects.equals(this.name, accountTeam.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountTeam {\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
