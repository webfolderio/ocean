package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppStaticSiteSpecAllOf
 */
@JsonPropertyOrder({ AppStaticSiteSpecAllOf.JSON_PROPERTY_INDEX_DOCUMENT,
        AppStaticSiteSpecAllOf.JSON_PROPERTY_ERROR_DOCUMENT, AppStaticSiteSpecAllOf.JSON_PROPERTY_CATCHALL_DOCUMENT,
        AppStaticSiteSpecAllOf.JSON_PROPERTY_OUTPUT_DIR, AppStaticSiteSpecAllOf.JSON_PROPERTY_CORS,
        AppStaticSiteSpecAllOf.JSON_PROPERTY_ROUTES })
public class AppStaticSiteSpecAllOf {
    public static final String JSON_PROPERTY_INDEX_DOCUMENT = "index_document";
    private String indexDocument = "index.html";

    public static final String JSON_PROPERTY_ERROR_DOCUMENT = "error_document";
    private String errorDocument = "404.html";

    public static final String JSON_PROPERTY_CATCHALL_DOCUMENT = "catchall_document";
    private String catchallDocument;

    public static final String JSON_PROPERTY_OUTPUT_DIR = "output_dir";
    private String outputDir;

    public static final String JSON_PROPERTY_CORS = "cors";
    private AppsCorsPolicy cors;

    public static final String JSON_PROPERTY_ROUTES = "routes";
    private List<AppRouteSpec> routes = null;

    public AppStaticSiteSpecAllOf() {
    }

    public AppStaticSiteSpecAllOf indexDocument(String indexDocument) {
        this.indexDocument = indexDocument;
        return this;
    }

    /**
     * The name of the index document to use when serving this static site. Default:
     * index.html
     *
     * @return indexDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INDEX_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getIndexDocument() {
        return indexDocument;
    }

    @JsonProperty(JSON_PROPERTY_INDEX_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIndexDocument(String indexDocument) {
        this.indexDocument = indexDocument;
    }

    public AppStaticSiteSpecAllOf errorDocument(String errorDocument) {
        this.errorDocument = errorDocument;
        return this;
    }

    /**
     * The name of the error document to use when serving this static site. Default:
     * 404.html. If no such file exists within the built assets, App Platform will
     * supply one.
     *
     * @return errorDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getErrorDocument() {
        return errorDocument;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorDocument(String errorDocument) {
        this.errorDocument = errorDocument;
    }

    public AppStaticSiteSpecAllOf catchallDocument(String catchallDocument) {
        this.catchallDocument = catchallDocument;
        return this;
    }

    /**
     * The name of the document to use as the fallback for any requests to documents
     * that are not found when serving this static site. Only 1 of
     * &#x60;catchall_document&#x60; or &#x60;error_document&#x60; can be set.
     *
     * @return catchallDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CATCHALL_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCatchallDocument() {
        return catchallDocument;
    }

    @JsonProperty(JSON_PROPERTY_CATCHALL_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCatchallDocument(String catchallDocument) {
        this.catchallDocument = catchallDocument;
    }

    public AppStaticSiteSpecAllOf outputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    /**
     * An optional path to where the built assets will be located, relative to the
     * build context. If not set, App Platform will automatically scan for these
     * directory names: &#x60;_static&#x60;, &#x60;dist&#x60;, &#x60;public&#x60;,
     * &#x60;build&#x60;.
     *
     * @return outputDir
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OUTPUT_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOutputDir() {
        return outputDir;
    }

    @JsonProperty(JSON_PROPERTY_OUTPUT_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public AppStaticSiteSpecAllOf cors(AppsCorsPolicy cors) {
        this.cors = cors;
        return this;
    }

    /**
     * Get cors
     *
     * @return cors
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsCorsPolicy getCors() {
        return cors;
    }

    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCors(AppsCorsPolicy cors) {
        this.cors = cors;
    }

    public AppStaticSiteSpecAllOf routes(List<AppRouteSpec> routes) {
        this.routes = routes;
        return this;
    }

    public AppStaticSiteSpecAllOf addRoutesItem(AppRouteSpec routesItem) {
        if (this.routes == null) {
            this.routes = new ArrayList<>();
        }
        this.routes.add(routesItem);
        return this;
    }

    /**
     * A list of HTTP routes that should be routed to this component.
     *
     * @return routes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppRouteSpec> getRoutes() {
        return routes;
    }

    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoutes(List<AppRouteSpec> routes) {
        this.routes = routes;
    }

    /**
     * Return true if this app_static_site_spec_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppStaticSiteSpecAllOf appStaticSiteSpecAllOf = (AppStaticSiteSpecAllOf) o;
        return Objects.equals(this.indexDocument, appStaticSiteSpecAllOf.indexDocument)
                && Objects.equals(this.errorDocument, appStaticSiteSpecAllOf.errorDocument)
                && Objects.equals(this.catchallDocument, appStaticSiteSpecAllOf.catchallDocument)
                && Objects.equals(this.outputDir, appStaticSiteSpecAllOf.outputDir)
                && Objects.equals(this.cors, appStaticSiteSpecAllOf.cors)
                && Objects.equals(this.routes, appStaticSiteSpecAllOf.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexDocument, errorDocument, catchallDocument, outputDir, cors, routes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppStaticSiteSpecAllOf {\n");
        sb.append("    indexDocument: ").append(toIndentedString(indexDocument)).append("\n");
        sb.append("    errorDocument: ").append(toIndentedString(errorDocument)).append("\n");
        sb.append("    catchallDocument: ").append(toIndentedString(catchallDocument)).append("\n");
        sb.append("    outputDir: ").append(toIndentedString(outputDir)).append("\n");
        sb.append("    cors: ").append(toIndentedString(cors)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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