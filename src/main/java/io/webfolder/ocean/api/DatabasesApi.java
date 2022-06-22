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
import java.util.UUID;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.Pair;
import io.webfolder.ocean.model.AddConnectionPoolResponse;
import io.webfolder.ocean.model.AddDatabaseResponse;
import io.webfolder.ocean.model.AddUserResponse;
import io.webfolder.ocean.model.ConnectionPool;
import io.webfolder.ocean.model.ConnectionPools;
import io.webfolder.ocean.model.CreateDatabaseClusterRequest;
import io.webfolder.ocean.model.CreateDatabaseClusterResponse;
import io.webfolder.ocean.model.CreateReplicaRequest;
import io.webfolder.ocean.model.CreateReplicaResponse;
import io.webfolder.ocean.model.Database;
import io.webfolder.ocean.model.DatabaseClusterResize;
import io.webfolder.ocean.model.DatabaseConfig;
import io.webfolder.ocean.model.DatabaseMaintenanceWindow;
import io.webfolder.ocean.model.DatabaseUser;
import io.webfolder.ocean.model.EvictionPolicy;
import io.webfolder.ocean.model.GetCaResponse;
import io.webfolder.ocean.model.GetDatabaseConfigResponse;
import io.webfolder.ocean.model.ListDatabaseBackupsResponse;
import io.webfolder.ocean.model.ListDatabaseClustersResponse;
import io.webfolder.ocean.model.ListDatabaseFirewallsResponse;
import io.webfolder.ocean.model.ListDatabasesResponse;
import io.webfolder.ocean.model.ListReplicasResponse;
import io.webfolder.ocean.model.ListUsersResponse;
import io.webfolder.ocean.model.OnlineMigration;
import io.webfolder.ocean.model.ResetAuthRequest;
import io.webfolder.ocean.model.SourceDatabase;
import io.webfolder.ocean.model.SqlMode;
import io.webfolder.ocean.model.UpdateDatabaseClusterRequest;
import io.webfolder.ocean.model.UpdateDatabaseFirewallRequest;

public class DatabasesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public DatabasesApi() {
        this(new ApiClient());
    }

    public DatabasesApi(ApiClient apiClient) {
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
     * Add a New Connection Pool (PostgreSQL) For PostgreSQL database clusters,
     * connection pools can be used to allow a database to share its idle
     * connections. The popular PostgreSQL connection pooling utility PgBouncer is
     * used to provide this service. [See here for more
     * information](https://www.digitalocean.com/docs/databases/postgresql/how-to/manage-connection-pools/)
     * about how and why to use PgBouncer connection pooling including details about
     * the available transaction modes. To add a new connection pool to a PostgreSQL
     * database cluster, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/pools&#x60; specifying a name for the pool,
     * the user to connect with, the database to connect to, as well as its desired
     * size and transaction mode.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param connectionPool      (required)
     * @return AddConnectionPoolResponse
     * @throws ApiException if fails to make API call
     */
    public AddConnectionPoolResponse addConnectionPool(UUID databaseClusterUuid, ConnectionPool connectionPool) {
        ApiResponse<AddConnectionPoolResponse> localVarResponse = addConnectionPoolWithHttpInfo(databaseClusterUuid,
                connectionPool);
        return localVarResponse.getData();
    }

    /**
     * Add a New Connection Pool (PostgreSQL) For PostgreSQL database clusters,
     * connection pools can be used to allow a database to share its idle
     * connections. The popular PostgreSQL connection pooling utility PgBouncer is
     * used to provide this service. [See here for more
     * information](https://www.digitalocean.com/docs/databases/postgresql/how-to/manage-connection-pools/)
     * about how and why to use PgBouncer connection pooling including details about
     * the available transaction modes. To add a new connection pool to a PostgreSQL
     * database cluster, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/pools&#x60; specifying a name for the pool,
     * the user to connect with, the database to connect to, as well as its desired
     * size and transaction mode.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param connectionPool      (required)
     * @return ApiResponse&lt;AddConnectionPoolResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddConnectionPoolResponse> addConnectionPoolWithHttpInfo(UUID databaseClusterUuid,
            ConnectionPool connectionPool) {
        HttpRequest.Builder localVarRequestBuilder = addConnectionPoolRequestBuilder(databaseClusterUuid,
                connectionPool);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addConnectionPool", localVarResponse);
                }
                return new ApiResponse<AddConnectionPoolResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AddConnectionPoolResponse>() {
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

    private HttpRequest.Builder addConnectionPoolRequestBuilder(UUID databaseClusterUuid,
            ConnectionPool connectionPool) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling addConnectionPool");
        }
        // verify the required parameter 'connectionPool' is set
        if (connectionPool == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'connectionPool' when calling addConnectionPool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/pools".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(connectionPool);
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
     * Add a New Database To add a new database to an existing cluster, send a POST
     * request to &#x60;/v2/databases/$DATABASE_ID/dbs&#x60;. Note: Database
     * management is not supported for Redis clusters. The response will be a JSON
     * object with a key called &#x60;db&#x60;. The value of this will be an object
     * that contains the standard attributes associated with a database.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param database            (required)
     * @return AddDatabaseResponse
     * @throws ApiException if fails to make API call
     */
    public AddDatabaseResponse addDatabase(UUID databaseClusterUuid, Database database) {
        ApiResponse<AddDatabaseResponse> localVarResponse = addDatabaseWithHttpInfo(databaseClusterUuid, database);
        return localVarResponse.getData();
    }

    /**
     * Add a New Database To add a new database to an existing cluster, send a POST
     * request to &#x60;/v2/databases/$DATABASE_ID/dbs&#x60;. Note: Database
     * management is not supported for Redis clusters. The response will be a JSON
     * object with a key called &#x60;db&#x60;. The value of this will be an object
     * that contains the standard attributes associated with a database.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param database            (required)
     * @return ApiResponse&lt;AddDatabaseResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddDatabaseResponse> addDatabaseWithHttpInfo(UUID databaseClusterUuid, Database database) {
        HttpRequest.Builder localVarRequestBuilder = addDatabaseRequestBuilder(databaseClusterUuid, database);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addDatabase", localVarResponse);
                }
                return new ApiResponse<AddDatabaseResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AddDatabaseResponse>() {
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

    private HttpRequest.Builder addDatabaseRequestBuilder(UUID databaseClusterUuid, Database database) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling addDatabase");
        }
        // verify the required parameter 'database' is set
        if (database == null) {
            throw new ApiException(400, "Missing the required parameter 'database' when calling addDatabase");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/dbs".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(database);
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
     * Add a Database User To add a new database user, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/users&#x60; with the desired username. Note:
     * User management is not supported for Redis clusters. When adding a user to a
     * MySQL cluster, additional options can be configured in the
     * &#x60;mysql_settings&#x60; object. The response will be a JSON object with a
     * key called &#x60;user&#x60;. The value of this will be an object that
     * contains the standard attributes associated with a database user including
     * its randomly generated password.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseUser        (required)
     * @return AddUserResponse
     * @throws ApiException if fails to make API call
     */
    public AddUserResponse addUser(UUID databaseClusterUuid, DatabaseUser databaseUser) {
        ApiResponse<AddUserResponse> localVarResponse = addUserWithHttpInfo(databaseClusterUuid, databaseUser);
        return localVarResponse.getData();
    }

    /**
     * Add a Database User To add a new database user, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/users&#x60; with the desired username. Note:
     * User management is not supported for Redis clusters. When adding a user to a
     * MySQL cluster, additional options can be configured in the
     * &#x60;mysql_settings&#x60; object. The response will be a JSON object with a
     * key called &#x60;user&#x60;. The value of this will be an object that
     * contains the standard attributes associated with a database user including
     * its randomly generated password.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseUser        (required)
     * @return ApiResponse&lt;AddUserResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddUserResponse> addUserWithHttpInfo(UUID databaseClusterUuid, DatabaseUser databaseUser) {
        HttpRequest.Builder localVarRequestBuilder = addUserRequestBuilder(databaseClusterUuid, databaseUser);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addUser", localVarResponse);
                }
                return new ApiResponse<AddUserResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AddUserResponse>() {
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

    private HttpRequest.Builder addUserRequestBuilder(UUID databaseClusterUuid, DatabaseUser databaseUser) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling addUser");
        }
        // verify the required parameter 'databaseUser' is set
        if (databaseUser == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseUser' when calling addUser");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/users".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(databaseUser);
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
     * Create a New Database Cluster To create a database cluster, send a POST
     * request to &#x60;/v2/databases&#x60;. The response will be a JSON object with
     * a key called &#x60;database&#x60;. The value of this will be an object that
     * contains the standard attributes associated with a database cluster. The
     * initial value of the database cluster&#39;s &#x60;status&#x60; attribute will
     * be &#x60;creating&#x60;. When the cluster is ready to receive traffic, this
     * will transition to &#x60;online&#x60;. The embedded &#x60;connection&#x60;
     * and &#x60;private_connection&#x60; objects will contain the information
     * needed to access the database cluster. DigitalOcean managed PostgreSQL and
     * MySQL database clusters take automated daily backups. To create a new
     * database cluster based on a backup of an exising cluster, send a POST request
     * to &#x60;/v2/databases&#x60;. In addition to the standard database cluster
     * attributes, the JSON body must include a key named &#x60;backup_restore&#x60;
     * with the name of the original database cluster and the timestamp of the
     * backup to be restored. Creating a database from a backup is the same as
     * forking a database in the control panel. Note: Backups are not supported for
     * Redis clusters.
     *
     * @param createDatabaseClusterRequest (required)
     * @return CreateDatabaseClusterResponse
     * @throws ApiException if fails to make API call
     */
    public CreateDatabaseClusterResponse createDatabaseCluster(
            CreateDatabaseClusterRequest createDatabaseClusterRequest) {
        ApiResponse<CreateDatabaseClusterResponse> localVarResponse = createDatabaseClusterWithHttpInfo(
                createDatabaseClusterRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Database Cluster To create a database cluster, send a POST
     * request to &#x60;/v2/databases&#x60;. The response will be a JSON object with
     * a key called &#x60;database&#x60;. The value of this will be an object that
     * contains the standard attributes associated with a database cluster. The
     * initial value of the database cluster&#39;s &#x60;status&#x60; attribute will
     * be &#x60;creating&#x60;. When the cluster is ready to receive traffic, this
     * will transition to &#x60;online&#x60;. The embedded &#x60;connection&#x60;
     * and &#x60;private_connection&#x60; objects will contain the information
     * needed to access the database cluster. DigitalOcean managed PostgreSQL and
     * MySQL database clusters take automated daily backups. To create a new
     * database cluster based on a backup of an exising cluster, send a POST request
     * to &#x60;/v2/databases&#x60;. In addition to the standard database cluster
     * attributes, the JSON body must include a key named &#x60;backup_restore&#x60;
     * with the name of the original database cluster and the timestamp of the
     * backup to be restored. Creating a database from a backup is the same as
     * forking a database in the control panel. Note: Backups are not supported for
     * Redis clusters.
     *
     * @param createDatabaseClusterRequest (required)
     * @return ApiResponse&lt;CreateDatabaseClusterResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateDatabaseClusterResponse> createDatabaseClusterWithHttpInfo(
            CreateDatabaseClusterRequest createDatabaseClusterRequest) {
        HttpRequest.Builder localVarRequestBuilder = createDatabaseClusterRequestBuilder(createDatabaseClusterRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createDatabaseCluster", localVarResponse);
                }
                return new ApiResponse<CreateDatabaseClusterResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateDatabaseClusterResponse>() {
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

    private HttpRequest.Builder createDatabaseClusterRequestBuilder(
            CreateDatabaseClusterRequest createDatabaseClusterRequest) {
        // verify the required parameter 'createDatabaseClusterRequest' is set
        if (createDatabaseClusterRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'createDatabaseClusterRequest' when calling createDatabaseCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createDatabaseClusterRequest);
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
     * Create a Read-only Replica To create a read-only replica for a PostgreSQL or
     * MySQL database cluster, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas&#x60; specifying the name it should
     * be given, the size of the node to be used, and the region where it will be
     * located. **Note**: Read-only replicas are not supported for Redis clusters.
     * The response will be a JSON object with a key called &#x60;replica&#x60;. The
     * value of this will be an object that contains the standard attributes
     * associated with a database replica. The initial value of the read-only
     * replica&#39;s &#x60;status&#x60; attribute will be &#x60;forking&#x60;. When
     * the replica is ready to receive traffic, this will transition to
     * &#x60;active&#x60;.
     *
     * @param databaseClusterUuid  A unique identifier for a database cluster.
     *                             (required)
     * @param createReplicaRequest (optional)
     * @return CreateReplicaResponse
     * @throws ApiException if fails to make API call
     */
    public CreateReplicaResponse createReplica(UUID databaseClusterUuid, CreateReplicaRequest createReplicaRequest) {
        ApiResponse<CreateReplicaResponse> localVarResponse = createReplicaWithHttpInfo(databaseClusterUuid,
                createReplicaRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a Read-only Replica To create a read-only replica for a PostgreSQL or
     * MySQL database cluster, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas&#x60; specifying the name it should
     * be given, the size of the node to be used, and the region where it will be
     * located. **Note**: Read-only replicas are not supported for Redis clusters.
     * The response will be a JSON object with a key called &#x60;replica&#x60;. The
     * value of this will be an object that contains the standard attributes
     * associated with a database replica. The initial value of the read-only
     * replica&#39;s &#x60;status&#x60; attribute will be &#x60;forking&#x60;. When
     * the replica is ready to receive traffic, this will transition to
     * &#x60;active&#x60;.
     *
     * @param databaseClusterUuid  A unique identifier for a database cluster.
     *                             (required)
     * @param createReplicaRequest (optional)
     * @return ApiResponse&lt;CreateReplicaResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateReplicaResponse> createReplicaWithHttpInfo(UUID databaseClusterUuid,
            CreateReplicaRequest createReplicaRequest) {
        HttpRequest.Builder localVarRequestBuilder = createReplicaRequestBuilder(databaseClusterUuid,
                createReplicaRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createReplica", localVarResponse);
                }
                return new ApiResponse<CreateReplicaResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateReplicaResponse>() {
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

    private HttpRequest.Builder createReplicaRequestBuilder(UUID databaseClusterUuid,
            CreateReplicaRequest createReplicaRequest) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling createReplica");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/replicas".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createReplicaRequest);
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
     * Delete a Connection Pool (PostgreSQL) To delete a specific connection pool
     * for a PostgreSQL database cluster, send a DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/pools/$POOL_NAME&#x60;. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param poolName            The name used to identify the connection pool.
     *                            (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteConnectionPool(UUID databaseClusterUuid, String poolName) {
        deleteConnectionPoolWithHttpInfo(databaseClusterUuid, poolName);
    }

    /**
     * Delete a Connection Pool (PostgreSQL) To delete a specific connection pool
     * for a PostgreSQL database cluster, send a DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/pools/$POOL_NAME&#x60;. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param poolName            The name used to identify the connection pool.
     *                            (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteConnectionPoolWithHttpInfo(UUID databaseClusterUuid, String poolName) {
        HttpRequest.Builder localVarRequestBuilder = deleteConnectionPoolRequestBuilder(databaseClusterUuid, poolName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteConnectionPool", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteConnectionPoolRequestBuilder(UUID databaseClusterUuid, String poolName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling deleteConnectionPool");
        }
        // verify the required parameter 'poolName' is set
        if (poolName == null) {
            throw new ApiException(400, "Missing the required parameter 'poolName' when calling deleteConnectionPool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/pools/{pool_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{pool_name}", ApiClient.urlEncode(poolName.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Delete a Database To delete a specific database, send a DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/dbs/$DB_NAME&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed. Note: Database management is not supported for
     * Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseName        The name of the database. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteDatabase(UUID databaseClusterUuid, String databaseName) {
        deleteDatabaseWithHttpInfo(databaseClusterUuid, databaseName);
    }

    /**
     * Delete a Database To delete a specific database, send a DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/dbs/$DB_NAME&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed. Note: Database management is not supported for
     * Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseName        The name of the database. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteDatabaseWithHttpInfo(UUID databaseClusterUuid, String databaseName) {
        HttpRequest.Builder localVarRequestBuilder = deleteDatabaseRequestBuilder(databaseClusterUuid, databaseName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteDatabase", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteDatabaseRequestBuilder(UUID databaseClusterUuid, String databaseName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling deleteDatabase");
        }
        // verify the required parameter 'databaseName' is set
        if (databaseName == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseName' when calling deleteDatabase");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/dbs/{database_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{database_name}", ApiClient.urlEncode(databaseName.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Stop an Online Migration To stop an online migration, send a DELETE request
     * to &#x60;/v2/databases/$DATABASE_ID/online-migration/$MIGRATION_ID&#x60;. A
     * status of 204 will be given. This indicates that the request was processed
     * successfully, but that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param migrationId         A unique identifier assigned to the online
     *                            migration. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteOnlineMigration(UUID databaseClusterUuid, String migrationId) {
        deleteOnlineMigrationWithHttpInfo(databaseClusterUuid, migrationId);
    }

    /**
     * Stop an Online Migration To stop an online migration, send a DELETE request
     * to &#x60;/v2/databases/$DATABASE_ID/online-migration/$MIGRATION_ID&#x60;. A
     * status of 204 will be given. This indicates that the request was processed
     * successfully, but that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param migrationId         A unique identifier assigned to the online
     *                            migration. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteOnlineMigrationWithHttpInfo(UUID databaseClusterUuid, String migrationId) {
        HttpRequest.Builder localVarRequestBuilder = deleteOnlineMigrationRequestBuilder(databaseClusterUuid,
                migrationId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteOnlineMigration", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteOnlineMigrationRequestBuilder(UUID databaseClusterUuid, String migrationId) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling deleteOnlineMigration");
        }
        // verify the required parameter 'migrationId' is set
        if (migrationId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'migrationId' when calling deleteOnlineMigration");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/online-migration/{migration_id}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{migration_id}", ApiClient.urlEncode(migrationId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Remove a Database User To remove a specific database user, send a DELETE
     * request to &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME&#x60;. A status
     * of 204 will be given. This indicates that the request was processed
     * successfully, but that no response body is needed. Note: User management is
     * not supported for Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteUser(UUID databaseClusterUuid, String username) {
        deleteUserWithHttpInfo(databaseClusterUuid, username);
    }

    /**
     * Remove a Database User To remove a specific database user, send a DELETE
     * request to &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME&#x60;. A status
     * of 204 will be given. This indicates that the request was processed
     * successfully, but that no response body is needed. Note: User management is
     * not supported for Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteUserWithHttpInfo(UUID databaseClusterUuid, String username) {
        HttpRequest.Builder localVarRequestBuilder = deleteUserRequestBuilder(databaseClusterUuid, username);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteUser", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteUserRequestBuilder(UUID databaseClusterUuid, String username) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling deleteUser");
        }
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException(400, "Missing the required parameter 'username' when calling deleteUser");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/users/{username}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{username}", ApiClient.urlEncode(username.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Destroy a Database Cluster To destroy a specific database, send a DELETE
     * request to &#x60;/v2/databases/$DATABASE_ID&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyCluster(UUID databaseClusterUuid) {
        destroyClusterWithHttpInfo(databaseClusterUuid);
    }

    /**
     * Destroy a Database Cluster To destroy a specific database, send a DELETE
     * request to &#x60;/v2/databases/$DATABASE_ID&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyClusterWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = destroyClusterRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyCluster", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder destroyClusterRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling destroyCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Destroy a Read-only Replica To destroy a specific read-only replica, send a
     * DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas/$REPLICA_NAME&#x60;. **Note**:
     * Read-only replicas are not supported for Redis clusters. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param replicaName         The name of the database replica. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyReplica(UUID databaseClusterUuid, String replicaName) {
        destroyReplicaWithHttpInfo(databaseClusterUuid, replicaName);
    }

    /**
     * Destroy a Read-only Replica To destroy a specific read-only replica, send a
     * DELETE request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas/$REPLICA_NAME&#x60;. **Note**:
     * Read-only replicas are not supported for Redis clusters. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param replicaName         The name of the database replica. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyReplicaWithHttpInfo(UUID databaseClusterUuid, String replicaName) {
        HttpRequest.Builder localVarRequestBuilder = destroyReplicaRequestBuilder(databaseClusterUuid, replicaName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyReplica", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder destroyReplicaRequestBuilder(UUID databaseClusterUuid, String replicaName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling destroyReplica");
        }
        // verify the required parameter 'replicaName' is set
        if (replicaName == null) {
            throw new ApiException(400, "Missing the required parameter 'replicaName' when calling destroyReplica");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/replicas/{replica_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{replica_name}", ApiClient.urlEncode(replicaName.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve the Public Certificate To retrieve the public certificate used to
     * secure the connection to the database cluster send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/ca&#x60;. The response will be a JSON object
     * with a &#x60;ca&#x60; key. This will be set to an object containing the
     * base64 encoding of the public key certificate.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return GetCaResponse
     * @throws ApiException if fails to make API call
     */
    public GetCaResponse getCa(UUID databaseClusterUuid) {
        ApiResponse<GetCaResponse> localVarResponse = getCaWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve the Public Certificate To retrieve the public certificate used to
     * secure the connection to the database cluster send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/ca&#x60;. The response will be a JSON object
     * with a &#x60;ca&#x60; key. This will be set to an object containing the
     * base64 encoding of the public key certificate.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;GetCaResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetCaResponse> getCaWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getCaRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getCa", localVarResponse);
                }
                return new ApiResponse<GetCaResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetCaResponse>() {
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

    private HttpRequest.Builder getCaRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling getCa");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/ca".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve Existing Connection Pool (PostgreSQL) To show information about an
     * existing connection pool for a PostgreSQL database cluster, send a GET
     * request to &#x60;/v2/databases/$DATABASE_ID/pools/$POOL_NAME&#x60;. The
     * response will be a JSON object with a &#x60;pool&#x60; key.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param poolName            The name used to identify the connection pool.
     *                            (required)
     * @return AddConnectionPoolResponse
     * @throws ApiException if fails to make API call
     */
    public AddConnectionPoolResponse getConnectionPool(UUID databaseClusterUuid, String poolName) {
        ApiResponse<AddConnectionPoolResponse> localVarResponse = getConnectionPoolWithHttpInfo(databaseClusterUuid,
                poolName);
        return localVarResponse.getData();
    }

    /**
     * Retrieve Existing Connection Pool (PostgreSQL) To show information about an
     * existing connection pool for a PostgreSQL database cluster, send a GET
     * request to &#x60;/v2/databases/$DATABASE_ID/pools/$POOL_NAME&#x60;. The
     * response will be a JSON object with a &#x60;pool&#x60; key.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param poolName            The name used to identify the connection pool.
     *                            (required)
     * @return ApiResponse&lt;AddConnectionPoolResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddConnectionPoolResponse> getConnectionPoolWithHttpInfo(UUID databaseClusterUuid,
            String poolName) {
        HttpRequest.Builder localVarRequestBuilder = getConnectionPoolRequestBuilder(databaseClusterUuid, poolName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getConnectionPool", localVarResponse);
                }
                return new ApiResponse<AddConnectionPoolResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AddConnectionPoolResponse>() {
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

    private HttpRequest.Builder getConnectionPoolRequestBuilder(UUID databaseClusterUuid, String poolName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getConnectionPool");
        }
        // verify the required parameter 'poolName' is set
        if (poolName == null) {
            throw new ApiException(400, "Missing the required parameter 'poolName' when calling getConnectionPool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/pools/{pool_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{pool_name}", ApiClient.urlEncode(poolName.toString()));

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
     * Retrieve an Existing Database To show information about an existing database
     * cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/dbs/$DB_NAME&#x60;. Note: Database
     * management is not supported for Redis clusters. The response will be a JSON
     * object with a &#x60;db&#x60; key. This will be set to an object containing
     * the standard database attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseName        The name of the database. (required)
     * @return AddDatabaseResponse
     * @throws ApiException if fails to make API call
     */
    public AddDatabaseResponse getDatabase(UUID databaseClusterUuid, String databaseName) {
        ApiResponse<AddDatabaseResponse> localVarResponse = getDatabaseWithHttpInfo(databaseClusterUuid, databaseName);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Database To show information about an existing database
     * cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/dbs/$DB_NAME&#x60;. Note: Database
     * management is not supported for Redis clusters. The response will be a JSON
     * object with a &#x60;db&#x60; key. This will be set to an object containing
     * the standard database attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseName        The name of the database. (required)
     * @return ApiResponse&lt;AddDatabaseResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddDatabaseResponse> getDatabaseWithHttpInfo(UUID databaseClusterUuid, String databaseName) {
        HttpRequest.Builder localVarRequestBuilder = getDatabaseRequestBuilder(databaseClusterUuid, databaseName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDatabase", localVarResponse);
                }
                return new ApiResponse<AddDatabaseResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AddDatabaseResponse>() {
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

    private HttpRequest.Builder getDatabaseRequestBuilder(UUID databaseClusterUuid, String databaseName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getDatabase");
        }
        // verify the required parameter 'databaseName' is set
        if (databaseName == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseName' when calling getDatabase");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/dbs/{database_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{database_name}", ApiClient.urlEncode(databaseName.toString()));

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
     * Retrieve an Existing Database Cluster To show information about an existing
     * database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID&#x60;. The response will be a JSON object
     * with a database key. This will be set to an object containing the standard
     * database cluster attributes. The embedded connection and private_connection
     * objects will contain the information needed to access the database cluster.
     * The embedded maintenance_window object will contain information about any
     * scheduled maintenance for the database cluster.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return CreateDatabaseClusterResponse
     * @throws ApiException if fails to make API call
     */
    public CreateDatabaseClusterResponse getDatabaseCluster(UUID databaseClusterUuid) {
        ApiResponse<CreateDatabaseClusterResponse> localVarResponse = getDatabaseClusterWithHttpInfo(
                databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Database Cluster To show information about an existing
     * database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID&#x60;. The response will be a JSON object
     * with a database key. This will be set to an object containing the standard
     * database cluster attributes. The embedded connection and private_connection
     * objects will contain the information needed to access the database cluster.
     * The embedded maintenance_window object will contain information about any
     * scheduled maintenance for the database cluster.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;CreateDatabaseClusterResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateDatabaseClusterResponse> getDatabaseClusterWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getDatabaseClusterRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDatabaseCluster", localVarResponse);
                }
                return new ApiResponse<CreateDatabaseClusterResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateDatabaseClusterResponse>() {
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

    private HttpRequest.Builder getDatabaseClusterRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getDatabaseCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve an Existing Database Cluster Configuration Shows configuration
     * parameters for an existing database cluster by sending a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/config&#x60;. The response is a JSON object
     * with a &#x60;config&#x60; key, which is set to an object containing any
     * database configuration parameters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return GetDatabaseConfigResponse
     * @throws ApiException if fails to make API call
     */
    public GetDatabaseConfigResponse getDatabaseConfig(UUID databaseClusterUuid) {
        ApiResponse<GetDatabaseConfigResponse> localVarResponse = getDatabaseConfigWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Database Cluster Configuration Shows configuration
     * parameters for an existing database cluster by sending a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/config&#x60;. The response is a JSON object
     * with a &#x60;config&#x60; key, which is set to an object containing any
     * database configuration parameters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;GetDatabaseConfigResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDatabaseConfigResponse> getDatabaseConfigWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getDatabaseConfigRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDatabaseConfig", localVarResponse);
                }
                return new ApiResponse<GetDatabaseConfigResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDatabaseConfigResponse>() {
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

    private HttpRequest.Builder getDatabaseConfigRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getDatabaseConfig");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/config".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve the Eviction Policy for a Redis Cluster To retrieve the configured
     * eviction policy for an existing Redis cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/eviction_policy&#x60;. The response will be
     * a JSON object with an &#x60;eviction_policy&#x60; key. This will be set to a
     * string representing the eviction policy.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return EvictionPolicy
     * @throws ApiException if fails to make API call
     */
    public EvictionPolicy getEvictionPolicy(UUID databaseClusterUuid) {
        ApiResponse<EvictionPolicy> localVarResponse = getEvictionPolicyWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve the Eviction Policy for a Redis Cluster To retrieve the configured
     * eviction policy for an existing Redis cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/eviction_policy&#x60;. The response will be
     * a JSON object with an &#x60;eviction_policy&#x60; key. This will be set to a
     * string representing the eviction policy.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;EvictionPolicy&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<EvictionPolicy> getEvictionPolicyWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getEvictionPolicyRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getEvictionPolicy", localVarResponse);
                }
                return new ApiResponse<EvictionPolicy>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<EvictionPolicy>() {
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

    private HttpRequest.Builder getEvictionPolicyRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getEvictionPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/eviction_policy".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve the Status of an Online Migration To retrieve the status of an
     * online migration, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/online-migration&#x60;. If a migration has
     * completed, a 200 OK status is returned with no response body.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return OnlineMigration
     * @throws ApiException if fails to make API call
     */
    public OnlineMigration getMigrationStatus(UUID databaseClusterUuid) {
        ApiResponse<OnlineMigration> localVarResponse = getMigrationStatusWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve the Status of an Online Migration To retrieve the status of an
     * online migration, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/online-migration&#x60;. If a migration has
     * completed, a 200 OK status is returned with no response body.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;OnlineMigration&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<OnlineMigration> getMigrationStatusWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getMigrationStatusRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getMigrationStatus", localVarResponse);
                }
                return new ApiResponse<OnlineMigration>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<OnlineMigration>() {
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

    private HttpRequest.Builder getMigrationStatusRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling getMigrationStatus");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/online-migration"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve an Existing Read-only Replica To show information about an existing
     * database replica, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas/$REPLICA_NAME&#x60;. **Note**:
     * Read-only replicas are not supported for Redis clusters. The response will be
     * a JSON object with a &#x60;replica key&#x60;. This will be set to an object
     * containing the standard database replica attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param replicaName         The name of the database replica. (required)
     * @return CreateReplicaResponse
     * @throws ApiException if fails to make API call
     */
    public CreateReplicaResponse getReplica(UUID databaseClusterUuid, String replicaName) {
        ApiResponse<CreateReplicaResponse> localVarResponse = getReplicaWithHttpInfo(databaseClusterUuid, replicaName);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Read-only Replica To show information about an existing
     * database replica, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas/$REPLICA_NAME&#x60;. **Note**:
     * Read-only replicas are not supported for Redis clusters. The response will be
     * a JSON object with a &#x60;replica key&#x60;. This will be set to an object
     * containing the standard database replica attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param replicaName         The name of the database replica. (required)
     * @return ApiResponse&lt;CreateReplicaResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateReplicaResponse> getReplicaWithHttpInfo(UUID databaseClusterUuid, String replicaName) {
        HttpRequest.Builder localVarRequestBuilder = getReplicaRequestBuilder(databaseClusterUuid, replicaName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getReplica", localVarResponse);
                }
                return new ApiResponse<CreateReplicaResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateReplicaResponse>() {
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

    private HttpRequest.Builder getReplicaRequestBuilder(UUID databaseClusterUuid, String replicaName) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling getReplica");
        }
        // verify the required parameter 'replicaName' is set
        if (replicaName == null) {
            throw new ApiException(400, "Missing the required parameter 'replicaName' when calling getReplica");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/replicas/{replica_name}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{replica_name}", ApiClient.urlEncode(replicaName.toString()));

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
     * Retrieve the SQL Modes for a MySQL Cluster To retrieve the configured SQL
     * modes for an existing MySQL cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/sql_mode&#x60;. The response will be a JSON
     * object with a &#x60;sql_mode&#x60; key. This will be set to a string
     * representing the configured SQL modes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return SqlMode
     * @throws ApiException if fails to make API call
     */
    public SqlMode getSqlMode(UUID databaseClusterUuid) {
        ApiResponse<SqlMode> localVarResponse = getSqlModeWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve the SQL Modes for a MySQL Cluster To retrieve the configured SQL
     * modes for an existing MySQL cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/sql_mode&#x60;. The response will be a JSON
     * object with a &#x60;sql_mode&#x60; key. This will be set to a string
     * representing the configured SQL modes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;SqlMode&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<SqlMode> getSqlModeWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = getSqlModeRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getSqlMode", localVarResponse);
                }
                return new ApiResponse<SqlMode>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SqlMode>() {
                        }) // closes the
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

    private HttpRequest.Builder getSqlModeRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling getSqlMode");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/sql_mode".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Retrieve an Existing Database User To show information about an existing
     * database user, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME&#x60;. Note: User management
     * is not supported for Redis clusters. The response will be a JSON object with
     * a &#x60;user&#x60; key. This will be set to an object containing the standard
     * database user attributes. For MySQL clusters, additional options will be
     * contained in the mysql_settings object.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @return AddUserResponse
     * @throws ApiException if fails to make API call
     */
    public AddUserResponse getUser(UUID databaseClusterUuid, String username) {
        ApiResponse<AddUserResponse> localVarResponse = getUserWithHttpInfo(databaseClusterUuid, username);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Database User To show information about an existing
     * database user, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME&#x60;. Note: User management
     * is not supported for Redis clusters. The response will be a JSON object with
     * a &#x60;user&#x60; key. This will be set to an object containing the standard
     * database user attributes. For MySQL clusters, additional options will be
     * contained in the mysql_settings object.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @return ApiResponse&lt;AddUserResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddUserResponse> getUserWithHttpInfo(UUID databaseClusterUuid, String username) {
        HttpRequest.Builder localVarRequestBuilder = getUserRequestBuilder(databaseClusterUuid, username);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getUser", localVarResponse);
                }
                return new ApiResponse<AddUserResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AddUserResponse>() {
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

    private HttpRequest.Builder getUserRequestBuilder(UUID databaseClusterUuid, String username) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling getUser");
        }
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException(400, "Missing the required parameter 'username' when calling getUser");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/users/{username}"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{username}", ApiClient.urlEncode(username.toString()));

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
     * List Connection Pools (PostgreSQL) To list all of the connection pools
     * available to a PostgreSQL database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/pools&#x60;. The result will be a JSON
     * object with a &#x60;pools&#x60; key. This will be set to an array of
     * connection pool objects.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ConnectionPools
     * @throws ApiException if fails to make API call
     */
    public ConnectionPools listConnectionPools(UUID databaseClusterUuid) {
        ApiResponse<ConnectionPools> localVarResponse = listConnectionPoolsWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List Connection Pools (PostgreSQL) To list all of the connection pools
     * available to a PostgreSQL database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/pools&#x60;. The result will be a JSON
     * object with a &#x60;pools&#x60; key. This will be set to an array of
     * connection pool objects.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ConnectionPools&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ConnectionPools> listConnectionPoolsWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listConnectionPoolsRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listConnectionPools", localVarResponse);
                }
                return new ApiResponse<ConnectionPools>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ConnectionPools>() {
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

    private HttpRequest.Builder listConnectionPoolsRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling listConnectionPools");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/pools".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * List Backups for a Database Cluster To list all of the available backups of a
     * PostgreSQL or MySQL database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/backups&#x60;. **Note**: Backups are not
     * supported for Redis clusters. The result will be a JSON object with a
     * &#x60;backups key&#x60;. This will be set to an array of backup objects, each
     * of which will contain the size of the backup and the timestamp at which it
     * was created.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ListDatabaseBackupsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDatabaseBackupsResponse listDatabaseBackups(UUID databaseClusterUuid) {
        ApiResponse<ListDatabaseBackupsResponse> localVarResponse = listDatabaseBackupsWithHttpInfo(
                databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List Backups for a Database Cluster To list all of the available backups of a
     * PostgreSQL or MySQL database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/backups&#x60;. **Note**: Backups are not
     * supported for Redis clusters. The result will be a JSON object with a
     * &#x60;backups key&#x60;. This will be set to an array of backup objects, each
     * of which will contain the size of the backup and the timestamp at which it
     * was created.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ListDatabaseBackupsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDatabaseBackupsResponse> listDatabaseBackupsWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listDatabaseBackupsRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDatabaseBackups", localVarResponse);
                }
                return new ApiResponse<ListDatabaseBackupsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDatabaseBackupsResponse>() {
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

    private HttpRequest.Builder listDatabaseBackupsRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling listDatabaseBackups");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/backups".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * List All Database Clusters To list all of the database clusters available on
     * your account, send a GET request to &#x60;/v2/databases&#x60;. To limit the
     * results to database clusters with a specific tag, include the
     * &#x60;tag_name&#x60; query parameter set to the name of the tag. For example,
     * &#x60;/v2/databases?tag_name&#x3D;$TAG_NAME&#x60;. The result will be a JSON
     * object with a &#x60;databases&#x60; key. This will be set to an array of
     * database objects, each of which will contain the standard database
     * attributes. The embedded &#x60;connection&#x60; and
     * &#x60;private_connection&#x60; objects will contain the information needed to
     * access the database cluster: The embedded &#x60;maintenance_window&#x60;
     * object will contain information about any scheduled maintenance for the
     * database cluster.
     *
     * @param tagName Limits the results to database clusters with a specific tag.
     *                (optional)
     * @return ListDatabaseClustersResponse
     * @throws ApiException if fails to make API call
     */
    public ListDatabaseClustersResponse listDatabaseClusters(String tagName) {
        ApiResponse<ListDatabaseClustersResponse> localVarResponse = listDatabaseClustersWithHttpInfo(tagName);
        return localVarResponse.getData();
    }

    /**
     * List All Database Clusters To list all of the database clusters available on
     * your account, send a GET request to &#x60;/v2/databases&#x60;. To limit the
     * results to database clusters with a specific tag, include the
     * &#x60;tag_name&#x60; query parameter set to the name of the tag. For example,
     * &#x60;/v2/databases?tag_name&#x3D;$TAG_NAME&#x60;. The result will be a JSON
     * object with a &#x60;databases&#x60; key. This will be set to an array of
     * database objects, each of which will contain the standard database
     * attributes. The embedded &#x60;connection&#x60; and
     * &#x60;private_connection&#x60; objects will contain the information needed to
     * access the database cluster: The embedded &#x60;maintenance_window&#x60;
     * object will contain information about any scheduled maintenance for the
     * database cluster.
     *
     * @param tagName Limits the results to database clusters with a specific tag.
     *                (optional)
     * @return ApiResponse&lt;ListDatabaseClustersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDatabaseClustersResponse> listDatabaseClustersWithHttpInfo(String tagName) {
        HttpRequest.Builder localVarRequestBuilder = listDatabaseClustersRequestBuilder(tagName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDatabaseClusters", localVarResponse);
                }
                return new ApiResponse<ListDatabaseClustersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDatabaseClustersResponse>() {
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

    private HttpRequest.Builder listDatabaseClustersRequestBuilder(String tagName) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("tag_name", tagName));

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
     * List Firewall Rules (Trusted Sources) for a Database Cluster To list all of a
     * database cluster&#39;s firewall rules (known as \&quot;trusted sources\&quot;
     * in the control panel), send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/firewall&#x60;. The result will be a JSON
     * object with a &#x60;rules&#x60; key.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ListDatabaseFirewallsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDatabaseFirewallsResponse listDatabaseFirewalls(UUID databaseClusterUuid) {
        ApiResponse<ListDatabaseFirewallsResponse> localVarResponse = listDatabaseFirewallsWithHttpInfo(
                databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List Firewall Rules (Trusted Sources) for a Database Cluster To list all of a
     * database cluster&#39;s firewall rules (known as \&quot;trusted sources\&quot;
     * in the control panel), send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/firewall&#x60;. The result will be a JSON
     * object with a &#x60;rules&#x60; key.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ListDatabaseFirewallsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDatabaseFirewallsResponse> listDatabaseFirewallsWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listDatabaseFirewallsRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDatabaseFirewalls", localVarResponse);
                }
                return new ApiResponse<ListDatabaseFirewallsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDatabaseFirewallsResponse>() {
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

    private HttpRequest.Builder listDatabaseFirewallsRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling listDatabaseFirewalls");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/firewall".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * List All Databases To list all of the databases in a clusters, send a GET
     * request to &#x60;/v2/databases/$DATABASE_ID/dbs&#x60;. The result will be a
     * JSON object with a &#x60;dbs&#x60; key. This will be set to an array of
     * database objects, each of which will contain the standard database
     * attributes. Note: Database management is not supported for Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ListDatabasesResponse
     * @throws ApiException if fails to make API call
     */
    public ListDatabasesResponse listDatabases(UUID databaseClusterUuid) {
        ApiResponse<ListDatabasesResponse> localVarResponse = listDatabasesWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List All Databases To list all of the databases in a clusters, send a GET
     * request to &#x60;/v2/databases/$DATABASE_ID/dbs&#x60;. The result will be a
     * JSON object with a &#x60;dbs&#x60; key. This will be set to an array of
     * database objects, each of which will contain the standard database
     * attributes. Note: Database management is not supported for Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ListDatabasesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDatabasesResponse> listDatabasesWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listDatabasesRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDatabases", localVarResponse);
                }
                return new ApiResponse<ListDatabasesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDatabasesResponse>() {
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

    private HttpRequest.Builder listDatabasesRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling listDatabases");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/dbs".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * List All Read-only Replicas To list all of the read-only replicas associated
     * with a database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas&#x60;. **Note**: Read-only replicas
     * are not supported for Redis clusters. The result will be a JSON object with a
     * &#x60;replicas&#x60; key. This will be set to an array of database replica
     * objects, each of which will contain the standard database replica attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ListReplicasResponse
     * @throws ApiException if fails to make API call
     */
    public ListReplicasResponse listReplicas(UUID databaseClusterUuid) {
        ApiResponse<ListReplicasResponse> localVarResponse = listReplicasWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List All Read-only Replicas To list all of the read-only replicas associated
     * with a database cluster, send a GET request to
     * &#x60;/v2/databases/$DATABASE_ID/replicas&#x60;. **Note**: Read-only replicas
     * are not supported for Redis clusters. The result will be a JSON object with a
     * &#x60;replicas&#x60; key. This will be set to an array of database replica
     * objects, each of which will contain the standard database replica attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ListReplicasResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListReplicasResponse> listReplicasWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listReplicasRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listReplicas", localVarResponse);
                }
                return new ApiResponse<ListReplicasResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListReplicasResponse>() {
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

    private HttpRequest.Builder listReplicasRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling listReplicas");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/replicas".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * List all Database Users To list all of the users for your database cluster,
     * send a GET request to &#x60;/v2/databases/$DATABASE_ID/users&#x60;. Note:
     * User management is not supported for Redis clusters. The result will be a
     * JSON object with a &#x60;users&#x60; key. This will be set to an array of
     * database user objects, each of which will contain the standard database user
     * attributes. For MySQL clusters, additional options will be contained in the
     * mysql_settings object.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ListUsersResponse
     * @throws ApiException if fails to make API call
     */
    public ListUsersResponse listUsers(UUID databaseClusterUuid) {
        ApiResponse<ListUsersResponse> localVarResponse = listUsersWithHttpInfo(databaseClusterUuid);
        return localVarResponse.getData();
    }

    /**
     * List all Database Users To list all of the users for your database cluster,
     * send a GET request to &#x60;/v2/databases/$DATABASE_ID/users&#x60;. Note:
     * User management is not supported for Redis clusters. The result will be a
     * JSON object with a &#x60;users&#x60; key. This will be set to an array of
     * database user objects, each of which will contain the standard database user
     * attributes. For MySQL clusters, additional options will be contained in the
     * mysql_settings object.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @return ApiResponse&lt;ListUsersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListUsersResponse> listUsersWithHttpInfo(UUID databaseClusterUuid) {
        HttpRequest.Builder localVarRequestBuilder = listUsersRequestBuilder(databaseClusterUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listUsers", localVarResponse);
                }
                return new ApiResponse<ListUsersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListUsersResponse>() {
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

    private HttpRequest.Builder listUsersRequestBuilder(UUID databaseClusterUuid) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling listUsers");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/users".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

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
     * Update the Database Configuration for an Existing Database To update the
     * configuration for an existing database cluster, send a PATCH request to
     * &#x60;/v2/databases/$DATABASE_ID/config&#x60;.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseConfig      (required)
     * @throws ApiException if fails to make API call
     */
    public void patchDatabaseConfig(UUID databaseClusterUuid, DatabaseConfig databaseConfig) {
        patchDatabaseConfigWithHttpInfo(databaseClusterUuid, databaseConfig);
    }

    /**
     * Update the Database Configuration for an Existing Database To update the
     * configuration for an existing database cluster, send a PATCH request to
     * &#x60;/v2/databases/$DATABASE_ID/config&#x60;.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param databaseConfig      (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> patchDatabaseConfigWithHttpInfo(UUID databaseClusterUuid, DatabaseConfig databaseConfig) {
        HttpRequest.Builder localVarRequestBuilder = patchDatabaseConfigRequestBuilder(databaseClusterUuid,
                databaseConfig);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("patchDatabaseConfig", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder patchDatabaseConfigRequestBuilder(UUID databaseClusterUuid,
            DatabaseConfig databaseConfig) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling patchDatabaseConfig");
        }
        // verify the required parameter 'databaseConfig' is set
        if (databaseConfig == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseConfig' when calling patchDatabaseConfig");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/config".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(databaseConfig);
            localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Reset a Database User&#39;s Password or Authentication Method To reset the
     * password for a database user, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME/reset_auth&#x60;. For
     * &#x60;mysql&#x60; databases, the authentication method can be specifying by
     * including a key in the JSON body called &#x60;mysql_settings&#x60; with the
     * &#x60;auth_plugin&#x60; value specified. The response will be a JSON object
     * with a &#x60;user&#x60; key. This will be set to an object containing the
     * standard database user attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @param resetAuthRequest    (required)
     * @return AddUserResponse
     * @throws ApiException if fails to make API call
     */
    public AddUserResponse resetAuth(UUID databaseClusterUuid, String username, ResetAuthRequest resetAuthRequest) {
        ApiResponse<AddUserResponse> localVarResponse = resetAuthWithHttpInfo(databaseClusterUuid, username,
                resetAuthRequest);
        return localVarResponse.getData();
    }

    /**
     * Reset a Database User&#39;s Password or Authentication Method To reset the
     * password for a database user, send a POST request to
     * &#x60;/v2/databases/$DATABASE_ID/users/$USERNAME/reset_auth&#x60;. For
     * &#x60;mysql&#x60; databases, the authentication method can be specifying by
     * including a key in the JSON body called &#x60;mysql_settings&#x60; with the
     * &#x60;auth_plugin&#x60; value specified. The response will be a JSON object
     * with a &#x60;user&#x60; key. This will be set to an object containing the
     * standard database user attributes.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param username            The name of the database user. (required)
     * @param resetAuthRequest    (required)
     * @return ApiResponse&lt;AddUserResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddUserResponse> resetAuthWithHttpInfo(UUID databaseClusterUuid, String username,
            ResetAuthRequest resetAuthRequest) {
        HttpRequest.Builder localVarRequestBuilder = resetAuthRequestBuilder(databaseClusterUuid, username,
                resetAuthRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("resetAuth", localVarResponse);
                }
                return new ApiResponse<AddUserResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AddUserResponse>() {
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

    private HttpRequest.Builder resetAuthRequestBuilder(UUID databaseClusterUuid, String username,
            ResetAuthRequest resetAuthRequest) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'databaseClusterUuid' when calling resetAuth");
        }
        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException(400, "Missing the required parameter 'username' when calling resetAuth");
        }
        // verify the required parameter 'resetAuthRequest' is set
        if (resetAuthRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'resetAuthRequest' when calling resetAuth");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/users/{username}/reset_auth"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()))
                .replace("{username}", ApiClient.urlEncode(username.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(resetAuthRequest);
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
     * Migrate a Database Cluster to a New Region To migrate a database cluster to a
     * new region, send a &#x60;PUT&#x60; request to
     * &#x60;/v2/databases/$DATABASE_ID/migrate&#x60;. The body of the request must
     * specify a &#x60;region&#x60; attribute. A successful request will receive a
     * 202 Accepted status code with no body in response. Querying the database
     * cluster will show that its &#x60;status&#x60; attribute will now be set to
     * &#x60;migrating&#x60;. This will transition back to &#x60;online&#x60; when
     * the migration has completed.
     *
     * @param databaseClusterUuid          A unique identifier for a database
     *                                     cluster. (required)
     * @param updateDatabaseClusterRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void updateDatabaseCluster(UUID databaseClusterUuid,
            UpdateDatabaseClusterRequest updateDatabaseClusterRequest) {
        updateDatabaseClusterWithHttpInfo(databaseClusterUuid, updateDatabaseClusterRequest);
    }

    /**
     * Migrate a Database Cluster to a New Region To migrate a database cluster to a
     * new region, send a &#x60;PUT&#x60; request to
     * &#x60;/v2/databases/$DATABASE_ID/migrate&#x60;. The body of the request must
     * specify a &#x60;region&#x60; attribute. A successful request will receive a
     * 202 Accepted status code with no body in response. Querying the database
     * cluster will show that its &#x60;status&#x60; attribute will now be set to
     * &#x60;migrating&#x60;. This will transition back to &#x60;online&#x60; when
     * the migration has completed.
     *
     * @param databaseClusterUuid          A unique identifier for a database
     *                                     cluster. (required)
     * @param updateDatabaseClusterRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateDatabaseClusterWithHttpInfo(UUID databaseClusterUuid,
            UpdateDatabaseClusterRequest updateDatabaseClusterRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateDatabaseClusterRequestBuilder(databaseClusterUuid,
                updateDatabaseClusterRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateDatabaseCluster", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateDatabaseClusterRequestBuilder(UUID databaseClusterUuid,
            UpdateDatabaseClusterRequest updateDatabaseClusterRequest) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateDatabaseCluster");
        }
        // verify the required parameter 'updateDatabaseClusterRequest' is set
        if (updateDatabaseClusterRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateDatabaseClusterRequest' when calling updateDatabaseCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/migrate".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateDatabaseClusterRequest);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Resize a Database Cluster To resize a database cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/resize&#x60;. The body of the request must
     * specify both the size and num_nodes attributes. A successful request will
     * receive a 202 Accepted status code with no body in response. Querying the
     * database cluster will show that its status attribute will now be set to
     * resizing. This will transition back to online when the resize operation has
     * completed.
     *
     * @param databaseClusterUuid   A unique identifier for a database cluster.
     *                              (required)
     * @param databaseClusterResize (required)
     * @throws ApiException if fails to make API call
     */
    public void updateDatabaseClusterSize(UUID databaseClusterUuid, DatabaseClusterResize databaseClusterResize) {
        updateDatabaseClusterSizeWithHttpInfo(databaseClusterUuid, databaseClusterResize);
    }

    /**
     * Resize a Database Cluster To resize a database cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/resize&#x60;. The body of the request must
     * specify both the size and num_nodes attributes. A successful request will
     * receive a 202 Accepted status code with no body in response. Querying the
     * database cluster will show that its status attribute will now be set to
     * resizing. This will transition back to online when the resize operation has
     * completed.
     *
     * @param databaseClusterUuid   A unique identifier for a database cluster.
     *                              (required)
     * @param databaseClusterResize (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateDatabaseClusterSizeWithHttpInfo(UUID databaseClusterUuid,
            DatabaseClusterResize databaseClusterResize) {
        HttpRequest.Builder localVarRequestBuilder = updateDatabaseClusterSizeRequestBuilder(databaseClusterUuid,
                databaseClusterResize);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateDatabaseClusterSize", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateDatabaseClusterSizeRequestBuilder(UUID databaseClusterUuid,
            DatabaseClusterResize databaseClusterResize) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateDatabaseClusterSize");
        }
        // verify the required parameter 'databaseClusterResize' is set
        if (databaseClusterResize == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterResize' when calling updateDatabaseClusterSize");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/resize".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(databaseClusterResize);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Update Firewall Rules (Trusted Sources) for a Database To update a database
     * cluster&#39;s firewall rules (known as \&quot;trusted sources\&quot; in the
     * control panel), send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/firewall&#x60; specifying which resources
     * should be able to open connections to the database. You may limit connections
     * to specific Droplets, Kubernetes clusters, or IP addresses. When a tag is
     * provided, any Droplet or Kubernetes node with that tag applied to it will
     * have access. The firewall is limited to 100 rules (or trusted sources). When
     * possible, we recommend [placing your databases into a VPC
     * network](https://www.digitalocean.com/docs/networking/vpc/) to limit access
     * to them instead of using a firewall. A successful
     *
     * @param databaseClusterUuid           A unique identifier for a database
     *                                      cluster. (required)
     * @param updateDatabaseFirewallRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void updateDatabaseFirewall(UUID databaseClusterUuid,
            UpdateDatabaseFirewallRequest updateDatabaseFirewallRequest) {
        updateDatabaseFirewallWithHttpInfo(databaseClusterUuid, updateDatabaseFirewallRequest);
    }

    /**
     * Update Firewall Rules (Trusted Sources) for a Database To update a database
     * cluster&#39;s firewall rules (known as \&quot;trusted sources\&quot; in the
     * control panel), send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/firewall&#x60; specifying which resources
     * should be able to open connections to the database. You may limit connections
     * to specific Droplets, Kubernetes clusters, or IP addresses. When a tag is
     * provided, any Droplet or Kubernetes node with that tag applied to it will
     * have access. The firewall is limited to 100 rules (or trusted sources). When
     * possible, we recommend [placing your databases into a VPC
     * network](https://www.digitalocean.com/docs/networking/vpc/) to limit access
     * to them instead of using a firewall. A successful
     *
     * @param databaseClusterUuid           A unique identifier for a database
     *                                      cluster. (required)
     * @param updateDatabaseFirewallRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateDatabaseFirewallWithHttpInfo(UUID databaseClusterUuid,
            UpdateDatabaseFirewallRequest updateDatabaseFirewallRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateDatabaseFirewallRequestBuilder(databaseClusterUuid,
                updateDatabaseFirewallRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateDatabaseFirewall", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateDatabaseFirewallRequestBuilder(UUID databaseClusterUuid,
            UpdateDatabaseFirewallRequest updateDatabaseFirewallRequest) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateDatabaseFirewall");
        }
        // verify the required parameter 'updateDatabaseFirewallRequest' is set
        if (updateDatabaseFirewallRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateDatabaseFirewallRequest' when calling updateDatabaseFirewall");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/firewall".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateDatabaseFirewallRequest);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Configure the Eviction Policy for a Redis Cluster To configure an eviction
     * policy for an existing Redis cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/eviction_policy&#x60; specifying the desired
     * policy.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param evictionPolicy      (required)
     * @throws ApiException if fails to make API call
     */
    public void updateEvictionPolicy(UUID databaseClusterUuid, EvictionPolicy evictionPolicy) {
        updateEvictionPolicyWithHttpInfo(databaseClusterUuid, evictionPolicy);
    }

    /**
     * Configure the Eviction Policy for a Redis Cluster To configure an eviction
     * policy for an existing Redis cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/eviction_policy&#x60; specifying the desired
     * policy.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param evictionPolicy      (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateEvictionPolicyWithHttpInfo(UUID databaseClusterUuid, EvictionPolicy evictionPolicy) {
        HttpRequest.Builder localVarRequestBuilder = updateEvictionPolicyRequestBuilder(databaseClusterUuid,
                evictionPolicy);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateEvictionPolicy", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateEvictionPolicyRequestBuilder(UUID databaseClusterUuid,
            EvictionPolicy evictionPolicy) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateEvictionPolicy");
        }
        // verify the required parameter 'evictionPolicy' is set
        if (evictionPolicy == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'evictionPolicy' when calling updateEvictionPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/eviction_policy".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(evictionPolicy);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Configure a Database Cluster&#39;s Maintenance Window To configure the window
     * when automatic maintenance should be performed for a database cluster, send a
     * PUT request to &#x60;/v2/databases/$DATABASE_ID/maintenance&#x60;. A
     * successful request will receive a 204 No Content status code with no body in
     * response.
     *
     * @param databaseClusterUuid       A unique identifier for a database cluster.
     *                                  (required)
     * @param databaseMaintenanceWindow (required)
     * @throws ApiException if fails to make API call
     */
    public void updateMaintenanceWindow(UUID databaseClusterUuid, DatabaseMaintenanceWindow databaseMaintenanceWindow) {
        updateMaintenanceWindowWithHttpInfo(databaseClusterUuid, databaseMaintenanceWindow);
    }

    /**
     * Configure a Database Cluster&#39;s Maintenance Window To configure the window
     * when automatic maintenance should be performed for a database cluster, send a
     * PUT request to &#x60;/v2/databases/$DATABASE_ID/maintenance&#x60;. A
     * successful request will receive a 204 No Content status code with no body in
     * response.
     *
     * @param databaseClusterUuid       A unique identifier for a database cluster.
     *                                  (required)
     * @param databaseMaintenanceWindow (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateMaintenanceWindowWithHttpInfo(UUID databaseClusterUuid,
            DatabaseMaintenanceWindow databaseMaintenanceWindow) {
        HttpRequest.Builder localVarRequestBuilder = updateMaintenanceWindowRequestBuilder(databaseClusterUuid,
                databaseMaintenanceWindow);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateMaintenanceWindow", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateMaintenanceWindowRequestBuilder(UUID databaseClusterUuid,
            DatabaseMaintenanceWindow databaseMaintenanceWindow) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateMaintenanceWindow");
        }
        // verify the required parameter 'databaseMaintenanceWindow' is set
        if (databaseMaintenanceWindow == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseMaintenanceWindow' when calling updateMaintenanceWindow");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/maintenance".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(databaseMaintenanceWindow);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Start an Online Migration To start an online migration, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/online-migration&#x60; endpoint. Migrating a
     * cluster establishes a connection with an existing cluster and replicates its
     * contents to the target cluster. Online migration is only available for MySQL,
     * PostgreSQL, and Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param sourceDatabase      (required)
     * @return OnlineMigration
     * @throws ApiException if fails to make API call
     */
    public OnlineMigration updateOnlineMigration(UUID databaseClusterUuid, SourceDatabase sourceDatabase) {
        ApiResponse<OnlineMigration> localVarResponse = updateOnlineMigrationWithHttpInfo(databaseClusterUuid,
                sourceDatabase);
        return localVarResponse.getData();
    }

    /**
     * Start an Online Migration To start an online migration, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/online-migration&#x60; endpoint. Migrating a
     * cluster establishes a connection with an existing cluster and replicates its
     * contents to the target cluster. Online migration is only available for MySQL,
     * PostgreSQL, and Redis clusters.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param sourceDatabase      (required)
     * @return ApiResponse&lt;OnlineMigration&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<OnlineMigration> updateOnlineMigrationWithHttpInfo(UUID databaseClusterUuid,
            SourceDatabase sourceDatabase) {
        HttpRequest.Builder localVarRequestBuilder = updateOnlineMigrationRequestBuilder(databaseClusterUuid,
                sourceDatabase);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateOnlineMigration", localVarResponse);
                }
                return new ApiResponse<OnlineMigration>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<OnlineMigration>() {
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

    private HttpRequest.Builder updateOnlineMigrationRequestBuilder(UUID databaseClusterUuid,
            SourceDatabase sourceDatabase) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateOnlineMigration");
        }
        // verify the required parameter 'sourceDatabase' is set
        if (sourceDatabase == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'sourceDatabase' when calling updateOnlineMigration");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/online-migration"
                .replace("{database_cluster_uuid}", ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(sourceDatabase);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Update SQL Mode for a Cluster To configure the SQL modes for an existing
     * MySQL cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/sql_mode&#x60; specifying the desired modes.
     * See the official MySQL 8 documentation for a [full list of supported SQL
     * modes](https://dev.mysql.com/doc/refman/8.0/en/sql-mode.html#sql-mode-full).
     * A successful request will receive a 204 No Content status code with no body
     * in response.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param sqlMode             (required)
     * @throws ApiException if fails to make API call
     */
    public void updateSqlMode(UUID databaseClusterUuid, SqlMode sqlMode) {
        updateSqlModeWithHttpInfo(databaseClusterUuid, sqlMode);
    }

    /**
     * Update SQL Mode for a Cluster To configure the SQL modes for an existing
     * MySQL cluster, send a PUT request to
     * &#x60;/v2/databases/$DATABASE_ID/sql_mode&#x60; specifying the desired modes.
     * See the official MySQL 8 documentation for a [full list of supported SQL
     * modes](https://dev.mysql.com/doc/refman/8.0/en/sql-mode.html#sql-mode-full).
     * A successful request will receive a 204 No Content status code with no body
     * in response.
     *
     * @param databaseClusterUuid A unique identifier for a database cluster.
     *                            (required)
     * @param sqlMode             (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> updateSqlModeWithHttpInfo(UUID databaseClusterUuid, SqlMode sqlMode) {
        HttpRequest.Builder localVarRequestBuilder = updateSqlModeRequestBuilder(databaseClusterUuid, sqlMode);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateSqlMode", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateSqlModeRequestBuilder(UUID databaseClusterUuid, SqlMode sqlMode) {
        // verify the required parameter 'databaseClusterUuid' is set
        if (databaseClusterUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'databaseClusterUuid' when calling updateSqlMode");
        }
        // verify the required parameter 'sqlMode' is set
        if (sqlMode == null) {
            throw new ApiException(400, "Missing the required parameter 'sqlMode' when calling updateSqlMode");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/databases/{database_cluster_uuid}/sql_mode".replace("{database_cluster_uuid}",
                ApiClient.urlEncode(databaseClusterUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(sqlMode);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
