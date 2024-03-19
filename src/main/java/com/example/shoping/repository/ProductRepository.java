package com.example.shoping.repository;

import com.example.shoping.model.Category;
import com.example.shoping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    // Поиск продуктов по категории
    List<Product> findByCategory(Category category);

    // Поиск продуктов по цене меньше или равной указанной
    List<Product> findByPriceLessThanEqual(Double price);

    // Поиск продуктов по наличию на складе
    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);

    // Поиск продуктов по наличию на складе и категории
    List<Product> findByStockQuantityGreaterThanAndCategory(Integer stockQuantity, Category category);
    List<Product> findByPriceLessThan(double price);



    List<Product> findByDateAddedAfter(Date date);
    Product findTopByOrderByQuantityDesc();

    List<Product> findAllByCategoryId(long categoryId);

    List<Product> findByCategoryId(Long categoryId);
}
