package com.kelvson.orchestration.application.usecase;

import com.kelvson.orchestration.interfaces.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest request);
}
