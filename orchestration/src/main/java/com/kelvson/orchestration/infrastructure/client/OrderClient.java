package com.kelvson.orchestration.infrastructure.client;

import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    public OrderClient(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Long create(CreateOrderRequest request){
        return restTemplate.postForObject(
            "http://order-service:8080/orders",
                request,
                Long.class
        );
    }

    public void confirm(Long orderId){
        restTemplate.postForLocation(
          "http://order-service:8080/orders/" + orderId + "/confirm",
            null
        );
    }

    public void cancel(Long orderId){
        restTemplate.postForLocation(
            "http://order-service:8080/orders/" + orderId + "/cancel",
            null
        );
    }
}
