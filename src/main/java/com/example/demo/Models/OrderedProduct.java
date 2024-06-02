package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double quantity;

    @ManyToOne
    private Product product;

//    @ManyToOne
//    private Purchase purchase;




}
