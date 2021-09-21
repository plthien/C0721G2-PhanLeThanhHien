package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Customer extends Person {
    private static Map<Integer,String> customerTypes = new LinkedHashMap<>();
    private String address;
    private String customerCode;

    static {
        customerTypes.put(1,"Diamond");
        customerTypes.put(2,"Platinium");
        customerTypes.put(3,"Gold");
        customerTypes.put(4,"Silver");
        customerTypes.put(5,"Member");
    }

    public Customer(String name, String birthDay, boolean gender, String personalID, String phoneNumber, String email, String address, String customerCode) {
        super(name, birthDay, gender, personalID, phoneNumber, email);
        this.address = address;
        this.customerCode = customerCode;
    }
}
