package com.example.shoping.repository;

import com.example.shoping.model.Cart;
import com.example.shoping.model.CartItem;
import com.example.shoping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarttlItemRepository extends JpaRepository<CarttlItemRepository, Long> {
    List<CartItem> findByCartId(Long cartId);
    List<CartItem> findByProductId(Long productId);
    CartItem save(CartItem cartItem);

    void deleteAll(List<CartItem> cartItems);

    CartItem findByCartAndProduct(Cart cart, Product product);

    void setQuantity(Integer quantity);

    List<CartItem> findByCart(Cart cart);
}
