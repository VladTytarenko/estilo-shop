package com.tytarenko.estiloshop.entity;

import javax.persistence.*;

@Entity
public enum SizeEnum {

    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    XXXL("XXXL");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String size;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Good good;

    SizeEnum(String size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
