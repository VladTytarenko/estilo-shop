package com.tytarenko.estiloshop.entity;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "size_join_table",
            joinColumns = @JoinColumn(name = "size_id"),
            inverseJoinColumns = @JoinColumn(name = "good_id"))
    private List<Good> good;

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

    public List<Good> getGood() {
        return good;
    }

    public void setGood(List<Good> good) {
        this.good = good;
    }
}
