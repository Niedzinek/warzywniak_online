package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private double price;

//    @OneToMany
//    private List<OrderedProduct> productInOrders = new ArrayList<>();


}
