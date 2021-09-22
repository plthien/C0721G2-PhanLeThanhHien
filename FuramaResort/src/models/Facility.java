package models;

public abstract class Facility {
    protected String serviceName;
    protected double usableArea;
    protected double cost;
    protected int customerMax;
    protected String rentingBy;

    public Facility(String serviceName, double usableArea, double cost, int customerMax, String rentingBy) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cost = cost;
        this.customerMax = customerMax;
        this.rentingBy = rentingBy;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCustomerMax() {
        return customerMax;
    }

    public void setCustomerMax(int customerMax) {
        this.customerMax = customerMax;
    }

    public String getRentingBy() {
        return rentingBy;
    }

    public void setRentingBy(String rentingBy) {
        this.rentingBy = rentingBy;
    }
}