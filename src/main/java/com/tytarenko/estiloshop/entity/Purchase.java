package com.tytarenko.estiloshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long purchaseId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @Column(nullable = true)
    private String address;

    @NotNull
    private Date date;

    private Boolean isBuyed;

    @ManyToMany(mappedBy = "good")
    private List<Good> purchase;

    public Purchase() {
    }

    public Purchase(@NotNull Date date,
                    /*@NotNull List<Good> goods,*/ @NotNull Customer customer, Boolean isBuyed) {
        this.date = date;
        //this.goods = goods;
        this.customer = customer;
        this.isBuyed = isBuyed;
    }

    public Purchase(@NotNull Date date,
                    /*@NotNull List<Good> goods,*/ @NotNull Customer customer, String address,
                    boolean isBuyed) {
        this.date = date;
        //this.goods = goods;
        this.customer = customer;
        this.address = address;
        this.isBuyed = isBuyed;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isBuyed() {
        return isBuyed;
    }

    public void setBuyed(Boolean buyed) {
        isBuyed = buyed;
    }

    public List<Good> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Good> purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                //", customer=" + customer +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", isBuyed=" + isBuyed +
                //", purchase=" + purchase +
                '}';
    }
}