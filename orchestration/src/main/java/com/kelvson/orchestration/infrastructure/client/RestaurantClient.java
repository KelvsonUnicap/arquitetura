package com.kelvson.orchestration.infrastructure.client;

import com.kelvson.orchestration.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestaurantClient {

    private final RestTemplate restTemplate;

    public RestaurantClient(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

//    public void validate(Long restaurantId){
//        restTemplate.getForObject(
//                AppConstants.buildRestaurantUrl(restaurantId), void.class
//        );
//    }
}
