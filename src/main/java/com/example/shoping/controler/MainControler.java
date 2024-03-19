package com.example.shoping.controler;

import com.example.shoping.sevice.CartItemServiceImpl;

public class CartItemControler {
    private final  CartItemServiceImpl cartItemService;

    public  CartItemControler(CartItemServiceImpl cartItemService){
        this.cartItemService=cartItemService;
    }




}
