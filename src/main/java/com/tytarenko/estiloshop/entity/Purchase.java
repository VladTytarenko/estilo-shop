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
    private long purchaseId;

    @ManyToMany()
    @JoinTable(name = "good",
    joinColumns = @JoinColumn(name = "purchase_Id"),
    inverseJoinColumns = @JoinColumn(name = "goodId"))
    @NotNull
    private List<Good> goods;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

    @Column(nullable = true)
    private String address;

    @NotNull
    private Date date;

    private boolean isBuyed;

    public Purchase() {
    }

    public Purchase(@NotNull Date date,
                    @NotNull List<Good> goods, @NotNull Customer customer, boolean isBuyed) {
        this.date = date;
        this.goods = goods;
        this.customer = customer;
        this.isBuyed = isBuyed;
    }

    public Purchase(@NotNull Date date,
                    @NotNull List<Good> goods, @NotNull Customer customer, String address,
                    boolean isBuyed) {
        this.date = date;
        this.goods = goods;
        this.customer = customer;
        this.address = address;
        this.isBuyed = isBuyed;
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

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
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

    public void setBuyed(boolean buyed) {
        isBuyed = buyed;
    }
}