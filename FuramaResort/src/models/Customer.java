package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Customer extends Person {
    private String customerTypes;
    private String address;
    private String customerCode;


    public Customer(String name, String birthDay, boolean gender, String personalID, String phoneNumber, String email,
                    String customerTypes, String address, String customerCode) {
        super(name, birthDay, gender, personalID, phoneNumber, email);
        this.customerTypes = customerTypes;
        this.address = address;
        this.customerCode = customerCode;
    }

    public String getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(String customerTypes) {
        this.customerTypes = customerTypes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " Customer Code: " + this.getCustomerCode() +
                ", Name: " + super.getName() +
                ", BirthDay: " + super.getBirthDay() +
                ", Gender: " + super.isGender() +
                ", Personal ID: " + super.getPersonalID() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", Email: " + super.getEmail() +
                ", Customer Types: " + this.getCustomerTypes() +
                ", Address: " + this.getAddress() + '}';
    }
}
