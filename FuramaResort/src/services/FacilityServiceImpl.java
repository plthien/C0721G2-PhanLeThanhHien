package services;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilities = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);

    static {
        facilities.put(new Villa("Villa-01", 500, 200, 10, "Day",
                "Deluxe Room", 90, 3), 2);
        facilities.put(new House("House-01", 150, 100, 5, "Day",
                "Family Room", 2), 7);
        facilities.put(new Room("Room-01", 30, 20, 2, "Hours",
                "Free Wifi/ Water"), 6);
    }

    public void display() {
        System.out.println("Facilities List: ");
        Set<Facility> set = facilities.keySet();
        for (Facility key : set) {
            System.out.println(key);
        }
    }

    public void add() {
        int choice;
        do {
            System.out.println("Menu: 1. Add New Villa \t 2. Add New House \t 3. Add New Room \t 4. Back to menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 4) {
                break;
            }
            System.out.println("Enter Service Name: ");
            String serviceName = sc.nextLine();
            System.out.println("Enter Usable Area: ");
            double usableArea = Double.parseDouble(sc.nextLine());
            System.out.println("Enter Cost: ");
            double cost = Double.parseDouble(sc.nextLine());
            System.out.println("Enter Customer Maximum: ");
            int customerMax = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Renting by: ");
            String rentingBy = sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Room Standard: ");
                    String roomStandard = sc.nextLine();
                    System.out.println("Enter Pool Area: ");
                    double poolArea = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter Number of floors: ");
                    int floors = Integer.parseInt(sc.nextLine());
                    facilities.put(new Villa(serviceName, usableArea, cost, customerMax, rentingBy, roomStandard, poolArea, floors), 0);
                    break;
                case 2:
                    System.out.println("Enter Room Standard: ");
                    String roomStandardHouse = sc.nextLine();
                    System.out.println("Enter Number of floors: ");
                    int floorsHouse = Integer.parseInt(sc.nextLine());
                    facilities.put(new House(serviceName, usableArea, cost, customerMax, rentingBy, roomStandardHouse, floorsHouse), 0);
                    break;
                case 3:
                    System.out.println("Enter Free Services: ");
                    String freeServices = sc.nextLine();
                    facilities.put(new Room(serviceName, usableArea, cost, customerMax, rentingBy, freeServices), 0);
                    break;
            }
            display();
        } while (true);

    }

    public void useFacilities(String serviceName) {
        Set<Facility> set = facilities.keySet();
        for (Facility key : set) {
            if (key.getServiceName().contains(serviceName)) {
                facilities.computeIfPresent(key, (k, v) -> v + 1);
                break;
            }
        }
    }

    public void displayFacilityMaintenance() {
        System.out.println("Facilities Maintenance List: ");
        for (Map.Entry<Facility, Integer> entry : facilities.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + "- Number of Uses: " + entry.getValue());
            }
        }
    }


}
