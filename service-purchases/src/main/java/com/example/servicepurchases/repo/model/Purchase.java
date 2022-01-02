package com.example.servicepurchases.repo.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public final class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long product_id;
    private long salesman_id;
    private long customer_id;

    public Purchase() {
    }

    public Purchase(long product_id, long salesman_id, long customer_id) {
        this.product_id = product_id;
        this.salesman_id = salesman_id;
        this.customer_id = customer_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(long salesman_id) {
        this.salesman_id = salesman_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
