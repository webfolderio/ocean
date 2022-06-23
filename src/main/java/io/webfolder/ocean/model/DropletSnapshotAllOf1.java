package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * DropletSnapshotAllOf1
 */
@JsonPropertyOrder({ DropletSnapshotAllOf1.JSON_PROPERTY_TYPE })
public class DropletSnapshotAllOf1 {
    /**
     * Describes the kind of image. It may be one of &#x60;snapshot&#x60; or
     * &#x60;backup&#x60;. This specifies whether an image is a user-generated
     * Droplet snapshot or automatically created Droplet backup.
     */
    public enum TypeEnum {
        SNAPSHOT("snapshot"),

        BACKUP("backup");

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

    public DropletSnapshotAllOf1() {
    }

    public DropletSnapshotAllOf1 type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Describes the kind of image. It may be one of &#x60;snapshot&#x60; or
     * &#x60;backup&#x60;. This specifies whether an image is a user-generated
     * Droplet snapshot or automatically created Droplet backup.
     *
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Return true if this droplet_snapshot_allOf_1 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DropletSnapshotAllOf1 dropletSnapshotAllOf1 = (DropletSnapshotAllOf1) o;
        return Objects.equals(this.type, dropletSnapshotAllOf1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DropletSnapshotAllOf1 {\n");
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