package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Purchase;

import java.util.Date;
import java.util.List;

public interface PurchaseService {

    void addPurchase(Purchase purchase);
    void updatePurchase(Purchase purchase);
    void deletePurchase(long id);
    List<Purchase> getPurchaseByCustomer(long customerId);
    List<Purchase> getPurchaseByDate(Date from, Date to);
}
