package models;

import libs.UserException;

public class House extends Facility{
    private String roomStandard;
    private int floors;

    public House() {
    }

    public House(String serviceId, double usableArea, double cost, int customerMax, String rentingBy) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
    }

    public House(String serviceId, double usableArea, double cost, int customerMax, String rentingBy, String roomStandard, int floors) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard() {
        boolean check = false;
        do {
            try {
                System.out.println("Enter Room Standard: ");
                this.roomStandard = sc.nextLine();
                check = UserException.checkNoun(this.roomStandard);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        } while (!check);
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors() {
        do {
            try {
                System.out.println("Enter Number of floors: ");
                this.floors = Integer.parseInt(sc.nextLine());
                if (this.floors <= 0) {
                    throw new UserException("The floors is grater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (this.floors <= 0);
    }

    @Override
    public String toString() {
        return "House{" +
                " Service Id: " + super.getServiceId()  +
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
        return this.getServiceId().equals(house.getServiceId());
    }

    @Override
    public int hashCode() {
        return serviceId.hashCode();
    }

    public String getInfoToWrite(){
        return super.getServiceId() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy()+ "," +
                this.getRoomStandard() + "," + this.getFloors();
    }

}
