package com.kelvson.restaurant.service;

import com.kelvson.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    public RestaurantService(@Autowired RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public boolean exists(Long id){return restaurantRepository.findById(id).isPresent();}

    public void delete(Long id){restaurantRepository.findById(id).ifPresent(restaurantRepository::delete);}
}
