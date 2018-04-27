package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseDao extends JpaRepository<Purchase, Long> {

    List<Purchase> findPurchasesByIsBuyedIsTrue();
    List<Purchase> findPurchasesByIsBuyedIsTrueAndCustomer(Customer customer);
    List<Purchase> findPurchasesByIsBuyedIsFalseAndCustomer(Customer customer);

    @Query("UPDATE Purchase p SET p.isBuyed = true WHERE p.purchaseId = :id")
    Purchase setBuyedPurchaseById(@Param("id") long id);

}
