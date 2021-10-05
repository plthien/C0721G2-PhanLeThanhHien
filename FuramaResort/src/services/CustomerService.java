package services;

import models.Customer;

public interface CustomerService extends Service {
    Customer searchCustomerByCode(String customerCode);


}
