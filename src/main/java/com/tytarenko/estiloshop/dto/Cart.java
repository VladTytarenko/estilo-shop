package com.tytarenko.estiloshop.dto;

import java.util.ArrayList;

import com.tytarenko.estiloshop.controller.ItemController;

public class Cart extends ArrayList<CartItem> {

	private static final long serialVersionUID = 6787317882591567159L;
	
	public void fetchGoods() {
		for(CartItem cartItem : this) 
			cartItem.setGoods(ItemController.findById(cartItem.getItemId()));
	}
	
	public int getTotal() {
		int total = 0;
		for (CartItem cartItem : this)
			total += cartItem.getAmount()*cartItem.getGoods().getPrice();
		return total;
	}

	public String toString() {
		
		return "test";
	}
	
}
