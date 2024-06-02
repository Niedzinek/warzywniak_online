package com.example.demo.Repositories;

import com.example.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Product save(Product entity);
}
