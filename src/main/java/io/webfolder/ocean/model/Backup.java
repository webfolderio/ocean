package io.webfolder.ocean.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * Backup
 */
@JsonPropertyOrder({ Backup.JSON_PROPERTY_CREATED_AT, Backup.JSON_PROPERTY_SIZE_GIGABYTES })
public class Backup {
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_SIZE_GIGABYTES = "size_gigabytes";
    private BigDecimal sizeGigabytes;

    public Backup() {
    }

    public Backup createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format at which the
     * backup was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "2019-01-31T19:25:22Z", required = true, value = "A time value given in ISO8601 combined date and time format at which the backup was created.")
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Backup sizeGigabytes(BigDecimal sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
        return this;
    }

    /**
     * The size of the database backup in GBs.
     *
     * @return sizeGigabytes
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "0.03364864", required = true, value = "The size of the database backup in GBs.")
    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public BigDecimal getSizeGigabytes() {
        return sizeGigabytes;
    }

    @JsonProperty(JSON_PROPERTY_SIZE_GIGABYTES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizeGigabytes(BigDecimal sizeGigabytes) {
        this.sizeGigabytes = sizeGigabytes;
    }

    /**
     * Return true if this backup object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Backup backup = (Backup) o;
        return Objects.equals(this.createdAt, backup.createdAt)
                && Objects.equals(this.sizeGigabytes, backup.sizeGigabytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, sizeGigabytes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Backup {\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    sizeGigabytes: ").append(toIndentedString(sizeGigabytes)).append("\n");
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
