package com.marketpc.serviceproducts.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public final class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private  String type;
    private int prod_year;
    private boolean used;

    public Product() {
    }

    public Product(String title, String type, int prod_year, boolean is_used) {
        this.title = title;
        this.type = type;
        this.prod_year = prod_year;
        this.used = is_used;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProd_year() {
        return prod_year;
    }

    public void setProd_year(int prod_year) {
        this.prod_year = prod_year;
    }

    public boolean isUsed() {
        return used;
    }

    public void setIs_used(boolean is_used) {
        this.used = is_used;
    }
}
