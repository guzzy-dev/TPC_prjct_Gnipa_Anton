package com.marketpc.serviceproducts.service;

import com.marketpc.serviceproducts.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.marketpc.serviceproducts.repo.model.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class ProductService {

    private final ProductRepo productRepo;

    public List<Product> fetchAll() {
        return productRepo.findAll();
    }

    public Product fetchById(long id) throws IllegalArgumentException{
        final Optional<Product> maybeProduct = productRepo.findById(id);

        if (maybeProduct.isEmpty()) throw new IllegalArgumentException("Product not Found");
        else return maybeProduct.get();
    }

    public long create(String title, String type, int prod_year, boolean is_used){
        final Product product = new Product(title, type, prod_year, is_used);
        final Product savedProduct = productRepo.save(product);
        return savedProduct.getId();
    }

    public void update(long id, String title, String type, int prod_year, boolean is_used) throws IllegalArgumentException{
        final Optional<Product> maybeProduct = productRepo.findById(id);

        if (maybeProduct.isEmpty()) throw new IllegalArgumentException("Product not Found");

        final Product product = maybeProduct.get();
        if (title != null && !title.isBlank()) product.setTitle(title);
        if (type != null && !type.isBlank()) product.setType(type);
        if (prod_year > 1980) product.setProd_year(prod_year);
        product.setIs_used(is_used);

        productRepo.save(product);
    }

    public void delete(long id){
        productRepo.deleteById(id);
    }
}
