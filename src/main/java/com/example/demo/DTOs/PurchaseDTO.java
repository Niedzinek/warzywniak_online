package com.example.demo.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PurchaseDTO {

    private String userId;
    private List<OrderedProductDTO> orderedProducts = new ArrayList<>();


}
