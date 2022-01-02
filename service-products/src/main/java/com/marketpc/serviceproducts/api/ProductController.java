package com.marketpc.serviceproducts.api;



import com.marketpc.serviceproducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public final class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<com.marketpc.serviceproducts.repo.model.Product>> index(){
        final List<com.marketpc.serviceproducts.repo.model.Product> products = productService.fetchAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.marketpc.serviceproducts.repo.model.Product> show(@PathVariable long id) {
        try {
            final com.marketpc.serviceproducts.repo.model.Product product = productService.fetchById(id);
            return ResponseEntity.ok(product);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.marketpc.serviceproducts.api.dto.Product product){
        final String title = product.getTitle();
        final String type = product.getType();
        final int prod_year = product.getProd_year();
        final boolean used = product.isUsed();
        final long id = productService.create(title, type, prod_year, used);
        final String location = String.format("/products/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable long id, @RequestBody com.marketpc.serviceproducts.api.dto.Product product){
        final String title = product.getTitle();
        final String type = product.getType();
        final int prod_year = product.getProd_year();
        final boolean used = product.isUsed();

        try {
            productService.update(id, title, type, prod_year, used);
            return ResponseEntity.noContent().build();

        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
