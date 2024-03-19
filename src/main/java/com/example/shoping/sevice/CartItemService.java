package com.example.shoping.sevice;

import com.example.shoping.model.Cart;
import com.example.shoping.model.CartItem;
import com.example.shoping.model.Product;
import com.example.shoping.repository.CarttlItemRepository;

import java.util.List;

public interface CartItemService {
    CartItem createCartItem(Cart cart, Product product, int quantity);

    List<CarttlItemRepository> getAllCartItems();

    List<CartItem> listCartItemsByCart(Cart cart);

    void updateCartItemQuantity(Long cartItemId, int quantity);

    void removeCartItem(Long cartItemId);
}
