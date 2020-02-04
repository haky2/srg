package com.srg.service;

import com.srg.entity.Restaurant;
import com.srg.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant get(int id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            System.out.println(optionalRestaurant.get());
            return optionalRestaurant.get();
        } else {
            return null;
        }
    }

    public void modify(int id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        Restaurant restaurant = optionalRestaurant.get();
        restaurant.setRstName("changeName");
        restaurant.setRstTag("#changeTag1#changeTag2");
        restaurant.setRegYmdt(LocalDateTime.now());
        restaurant.setLastUpdateYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }

    public void add(Restaurant restaurant) {
        restaurant.setRstName("restaurant002");
        restaurant.setRstTag("#restaurant002");
        restaurant.setLocationNo(0);
        restaurant.setRstMenu("{}");
        restaurant.setStoreHour("10:00 ~ 20:00");
        restaurant.setRegYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }
}
