package com.foodfinder.controller;

import com.foodfinder.pojo.RestaurantType;
import com.foodfinder.service.RestaurantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantTypeController {

    @Autowired
    private RestaurantTypeService typeService;

    @GetMapping("/types")
    public List<RestaurantType> getAllTypes() {
        return typeService.findAllTypes();
    }
}
