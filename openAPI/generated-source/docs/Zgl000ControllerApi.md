# Zgl000ControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAsync**](Zgl000ControllerApi.md#getAsync) | **GET** /async | 
[**getHello**](Zgl000ControllerApi.md#getHello) | **GET** /hello | 
[**getOrders**](Zgl000ControllerApi.md#getOrders) | **GET** /orders | 
[**getRfc**](Zgl000ControllerApi.md#getRfc) | **GET** /rfc | 
[**putOrders**](Zgl000ControllerApi.md#putOrders) | **PUT** /orders | 



## getAsync

> HelloWorldResponse getAsync(name)



### Example

```java
// Import classes:
import com.example.samplesystem.sample.ApiClient;
import com.example.samplesystem.sample.ApiException;
import com.example.samplesystem.sample.Configuration;
import com.example.samplesystem.sample.models.*;
import com.example.samplesystem.sample.api.Zgl000ControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        Zgl000ControllerApi apiInstance = new Zgl000ControllerApi(defaultClient);
        String name = "world"; // String | 
        try {
            HelloWorldResponse result = apiInstance.getAsync(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Zgl000ControllerApi#getAsync");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  | [optional] [default to world]

### Return type

[**HelloWorldResponse**](HelloWorldResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getHello

> HelloWorldResponse getHello(name)



### Example

```java
// Import classes:
import com.example.samplesystem.sample.ApiClient;
import com.example.samplesystem.sample.ApiException;
import com.example.samplesystem.sample.Configuration;
import com.example.samplesystem.sample.models.*;
import com.example.samplesystem.sample.api.Zgl000ControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        Zgl000ControllerApi apiInstance = new Zgl000ControllerApi(defaultClient);
        String name = "world"; // String | 
        try {
            HelloWorldResponse result = apiInstance.getHello(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Zgl000ControllerApi#getHello");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  | [optional] [default to world]

### Return type

[**HelloWorldResponse**](HelloWorldResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getOrders

> List&lt;Ytorderadd&gt; getOrders()



### Example

```java
// Import classes:
import com.example.samplesystem.sample.ApiClient;
import com.example.samplesystem.sample.ApiException;
import com.example.samplesystem.sample.Configuration;
import com.example.samplesystem.sample.models.*;
import com.example.samplesystem.sample.api.Zgl000ControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        Zgl000ControllerApi apiInstance = new Zgl000ControllerApi(defaultClient);
        try {
            List<Ytorderadd> result = apiInstance.getOrders();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Zgl000ControllerApi#getOrders");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Ytorderadd&gt;**](Ytorderadd.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getRfc

> HelloWorldResponse getRfc(name)



### Example

```java
// Import classes:
import com.example.samplesystem.sample.ApiClient;
import com.example.samplesystem.sample.ApiException;
import com.example.samplesystem.sample.Configuration;
import com.example.samplesystem.sample.models.*;
import com.example.samplesystem.sample.api.Zgl000ControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        Zgl000ControllerApi apiInstance = new Zgl000ControllerApi(defaultClient);
        String name = "world"; // String | 
        try {
            HelloWorldResponse result = apiInstance.getRfc(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Zgl000ControllerApi#getRfc");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  | [optional] [default to world]

### Return type

[**HelloWorldResponse**](HelloWorldResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## putOrders

> CountResponse putOrders(ytorderadd)



### Example

```java
// Import classes:
import com.example.samplesystem.sample.ApiClient;
import com.example.samplesystem.sample.ApiException;
import com.example.samplesystem.sample.Configuration;
import com.example.samplesystem.sample.models.*;
import com.example.samplesystem.sample.api.Zgl000ControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        Zgl000ControllerApi apiInstance = new Zgl000ControllerApi(defaultClient);
        Ytorderadd ytorderadd = new Ytorderadd(); // Ytorderadd | 
        try {
            CountResponse result = apiInstance.putOrders(ytorderadd);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling Zgl000ControllerApi#putOrders");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ytorderadd** | [**Ytorderadd**](Ytorderadd.md)|  |

### Return type

[**CountResponse**](CountResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

