package models;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int floors;


    public Villa(String rentalPropertiesTypes, double usableArea, double cost, int roomTypes, long rentingBy, String roomStandard, double poolArea, int floors) {
        super(rentalPropertiesTypes, usableArea, cost, roomTypes, rentingBy);
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
}
