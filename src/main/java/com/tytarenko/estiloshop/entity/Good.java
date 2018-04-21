package com.tytarenko.estiloshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long goodId;

    @NotNull
    @Size(min = 4, max = 25)
    private String name;

    @NotNull
    @Size(min = 25, max = 500)
    private String description;

    @NotNull
    private long price;

    @NotNull
    private SizeEnum size;

    @NotNull
    private String composition;

    @Lob
    private byte[] image;

    @ManyToMany(mappedBy = "goods")
    private List<Purchase> purchaseList;

    public Good(){
    }

    public Good(@NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull SizeEnum size,
                @NotNull String composition) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.composition = composition;
    }

    public Good(@NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull SizeEnum size,
                @NotNull String composition, byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.composition = composition;
        this.image = image;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(long goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", composition='" + composition + '\'' +
                '}';
    }
}
