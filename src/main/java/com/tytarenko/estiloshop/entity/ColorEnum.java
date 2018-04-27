package com.tytarenko.estiloshop.entity;

import javax.persistence.*;

@Entity
public enum ColorEnum {
	
	DARKORANGE   (255, 140,   0),
	DARKTURQUOISE(  0, 206, 209),
	BLACK        (  0,   0,   0);

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private int r;
    private int g;
    private int b;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Good good;

    ColorEnum() {
    }

    private ColorEnum(final int r, final int g, final int b) {
		this.r = r;
        this.g = g;
        this.b = b;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setB(int b) {
        this.b = b;
    }
}
