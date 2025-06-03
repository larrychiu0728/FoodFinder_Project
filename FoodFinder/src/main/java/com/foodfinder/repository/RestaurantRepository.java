package com.foodfinder.repository;

import com.foodfinder.pojo.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>, JpaSpecificationExecutor<Restaurant> {

}