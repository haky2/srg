package com.srg.restaurant.service;

import com.srg.restaurant.entity.Restaurant;
import com.srg.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Optional<Restaurant> get(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    public void modify(Restaurant restaurant) {
        restaurant.setLastUpdateYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }

    public void add(Restaurant restaurant) {
        restaurant.setLocationNo(0);
        restaurant.setRegYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }
}
