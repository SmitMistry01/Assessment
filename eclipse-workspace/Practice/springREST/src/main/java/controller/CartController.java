package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import service.*;
import model.Product;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartService;

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId,
                            @RequestParam("quantity") int quantity) {

        Product product = productService.getProductById(productId);
        if (product == null || quantity <= 0) {
            // invalid input - ignore and go back to products
            return "redirect:/products";
        }

        cartService.addToCart(product, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotal());
        return "cart";
    }
}