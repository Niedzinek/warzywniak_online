package com.example.demo.Repositories;

import com.example.demo.Models.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {

    OrderedProduct save(OrderedProduct entity);

}
