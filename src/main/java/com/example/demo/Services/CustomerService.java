package com.example.demo.Services;

import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer entity){
        return customerRepository.save(entity);
    }
}
