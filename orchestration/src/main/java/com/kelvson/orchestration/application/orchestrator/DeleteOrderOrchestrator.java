package com.kelvson.orchestration.application.orchestrator;

import com.kelvson.orchestration.application.usecase.DeleteOrderUseCase;
import com.kelvson.orchestration.infrastructure.client.OrderClient;
import com.kelvson.orchestration.infrastructure.client.PaymentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Service
//@RequiredArgsConstructor
//public class DeleteOrderOrchestrator implements DeleteOrderUseCase {
//
//    private final OrderClient orderClient;
//    private final PaymentClient paymentClient;
//
//    @Override
//    public void execute(Long orderId) {
//        if(orderClient.exists(orderId)){
//            orderClient.delete(orderId);
//        }
//    }
//}
