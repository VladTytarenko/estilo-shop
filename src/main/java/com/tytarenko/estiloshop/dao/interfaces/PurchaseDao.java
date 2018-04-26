package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseDao extends JpaRepository<Purchase, Long> {

    List<Purchase> findPurchasesByIsBuyedIsTrue();
    List<Purchase> findPurchasesByIsBuyedIsTrueAndCustomer(Customer customer);
    List<Purchase> findPurchasesByIsBuyedIsFalseAndCustomer(Customer customer);

}
