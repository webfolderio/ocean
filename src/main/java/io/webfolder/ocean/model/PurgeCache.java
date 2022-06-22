package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * PurgeCache
 */
@JsonPropertyOrder({ PurgeCache.JSON_PROPERTY_FILES })
public class PurgeCache {
    public static final String JSON_PROPERTY_FILES = "files";
    private List<String> files = new ArrayList<>();

    public PurgeCache() {
    }

    public PurgeCache files(List<String> files) {
        this.files = files;
        return this;
    }

    public PurgeCache addFilesItem(String filesItem) {
        this.files.add(filesItem);
        return this;
    }

    /**
     * An array of strings containing the path to the content to be purged from the
     * CDN cache.
     *
     * @return files
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "[\"path/to/image.png\",\"path/to/css/_*\"]", required = true, value = "An array of strings containing the path to the content to be purged from the CDN cache.")
    @JsonProperty(JSON_PROPERTY_FILES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getFiles() {
        return files;
    }

    @JsonProperty(JSON_PROPERTY_FILES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFiles(List<String> files) {
        this.files = files;
    }

    /**
     * Return true if this purge_cache object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurgeCache purgeCache = (PurgeCache) o;
        return Objects.equals(this.files, purgeCache.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(files);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PurgeCache {\n");
        sb.append("    files: ").append(toIndentedString(files)).append("\n");
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
