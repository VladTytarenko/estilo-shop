package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
}
