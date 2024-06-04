package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    Customer customerToCreate (@RequestBody Customer customerToCreate){
        return customerService.createCustomer(customerToCreate);

    }
}
