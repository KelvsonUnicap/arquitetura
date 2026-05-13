package com.kelvson.restaurant.controller;

import com.kelvson.restaurant.dto.CreateRestaurantRequest;
import com.kelvson.restaurant.service.RestaurantService;
import com.kelvson.restaurant.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.RESTAURANT_BASE_PATH)
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Long create(@RequestBody @Valid CreateRestaurantRequest request){
        return restaurantService.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void exists(@PathVariable Long id){
        System.out.println("Validano aqui no restaurant");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        restaurantService.delete(id);
    }
}
