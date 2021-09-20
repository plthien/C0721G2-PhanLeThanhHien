package models;

public class Room extends Facility {
    private String freeServices;

    public Room(String rentalPropertiesTypes, double usableArea, double cost, int roomTypes, long rentingBy, String freeServices) {
        super(rentalPropertiesTypes, usableArea, cost, roomTypes, rentingBy);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
}
