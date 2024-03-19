package com.example.shoping.sevice;

import com.example.shoping.model.Cart;
import com.example.shoping.model.CartItem;
import com.example.shoping.model.Product;
import com.example.shoping.repository.CarttlItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CarttlItemRepository cartItemRepository;

    public CartItemServiceImpl(CarttlItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem createCartItem(Cart cart, Product product, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CarttlItemRepository> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public List<CartItem> listCartItemsByCart(Cart cart) {
        return cartItemRepository.findByCart(cart);
    }

    @Override
    public void updateCartItemQuantity(Long cartItemId, int quantity) {
        Optional<CarttlItemRepository> cartItemOptional = cartItemRepository.findById(cartItemId);
        cartItemOptional.ifPresent(cartItem -> {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        });
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
