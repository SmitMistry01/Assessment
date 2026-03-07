package com.example.demo.service;

import com.example.demo.model.FoodItem;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.FoodItemRepository;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodItemService(FoodItemRepository foodItemRepository,
                           RestaurantRepository restaurantRepository) {
        this.foodItemRepository = foodItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }

    public Optional<FoodItem> addFoodItemToRestaurant(Long restaurantId, FoodItem foodItem) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            foodItem.setRestaurant(restaurant);
            return foodItemRepository.save(foodItem);
        });
    }

    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public boolean deleteFoodItem(Long restaurantId, Long foodItemId) {
        return foodItemRepository.findById(foodItemId)
                .filter(item -> item.getRestaurant() != null
                        && item.getRestaurant().getId().equals(restaurantId))
                .map(item -> {
                    foodItemRepository.delete(item);
                    return true;
                })
                .orElse(false);
    }
}
