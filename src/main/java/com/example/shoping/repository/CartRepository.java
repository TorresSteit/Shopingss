package com.example.shoping.repository;

import com.example.shoping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByCustomerId(Long customerId);

    void deleteAllByCartId(Long cartId);

    @Override
    <S extends Cart> List<S> saveAll(Iterable<S> entities);
    List<Cart> findAll();
    Optional<Cart> findById();
}
