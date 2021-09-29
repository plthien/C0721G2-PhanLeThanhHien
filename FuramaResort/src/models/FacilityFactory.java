package models;

public class FacilityFactory {

    private FacilityFactory() {
    }

    public static Facility getFacility(int choice, String serviceName, double usableArea, double cost, int customerMax, String rentingBy) {
        if (choice == 1) {
            return new Villa(serviceName, usableArea, cost, customerMax, rentingBy);
        } else if (choice == 2) {
            return new House(serviceName, usableArea, cost, customerMax, rentingBy);
        } else return new Room(serviceName, usableArea, cost, customerMax, rentingBy);
    }
}
