package com.example.demo.Controllers;

import com.example.demo.DTOs.PurchaseDTO;
import com.example.demo.Models.Customer;
import com.example.demo.Models.OrderedProduct;
import com.example.demo.Models.Purchase;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.OrderedProductRepository;
import com.example.demo.Repositories.PurchaseRepository;
import com.example.demo.Services.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;
    public PurchaseController(final PurchaseService purchaseService){
        this.purchaseService = purchaseService;}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/purchase")
//    @PreAuthorize("hasRole('client_customer')")
    ResponseEntity<?> createPurchase (@RequestBody PurchaseDTO purchaseToCreate){
        return ResponseEntity.ok(purchaseService.createPurchase(purchaseToCreate));
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(value = "/purchase")
//    ResponseEntity<List<Purchase>> readAllPurchases(){
//        return ResponseEntity.ok(purchaseService.findAllPurchases());
//    }

//    @GetMapping(value = "/purchase/{username}")
//    ResponseEntity<List<Purchase>> findPurchasesByCustomerUsername(@PathVariable String username){
//        return ResponseEntity.ok(purchaseService.findPurchasesByLogin(username));
//    }

@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/purchase/{userid}", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> findPurchasesByCustomerUserId(@PathVariable String userid){
        return ResponseEntity.ok(purchaseService.findPurchasesByUserId(userid));
    }


}
