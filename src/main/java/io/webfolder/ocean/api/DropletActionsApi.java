package io.webfolder.ocean.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.Pair;
import io.webfolder.ocean.model.GetActionResponse;
import io.webfolder.ocean.model.ListAllActionsResponse;
import io.webfolder.ocean.model.PostDropletActionByTagRequest;
import io.webfolder.ocean.model.PostDropletActionByTagResponse;
import io.webfolder.ocean.model.PostDropletActionRequest;

public class DropletActionsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public DropletActionsApi() {
        this(new ApiClient());
    }

    public DropletActionsApi(ApiClient apiClient) {
        memberVarHttpClient = apiClient.getHttpClient();
        memberVarObjectMapper = apiClient.getObjectMapper();
        memberVarBaseUri = apiClient.getBaseUri();
        memberVarInterceptor = apiClient.getRequestInterceptor();
        memberVarReadTimeout = apiClient.getReadTimeout();
        memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    }

    protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
        String body = response.body() == null ? null : new String(response.body().readAllBytes());
        String message = formatExceptionMessage(operationId, response.statusCode(), body);
        return new ApiException(response.statusCode(), message, response.headers(), body);
    }

    private String formatExceptionMessage(String operationId, int statusCode, String body) {
        if (body == null || body.isEmpty()) {
            body = "[no body]";
        }
        return operationId + " call failed with: " + statusCode + " - " + body;
    }

    /**
     * Retrieve a Droplet Action To retrieve a Droplet action, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/actions/$ACTION_ID&#x60;. The response will be
     * a JSON object with a key called &#x60;action&#x60;. The value will be a
     * Droplet action object.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param actionId  A unique numeric ID that can be used to identify and
     *                  reference an action. (required)
     * @return GetActionResponse
     * @throws ApiException if fails to make API call
     */
    public GetActionResponse getDropletAction(Integer dropletId, Integer actionId) {
        ApiResponse<GetActionResponse> localVarResponse = getDropletActionWithHttpInfo(dropletId, actionId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve a Droplet Action To retrieve a Droplet action, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/actions/$ACTION_ID&#x60;. The response will be
     * a JSON object with a key called &#x60;action&#x60;. The value will be a
     * Droplet action object.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param actionId  A unique numeric ID that can be used to identify and
     *                  reference an action. (required)
     * @return ApiResponse&lt;GetActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetActionResponse> getDropletActionWithHttpInfo(Integer dropletId, Integer actionId) {
        HttpRequest.Builder localVarRequestBuilder = getDropletActionRequestBuilder(dropletId, actionId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletAction", localVarResponse);
                }
                return new ApiResponse<GetActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetActionResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getDropletActionRequestBuilder(Integer dropletId, Integer actionId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling getDropletAction");
        }
        // verify the required parameter 'actionId' is set
        if (actionId == null) {
            throw new ApiException(400, "Missing the required parameter 'actionId' when calling getDropletAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/actions/{action_id}"
                .replace("{droplet_id}", ApiClient.urlEncode(dropletId.toString()))
                .replace("{action_id}", ApiClient.urlEncode(actionId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * List Actions for a Droplet To retrieve a list of all actions that have been
     * executed for a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/actions&#x60;. The results will be returned as
     * a JSON object with an &#x60;actions&#x60; key. This will be set to an array
     * filled with &#x60;action&#x60; objects containing the standard
     * &#x60;action&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ListAllActionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllActionsResponse listDropletActions(Integer dropletId, Integer perPage, Integer page) {
        ApiResponse<ListAllActionsResponse> localVarResponse = listDropletActionsWithHttpInfo(dropletId, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List Actions for a Droplet To retrieve a list of all actions that have been
     * executed for a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/actions&#x60;. The results will be returned as
     * a JSON object with an &#x60;actions&#x60; key. This will be set to an array
     * filled with &#x60;action&#x60; objects containing the standard
     * &#x60;action&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ApiResponse&lt;ListAllActionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllActionsResponse> listDropletActionsWithHttpInfo(Integer dropletId, Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listDropletActionsRequestBuilder(dropletId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletActions", localVarResponse);
                }
                return new ApiResponse<ListAllActionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllActionsResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder listDropletActionsRequestBuilder(Integer dropletId, Integer perPage, Integer page) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletActions");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/actions".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Initiate a Droplet Action To initiate an action on a Droplet send a POST
     * request to &#x60;/v2/droplets/$DROPLET_ID/actions&#x60;. In the JSON body to
     * the request, set the &#x60;type&#x60; attribute to on of the supported action
     * types: | Action | Details | | ---------------------------------------- |
     * ----------- | | &lt;nobr&gt;&#x60;enable_backups&#x60;&lt;/nobr&gt; | Enables
     * backups for a Droplet | |
     * &lt;nobr&gt;&#x60;disable_backups&#x60;&lt;/nobr&gt; | Disables backups for a
     * Droplet | | &lt;nobr&gt;&#x60;reboot&#x60;&lt;/nobr&gt; | Reboots a Droplet.
     * A &#x60;reboot&#x60; action is an attempt to reboot the Droplet in a graceful
     * way, similar to using the &#x60;reboot&#x60; command from the console. | |
     * &lt;nobr&gt;&#x60;power_cycle&#x60;&lt;/nobr&gt; | Power cycles a Droplet. A
     * &#x60;powercycle&#x60; action is similar to pushing the reset button on a
     * physical machine, it&#39;s similar to booting from scratch. | |
     * &lt;nobr&gt;&#x60;shutdown&#x60;&lt;/nobr&gt; | Shutsdown a Droplet. A
     * shutdown action is an attempt to shutdown the Droplet in a graceful way,
     * similar to using the &#x60;shutdown&#x60; command from the console. Since a
     * &#x60;shutdown&#x60; command can fail, this action guarantees that the
     * command is issued, not that it succeeds. The preferred way to turn off a
     * Droplet is to attempt a shutdown, with a reasonable timeout, followed by a
     * &#x60;power_off&#x60; action to ensure the Droplet is off. | |
     * &lt;nobr&gt;&#x60;power_off&#x60;&lt;/nobr&gt; | Powers off a Droplet. A
     * &#x60;power_off&#x60; event is a hard shutdown and should only be used if the
     * &#x60;shutdown&#x60; action is not successful. It is similar to cutting the
     * power on a server and could lead to complications. | |
     * &lt;nobr&gt;&#x60;power_on&#x60;&lt;/nobr&gt; | Powers on a Droplet. | |
     * &lt;nobr&gt;&#x60;restore&#x60;&lt;/nobr&gt; | Restore a Droplet using a
     * backup image. The image ID that is passed in must be a backup of the current
     * Droplet instance. The operation will leave any embedded SSH keys intact. | |
     * &lt;nobr&gt;&#x60;password_reset&#x60;&lt;/nobr&gt; | Resets the root
     * password for a Droplet. A new password will be provided via email. It must be
     * changed after first use. | | &lt;nobr&gt;&#x60;resize&#x60;&lt;/nobr&gt; |
     * Resizes a Droplet. Set the &#x60;size&#x60; attribute to a size slug. If a
     * permanent resize with disk changes included is desired, set the
     * &#x60;disk&#x60; attribute to &#x60;true&#x60;. | |
     * &lt;nobr&gt;&#x60;rebuild&#x60;&lt;/nobr&gt; | Rebuilds a Droplet from a new
     * base image. Set the &#x60;image&#x60; attribute to an image ID or slug. | |
     * &lt;nobr&gt;&#x60;rename&#x60;&lt;/nobr&gt; | Renames a Droplet. | |
     * &lt;nobr&gt;&#x60;change_kernel&#x60;&lt;/nobr&gt; | Changes a Droplet&#39;s
     * kernel. Only applies to Droplets with externally managed kernels. All
     * Droplets created after March 2017 use internal kernels by default. | |
     * &lt;nobr&gt;&#x60;enable_ipv6&#x60;&lt;/nobr&gt; | Enables IPv6 for a
     * Droplet. | | &lt;nobr&gt;&#x60;snapshot&#x60;&lt;/nobr&gt; | Takes a snapshot
     * of a Droplet. |
     *
     * @param dropletId                A unique identifier for a Droplet instance.
     *                                 (required)
     * @param postDropletActionRequest The &#x60;type&#x60; attribute set in the
     *                                 request body will specify the action that
     *                                 will be taken on the Droplet. Some actions
     *                                 will require additional attributes to be set
     *                                 as well. (optional)
     * @return GetActionResponse
     * @throws ApiException if fails to make API call
     */
    public GetActionResponse postDropletAction(Integer dropletId, PostDropletActionRequest postDropletActionRequest) {
        ApiResponse<GetActionResponse> localVarResponse = postDropletActionWithHttpInfo(dropletId,
                postDropletActionRequest);
        return localVarResponse.getData();
    }

    /**
     * Initiate a Droplet Action To initiate an action on a Droplet send a POST
     * request to &#x60;/v2/droplets/$DROPLET_ID/actions&#x60;. In the JSON body to
     * the request, set the &#x60;type&#x60; attribute to on of the supported action
     * types: | Action | Details | | ---------------------------------------- |
     * ----------- | | &lt;nobr&gt;&#x60;enable_backups&#x60;&lt;/nobr&gt; | Enables
     * backups for a Droplet | |
     * &lt;nobr&gt;&#x60;disable_backups&#x60;&lt;/nobr&gt; | Disables backups for a
     * Droplet | | &lt;nobr&gt;&#x60;reboot&#x60;&lt;/nobr&gt; | Reboots a Droplet.
     * A &#x60;reboot&#x60; action is an attempt to reboot the Droplet in a graceful
     * way, similar to using the &#x60;reboot&#x60; command from the console. | |
     * &lt;nobr&gt;&#x60;power_cycle&#x60;&lt;/nobr&gt; | Power cycles a Droplet. A
     * &#x60;powercycle&#x60; action is similar to pushing the reset button on a
     * physical machine, it&#39;s similar to booting from scratch. | |
     * &lt;nobr&gt;&#x60;shutdown&#x60;&lt;/nobr&gt; | Shutsdown a Droplet. A
     * shutdown action is an attempt to shutdown the Droplet in a graceful way,
     * similar to using the &#x60;shutdown&#x60; command from the console. Since a
     * &#x60;shutdown&#x60; command can fail, this action guarantees that the
     * command is issued, not that it succeeds. The preferred way to turn off a
     * Droplet is to attempt a shutdown, with a reasonable timeout, followed by a
     * &#x60;power_off&#x60; action to ensure the Droplet is off. | |
     * &lt;nobr&gt;&#x60;power_off&#x60;&lt;/nobr&gt; | Powers off a Droplet. A
     * &#x60;power_off&#x60; event is a hard shutdown and should only be used if the
     * &#x60;shutdown&#x60; action is not successful. It is similar to cutting the
     * power on a server and could lead to complications. | |
     * &lt;nobr&gt;&#x60;power_on&#x60;&lt;/nobr&gt; | Powers on a Droplet. | |
     * &lt;nobr&gt;&#x60;restore&#x60;&lt;/nobr&gt; | Restore a Droplet using a
     * backup image. The image ID that is passed in must be a backup of the current
     * Droplet instance. The operation will leave any embedded SSH keys intact. | |
     * &lt;nobr&gt;&#x60;password_reset&#x60;&lt;/nobr&gt; | Resets the root
     * password for a Droplet. A new password will be provided via email. It must be
     * changed after first use. | | &lt;nobr&gt;&#x60;resize&#x60;&lt;/nobr&gt; |
     * Resizes a Droplet. Set the &#x60;size&#x60; attribute to a size slug. If a
     * permanent resize with disk changes included is desired, set the
     * &#x60;disk&#x60; attribute to &#x60;true&#x60;. | |
     * &lt;nobr&gt;&#x60;rebuild&#x60;&lt;/nobr&gt; | Rebuilds a Droplet from a new
     * base image. Set the &#x60;image&#x60; attribute to an image ID or slug. | |
     * &lt;nobr&gt;&#x60;rename&#x60;&lt;/nobr&gt; | Renames a Droplet. | |
     * &lt;nobr&gt;&#x60;change_kernel&#x60;&lt;/nobr&gt; | Changes a Droplet&#39;s
     * kernel. Only applies to Droplets with externally managed kernels. All
     * Droplets created after March 2017 use internal kernels by default. | |
     * &lt;nobr&gt;&#x60;enable_ipv6&#x60;&lt;/nobr&gt; | Enables IPv6 for a
     * Droplet. | | &lt;nobr&gt;&#x60;snapshot&#x60;&lt;/nobr&gt; | Takes a snapshot
     * of a Droplet. |
     *
     * @param dropletId                A unique identifier for a Droplet instance.
     *                                 (required)
     * @param postDropletActionRequest The &#x60;type&#x60; attribute set in the
     *                                 request body will specify the action that
     *                                 will be taken on the Droplet. Some actions
     *                                 will require additional attributes to be set
     *                                 as well. (optional)
     * @return ApiResponse&lt;GetActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetActionResponse> postDropletActionWithHttpInfo(Integer dropletId,
            PostDropletActionRequest postDropletActionRequest) {
        HttpRequest.Builder localVarRequestBuilder = postDropletActionRequestBuilder(dropletId,
                postDropletActionRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postDropletAction", localVarResponse);
                }
                return new ApiResponse<GetActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetActionResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder postDropletActionRequestBuilder(Integer dropletId,
            PostDropletActionRequest postDropletActionRequest) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling postDropletAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/actions".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postDropletActionRequest);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Acting on Tagged Droplets Some actions can be performed in bulk on tagged
     * Droplets. The actions can be initiated by sending a POST to
     * &#x60;/v2/droplets/actions?tag_name&#x3D;$TAG_NAME&#x60; with the action
     * arguments. Only a sub-set of action types are supported: -
     * &#x60;power_cycle&#x60; - &#x60;power_on&#x60; - &#x60;power_off&#x60; -
     * &#x60;shutdown&#x60; - &#x60;enable_ipv6&#x60; - &#x60;enable_backups&#x60; -
     * &#x60;disable_backups&#x60; - &#x60;snapshot&#x60;
     *
     * @param tagName                       Used to filter Droplets by a specific
     *                                      tag. (optional)
     * @param postDropletActionByTagRequest The &#x60;type&#x60; attribute set in
     *                                      the request body will specify the action
     *                                      that will be taken on the Droplet. Some
     *                                      actions will require additional
     *                                      attributes to be set as well. (optional)
     * @return PostDropletActionByTagResponse
     * @throws ApiException if fails to make API call
     */
    public PostDropletActionByTagResponse postDropletActionByTag(String tagName,
            PostDropletActionByTagRequest postDropletActionByTagRequest) {
        ApiResponse<PostDropletActionByTagResponse> localVarResponse = postDropletActionByTagWithHttpInfo(tagName,
                postDropletActionByTagRequest);
        return localVarResponse.getData();
    }

    /**
     * Acting on Tagged Droplets Some actions can be performed in bulk on tagged
     * Droplets. The actions can be initiated by sending a POST to
     * &#x60;/v2/droplets/actions?tag_name&#x3D;$TAG_NAME&#x60; with the action
     * arguments. Only a sub-set of action types are supported: -
     * &#x60;power_cycle&#x60; - &#x60;power_on&#x60; - &#x60;power_off&#x60; -
     * &#x60;shutdown&#x60; - &#x60;enable_ipv6&#x60; - &#x60;enable_backups&#x60; -
     * &#x60;disable_backups&#x60; - &#x60;snapshot&#x60;
     *
     * @param tagName                       Used to filter Droplets by a specific
     *                                      tag. (optional)
     * @param postDropletActionByTagRequest The &#x60;type&#x60; attribute set in
     *                                      the request body will specify the action
     *                                      that will be taken on the Droplet. Some
     *                                      actions will require additional
     *                                      attributes to be set as well. (optional)
     * @return ApiResponse&lt;PostDropletActionByTagResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostDropletActionByTagResponse> postDropletActionByTagWithHttpInfo(String tagName,
            PostDropletActionByTagRequest postDropletActionByTagRequest) {
        HttpRequest.Builder localVarRequestBuilder = postDropletActionByTagRequestBuilder(tagName,
                postDropletActionByTagRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postDropletActionByTag", localVarResponse);
                }
                return new ApiResponse<PostDropletActionByTagResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostDropletActionByTagResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder postDropletActionByTagRequestBuilder(String tagName,
            PostDropletActionByTagRequest postDropletActionByTagRequest) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/actions";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("tag_name", tagName));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postDropletActionByTagRequest);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }
}
