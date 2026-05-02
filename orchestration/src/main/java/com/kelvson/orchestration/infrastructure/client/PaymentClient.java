package com.kelvson.orchestration.infrastructure.client;

import com.kelvson.orchestration.interfaces.dto.PaymentRequest;
import com.kelvson.orchestration.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    private final RestTemplate restTemplate;

    public PaymentClient(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public boolean process(Long orderId, Double amount){
        return Boolean.TRUE.equals(restTemplate.postForObject(
                AppConstants.PAYMENT_SERVICE_URL,
                new PaymentRequest(orderId, amount),
                Boolean.class));
    }
}
