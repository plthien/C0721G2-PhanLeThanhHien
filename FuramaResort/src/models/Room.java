package models;

import libs.UserException;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String serviceName, double usableArea, double cost, int customerMax, String rentingBy) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
    }

    public Room(String serviceName, double usableArea, double cost, int customerMax, String rentingBy, String freeServices) {
        super(serviceName, usableArea, cost, customerMax, rentingBy);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices() {
        boolean check = false;
        do {
            try {
                System.out.println("Enter Free Services: ");
                this.freeServices = sc.nextLine();
                check = UserException.checkNoun(freeServices);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        } while (!check);
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

    public String getInfoToWrite(){
        return super.getServiceName() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy()+ "," +
                this.getFreeServices();
    }
}
