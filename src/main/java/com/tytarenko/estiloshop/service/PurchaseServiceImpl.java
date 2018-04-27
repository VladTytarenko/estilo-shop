package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.PurchaseDao;
import com.tytarenko.estiloshop.entity.Purchase;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import com.tytarenko.estiloshop.service.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    private CustomerService customerService;

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseDao.saveAndFlush(purchase);
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        purchaseDao.saveAndFlush(purchase);
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseDao.deleteById(id);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseDao.findPurchasesByIsBuyedIsTrue();
    }

    @Override
    public void setBuyedPurchaseById(long id) {
        purchaseDao.setBuyedPurchaseById(id);
    }

    @Override
    public List<Purchase> getPurchaseByCustomer(Long customerId) {
        return purchaseDao.findPurchasesByIsBuyedIsTrueAndCustomer(customerService.findById(customerId));
    }

    @Override
    public List<Purchase> getNotBuyedPurchaseByCustomer(Long customerId) {
        return purchaseDao.findPurchasesByIsBuyedIsFalseAndCustomer(customerService.findById(customerId));
    }

    @Override
    public List<Purchase> getPurchaseByDate(Date from, Date to) {
        return null;
    }
}
