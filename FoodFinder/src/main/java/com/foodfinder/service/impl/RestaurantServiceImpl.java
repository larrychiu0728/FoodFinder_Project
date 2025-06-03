package com.foodfinder.service.impl;

import com.foodfinder.pojo.Restaurant;
import com.foodfinder.pojo.RestaurantType;
import com.foodfinder.repository.RestaurantRepository;
import com.foodfinder.service.RestaurantService;
import com.foodfinder.specification.RestaurantSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Page<Restaurant> search(RestaurantType type, Double minScore, Double maxScore, Pageable pageable) {
        if (minScore != null) {
            minScore = Math.round(minScore * 10.0) / 10.0; // 四捨五入到 1 位小數
        }
        if (maxScore != null) {
            maxScore = Math.round(maxScore * 10.0) / 10.0;
        }

        Specification<Restaurant> spec = Specification
                .where(RestaurantSpecification.hasType(type))
                .and(RestaurantSpecification.scoreBetween(minScore, maxScore));
        return restaurantRepository.findAll(spec, pageable);
    }

    @Transactional
    public void updateNote(Integer id, String note) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到餐廳"));
        restaurant.setNote(note);
    }
}
