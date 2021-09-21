package models;

public class Room extends Facility {
    private String freeServices;

    public Room(String serviceName, double usableArea, double cost, int roomTypes, long rentingBy, String freeServices) {
        super(serviceName, usableArea, cost, roomTypes, rentingBy);
        this.freeServices = freeServices;
    }
}
