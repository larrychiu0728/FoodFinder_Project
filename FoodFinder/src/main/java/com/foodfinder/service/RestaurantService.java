package com.foodfinder.service;

import com.foodfinder.pojo.Restaurant;
import com.foodfinder.pojo.RestaurantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    Page<Restaurant> search(RestaurantType type, Double minScore, Double maxScore, Pageable pageable);
    void updateNote(Integer id, String note);
}