package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return iCustomerRepository.insertWithStoredProcedure(customer);
    }
}
