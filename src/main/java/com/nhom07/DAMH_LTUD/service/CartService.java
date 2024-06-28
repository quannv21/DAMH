package com.nhom07.DAMH_LTUD.service;


import com.nhom07.DAMH_LTUD.model.CartItem;
import com.nhom07.DAMH_LTUD.model.Product;
import com.nhom07.DAMH_LTUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
@Service
public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
                cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public void clearCart() {
        cartItems.clear();
    }
}
*/
@Service
public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

/*    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                // Tăng số lượng sản phẩm nếu đã tồn tại
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        // Nếu sản phẩm chưa tồn tại, thêm sản phẩm mới vào giỏ hàng
        cartItems.add(new CartItem(product, quantity));
    }*/
public void addToCart(Long productId, int quantity) {
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));
    // Check if the product already exists in the cart
    for (CartItem item : cartItems) {
        if (item.getProduct().getId().equals(productId)) {
            // Increase the quantity if it exists
            item.setQuantity(item.getQuantity() + quantity);
            return;
        }
    }
    // If the product does not exist, add a new product to the cart
    cartItems.add(new CartItem(product, quantity));
}

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double getTotalCartPrice() {
        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void updateQuantity(Long productId, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

}


