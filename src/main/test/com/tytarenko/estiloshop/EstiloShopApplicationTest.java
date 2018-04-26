package com.tytarenko.estiloshop;

import com.tytarenko.estiloshop.entity.Customer;
import com.tytarenko.estiloshop.service.interfaces.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EstiloShopApplicationTest {

    @Mock
    private CustomerService customerService;

    @Test
    public void contextLoads() {
        List<Customer> customerList = customerService.findAllCustomers();

    }
}
