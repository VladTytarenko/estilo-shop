package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all_customers")
    public ModelAndView getAllCustomers() {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.findAllCustomers());//customerService.loadUserByUsername("vlad@gmail.com"));
        return new ModelAndView("all-customers", model);
    }

    @GetMapping("/save")
    public ModelAndView saveCustomer() {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String password = b.encode("123456");
        //System.out.println(b.encode("123456"));
        customerService.addCustomer(new Customer("Vlad", "12345678",
                "vlad@gmail.com",password));
        return new ModelAndView("save");
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
       // customerService.addCustomer(customer);
        if(result.hasErrors()) {
            System.out.println(result.toString());
        } else {
            System.out.println("OK");
        }
        return new ModelAndView("test");
    }
}
