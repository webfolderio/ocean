package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsListInstanceSizesResponse
 */
@JsonPropertyOrder({ AppsListInstanceSizesResponse.JSON_PROPERTY_DISCOUNT_PERCENT,
        AppsListInstanceSizesResponse.JSON_PROPERTY_INSTANCE_SIZES })
public class AppsListInstanceSizesResponse {
    public static final String JSON_PROPERTY_DISCOUNT_PERCENT = "discount_percent";
    private Float discountPercent;

    public static final String JSON_PROPERTY_INSTANCE_SIZES = "instance_sizes";
    private List<AppsInstanceSize> instanceSizes = null;

    public AppsListInstanceSizesResponse() {
    }

    public AppsListInstanceSizesResponse discountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    /**
     * Get discountPercent
     *
     * @return discountPercent
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISCOUNT_PERCENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Float getDiscountPercent() {
        return discountPercent;
    }

    @JsonProperty(JSON_PROPERTY_DISCOUNT_PERCENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public AppsListInstanceSizesResponse instanceSizes(List<AppsInstanceSize> instanceSizes) {
        this.instanceSizes = instanceSizes;
        return this;
    }

    public AppsListInstanceSizesResponse addInstanceSizesItem(AppsInstanceSize instanceSizesItem) {
        if (this.instanceSizes == null) {
            this.instanceSizes = new ArrayList<>();
        }
        this.instanceSizes.add(instanceSizesItem);
        return this;
    }

    /**
     * Get instanceSizes
     *
     * @return instanceSizes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppsInstanceSize> getInstanceSizes() {
        return instanceSizes;
    }

    @JsonProperty(JSON_PROPERTY_INSTANCE_SIZES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInstanceSizes(List<AppsInstanceSize> instanceSizes) {
        this.instanceSizes = instanceSizes;
    }

    /**
     * Return true if this apps_list_instance_sizes_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsListInstanceSizesResponse appsListInstanceSizesResponse = (AppsListInstanceSizesResponse) o;
        return Objects.equals(this.discountPercent, appsListInstanceSizesResponse.discountPercent)
                && Objects.equals(this.instanceSizes, appsListInstanceSizesResponse.instanceSizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountPercent, instanceSizes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsListInstanceSizesResponse {\n");
        sb.append("    discountPercent: ").append(toIndentedString(discountPercent)).append("\n");
        sb.append("    instanceSizes: ").append(toIndentedString(instanceSizes)).append("\n");
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