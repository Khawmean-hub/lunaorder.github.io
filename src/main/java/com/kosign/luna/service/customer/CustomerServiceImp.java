package com.kosign.luna.service.customer;

import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{

    private CustomerRepository customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
        return customerRepo.findByNameContaining(name, pageable);
    }

    @Override
    public Customer save(Customer customer) {
        if(customerRepo.findById(customer.getId()) == null){
            return customerRepo.save(customer);
        }else 
            return null;
    }

    @Override
    public boolean delete(int id) {
        if(customerRepo.findById(id)!=null){
            customerRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Customer update(Customer customer) {
        if(customerRepo.findById(customer.getId()) != null){
            return customerRepo.save(customer);
        }else 
            return null;
    }

    @Override
    public Customer findById(int id) {  
        return customerRepo.findById(id);
    }
}
