package models;

public class FacilityFactory {

    private FacilityFactory() {
    }

    public static Facility getFacility(int choice) {
        if (choice == 1) {
            return new Villa();
        } else if (choice == 2) {
            return new House();
        } else return new Room();
    }
}
