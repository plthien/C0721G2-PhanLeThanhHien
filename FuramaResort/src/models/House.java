package models;

public class House extends Facility{
    private String roomStandard;
    private int floors;

    public House(String rentalPropertiesTypes, double usableArea, double cost, int roomTypes, long rentingBy, String roomStandard, int floors) {
        super(rentalPropertiesTypes, usableArea, cost, roomTypes, rentingBy);
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
}
