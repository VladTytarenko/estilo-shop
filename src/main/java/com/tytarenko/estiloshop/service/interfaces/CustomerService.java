package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomerService extends UserDetailsService {

    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);

}
