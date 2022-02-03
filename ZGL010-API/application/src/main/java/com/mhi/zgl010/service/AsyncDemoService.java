package com.mhi.zgl010.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AsyncDemoService {
    
    @Async
    public CompletableFuture<Void> callAPI(final String name) throws InterruptedException {

        System.out.println("print start: " + name);
        // Thread.sleep(1000); // 1秒待つ

        RestTemplate rest = new RestTemplate();

        final String endpoint = "http://java-springboot-basic-lundylundy99-dev.apps.sandbox.x8i5.p1.openshiftapps.com/";

        final String url = endpoint ;

        // 直接Beanクラスにマップ出来るけど今回はめんどくさいのでStringで。
        ResponseEntity<String> response = rest.getForEntity(url, String.class);

        String json = response.getBody();
        
        System.out.println("print end: " + name + "return:"+ json);

        return CompletableFuture.completedFuture(null);
    }
}
