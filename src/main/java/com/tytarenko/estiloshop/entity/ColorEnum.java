package com.tytarenko.estiloshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.Color;

@Entity
public enum ColorEnum {
	
	DARKORANGE   (255, 140,   0),
	DARKTURQUOISE(  0, 206, 209),
	BLACK        (  0,   0,   0);

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private final int r;
    private final int g;
    private final int b;

	
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
}
