package com.foodfinder.specification;

import com.foodfinder.pojo.Restaurant;
import com.foodfinder.pojo.RestaurantType;
import org.springframework.data.jpa.domain.Specification;

public class RestaurantSpecification {
    public static Specification<Restaurant> hasType(RestaurantType type) {
        return (root, query, cb) -> {
            if (type == null) return null;
            return cb.equal(root.get("type"), type);
        };
    }

    /**
     * 根據評分範圍查詢 (支援 min / max 皆可為 null)
     */
    public static Specification<Restaurant> scoreBetween(Double min, Double max) {
        return (root, query, cb) -> {
            if (min != null && max != null) {
                return cb.between(root.get("rating"), min, max);
            } else if (min != null) {
                return cb.greaterThanOrEqualTo(root.get("rating"), min);
            } else if (max != null) {
                return cb.lessThanOrEqualTo(root.get("rating"), max);
            } else {
                return null;
            }
        };
    }
}
