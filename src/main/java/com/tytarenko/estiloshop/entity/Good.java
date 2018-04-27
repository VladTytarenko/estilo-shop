package com.tytarenko.estiloshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;


@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long goodId;

    @NotNull
    @Size(min = 4, max = 25)
    private String name;

    @NotNull
    @Size(min = 25, max = 500)
    private String description;

    @NotNull
    private long price;

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    @NotNull
    private Collection<SizeEnum> sizeEnums;

    @NotNull
    private String composition;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    private List<ColorEnum> colors;

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    private List<CartItem> cartItem;

    public Good(){
    }

    public Good(long id, @NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull Collection<SizeEnum> size,
                @NotNull String composition,
                @NotNull List<ColorEnum> colors) {
        this.goodId = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.sizeEnums = size;
        this.composition = composition;
        this.colors = colors;
    }

    public Good(@NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull Collection<SizeEnum> size,
                @NotNull String composition,
                @NotNull List<ColorEnum> colors) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sizeEnums = size;
        this.composition = composition;
        this.colors = colors;
    }

    public Good(@NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull List<SizeEnum> size,
                @NotNull String composition, byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sizeEnums = size;
        this.composition = composition;
        this.image = image;
    }

    public long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
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

    public Collection<SizeEnum> getSizeEnums() {
        return sizeEnums;
    }

    public void setSizeEnums(Collection<SizeEnum> sizeEnums) {
        this.sizeEnums = sizeEnums;
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

    public List<CartItem> getCartItems() {
        return cartItem;
    }

    public void setCartItems(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public List<ColorEnum> getColors() {
        return colors;
    }

    public void setColors(List<ColorEnum> colors) {
        this.colors = colors;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodId=" + goodId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", composition='" + composition + '\'' +
                '}';
    }
}
