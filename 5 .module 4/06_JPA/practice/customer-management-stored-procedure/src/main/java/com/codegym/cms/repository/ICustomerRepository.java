package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import org.springframework.stereotype.Repository;


public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);

}
