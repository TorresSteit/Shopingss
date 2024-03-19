package com.example.shoping.controler;

import com.example.shoping.model.Cart;
import com.example.shoping.model.Category;
import com.example.shoping.sevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminContreoler {
    private final CategoryService categoryService;
    private final CartItemService cartItemService;
    private final CartService cartService;
    private final CustomerService customerService;
    private final ProductService productService;

    public AdminContreoler(CategoryService categoryService, CartItemService cartItemService, CartService cartService, CustomerService customerService, ProductService productService) {
        this.categoryService = categoryService;
        this.cartItemService = cartItemService;
        this.cartService = cartService;
        this.customerService = customerService;
        this.productService = productService;
    }
    @GetMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }


}


