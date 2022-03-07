package com.kosign.luna.rest_controller;

import com.kosign.luna.model.BaseApiResponse;
import com.kosign.luna.model.PageReq;
import com.kosign.luna.model.customer.Customer;
import com.kosign.luna.service.customer.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/customer")
@Api(tags = "Customer", value = "customer", description = "customer for File control")
public class CustomerController {
    
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public BaseApiResponse findAll(@RequestParam(defaultValue = "") String search, PageReq pageReq){
        BaseApiResponse result = new BaseApiResponse();
        Pageable pageable = PageRequest.of(pageReq.getPage(), pageReq.getOffset(), pageReq.getSortDirection(), pageReq.getSortBy());
            result.setCode("0000");
            result.setMessage("fetch data ok");
            result.setData(customerService.findByNameContaining(search, pageable));

        return result;
    }

    @PostMapping("/add")
    public BaseApiResponse save(@RequestBody Customer customer){
        BaseApiResponse result = new BaseApiResponse();
        Customer cust  = customerService.save(customer);
        if(cust != null){
            result.setCode("0000");
            result.setMessage("save successfully");
            result.setData(cust);
        }else {
            result.setCode("0001");
            result.setMessage("customer already exist");
        }

        return result;
    }

    @PutMapping("/update")
    public BaseApiResponse update(@RequestBody Customer customer){
        BaseApiResponse result = new BaseApiResponse();
        Customer cust  = customerService.update(customer);
        if(cust != null){
            result.setCode("0000");
            result.setMessage("update successfully");
            result.setData(cust);
        }else {
            result.setCode("0001");
            result.setMessage("not found");
        }

        return result;
    }

    @DeleteMapping("/delete/{id}")
    public BaseApiResponse delete(@PathVariable int id){
        BaseApiResponse result = new BaseApiResponse();
        Customer customer = customerService.findById(id);
        boolean cust  = customerService.delete(id);
        if(cust){
            result.setCode("0000");
            result.setMessage("delete successfully");
            result.setData(customer);
        }else {
            result.setCode("0001");
            result.setMessage("not found");
        }
        return result;
    }

}
