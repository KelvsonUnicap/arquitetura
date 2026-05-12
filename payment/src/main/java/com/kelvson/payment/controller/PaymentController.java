package com.kelvson.payment.controller;

import com.kelvson.payment.dto.CreatePaymentRequest;
import com.kelvson.payment.service.PaymentService;
import com.kelvson.payment.util.AppConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.PAYMENT_BASE_PATH)
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public boolean create(@RequestBody @Valid CreatePaymentRequest request){
        return paymentService.save(request);
    }
}
