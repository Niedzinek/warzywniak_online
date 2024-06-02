package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

}
