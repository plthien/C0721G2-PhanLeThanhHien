package services;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import utils.ReadAndWriteFacility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    static Scanner sc = new Scanner(System.in);
    private final String FILE_HOUSE_PATH = "src\\data\\house.csv";
    private final String FILE_VILLA_PATH = "src\\data\\villa.csv";
    private final String FILE_ROOM_PATH = "src\\data\\room.csv";

    public void display() {
        Map<Facility,Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        System.out.println("Villa List: ");
        Set<Facility> keyVilla = villa.keySet();
        for (Facility key : keyVilla) {
            System.out.println(key);
        }
        Map<Facility,Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        System.out.println("House List: ");
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            System.out.println(key);
        }
        Map<Facility,Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        System.out.println("Room List: ");
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
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
                case 1: {
                    System.out.println("Enter Room Standard: ");
                    String roomStandard = sc.nextLine();
                    System.out.println("Enter Pool Area: ");
                    double poolArea = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter Number of floors: ");
                    int floors = Integer.parseInt(sc.nextLine());
                    Map<Facility, Integer> facilities = new LinkedHashMap<>();
                    facilities.put(new Villa(serviceName, usableArea, cost, customerMax, rentingBy, roomStandard, poolArea, floors), 0);
                    ReadAndWriteFacility.writeFile(FILE_VILLA_PATH, facilities);
                    break;
                }

                case 2: {
                    System.out.println("Enter Room Standard: ");
                    String roomStandardHouse = sc.nextLine();
                    System.out.println("Enter Number of floors: ");
                    int floorsHouse = Integer.parseInt(sc.nextLine());
                    Map<Facility, Integer> facilities = new LinkedHashMap<>();
                    facilities.put(new House(serviceName, usableArea, cost, customerMax, rentingBy, roomStandardHouse, floorsHouse), 0);
                    ReadAndWriteFacility.writeFile(FILE_HOUSE_PATH, facilities);
                    break;
                }

                case 3: {
                    System.out.println("Enter Free Services: ");
                    String freeServices = sc.nextLine();
                    Map<Facility, Integer> facilities = new LinkedHashMap<>();
                    facilities.put(new Room(serviceName, usableArea, cost, customerMax, rentingBy, freeServices), 0);
                    ReadAndWriteFacility.writeFile(FILE_ROOM_PATH, facilities);
                    break;
                }

            }
            display();
        } while (true);

    }

//    public void useFacilities(String serviceName) {
//        Set<Facility> set = facilities.keySet();
//        for (Facility key : set) {
//            if (key.getServiceName().contains(serviceName)) {
//                facilities.computeIfPresent(key, (k, v) -> v + 1);
//                break;
//            }
//        }
//    }

    public void displayFacilityMaintenance() {
        Map<Facility,Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        System.out.println("Villa Maintenance List: ");
        Set<Facility> keyVilla = villa.keySet();
        for (Facility key : keyVilla) {
            if (villa.get(key) >= 5) {
                System.out.println(key.toString() + villa.get(key));
            }
        }
        Map<Facility,Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        System.out.println("House List: ");
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            if (house.get(key) >= 5) {
                System.out.println(key.toString() + house.get(key));
            }
        }
        Map<Facility,Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        System.out.println("Room List: ");
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
            if (room.get(key) >= 5) {
                System.out.println(key.toString() + room.get(key));
            }
        }
    }


}
