package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String login;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String addres;

    @OneToMany
    private List<Purchase> customersPurchases = new ArrayList<>();

}

