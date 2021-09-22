package models;

public class Room extends Facility {
    private String freeServices;

    public Room(String serviceName, double usableArea, double cost, int customerMax, String rentingBy, String freeServices) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                " Service Name: " + super.getServiceName()  +
                ", Usable Area: " + super.getUsableArea() +
                ", Cost: " + super.getCost() +
                ", Customer Max: " + super.getCustomerMax() +
                ", Renting By: " + super.getRentingBy() +
                ", Free Services: " + this.getFreeServices() + '}';
    }


    @Override
    public boolean equals(Object o) {
        Room room = (Room) o;
        return this.getServiceName().equals(room.getServiceName());
    }

    @Override
    public int hashCode() {
        return serviceName.hashCode();
    }
}
