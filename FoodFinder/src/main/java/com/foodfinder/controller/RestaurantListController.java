package com.foodfinder.controller;

import com.foodfinder.pojo.Restaurant;
import com.foodfinder.pojo.RestaurantType;
import com.foodfinder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestaurantListController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantListController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/lists")
    public Page<Restaurant> list(
            @RequestParam(required = false) RestaurantType typeId,
            @RequestParam(required = false) Double minScore,
            @RequestParam(required = false) Double maxScore,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return restaurantService.search(typeId, minScore, maxScore, pageable);
    }

    @PutMapping("/restaurant/{id}/note")
    public ResponseEntity<?> updateNote(@PathVariable Integer id, @RequestBody Map<String, String> payload) {
        String note = payload.get("note");
        restaurantService.updateNote(id, note);
        return ResponseEntity.ok().build();
    }
}
