package com.marketpc.serviceproducts.repo;

import  com.marketpc.serviceproducts.repo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
