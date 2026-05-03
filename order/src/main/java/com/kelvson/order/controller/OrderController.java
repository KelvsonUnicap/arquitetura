package com.kelvson.order.controller;

import com.kelvson.order.dto.CreateOrderRequest;
import com.kelvson.order.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstants.ORDER_BASE_PATH)
public class OrderController {

    @PostMapping(value={"","/"})
    public ResponseEntity<Long> create(@RequestBody @Valid CreateOrderRequest request){
        return null;
    }
}
