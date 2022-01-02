package com.example.servicepurchases.service;


import com.example.servicepurchases.repo.PurchaseRepo;
import com.example.servicepurchases.repo.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PurchaseService {

    private final PurchaseRepo purchaseRepo;

    public List<Purchase> fetchall(){

        return purchaseRepo.findAll();
    }

    public Purchase fetchById(long purchase_id)throws IllegalArgumentException{
        final Optional<Purchase> maybePurchase = purchaseRepo.findById(purchase_id);

        if (maybePurchase.isEmpty()) throw new IllegalArgumentException("Car not found");
        else return maybePurchase.get();
    }

    public long create(long product_id, long salesman_id, long consumer_id){
        final Purchase purchase = new Purchase(product_id, salesman_id, consumer_id);
        final Purchase savedPurchase = purchaseRepo.save(purchase);
        return savedPurchase.getId();
    }


    public void delete(long purchase_id){
        purchaseRepo.deleteById(purchase_id);
    }
}
