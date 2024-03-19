package com.example.shoping.sevice;

import com.example.shoping.model.Cart;
import com.example.shoping.model.CartItem;
import com.example.shoping.model.Customer;
import com.example.shoping.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cart) {
        Optional<Cart> cartData = cartRepository.findById(id);
        if (!cartData.isPresent()) {
            throw new RuntimeException("Cart not found with id: " + id);
        }
        cart.setId(id);
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}