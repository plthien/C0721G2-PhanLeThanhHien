package com.codegym.shoppingcart.service.impl;

import com.codegym.shoppingcart.model.Customer;
import com.codegym.shoppingcart.repository.ICustomerRepository;
import com.codegym.shoppingcart.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Customer save(Customer customer) {
       return  iCustomerRepository.save(customer);
    }
}
