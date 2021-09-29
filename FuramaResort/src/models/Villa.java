package models;

import java.util.Objects;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa(String serviceName, double usableArea, double cost, int customerMax, String rentingBy) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
    }

    public Villa(String serviceName, double usableArea, double cost, int customerMax, String rentingBy,
                 String roomStandard, double poolArea, int floors) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                " Service Name: " + super.getServiceName()  +
                ", Usable Area: " + super.getUsableArea() +
                ", Cost: " + super.getCost() +
                ", Customer Max: " + super.getCustomerMax() +
                ", Renting By: " + super.getRentingBy() +
                ", Room Standard: " + this.getRoomStandard() +
                ", Pool Area: " + this.getPoolArea() +
                ", Floors: " + this.getFloors() + '}';
    }

    @Override
    public boolean equals(Object o) {
        Villa villa = (Villa) o;
        return this.getServiceName().equals(villa.getServiceName());
    }

    @Override
    public int hashCode() {
        return serviceName.hashCode();
    }

    public String getInfoToWrite(){
        return super.getServiceName() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy()+ "," +
                this.getRoomStandard() + "," + this.getPoolArea()+ "," +
                this.getFloors();
    }
}