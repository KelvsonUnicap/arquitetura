package com.kelvson.orchestration.interfaces.dto;

public record PaymentRequest(Long orderId, Double amount) {
}
