package com.kelvson.restaurant.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.models.spi.GenericGeneratorRegistration;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "address")
    private String address;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
