package com.foodfinder.controller;

import com.foodfinder.pojo.RestaurantImage;
import com.foodfinder.repository.RestaurantImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantImageController {

    @Autowired
    private RestaurantImageRepository restaurantImageRepository;

    @GetMapping("/images")
    public List<RestaurantImage> getImages(@RequestParam("restaurantId") Integer restaurantId) {
        return restaurantImageRepository.findByRestaurantId(restaurantId);
    }
}
