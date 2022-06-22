package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListDropletBackupsResponseAllOf
 */
@JsonPropertyOrder({ ListDropletBackupsResponseAllOf.JSON_PROPERTY_BACKUPS })
public class ListDropletBackupsResponseAllOf {
    public static final String JSON_PROPERTY_BACKUPS = "backups";
    private List<DropletSnapshot> backups = null;

    public ListDropletBackupsResponseAllOf() {
    }

    public ListDropletBackupsResponseAllOf backups(List<DropletSnapshot> backups) {
        this.backups = backups;
        return this;
    }

    public ListDropletBackupsResponseAllOf addBackupsItem(DropletSnapshot backupsItem) {
        if (this.backups == null) {
            this.backups = new ArrayList<>();
        }
        this.backups.add(backupsItem);
        return this;
    }

    /**
     * Get backups
     *
     * @return backups
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DropletSnapshot> getBackups() {
        return backups;
    }

    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackups(List<DropletSnapshot> backups) {
        this.backups = backups;
    }

    /**
     * Return true if this list_droplet_backups_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletBackupsResponseAllOf listDropletBackupsResponseAllOf = (ListDropletBackupsResponseAllOf) o;
        return Objects.equals(this.backups, listDropletBackupsResponseAllOf.backups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletBackupsResponseAllOf {\n");
        sb.append("    backups: ").append(toIndentedString(backups)).append("\n");
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
