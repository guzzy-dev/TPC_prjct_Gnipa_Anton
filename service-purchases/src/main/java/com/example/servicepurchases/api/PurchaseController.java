package com.example.servicepurchases.api;

import com.example.servicepurchases.repo.model.Purchase;
import com.example.servicepurchases.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/purchases")
public final class PurchaseController {

    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<com.example.servicepurchases.repo.model.Purchase>> index(){
        final List<com.example.servicepurchases.repo.model.Purchase> purchases = purchaseService.fetchall();
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.servicepurchases.repo.model.Purchase> show(@PathVariable long id) {
        try{
            final com.example.servicepurchases.repo.model.Purchase purchase = purchaseService.fetchById(id);
            return ResponseEntity.ok(purchase);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.example.servicepurchases.api.dto.Purchase purchase) {
        final long customer_id =  purchase.getCustomer_id();
        final long product_id =  purchase.getProduct_id();
        final long salesman_id =  purchase.getSalesman_id();

        final long id = purchaseService.create(product_id, salesman_id, customer_id);

        final String location = String.format("/purchases/" + id);
        return ResponseEntity.created(URI.create(location)).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        purchaseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
