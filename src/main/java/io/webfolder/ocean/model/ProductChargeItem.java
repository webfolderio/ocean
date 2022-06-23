package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProductChargeItem
 */
@JsonPropertyOrder({ ProductChargeItem.JSON_PROPERTY_AMOUNT, ProductChargeItem.JSON_PROPERTY_NAME,
        ProductChargeItem.JSON_PROPERTY_COUNT })
public class ProductChargeItem {
    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_COUNT = "count";
    private String count;

    public ProductChargeItem() {
    }

    public ProductChargeItem amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount of the charge
     *
     * @return amount
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAmount() {
        return amount;
    }

    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ProductChargeItem name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Description of the charge
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

    public ProductChargeItem count(String count) {
        this.count = count;
        return this;
    }

    /**
     * Number of times the charge was applied
     *
     * @return count
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCount() {
        return count;
    }

    @JsonProperty(JSON_PROPERTY_COUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * Return true if this product_charge_item object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductChargeItem productChargeItem = (ProductChargeItem) o;
        return Objects.equals(this.amount, productChargeItem.amount)
                && Objects.equals(this.name, productChargeItem.name)
                && Objects.equals(this.count, productChargeItem.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, name, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductChargeItem {\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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