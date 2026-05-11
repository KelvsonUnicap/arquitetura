package com.kelvson.restaurant.dto;

import jakarta.validation.constraints.NotNull;

public record CreateRestaurantRequest(
        @NotNull String name,
        @NotNull String address
) {
}
