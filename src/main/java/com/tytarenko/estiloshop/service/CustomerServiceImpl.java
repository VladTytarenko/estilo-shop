package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.CustomerDao;
import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return customerDao.findByEmail(userName);
    }
}
