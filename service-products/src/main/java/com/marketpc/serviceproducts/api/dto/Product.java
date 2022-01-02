package com.marketpc.serviceproducts.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Product {
    private String title;
    private  String type;
    private int prod_year;
    private boolean used;
}
