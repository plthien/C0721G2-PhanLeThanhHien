package models;

public abstract class Facility {
    protected String rentalPropertiesTypes;
    protected double usableArea;
    protected double cost;
    protected int roomTypes;
    protected long rentingBy;

    public Facility(String rentalPropertiesTypes, double usableArea, double cost, int roomTypes, long rentingBy) {
        this.rentalPropertiesTypes = rentalPropertiesTypes;
        this.usableArea = usableArea;
        this.cost = cost;
        this.roomTypes = roomTypes;
        this.rentingBy = rentingBy;
    }

    public String getRentalPropertiesTypes() {
        return rentalPropertiesTypes;
    }

    public void setRentalPropertiesTypes(String rentalPropertiesTypes) {
        this.rentalPropertiesTypes = rentalPropertiesTypes;
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

    public int getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(int roomTypes) {
        this.roomTypes = roomTypes;
    }

    public long getRentingBy() {
        return rentingBy;
    }

    public void setRentingBy(long rentingBy) {
        this.rentingBy = rentingBy;
    }
}
