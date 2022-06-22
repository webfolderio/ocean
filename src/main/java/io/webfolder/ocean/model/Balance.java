package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Balance
 */
@JsonPropertyOrder({ Balance.JSON_PROPERTY_MONTH_TO_DATE_BALANCE, Balance.JSON_PROPERTY_ACCOUNT_BALANCE,
        Balance.JSON_PROPERTY_MONTH_TO_DATE_USAGE, Balance.JSON_PROPERTY_GENERATED_AT })
public class Balance {
    public static final String JSON_PROPERTY_MONTH_TO_DATE_BALANCE = "month_to_date_balance";
    private String monthToDateBalance;

    public static final String JSON_PROPERTY_ACCOUNT_BALANCE = "account_balance";
    private String accountBalance;

    public static final String JSON_PROPERTY_MONTH_TO_DATE_USAGE = "month_to_date_usage";
    private String monthToDateUsage;

    public static final String JSON_PROPERTY_GENERATED_AT = "generated_at";
    private OffsetDateTime generatedAt;

    public Balance() {
    }

    public Balance monthToDateBalance(String monthToDateBalance) {
        this.monthToDateBalance = monthToDateBalance;
        return this;
    }

    /**
     * Balance as of the &#x60;generated_at&#x60; time. This value includes the
     * &#x60;account_balance&#x60; and &#x60;month_to_date_usage&#x60;.
     *
     * @return monthToDateBalance
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MONTH_TO_DATE_BALANCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMonthToDateBalance() {
        return monthToDateBalance;
    }

    @JsonProperty(JSON_PROPERTY_MONTH_TO_DATE_BALANCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMonthToDateBalance(String monthToDateBalance) {
        this.monthToDateBalance = monthToDateBalance;
    }

    public Balance accountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
        return this;
    }

    /**
     * Current balance of the customer&#39;s most recent billing activity. Does not
     * reflect &#x60;month_to_date_usage&#x60;.
     *
     * @return accountBalance
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACCOUNT_BALANCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAccountBalance() {
        return accountBalance;
    }

    @JsonProperty(JSON_PROPERTY_ACCOUNT_BALANCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Balance monthToDateUsage(String monthToDateUsage) {
        this.monthToDateUsage = monthToDateUsage;
        return this;
    }

    /**
     * Amount used in the current billing period as of the &#x60;generated_at&#x60;
     * time.
     *
     * @return monthToDateUsage
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MONTH_TO_DATE_USAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMonthToDateUsage() {
        return monthToDateUsage;
    }

    @JsonProperty(JSON_PROPERTY_MONTH_TO_DATE_USAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMonthToDateUsage(String monthToDateUsage) {
        this.monthToDateUsage = monthToDateUsage;
    }

    public Balance generatedAt(OffsetDateTime generatedAt) {
        this.generatedAt = generatedAt;
        return this;
    }

    /**
     * The time at which balances were most recently generated.
     *
     * @return generatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GENERATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getGeneratedAt() {
        return generatedAt;
    }

    @JsonProperty(JSON_PROPERTY_GENERATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGeneratedAt(OffsetDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    /**
     * Return true if this balance object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Balance balance = (Balance) o;
        return Objects.equals(this.monthToDateBalance, balance.monthToDateBalance)
                && Objects.equals(this.accountBalance, balance.accountBalance)
                && Objects.equals(this.monthToDateUsage, balance.monthToDateUsage)
                && Objects.equals(this.generatedAt, balance.generatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthToDateBalance, accountBalance, monthToDateUsage, generatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Balance {\n");
        sb.append("    monthToDateBalance: ").append(toIndentedString(monthToDateBalance)).append("\n");
        sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
        sb.append("    monthToDateUsage: ").append(toIndentedString(monthToDateUsage)).append("\n");
        sb.append("    generatedAt: ").append(toIndentedString(generatedAt)).append("\n");
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
