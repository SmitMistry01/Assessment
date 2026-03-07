package com.example.demo.controller;

import com.example.demo.model.FoodItem;
import com.example.demo.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/fooditems")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getFoodItemsByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(foodItemService.getFoodItemsByRestaurant(restaurantId));
    }

    @PostMapping
    public ResponseEntity<FoodItem> addFoodItem(@PathVariable Long restaurantId,
                                                @RequestBody FoodItem foodItem) {
        return foodItemService.addFoodItemToRestaurant(restaurantId, foodItem)
                .map(created -> ResponseEntity.status(HttpStatus.CREATED).body(created))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long restaurantId,
                                               @PathVariable Long id) {
        if (foodItemService.deleteFoodItem(restaurantId, id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
