package com.tytarenko.estiloshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tytarenko.estiloshop.dto.Cart;
import com.tytarenko.estiloshop.dto.CartItem;

@Controller
public class CartController {
	
	@Autowired
	private Cart cart;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView("cart");
		cart.fetchGoods();
		mv.addObject("cartItems", (List<CartItem>) cart);
		mv.addObject("total", cart.getTotal());
		mv.addObject("cartSize", cart.size());
		System.out.println(cart);
		return mv;
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView cartAddItem(@ModelAttribute("cartItem") @Valid CartItem cartItem, BindingResult results, Errors errors) {
		ModelAndView mv = new ModelAndView("redirect:/items/" + cartItem.getItemId());
		if(!results.hasErrors()) {
			cart.add(cartItem);
		}
		System.out.println(cart);
		return mv;
	}
	
	@RequestMapping(value = "/cart/{cartItemIndex}", method = RequestMethod.GET)
	public ModelAndView cartDelete(@PathVariable("cartItemIndex") int cartItemIndex) {
		ModelAndView mv = new ModelAndView("redirect:/cart");
		cart.remove(cartItemIndex);
		return mv;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
