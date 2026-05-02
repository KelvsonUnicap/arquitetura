package com.kelvson.orchestration.infrastructure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestaurantClient {

    private final RestTemplate restTemplate;

    public RestaurantClient(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void validate(Long id){
        restTemplate.getForObject(
                "http://restaurant-service:8080/restaurants" + id, void.class
        );
    }
}
