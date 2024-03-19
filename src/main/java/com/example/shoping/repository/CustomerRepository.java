package com.example.shoping.repository;

import com.example.shoping.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer  findByLogin(String login);

    Customer findByname(String fistname);
    Customer findByLastname(String lastname);

    @Override
    boolean existsById(Long Id);
boolean existsByEmail(String email);
}
