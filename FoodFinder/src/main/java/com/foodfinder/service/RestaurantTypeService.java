package com.foodfinder.service;

import com.foodfinder.pojo.RestaurantType;

import java.util.List;

public interface RestaurantTypeService {
    List<RestaurantType> findAllTypes();
}
