package service;

import org.springframework.stereotype.Service;
import model.*;

import java.util.*;

@Service
public class CartItemService {

    private Map<Integer, CartItem> cart = new HashMap<>();

    public void addToCart(Product product, int quantity) {

        if (cart.containsKey(product.getId())) {
            CartItem item = cart.get(product.getId());
            int newQty = item.getQuantity() + quantity;
            cart.put(product.getId(), new CartItem(product, newQty));
        } else {
            cart.put(product.getId(), new CartItem(product, quantity));
        }
    }

    public Collection<CartItem> getCartItems() {
        return cart.values();
    }

    public double getTotal() {
        return cart.values()
                .stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}