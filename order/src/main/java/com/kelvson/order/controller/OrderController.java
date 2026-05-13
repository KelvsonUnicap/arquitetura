package com.kelvson.order.controller;

import com.kelvson.order.dto.CreateOrderRequest;
import com.kelvson.order.service.OrderService;
import com.kelvson.order.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.ORDER_BASE_PATH)
public class OrderController {

    private final OrderService orderService;

    public OrderController(@Autowired OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public Long create(@RequestBody @Valid CreateOrderRequest request){
        return orderService.save(request);
    }

    @GetMapping("/{id}/exists")
    public boolean exists(@PathVariable Long id){
        return orderService.exists(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }
}
