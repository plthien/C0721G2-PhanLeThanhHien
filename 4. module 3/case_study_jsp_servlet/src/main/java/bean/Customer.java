package bean;

public class Customer extends Person {
    private String customerType;

    public Customer() {
    }



    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
