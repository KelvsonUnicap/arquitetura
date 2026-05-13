package com.kelvson.orchestration.infrastructure.client;

import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;
import com.kelvson.orchestration.util.AppConstants;
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
                AppConstants.ORDER_SERVICE_URL,
                request,
                Long.class
        );
    }

    public boolean exists(Long orderId) {
        return Boolean.TRUE.equals(
                restTemplate.getForObject(
                        AppConstants.buildOrderUrl(orderId, AppConstants.EXIST_ENDPOINT),
                        Boolean.class
                )
        );
    }

    public void delete(Long orderId){
        restTemplate.delete(AppConstants.buildOrderUrl(orderId));
    }

//    public void confirm(Long orderId){
//        restTemplate.postForLocation(
//          AppConstants.buildOrderUrl(orderId, AppConstants.CONFIRM_ENDPOINT),
//            null
//        );
//    }

//    public void cancel(Long orderId){
//        restTemplate.postForLocation(
//            AppConstants.buildOrderUrl(orderId, AppConstants.CANCEL_ENDPOINT),
//            null
//        );
//    }
}
