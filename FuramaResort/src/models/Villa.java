package models;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa(String serviceName, double usableArea, double cost, int roomTypes, long rentingBy, String roomStandard, double poolArea, int floors) {
        super(serviceName, usableArea, cost, roomTypes, rentingBy);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }
}