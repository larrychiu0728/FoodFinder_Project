package com.foodfinder.repository;

import com.foodfinder.pojo.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Integer> {

}
