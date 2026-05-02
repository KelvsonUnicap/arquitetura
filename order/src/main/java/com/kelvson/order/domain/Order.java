package com.kelvson.order.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="restaurant_id")
    private Long restaurantId;

    @Column(name="customer_id")
    private Long customerId;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="total_amount")
    private Double totalAmount;

    @CreationTimestamp
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public Order(Long restaurantId, Long customerId, Double totalAmount){
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.totalAmount = totalAmount; this.status = Status.PENDING; }
    public void nextStatus() { status.next(this); }
    public void cancel(){ status.cancel(this); }
}