package com.kosign.luna.service.customer;

import com.kosign.luna.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
    Customer findById(int id);
    Customer save(Customer product);
    boolean delete(int id);
    Customer update(Customer product);
}
