package models;

import libs.UserException;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String serviceId, double usableArea, double cost, int customerMax, String rentingBy) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
    }

    public Room(String serviceId, double usableArea, double cost, int customerMax, String rentingBy, String freeServices) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
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
                " Service Id: " + super.getServiceId()  +
                ", Usable Area: " + super.getUsableArea() +
                ", Cost: " + super.getCost() +
                ", Customer Max: " + super.getCustomerMax() +
                ", Renting By: " + super.getRentingBy() +
                ", Free Services: " + this.getFreeServices() + '}';
    }


    @Override
    public boolean equals(Object o) {
        Room room = (Room) o;
        return this.getServiceId().equals(room.getServiceId());
    }

    @Override
    public int hashCode() {
        return serviceId.hashCode();
    }

    public String getInfoToWrite(){
        return super.getServiceId() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy()+ "," +
                this.getFreeServices();
    }
}
