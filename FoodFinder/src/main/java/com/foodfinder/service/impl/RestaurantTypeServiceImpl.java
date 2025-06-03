package com.foodfinder.service.impl;

import com.foodfinder.pojo.RestaurantType;
import com.foodfinder.repository.RestaurantTypeRepository;
import com.foodfinder.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTypeServiceImpl implements RestaurantTypeService {
    private final RestaurantTypeRepository restaurantTypeRepository;

    @Autowired
    public RestaurantTypeServiceImpl(RestaurantTypeRepository restaurantTypeRepository) {
        this.restaurantTypeRepository = restaurantTypeRepository;
    }

    @Override
    public List<RestaurantType> findAllTypes() {
        return restaurantTypeRepository.findAll();  // 直接用 JPA 查所有資料
    }
}
