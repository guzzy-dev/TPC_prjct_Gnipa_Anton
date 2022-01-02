package com.example.servicepurchases.repo;

import com.example.servicepurchases.repo.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
}
