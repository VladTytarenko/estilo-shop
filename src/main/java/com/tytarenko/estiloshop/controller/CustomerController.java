package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.entity.Admin;
import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.entity.Purchase;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import com.tytarenko.estiloshop.service.interfaces.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/{id}")
    public ModelAndView getCustomer(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.findById(id));
        return new ModelAndView("customer", model);
    }

    @GetMapping("/buyed_purchase")
    public ModelAndView getAllBuyedPurchase() {
        Map<String, Object> model = new HashMap<>();
        model.put("purchase-list", purchaseService.getAllPurchase());
        return new ModelAndView("all-purchase", model);
    }

    @GetMapping("/{id}/buyed_purchase")
    public ModelAndView getBuyedPurchase(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("purchase", purchaseService.getPurchaseByCustomer(id));
        return new ModelAndView("customer-buyed-purchase", model);
    }

    @GetMapping("/{id}/purchase")
    public ModelAndView getPurchase(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("purchase", purchaseService.getNotBuyedPurchaseByCustomer(id));
        return new ModelAndView("customer-buyed-purchase", model);
    }

    @GetMapping("/{id}/update")
    public ModelAndView updateCustomer(@PathVariable("id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.findById(id));
        return new ModelAndView("update-customer", model);
    }

    @PostMapping("/{id}/update")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        System.out.println(customer);
        customerService.updateCustomer(customer);
        return new ModelAndView("redirect:/customer/" + customer.getCustomerId());
    }

    @PostMapping("/{id}/buy/{purchaseId}")
    public void buyPurchase(@PathVariable("id") long id,
                            @PathVariable("purchaseId") long purchaseId) {
        purchaseService.setBuyedPurchaseById(id);
    }
}
