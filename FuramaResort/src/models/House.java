package models;

public class House extends Facility{
    private String roomStandard;
    private int floors;

    public House(String serviceName, double usableArea, double cost, int roomTypes, long rentingBy, String roomStandard, int floors) {
        super(serviceName, usableArea, cost, roomTypes, rentingBy);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }
}
