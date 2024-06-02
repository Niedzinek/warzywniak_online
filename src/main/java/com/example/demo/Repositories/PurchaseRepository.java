package com.example.demo.Repositories;

import com.example.demo.Models.Product;
import com.example.demo.Models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Purchase save(Purchase entity);
}
