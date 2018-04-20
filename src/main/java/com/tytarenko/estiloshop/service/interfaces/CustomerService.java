package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService {

    Customer findById(long id);
    List<Customer> findAllCustomers();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);

}
