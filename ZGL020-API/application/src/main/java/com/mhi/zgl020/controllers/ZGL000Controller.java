package com.mhi.zgl010.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import com.mhi.zgl010.domains.Ytorderadd;
import com.mhi.zgl010.domains.OrderDto;
import com.mhi.zgl010.models.CountResponse;
import com.mhi.zgl010.models.HelloWorldResponse;
// import com.mhi.zgl010.domains.YdtMinord1;
import com.mhi.zgl010.service.*;
import com.sap.conn.jco.JCoException;
import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import com.mhi.zgl010.flamework.Alert;
// @Api(tags = "Sample")
@EnableAsync
@RestController
public class ZGL000Controller
{
    private static final Logger logger = LoggerFactory.getLogger(ZGL000Controller.class);
    
    @Autowired
    private OrdersService orderService;
    @Autowired
    private RfcService rfcService;

    @Autowired
    private AsyncDemoService asyncDemoService;
    
    @Autowired
    private Environment env;

    @Autowired
    private Alert alert;
    @GetMapping( path = "/hello/{client:\\d{3}}")
    public ResponseEntity<HelloWorldResponse> getHello(@PathVariable String client,@RequestParam( defaultValue = "world" ) String name ) throws Exception
    {
        logger.info("I am running at hello!");
        logger.info("env:" + env.getActiveProfiles().toString());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        logger.info("requestUrl:" + url);
        logger.info("client:" + client);
                
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

    @GetMapping( path = "/orders/{client:\\d{3}}")
    public ResponseEntity<List<Ytorderadd>> getOrders()
    {

        logger.info("I am GetOrders!");
        List<Ytorderadd> data = orderService.getAll();
        return ResponseEntity.ok(data);
        
    }

    @PutMapping( path = "/orders/{client:\\d{3}}")
    public ResponseEntity<CountResponse> putOrders( @RequestBody OrderDto orders)
    {

        logger.info("I am PutOrders!");
        ModelMapper modelMapper = new ModelMapper();
        Ytorderadd ytorderadd = modelMapper.map(orders, Ytorderadd.class);

        int result = orderService.putYtorderadd(ytorderadd);
        // int result = 0;
        return ResponseEntity.ok(new CountResponse(result));
        
    }
    @PostMapping( path = "/orders/{client:\\d{3}}")
    public ResponseEntity<CountResponse> posttOrders( @RequestBody OrderDto orders)
    {

        logger.info("I am PostOrders!");
        
        ModelMapper modelMapper = new ModelMapper();
        Ytorderadd ytorderadd = modelMapper.map(orders, Ytorderadd.class);

        int result = orderService.postYtorderadd(ytorderadd);
        // int result = 0;
        return ResponseEntity.ok(new CountResponse(result));
        
    }
    @GetMapping( path = "alert")
    public ResponseEntity<HelloWorldResponse> getalert()
    {

        logger.info("I am Alert!");
        
        alert.sendAlertMail();
       
        return ResponseEntity.ok(new HelloWorldResponse("Alert!"));
        
    }    
    
}
