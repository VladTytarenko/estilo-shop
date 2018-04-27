package com.tytarenko.estiloshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tytarenko.estiloshop.dto.Cart;
import com.tytarenko.estiloshop.dto.Order;

@Controller
public class OrderController {
	
	@Autowired
	private Cart cart;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView mv;
		if(cart.isEmpty()) {
			mv = new ModelAndView("redirect:/cart");
		} else {
			mv = new ModelAndView("order");
			Order order = new Order();
			mv.addObject("order", order);
		}
		return mv;
	}
	
	@RequestMapping(value = "/order/confirm", method = RequestMethod.POST)
	public ModelAndView confirm(@ModelAttribute("order") @Valid Order order, BindingResult results, Errors errors) {
		ModelAndView mv;
		if(cart.isEmpty()) {
			mv = new ModelAndView("redirect:/cart");
		} else {
			if(results.hasErrors()) {
				mv = new ModelAndView("redirect:/order");
			} else {
				mv = new ModelAndView("status");
				mv.addObject("status", "Order is successfully confirmed!");
				cart.clear();
			}
		}
		return mv;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
