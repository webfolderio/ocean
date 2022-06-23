package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * BillingHistory
 */
@JsonPropertyOrder({ BillingHistory.JSON_PROPERTY_DESCRIPTION, BillingHistory.JSON_PROPERTY_AMOUNT,
        BillingHistory.JSON_PROPERTY_INVOICE_ID, BillingHistory.JSON_PROPERTY_INVOICE_UUID,
        BillingHistory.JSON_PROPERTY_DATE, BillingHistory.JSON_PROPERTY_TYPE })
public class BillingHistory {
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_AMOUNT = "amount";
    private String amount;

    public static final String JSON_PROPERTY_INVOICE_ID = "invoice_id";
    private String invoiceId;

    public static final String JSON_PROPERTY_INVOICE_UUID = "invoice_uuid";
    private String invoiceUuid;

    public static final String JSON_PROPERTY_DATE = "date";
    private OffsetDateTime date;

    /**
     * Type of billing history entry.
     */
    public enum TypeEnum {
        ACHFAILURE("ACHFailure"),

        ADJUSTMENT("Adjustment"),

        ATTEMPTFAILED("AttemptFailed"),

        CHARGEBACK("Chargeback"),

        CREDIT("Credit"),

        CREDITEXPIRATION("CreditExpiration"),

        INVOICE("Invoice"),

        PAYMENT("Payment"),

        REFUND("Refund"),

        REVERSAL("Reversal");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public BillingHistory() {
    }

    public BillingHistory description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the billing history entry.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public BillingHistory amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Amount of the billing history entry.
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

    public BillingHistory invoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    /**
     * ID of the invoice associated with the billing history entry, if applicable.
     *
     * @return invoiceId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INVOICE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BillingHistory invoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
        return this;
    }

    /**
     * UUID of the invoice associated with the billing history entry, if applicable.
     *
     * @return invoiceUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INVOICE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    @JsonProperty(JSON_PROPERTY_INVOICE_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }

    public BillingHistory date(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Time the billing history entry occured.
     *
     * @return date
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getDate() {
        return date;
    }

    @JsonProperty(JSON_PROPERTY_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public BillingHistory type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of billing history entry.
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Return true if this billing_history object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BillingHistory billingHistory = (BillingHistory) o;
        return Objects.equals(this.description, billingHistory.description)
                && Objects.equals(this.amount, billingHistory.amount)
                && Objects.equals(this.invoiceId, billingHistory.invoiceId)
                && Objects.equals(this.invoiceUuid, billingHistory.invoiceUuid)
                && Objects.equals(this.date, billingHistory.date) && Objects.equals(this.type, billingHistory.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, amount, invoiceId, invoiceUuid, date, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BillingHistory {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
        sb.append("    invoiceUuid: ").append(toIndentedString(invoiceUuid)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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