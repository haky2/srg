package com.srg.service;

import com.srg.entity.Restaurant;
import com.srg.enums.RestaurantCategory;
import com.srg.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void add() {
        restaurantRepository.save(Restaurant.builder()
                .rstName("test")
                .rstCategory(RestaurantCategory.RC01)
                .rstMenu("{}")
                .storeHour("09:00 ~ 18:00")
                .rstTag("#test1#test2")
                .regYmdt(LocalDateTime.now())
                .lastUpdateYmdt(LocalDateTime.now())
                .build());
    }
}
