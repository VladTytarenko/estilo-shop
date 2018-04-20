package com.tytarenko.estiloshop.entity;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Purchase {

    @NotNull
    private long purchaseId;

    //@OneToMany
    @NotNull
    private Good good;

    //OneToOne
    @NotNull
    private Customer customer;

    //@Column(nullable = true)
    private String adress;

    @NotNull
    private Date date;

    public Purchase() {
    }

    public Purchase(@NotNull long purchaseId, @NotNull Date date,
                    @NotNull Good good, @NotNull Customer customer) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.good = good;
        this.customer = customer;
    }

    public Purchase(@NotNull long purchaseId, @NotNull Date date,
                    @NotNull Good good, @NotNull Customer customer, String adress) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.adress = adress;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}