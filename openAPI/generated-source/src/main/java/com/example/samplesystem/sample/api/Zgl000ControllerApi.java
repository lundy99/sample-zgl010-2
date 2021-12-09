package com.example.samplesystem.sample.api;

import com.example.samplesystem.sample.ApiClient;

import com.example.samplesystem.sample.model.CountResponse;
import com.example.samplesystem.sample.model.HelloWorldResponse;
import com.example.samplesystem.sample.model.Ytorderadd;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-07T09:02:24.157159Z[Etc/UTC]")
@Component("com.example.samplesystem.sample.api.Zgl000ControllerApi")
public class Zgl000ControllerApi {
    private ApiClient apiClient;

    public Zgl000ControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public Zgl000ControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return HelloWorldResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public HelloWorldResponse getAsync(String name) throws RestClientException {
        return getAsyncWithHttpInfo(name).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return ResponseEntity&lt;HelloWorldResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HelloWorldResponse> getAsyncWithHttpInfo(String name) throws RestClientException {
        Object postBody = null;
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<HelloWorldResponse> returnType = new ParameterizedTypeReference<HelloWorldResponse>() {};
        return apiClient.invokeAPI("/async", HttpMethod.GET, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return HelloWorldResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public HelloWorldResponse getHello(String name) throws RestClientException {
        return getHelloWithHttpInfo(name).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return ResponseEntity&lt;HelloWorldResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HelloWorldResponse> getHelloWithHttpInfo(String name) throws RestClientException {
        Object postBody = null;
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<HelloWorldResponse> returnType = new ParameterizedTypeReference<HelloWorldResponse>() {};
        return apiClient.invokeAPI("/hello", HttpMethod.GET, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return List&lt;Ytorderadd&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Ytorderadd> getOrders() throws RestClientException {
        return getOrdersWithHttpInfo().getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;List&lt;Ytorderadd&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Ytorderadd>> getOrdersWithHttpInfo() throws RestClientException {
        Object postBody = null;
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Ytorderadd>> returnType = new ParameterizedTypeReference<List<Ytorderadd>>() {};
        return apiClient.invokeAPI("/orders", HttpMethod.GET, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return HelloWorldResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public HelloWorldResponse getRfc(String name) throws RestClientException {
        return getRfcWithHttpInfo(name).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param name  (optional, default to world)
     * @return ResponseEntity&lt;HelloWorldResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HelloWorldResponse> getRfcWithHttpInfo(String name) throws RestClientException {
        Object postBody = null;
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<HelloWorldResponse> returnType = new ParameterizedTypeReference<HelloWorldResponse>() {};
        return apiClient.invokeAPI("/rfc", HttpMethod.GET, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param ytorderadd  (required)
     * @return CountResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CountResponse putOrders(Ytorderadd ytorderadd) throws RestClientException {
        return putOrdersWithHttpInfo(ytorderadd).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param ytorderadd  (required)
     * @return ResponseEntity&lt;CountResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CountResponse> putOrdersWithHttpInfo(Ytorderadd ytorderadd) throws RestClientException {
        Object postBody = ytorderadd;
        
        // verify the required parameter 'ytorderadd' is set
        if (ytorderadd == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ytorderadd' when calling putOrders");
        }
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CountResponse> returnType = new ParameterizedTypeReference<CountResponse>() {};
        return apiClient.invokeAPI("/orders", HttpMethod.PUT, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
}
