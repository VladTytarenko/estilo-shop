package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    Customer findByCustomerEmail(String email);
    Customer findByCustomerId(Long id);

}
