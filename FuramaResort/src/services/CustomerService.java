package services;

import models.Customer;

public interface CustomerService extends Service {
    void editCustomer(String customerCode);
    Customer searchCustomerByCode(String customerCode);


}
