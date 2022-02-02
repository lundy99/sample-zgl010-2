package com.mhi.zgl010.flamework;
import com.sap.cloud.alert.notification.client.IAlertNotificationClient;
import com.sap.cloud.alert.notification.client.IRetryPolicy;
import com.sap.cloud.alert.notification.client.ServiceRegion;
import com.sap.cloud.alert.notification.client.builder.AffectedCustomerResourceBuilder;
import com.sap.cloud.alert.notification.client.builder.CustomerResourceEventBuilder;
import com.sap.cloud.alert.notification.client.internal.AlertNotificationClient;
import com.sap.cloud.alert.notification.client.internal.BasicAuthorizationHeader;
import com.sap.cloud.alert.notification.client.internal.OAuthAuthorizationHeader;
import com.sap.cloud.alert.notification.client.internal.IAuthorizationHeader;
import com.sap.cloud.alert.notification.client.internal.SimpleRetryPolicy;
import com.sap.cloud.alert.notification.client.model.AffectedCustomerResource;
import com.sap.cloud.alert.notification.client.model.CustomerResourceEvent;
import com.sap.cloud.alert.notification.client.model.EventCategory;
import com.sap.cloud.alert.notification.client.model.EventSeverity;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.pivotal.cfenv.core.CfEnv;
import io.pivotal.cfenv.core.CfService;

import java.net.URI;
import java.time.Duration;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * SAP Alert Notification service for SAP BTP Client
 * @version
 * @author 001321-danganaosai
 */
@Component
public class Alert {
    
    // @Value("${alert.maxRetries:5}")
    private int maxRetries= 5;
    // @Value("${alert.retryBackoffMs:1000}")
    private int retryBackoffMs=1000;
    // @Value("${alert.userName:#{null}}")
    private String userName="#{null}";
    // @Value("${alert.clientSecret:#{null}}")
    private String clientSecret="#{null}";

    private static final Logger logger = LoggerFactory.getLogger(Alert.class);

    public void sendAlertMail() {
    	//initializing IAlertNotificationClient
        HttpClient httpClient = HttpClients.createDefault();
        IRetryPolicy iRetryPolicy = new SimpleRetryPolicy(5, Duration.ofMillis(100));
        ServiceRegion serviceRegion = ServiceRegion.US10;
 
        logger.info("I am running! 1");
         CfEnv cfEnv = new CfEnv();
        
                
          
         String serviceClientId = cfEnv.findCredentialsByLabel("alert-notification").getString("client_id");
         String serviceClientSecret = cfEnv.findCredentialsByLabel("alert-notification").getString("client_secret");
        URI serviceURL = URI.create(cfEnv.findCredentialsByLabel("alert-notification").getString("oauth_url"));
        // String serviceClientId = "sb-426bd4ec-80cd-48b0-8799-7bb3749dffa5!b34236|ans-xsuaa!b673";
        // String serviceClientSecret = "88398093-afbf-4681-8d7d-afa6256ce18c$Y4SAaaNW7vEyC21heKmLcw5u3VbzqfDba9SfGKy3x8Q=";
        logger.info("I am running! 2 serviceClientId :" + serviceClientId);
         logger.info("I am running! 3 serviceClientSecret :" + serviceClientSecret);
         logger.info("I am running! 4 serviceURL :" + serviceURL);

      
        IAuthorizationHeader iAuthorizationHeader = new OAuthAuthorizationHeader(serviceClientId, serviceClientSecret, serviceURL, httpClient);

        IAlertNotificationClient iAlertNotificationClient = new AlertNotificationClient(httpClient, iRetryPolicy, serviceRegion, iAuthorizationHeader);


        AffectedCustomerResource resource = new AffectedCustomerResourceBuilder()
                .withName("simplejava")     // resource name
                .withType("java-app")                // resource type
        //        .withInstance("v9192c8cba")          // identifier of the particular instance of the resource
                .withTags(Collections.emptyMap())    // additional information in form of key-value pairs
                .build();
                        
        CustomerResourceEvent event = new CustomerResourceEventBuilder()
                .withType("TestEvent")                               // type of the event
                .withCategory(EventCategory.NOTIFICATION)                   // event category
                .withSeverity(EventSeverity.INFO)                           // event severity
                .withSubject("First Event Posted on Alert Notification")    // subject
                .withBody("ERROR:This event has test purpose.")                   // body
                .withTags(Collections.singletonMap("my-tag", "test"))       // additional information in form of key-value pairs
                .withAffectedResource(resource)                             // the affected resource
                .build();
        
        iAlertNotificationClient.sendEvent(event);
    }
}