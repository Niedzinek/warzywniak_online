package com.example.demo.Repositories;

import com.example.demo.DTOs.CustomerDTO;
import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByLogin(String login);
    Optional<Customer> findCustomerByUserId(String userId);

    Customer save(CustomerDTO customerDTO);
}
