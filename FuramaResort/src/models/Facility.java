package models;

public abstract class Facility {
    protected String serviceName;
    protected double usableArea;
    protected double cost;
    protected int roomTypes;
    protected long rentingBy;

    public Facility(String serviceName, double usableArea, double cost, int roomTypes, long rentingBy) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cost = cost;
        this.roomTypes = roomTypes;
        this.rentingBy = rentingBy;
    }
}