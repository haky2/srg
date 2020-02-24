package com.srg.restaurant.service;

import com.srg.restaurant.entity.Restaurant;
import com.srg.restaurant.model.request.RestaurantRegister;
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

    public void add(RestaurantRegister restaurantRegister) {
        Restaurant restaurant = new Restaurant();
        restaurant.setLocationNo(0);
        restaurant.setRstTag(restaurantRegister.getRstTag());
        restaurant.setRstCategory(restaurantRegister.getRstCategory());
        restaurant.setRstName(restaurantRegister.getRstName());
        restaurant.setRstMenu(restaurantRegister.getRstMenu());
        restaurant.setStoreHour(restaurantRegister.getStoreHour());
        restaurant.setRegYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }
}
