package com.kelvson.payment.dto;

public record CreatePaymentRequest(Long orderId, Double amount) {
}

