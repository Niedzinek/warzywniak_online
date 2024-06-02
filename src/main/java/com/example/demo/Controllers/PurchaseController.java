package com.example.demo.Controllers;

import com.example.demo.Models.OrderedProduct;
import com.example.demo.Models.Purchase;
import com.example.demo.Repositories.OrderedProductRepository;
import com.example.demo.Repositories.PurchaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
    private final PurchaseRepository repository;
    private final OrderedProductRepository orderRepository;
    public PurchaseController(final PurchaseRepository repository, OrderedProductRepository orderRepository){
        this.repository = repository; this.orderRepository = orderRepository;}

    @PostMapping("/purchase")
//    @PreAuthorize("hasRole('client_customer')")
    ResponseEntity<?> createPurchase (@RequestBody Purchase toCreate){
        System.out.println("post purchaseController");
//        toCreate.getOrderedProducts().forEach(x ->{
//            System.out.println(x.getProduct().getDescription());
//        });
//        orderRepository.saveAll(toCreate.getOrderedProducts());
        repository.save(toCreate);
        System.out.println(toCreate.getId());
        return ResponseEntity.ok(toCreate);
    }

    @GetMapping(value = "/purchase")
    ResponseEntity<List<Purchase>> readAllPurchases(){
        return ResponseEntity.ok(repository.findAll());
    }
}
