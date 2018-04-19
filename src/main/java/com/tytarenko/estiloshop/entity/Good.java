package com.tytarenko.estiloshop.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;

public class Good {

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

    @NotNull
    private Color color;

    private Image image;

    public Good(@NotNull long goodId, @NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull SizeEnum size,
                @NotNull String composition, @NotNull Color color) {
        this.goodId = goodId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.composition = composition;
        this.color = color;
    }

    public Good(@NotNull long goodId, @NotNull @Size(min = 4, max = 25) String name,
                @NotNull @Size(min = 25, max = 500) String description,
                @NotNull long price, @NotNull SizeEnum size,
                @NotNull String composition, @NotNull Color color, Image image) {
        this.goodId = goodId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.composition = composition;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
                ", color='" + color + '\'' +
                '}';
    }
}
