package com.kelvson.orchestration.interfaces.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderRequest (
        @Positive @NotNull Long restaurantId,
        @Positive @NotNull Double amount
) {
}
