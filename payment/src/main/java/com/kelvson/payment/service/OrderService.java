package com.kelvson.payment.service;

import com.kelvson.order.domain.Order;
import com.kelvson.order.dto.CreateOrderRequest;
import com.kelvson.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Boolean save(CreateOrderRequest request){
        Order order = new Order(request.restaurantId(), request.amount());
        return orderRepository.save(order).getId();
    }

    public boolean exists(Long id){
        return orderRepository.findById(id).isPresent();
    }

    public void delete(Long id){
        orderRepository.findById(id).ifPresent(orderRepository::delete);
    }
}
