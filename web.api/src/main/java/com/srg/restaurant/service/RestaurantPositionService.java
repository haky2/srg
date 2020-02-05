package com.srg.restaurant.service;

import com.srg.restaurant.entity.RestaurantPosition;
import com.srg.restaurant.repository.RestaurantPositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RestaurantPositionService {
    @Autowired
    private RestaurantPositionRepository restaurantPositionRepository;

    public RestaurantPosition findById(long rstNo) {
        RestaurantPosition restaurantPosition = restaurantPositionRepository.findById(rstNo);
        return restaurantPosition;
    }

    public void deleteById(long rstNo) {
        restaurantPositionRepository.deleteById(rstNo);
    }

    public RestaurantPosition save(RestaurantPosition restaurantPosition) {
        restaurantPositionRepository.save(restaurantPosition);

        return restaurantPosition;
    }

    public void updateById(long rstNo, RestaurantPosition restaurantPosition) {
        RestaurantPosition updateData = restaurantPositionRepository.findById(rstNo);
        LocalDateTime currentDateTime = LocalDateTime.now();

        updateData.setResCoordinate(restaurantPosition.getResCoordinate());
        updateData.setResAddress(restaurantPosition.getResAddress());
        updateData.setUpdateYmdt(currentDateTime);

        restaurantPositionRepository.save(restaurantPosition);
    }
}
