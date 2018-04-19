package com.tytarenko.estiloshop.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Purchase {

    @NotNull
    private long purchaseId;

    @NotNull
    private Date date;

    @NotNull
    private Purchase purchaseList;

    @NotNull
    private Customer customer;

    public Purchase(@NotNull long purchaseId, @NotNull Date date,
                    @NotNull Purchase purchaseList, @NotNull Customer customer) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.purchaseList = purchaseList;
        this.customer = customer;
    }

    public long getPurchaseIdId() {
        return purchaseId;
    }

    public void setId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(Purchase purchaseList) {
        this.purchaseList = purchaseList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}