package models;

import libs.UserException;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String serviceId, double usableArea, double cost, int customerMax, String rentingBy) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
    }

    public Villa(String serviceId, double usableArea, double cost, int customerMax, String rentingBy,
                 String roomStandard, double poolArea, int floors) {
        super(serviceId, usableArea, cost, customerMax, rentingBy);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea() {
        do {
            try {
                System.out.println("Enter Pool Area: ");
                this.poolArea = Double.parseDouble(sc.nextLine());
                if (this.poolArea < 30) {
                    throw new UserException("The usable area is invalid. It is greater than 30!");
                }
            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.poolArea < 30);
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
        return "Villa{" +
                " Service Id: " + super.getServiceId() +
                ", Usable Area: " + super.getUsableArea() +
                ", Cost: " + super.getCost() +
                ", Customer Max: " + super.getCustomerMax() +
                ", Renting By: " + super.getRentingBy() +
                ", Room Standard: " + this.getRoomStandard() +
                ", Pool Area: " + this.getPoolArea() +
                ", Floors: " + this.getFloors() + '}';
    }

    @Override
    public boolean equals(Object o) {
        Villa villa = (Villa) o;
        return this.getServiceId().equals(villa.getServiceId());
    }

    @Override
    public int hashCode() {
        return serviceId.hashCode();
    }

    public String getInfoToWrite() {
        return super.getServiceId() + "," + super.getUsableArea() + "," + super.getCost() + "," +
                super.getCustomerMax() + "," + super.getRentingBy() + "," +
                this.getRoomStandard() + "," + this.getPoolArea() + "," +
                this.getFloors();
    }
}