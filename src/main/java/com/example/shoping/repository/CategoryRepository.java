package com.example.shoping.repository;

import com.example.shoping.model.Category;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String name);

    Optional<Category> findById(Integer categoryId);
}