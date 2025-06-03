package com.foodfinder.repository;

import com.foodfinder.pojo.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Integer> {
    List<RestaurantImage> findByRestaurantId(Integer restaurantId);
}
