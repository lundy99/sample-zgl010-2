package com.mhi.zgl010.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import com.mhi.zgl010.domains.Ytorderadd;
import com.mhi.zgl010.models.CountResponse;
import com.mhi.zgl010.models.HelloWorldResponse;
// import com.mhi.zgl010.domains.YdtMinord1;
import com.mhi.zgl010.service.*;
import com.sap.conn.jco.JCoException;
import java.util.Arrays;
import java.util.List;

// @Api(tags = "Sample")
@EnableAsync
@RestController
public class ZGL000Controller
{
    private static final Logger logger = LoggerFactory.getLogger(ZGL000Controller.class);
    
    @Autowired
    private PutOrdersService putOrderService;
    @Autowired
    private RfcService rfcService;

    @Autowired
    private AsyncDemoService asyncDemoService;
    
    @Autowired
    private Environment env;

    
    @GetMapping( path = "/hello")
    public ResponseEntity<HelloWorldResponse> getHello( @RequestParam( defaultValue = "world" ) String name ) throws Exception
    {
        logger.info("I am running at hello!");
        logger.info("env:" + env.getActiveProfiles().toString());
                
        return ResponseEntity.ok(new HelloWorldResponse(name));
    }
    @GetMapping( path = "/rfc")
    public ResponseEntity<HelloWorldResponse> getRfc( @RequestParam( defaultValue = "world" ) String name ) throws Exception
    {
        logger.info("I am running at rfc!");
        name = rfcService.getName();
        rfcService.getRFC();
        return ResponseEntity.ok(new HelloWorldResponse(name));
    }
    @GetMapping( path = "/async")
    public ResponseEntity<HelloWorldResponse> getAsync( @RequestParam( defaultValue = "world" ) String name ) throws Exception
    {
        logger.info("I am asyncSample at async!");
        
        // それぞれ非同期で処理する
        for (int i=0; i<10000; i++){
            CompletableFuture<Void> obj = asyncDemoService.callAPI("No"+String.valueOf(i));
        }
        // CompletableFuture<Void> name1 = asyncDemoService.callAPI(name);
        // // 非同期処理が完了するまで待つ
        // CompletableFuture.allOf(name1, name2, name3).join();
        // System.out.println("DONE!!!");
        return ResponseEntity.ok(new HelloWorldResponse("Async All Done!"));
    }

    @GetMapping( path = "/orders")
    public ResponseEntity<List<Ytorderadd>> getOrders()
    {

        logger.info("I am GetOrders!");
        List<Ytorderadd> data = putOrderService.getAll();
        return ResponseEntity.ok(data);
        
    }

    @PutMapping( path = "/orders")
    public ResponseEntity<CountResponse> putOrders( @RequestBody Ytorderadd orders)
    {

        logger.info("I am PutOrders!");
        int result = putOrderService.putYtorderadd(orders);
        return ResponseEntity.ok(new CountResponse(result));
        
    }
}
