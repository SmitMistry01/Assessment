package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Product;

class CartItemServiceTest {

    private CartItemService cartService;
    private Product product;

    @BeforeEach
    void setup() {
        cartService = new CartItemService();
        product = new Product(1, "Laptop", 50000);
    }

    @Test
    void testAddToCart() {
        cartService.addToCart(product, 2);
        assertEquals(1, cartService.getCartItems().size());
    }

    @Test
    void testTotalCalculation() {
        cartService.addToCart(product, 2);
        assertEquals(100000, cartService.getTotal());
    }
}