package com.example.demo.Controllers;

import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;
    public ProductController(final ProductRepository repository){this.repository = repository;}
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/products")
    @PreAuthorize("hasRole('client_customer')")
    ResponseEntity<List<Product>> readAllProducts(){
        System.out.println("product controller");
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/products")
//    @PreAuthorize("hasRole('client_admin')")
    ResponseEntity<?> createProduct(@RequestBody Product toCreate){
        repository.save(toCreate);
        System.out.println(toCreate.getName());
        return ResponseEntity.ok(toCreate);
    }

}
