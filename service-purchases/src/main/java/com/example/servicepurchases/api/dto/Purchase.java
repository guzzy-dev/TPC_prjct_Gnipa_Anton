package com.example.servicepurchases.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Purchase {
    private long product_id;
    private long salesman_id;
    private long customer_id;
}
