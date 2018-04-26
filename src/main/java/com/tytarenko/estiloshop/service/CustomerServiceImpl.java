package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.CustomerDao;
import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer findById(Long id) {
        return customerDao.findByCustomerId(id);
    }

    @Override
    public Customer findByCustomerEmail(String email) {
        return customerDao.findByCustomerEmail(email);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.saveAndFlush(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.saveAndFlush(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return customerDao.findByCustomerEmail(userName);
    }
}
