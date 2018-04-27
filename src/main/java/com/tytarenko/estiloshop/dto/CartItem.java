package com.tytarenko.estiloshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tytarenko.estiloshop.entity.ColorEnum;
import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;

public class CartItem {
	
	@NotNull
	private Long itemId;
	
	private Good goods;

	@NotNull
	private ColorEnum color;

	@NotNull
	private SizeEnum sizeEnum;

	@NotNull
	@Min(1)
	private Integer amount;
	
	public CartItem() {}

	public CartItem(Long itemId, ColorEnum color, SizeEnum sizeEnum, Integer amount) {
		super();
		this.itemId = itemId;
		this.color = color;
		this.sizeEnum = sizeEnum;
		this.amount = amount;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public ColorEnum getColor() {
		return color;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public SizeEnum getSizeEnum() {
		return sizeEnum;
	}

	public void setSizeEnum(SizeEnum sizeEnum) {
		this.sizeEnum = sizeEnum;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Good getGoods() {
		return goods;
	}

	public void setGoods(Good goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartItem [itemId=");
		builder.append(itemId);
		builder.append(", color=");
		builder.append(color);
		builder.append(", sizeEnum=");
		builder.append(sizeEnum);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
		
}
