package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Product;

class ProductServiceTest {

    private ProductService productService = new ProductService();

    @Test
    void testGetAllProducts() {
        assertNotNull(productService.getAllProducts());
        assertFalse(productService.getAllProducts().isEmpty());
    }

    @Test
    void testGetProductById() {
        Product product = productService.getProductById(1);
        assertNotNull(product);
        assertEquals(1, product.getId());
    }

    @Test
    void testInvalidProductId() {
        Product product = productService.getProductById(999);
        assertNull(product);
    }
}