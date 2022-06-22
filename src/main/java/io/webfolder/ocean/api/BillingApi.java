package io.webfolder.ocean.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.model.Balance;
import io.webfolder.ocean.model.GetInvoiceByUuidResponse;
import io.webfolder.ocean.model.InvoiceSummary;
import io.webfolder.ocean.model.ListBillingHistoryResponse;
import io.webfolder.ocean.model.ListInvoicesResponse;

public class BillingApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public BillingApi() {
        this(new ApiClient());
    }

    public BillingApi(ApiClient apiClient) {
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
     * Get Customer Balance To retrieve the balances on a customer&#39;s account,
     * send a GET request to &#x60;/v2/customers/my/balance&#x60;.
     *
     * @return Balance
     * @throws ApiException if fails to make API call
     */
    public Balance getCustomerBalance() {
        ApiResponse<Balance> localVarResponse = getCustomerBalanceWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * Get Customer Balance To retrieve the balances on a customer&#39;s account,
     * send a GET request to &#x60;/v2/customers/my/balance&#x60;.
     *
     * @return ApiResponse&lt;Balance&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Balance> getCustomerBalanceWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = getCustomerBalanceRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getCustomerBalance", localVarResponse);
                }
                return new ApiResponse<Balance>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Balance>() {
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

    private HttpRequest.Builder getCustomerBalanceRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/balance";

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
     * Retrieve an Invoice by UUID To retrieve the invoice items for an invoice,
     * send a GET request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return GetInvoiceByUuidResponse
     * @throws ApiException if fails to make API call
     */
    public GetInvoiceByUuidResponse getInvoiceByUuid(String invoiceUuid) {
        ApiResponse<GetInvoiceByUuidResponse> localVarResponse = getInvoiceByUuidWithHttpInfo(invoiceUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Invoice by UUID To retrieve the invoice items for an invoice,
     * send a GET request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return ApiResponse&lt;GetInvoiceByUuidResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetInvoiceByUuidResponse> getInvoiceByUuidWithHttpInfo(String invoiceUuid) {
        HttpRequest.Builder localVarRequestBuilder = getInvoiceByUuidRequestBuilder(invoiceUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getInvoiceByUuid", localVarResponse);
                }
                return new ApiResponse<GetInvoiceByUuidResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetInvoiceByUuidResponse>() {
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

    private HttpRequest.Builder getInvoiceByUuidRequestBuilder(String invoiceUuid) {
        // verify the required parameter 'invoiceUuid' is set
        if (invoiceUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'invoiceUuid' when calling getInvoiceByUuid");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/invoices/{invoice_uuid}".replace("{invoice_uuid}",
                ApiClient.urlEncode(invoiceUuid.toString()));

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
     * Retrieve an Invoice CSV by UUID To retrieve a CSV for an invoice, send a GET
     * request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID/csv&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return String
     * @throws ApiException if fails to make API call
     */
    public String getInvoiceCsvByUuid(String invoiceUuid) {
        ApiResponse<String> localVarResponse = getInvoiceCsvByUuidWithHttpInfo(invoiceUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Invoice CSV by UUID To retrieve a CSV for an invoice, send a GET
     * request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID/csv&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<String> getInvoiceCsvByUuidWithHttpInfo(String invoiceUuid) {
        HttpRequest.Builder localVarRequestBuilder = getInvoiceCsvByUuidRequestBuilder(invoiceUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getInvoiceCsvByUuid", localVarResponse);
                }
                return new ApiResponse<String>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<String>() {
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

    private HttpRequest.Builder getInvoiceCsvByUuidRequestBuilder(String invoiceUuid) {
        // verify the required parameter 'invoiceUuid' is set
        if (invoiceUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'invoiceUuid' when calling getInvoiceCsvByUuid");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/invoices/{invoice_uuid}/csv".replace("{invoice_uuid}",
                ApiClient.urlEncode(invoiceUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "text/csv, application/json");

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
     * Retrieve an Invoice PDF by UUID To retrieve a PDF for an invoice, send a GET
     * request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID/pdf&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return File
     * @throws ApiException if fails to make API call
     */
    public File getInvoicePdfByUuid(String invoiceUuid) {
        ApiResponse<File> localVarResponse = getInvoicePdfByUuidWithHttpInfo(invoiceUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Invoice PDF by UUID To retrieve a PDF for an invoice, send a GET
     * request to &#x60;/v2/customers/my/invoices/$INVOICE_UUID/pdf&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<File> getInvoicePdfByUuidWithHttpInfo(String invoiceUuid) {
        HttpRequest.Builder localVarRequestBuilder = getInvoicePdfByUuidRequestBuilder(invoiceUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getInvoicePdfByUuid", localVarResponse);
                }
                return new ApiResponse<File>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<File>() {
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

    private HttpRequest.Builder getInvoicePdfByUuidRequestBuilder(String invoiceUuid) {
        // verify the required parameter 'invoiceUuid' is set
        if (invoiceUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'invoiceUuid' when calling getInvoicePdfByUuid");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/invoices/{invoice_uuid}/pdf".replace("{invoice_uuid}",
                ApiClient.urlEncode(invoiceUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/pdf, application/json");

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
     * Retrieve an Invoice Summary by UUID To retrieve a summary for an invoice,
     * send a GET request to
     * &#x60;/v2/customers/my/invoices/$INVOICE_UUID/summary&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return InvoiceSummary
     * @throws ApiException if fails to make API call
     */
    public InvoiceSummary getInvoiceSummaryByUuid(String invoiceUuid) {
        ApiResponse<InvoiceSummary> localVarResponse = getInvoiceSummaryByUuidWithHttpInfo(invoiceUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Invoice Summary by UUID To retrieve a summary for an invoice,
     * send a GET request to
     * &#x60;/v2/customers/my/invoices/$INVOICE_UUID/summary&#x60;.
     *
     * @param invoiceUuid UUID of the invoice (required)
     * @return ApiResponse&lt;InvoiceSummary&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<InvoiceSummary> getInvoiceSummaryByUuidWithHttpInfo(String invoiceUuid) {
        HttpRequest.Builder localVarRequestBuilder = getInvoiceSummaryByUuidRequestBuilder(invoiceUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getInvoiceSummaryByUuid", localVarResponse);
                }
                return new ApiResponse<InvoiceSummary>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<InvoiceSummary>() {
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

    private HttpRequest.Builder getInvoiceSummaryByUuidRequestBuilder(String invoiceUuid) {
        // verify the required parameter 'invoiceUuid' is set
        if (invoiceUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'invoiceUuid' when calling getInvoiceSummaryByUuid");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/invoices/{invoice_uuid}/summary".replace("{invoice_uuid}",
                ApiClient.urlEncode(invoiceUuid.toString()));

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
     * List Billing History To retrieve a list of all billing history entries, send
     * a GET request to &#x60;/v2/customers/my/billing_history&#x60;.
     *
     * @return ListBillingHistoryResponse
     * @throws ApiException if fails to make API call
     */
    public ListBillingHistoryResponse listBillingHistory() {
        ApiResponse<ListBillingHistoryResponse> localVarResponse = listBillingHistoryWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List Billing History To retrieve a list of all billing history entries, send
     * a GET request to &#x60;/v2/customers/my/billing_history&#x60;.
     *
     * @return ApiResponse&lt;ListBillingHistoryResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListBillingHistoryResponse> listBillingHistoryWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listBillingHistoryRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listBillingHistory", localVarResponse);
                }
                return new ApiResponse<ListBillingHistoryResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListBillingHistoryResponse>() {
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

    private HttpRequest.Builder listBillingHistoryRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/billing_history";

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
     * List All Invoices To retrieve a list of all invoices, send a GET request to
     * &#x60;/v2/customers/my/invoices&#x60;.
     *
     * @return ListInvoicesResponse
     * @throws ApiException if fails to make API call
     */
    public ListInvoicesResponse listInvoices() {
        ApiResponse<ListInvoicesResponse> localVarResponse = listInvoicesWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Invoices To retrieve a list of all invoices, send a GET request to
     * &#x60;/v2/customers/my/invoices&#x60;.
     *
     * @return ApiResponse&lt;ListInvoicesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListInvoicesResponse> listInvoicesWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listInvoicesRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listInvoices", localVarResponse);
                }
                return new ApiResponse<ListInvoicesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListInvoicesResponse>() {
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

    private HttpRequest.Builder listInvoicesRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/customers/my/invoices";

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
}
