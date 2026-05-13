package com.kelvson.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderRequest (
        @Positive @NotNull Long restaurantId,
        @Positive @NotNull Double amount
) {
}