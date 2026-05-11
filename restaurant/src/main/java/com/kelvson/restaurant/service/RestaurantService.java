package com.kelvson.restaurant.service;

import com.kelvson.restaurant.domain.Restaurant;
import com.kelvson.restaurant.dto.CreateRestaurantRequest;
import com.kelvson.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    public RestaurantService(@Autowired RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Long save(CreateRestaurantRequest request){
        Restaurant restaurant = new Restaurant(request.name(), request.address());
        return restaurantRepository.save(restaurant).getId();
    }

    public boolean exists(Long id){return restaurantRepository.findById(id).isPresent();}

    public void delete(Long id){restaurantRepository.findById(id).ifPresent(restaurantRepository::delete);}
}
