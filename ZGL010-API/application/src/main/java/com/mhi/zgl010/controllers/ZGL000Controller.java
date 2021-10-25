package com.mhi.zgl010.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mhi.zgl010.models.HelloWorldResponse;
// import com.mhi.zgl010.domains.YdtMinord1;
import com.mhi.zgl010.service.*;
import com.sap.conn.jco.JCoException;

@RestController
public class ZGL000Controller
{
    private static final Logger logger = LoggerFactory.getLogger(ZGL000Controller.class);
    
    @Autowired
    private PutOrdersService putOrderService;

    @GetMapping( path = "/hello")
    public ResponseEntity<HelloWorldResponse> getHello( @RequestParam( defaultValue = "world" ) String name ) throws Exception
    {
        logger.info("I am running!");
        putOrderService.init();
        name = putOrderService.getName();
        return ResponseEntity.ok(new HelloWorldResponse(name));
    }

    // @PutMapping( path = "/orders")
    // public BodyBuilder putOrders( @RequestBody YdtMinord1 orders)
    // {
    //     logger.info("I am PutOrders!");

    //     if (putOrderService.putOrders(orders)){
    //         return ResponseEntity.ok();
    //     }else{
    //         return ResponseEntity.ok();
    //     }
        
    // }
}
