package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateVpcResponse
 */
@JsonPropertyOrder({ CreateVpcResponse.JSON_PROPERTY_VPC })
public class CreateVpcResponse {
    public static final String JSON_PROPERTY_VPC = "vpc";
    private Vpc vpc;

    public CreateVpcResponse() {
    }

    public CreateVpcResponse vpc(Vpc vpc) {
        this.vpc = vpc;
        return this;
    }

    /**
     * Get vpc
     *
     * @return vpc
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VPC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Vpc getVpc() {
        return vpc;
    }

    @JsonProperty(JSON_PROPERTY_VPC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVpc(Vpc vpc) {
        this.vpc = vpc;
    }

    /**
     * Return true if this create_vpc_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateVpcResponse createVpcResponse = (CreateVpcResponse) o;
        return Objects.equals(this.vpc, createVpcResponse.vpc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vpc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateVpcResponse {\n");
        sb.append("    vpc: ").append(toIndentedString(vpc)).append("\n");
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
