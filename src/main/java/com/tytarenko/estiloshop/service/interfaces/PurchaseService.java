package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Purchase;

import java.util.Date;
import java.util.List;

public interface PurchaseService {

    void addPurchase(Purchase purchase);
    void updatePurchase(Purchase purchase);
    void deletePurchase(Long id);
    List<Purchase> getAllPurchase();
    List<Purchase> getPurchaseByCustomer(Long customerId);
    List<Purchase> getNotBuyedPurchaseByCustomer(Long customerId);
    List<Purchase> getPurchaseByDate(Date from, Date to);
}
