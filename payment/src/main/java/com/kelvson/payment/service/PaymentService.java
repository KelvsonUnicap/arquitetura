package com.kelvson.payment.service;

import com.kelvson.payment.domain.Payment;
import com.kelvson.payment.dto.CreatePaymentRequest;
import com.kelvson.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(@Autowired PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Boolean save(CreatePaymentRequest request){
        Payment payment = new Payment(request.orderId(), request.amount());
        Long saved = paymentRepository.save(payment).getId();
        return saved != null;
    }

    public boolean exists(Long id){
        return paymentRepository.findById(id).isPresent();
    }

    public void delete(Long id){
        paymentRepository.findById(id).ifPresent(paymentRepository::delete);
    }
}
