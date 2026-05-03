package com.kelvson.orchestration.application.orchestrator;

import com.kelvson.orchestration.application.usecase.CreateOrderUseCase;
import com.kelvson.orchestration.infrastructure.client.OrderClient;
import com.kelvson.orchestration.infrastructure.client.PaymentClient;
import com.kelvson.orchestration.infrastructure.client.RestaurantClient;
import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderOrchestrator implements CreateOrderUseCase {

    private final RestaurantClient restaurantClient;
    private final OrderClient orderClient;
    private final PaymentClient paymentClient;

    /**
     * Orchestrates the order creation workflow
     *
     * <p> This method performs the following steps:
     * <ul>
     *     <li>(1) Validates the restaurant</li>
     *     <li>(2) Creates an order and retrieves its ID</li>
     *     <li>(3) Processes the payment</li>
     *     <li>(4) Confirms or cancels the order based on payment result</li>
     * </ul>
     *
     * <p>If the payment is approved, the order is confirmed.
     *  * Otherwise, the order is canceled.
     * @param request the order creation request containing restaurant and payment data.
     * */

    public void execute(CreateOrderRequest request){
//        restaurantClient.validate(request.restaurantId());
        Long orderId = orderClient.create(request);
//        boolean approved = paymentClient.process(orderId, request.amount());

//        if(approved) {
//            orderClient.confirm(orderId);
//        } else {
//            orderClient.cancel(orderId);
//        }
    }
}
