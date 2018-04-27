package com.tytarenko.estiloshop.controller;

import com.tytarenko.estiloshop.entity.*;
import com.tytarenko.estiloshop.service.interfaces.AdminService;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import com.tytarenko.estiloshop.service.interfaces.GoodService;
import com.tytarenko.estiloshop.service.interfaces.PurchaseService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class Test {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private GoodService goodService;

    @GetMapping("/good")
    public ModelAndView getGood() {
        List<SizeEnum> sizeEnums = new ArrayList<>();
        sizeEnums.add(SizeEnum.S);
        sizeEnums.add(SizeEnum.L);
        List<Good> goodList = goodService.getByFilterAsc(SizeEnum.S, 11, 13);
        if (goodList != null) {
            for (Good good : goodList)
                System.out.println(good);
        }
        else
            System.out.println("NO!!!");
        return new ModelAndView("save");
    }

    @GetMapping("/purchase")
    public ModelAndView getPurchase() {
        List<Purchase> purchase = purchaseService.getPurchaseByCustomer(1L);
        if (purchase != null) {
            for (Purchase purchase1 : purchase)
                System.out.println(purchase1);
        }
        else
            System.out.println("NO!!!");
        return new ModelAndView("save");
    }

    @GetMapping("/admin_test")
    public ModelAndView getAdmin() {
        Admin admin = adminService.getAdminByLogin("avt@ukr.net");
        Admin admin1 = adminService.getAdminById(1L);
        if (admin != null)
            System.out.println(admin);
        else
            System.out.println("NO!!!!");
        if (admin1 != null)
            System.out.println(admin1);
        else
            System.out.println("NO-2!!!!");

        return new ModelAndView("save");
    }


    @GetMapping("/all_customers")
    public ModelAndView getAllCustomers() {
        Map<String, Object> model = new HashMap<>();
        model.put("customer", customerService.findAllCustomers());
        Customer customer = customerService.findByCustomerEmail("qw@ukr.net");
        Customer customer1 = customerService.findById(1L);
        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("NO!!!!");
        if(customer != null)
            System.out.println(customer1);
        else
            System.out.println("NO-2!!!");
        return new ModelAndView("all-customers", model);
    }

    @GetMapping("/save")
    public ModelAndView saveCustomer() {
//        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String password = "123456";
        //System.out.println(b.encode("123456"));
        customerService.addCustomer(new Customer(1, "Vlad", "12345678",
                "vlad@gmail.com",password));
        return new ModelAndView("save");
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        customerService.addCustomer(customer);
        if(result.hasErrors()) {
            System.out.println(result.toString());
        } else {
            System.out.println("OK");
        }
        return new ModelAndView("test");
    }
}
