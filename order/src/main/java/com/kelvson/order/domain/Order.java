package com.kelvson.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long restaurantId;

    private Long customerId;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    private Double totalAmount;

    private LocalDateTime CreatedAt;

    public void nextStatus(){
        status.next(this);
    }
    public void cancel(){
        status.cancel(this);
    }
}
