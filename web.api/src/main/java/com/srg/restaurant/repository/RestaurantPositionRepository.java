package com.srg.restaurant.repository;

import com.srg.restaurant.entity.RestaurantPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantPositionRepository extends JpaRepository<RestaurantPosition, Long> {
    RestaurantPosition findByRstNo(long rst_no);
}
