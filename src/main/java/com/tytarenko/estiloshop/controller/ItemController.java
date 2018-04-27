package com.tytarenko.estiloshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.tytarenko.estiloshop.service.interfaces.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tytarenko.estiloshop.dto.Cart;
import com.tytarenko.estiloshop.dto.CartItem;
import com.tytarenko.estiloshop.entity.ColorEnum;
import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;

@Controller
public class ItemController {
	
	@Autowired
	private Cart cart;

	@Autowired
	private GoodService  goodService;
	
	@RequestMapping(value = { "/", "/items" }, method = RequestMethod.GET)
	public ModelAndView collection() {
		ModelAndView mv = new ModelAndView("items");
		List<Good> items = findAll();
		mv.addObject("items", items);
		mv.addObject("cartSize", cart.size());
		return mv;
	}
	
	@RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
	public ModelAndView item(@PathVariable("itemId") long itemId) {
		ModelAndView mv = new ModelAndView("item");
		Good item = findById(itemId);
		mv.addObject("item", item);
		CartItem cartItem = new CartItem();
		mv.addObject("cartItem", cartItem);
		mv.addObject("cartSize", cart.size());
		return mv;
	}
	
	public static List<Good> findAll() {
		List<SizeEnum> sizeEnums = new ArrayList<>();
		sizeEnums.add(SizeEnum.S);
		sizeEnums.add(SizeEnum.XL);
		sizeEnums.add(SizeEnum.XXXL);
		List<ColorEnum> colors = new ArrayList<>();
		colors.add(ColorEnum.DARKORANGE);
		colors.add(ColorEnum.DARKTURQUOISE);
		colors.add(ColorEnum.BLACK);
		Good[] all = new Good[]
		{
			new Good(1,"One goods name", "This is one goods description from server.", 100, sizeEnums, "composition stuff", colors),
			new Good(2,"Two goods name", "This is one goods description from server.", 100, sizeEnums, "composition stuff", colors),
			new Good(3, "Third goods name", "This is one goods description from server.", 100, sizeEnums, "composition stuff", colors),
			new Good(4,"Four goods name", "This is one goods description from server.", 100, sizeEnums, "composition stuff", colors),
			new Good(5,"Five goods name", "This is one goods description from server.", 100, sizeEnums, "composition stuff", colors)
		};
		return Arrays.asList(all);
	}
	
	public static Good findById(long id) {
		for (Good item : findAll()) {
			if(item.getGoodId() == id)
				return item;
		}
		return null;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
