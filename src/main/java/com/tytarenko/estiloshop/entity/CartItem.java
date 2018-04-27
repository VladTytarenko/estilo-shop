package com.tytarenko.estiloshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tytarenko.estiloshop.entity.ColorEnum;
import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;

import java.util.List;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cardId;

	@NotNull
	private Long itemId;

	@NotNull
	private ColorEnum color;

	@NotNull
	private SizeEnum sizeEnum;

	@NotNull
	@Min(1)
	private Integer amount;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Good good;

	@ManyToMany
	@JoinTable(name = "purchase_join_table",
			joinColumns = @JoinColumn(name = "cartItem_id"),
			inverseJoinColumns = @JoinColumn(name = "purchase_id"))
	private List<Purchase> cartItem;
	
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
		return good;
	}

	public void setGoods(Good goods) {
		this.good = good;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
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
