package com.tytarenko.estiloshop.dto;

import java.util.ArrayList;

import com.tytarenko.estiloshop.controller.ItemController;
import com.tytarenko.estiloshop.service.interfaces.GoodService;
import org.springframework.beans.factory.annotation.Autowired;

public class Cart extends ArrayList<CartItem> {

	private static final long serialVersionUID = 6787317882591567159L;

	@Autowired
	private GoodService goodService;

	public void fetchGoods() {
		for(CartItem cartItem : this) 
			cartItem.setGoods(goodService.getGoodById(cartItem.getItemId()));
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
