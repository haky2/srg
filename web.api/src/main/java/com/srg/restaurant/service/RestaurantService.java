package com.srg.restaurant.service;

import com.srg.restaurant.entity.Restaurant;
import com.srg.restaurant.model.request.RestaurantRegister;
import com.srg.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getList() {
        List<Restaurant> restaurant = restaurantRepository.findAll();
        return restaurant;
    }

    public Optional<Restaurant> get(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    public void save(RestaurantRegister restaurantRegister) {
        Restaurant restaurant = new Restaurant();
        if (restaurantRegister.getRstNo() != null && restaurantRegister.getRstNo() > 0) {
            restaurant.setRstNo(restaurantRegister.getRstNo());
        }
        restaurant.setLocationNo(restaurantRegister.getLocationNo());
        restaurant.setRstTag(restaurantRegister.getRstTag());
        restaurant.setRstCategory(restaurantRegister.getRstCategory());
        restaurant.setRstName(restaurantRegister.getRstName());
        restaurant.setRstMenu(restaurantRegister.getRstMenu());
        restaurant.setStoreHour(restaurantRegister.getStoreHour());
        restaurant.setRegYmdt(LocalDateTime.now());
        restaurantRepository.save(restaurant);
    }
}
