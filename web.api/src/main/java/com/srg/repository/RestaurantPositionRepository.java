package com.srg.repository;

import com.srg.entity.RestaurantPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantPositionRepository extends JpaRepository<RestaurantPosition, Long> {
    RestaurantPosition findById(long id);
}
