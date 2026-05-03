package com.kelvson.order.service;

import com.kelvson.order.domain.Order;
import com.kelvson.order.dto.CreateOrderRequest;
import com.kelvson.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Long save(CreateOrderRequest request){
        Order order = new Order(request.restaurantId(), request.amount());
        return orderRepository.save(order).getId();
    }
}
