package models;

public class House extends Facility{
    private String roomStandard;
    private int floors;

    public House(String serviceName, double usableArea, double cost, int customerMax, String rentingBy, String roomStandard, int floors) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                " Service Name: " + super.getServiceName()  +
                ", Usable Area: " + super.getUsableArea() +
                ", Cost: " + super.getCost() +
                ", Customer Max: " + super.getCustomerMax() +
                ", Renting By: " + super.getRentingBy() +
                ", Room Standard: " + this.getRoomStandard() +
                ", Floors: " + this.getFloors() + '}';
    }

    @Override
    public boolean equals(Object o) {
        House house = (House) o;
        return this.getServiceName().equals(house.getServiceName());
    }

    @Override
    public int hashCode() {
        return serviceName.hashCode();
    }

    public String getInfoToWrite(){
        return super.getServiceName() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy()+ "," +
                this.getRoomStandard() + "," + this.getFloors();
    }

}
