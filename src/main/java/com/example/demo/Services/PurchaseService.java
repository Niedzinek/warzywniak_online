package com.example.demo.Services;

import com.example.demo.DTOs.PurchaseDTO;
import com.example.demo.Models.Customer;
import com.example.demo.Models.OrderedProduct;
import com.example.demo.Models.Product;
import com.example.demo.Models.Purchase;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Repositories.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {
    private static final Logger log = LoggerFactory.getLogger(PurchaseService.class);
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    public Purchase createPurchase(PurchaseDTO purchaseToCreate){
        Customer customer = customerRepository.findCustomerByUserId(purchaseToCreate.getUserId())
                .orElseThrow(() -> new RuntimeException("Customer not found with userId: " + purchaseToCreate.getUserId()));



        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);

        List<OrderedProduct> orderedProducts = purchaseToCreate.getOrderedProducts().stream()
                .map(dto ->{
                    Product product = productRepository.findById(dto.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found"));

                    OrderedProduct orderedProduct = new OrderedProduct();
                    orderedProduct.setProduct(product);
                    orderedProduct.setQuantity(dto.getQuantity());
                    return orderedProduct;
                })
                .collect(Collectors.toList());

        purchase.setOrderedProducts(orderedProducts);
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> findAllPurchases(){
        return purchaseRepository.findAll();
    }

    public List<Purchase> findPurchasesByLogin(String username) {
        Customer customer = customerRepository.findCustomerByLogin(username)
                .orElseThrow(() -> new RuntimeException("Customer not found with login: " + username));

        return purchaseRepository.findPurchasesByCustomer(customer);
    }

    public List<Purchase> findPurchasesByUserId(String userId){
        Customer customer = customerRepository.findCustomerByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + userId));

        return purchaseRepository.findPurchasesByCustomer(customer);
    }


}
