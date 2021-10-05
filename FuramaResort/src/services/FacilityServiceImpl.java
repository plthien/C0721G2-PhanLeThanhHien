package services;

import libs.MenuException;
import libs.UserException;
import models.*;
import utils.ReadAndWriteFacility;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_HOUSE_PATH = "src\\data\\house.csv";
    private final String FILE_VILLA_PATH = "src\\data\\villa.csv";
    private final String FILE_ROOM_PATH = "src\\data\\room.csv";

    public void display() {
        Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        int number = 1;
        System.out.println("Facility List: ");
        Set<Facility> keyVilla = villa.keySet();
        for (Facility key : keyVilla) {
            System.out.println(number++ + ". " + key);
        }
        Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            System.out.println(number++ + ". " + key);
        }
        Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
            System.out.println(number++ + ". " + key);
        }
    }

    @Override
    public void edit(String str) {
        //bo sung sau
    }

    @Override
    public void delete() {
        // bo sung sau
    }

    public ArrayList<String> getServiceNameList(){
        Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        Set<Facility> keyVilla = villa.keySet();
        ArrayList<String> serviceNameList = new ArrayList<>();
        for (Facility key : keyVilla) {
            serviceNameList.add(key.getServiceName());
        }
        Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            serviceNameList.add(key.getServiceName());
        }
        Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
            serviceNameList.add(key.getServiceName());
        }
        return serviceNameList;
    }

    public void add() {
        int choice = 0;
        do {
            do {
                try {
                    System.out.println("Menu: 1. Add New Villa \t 2. Add New House \t 3. Add New Room \t 4. Back to menu");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice <= 0 || choice >= 5) {
                        throw new MenuException("Your choice is invalid!");
                    }
                } catch (MenuException e) {
                    System.out.println(e.getMessage());
                }
            } while (choice <= 0 || choice >= 5);

            if (choice == 4) {
                break;
            }
            Map<Facility, Integer> facilityList = new LinkedHashMap<>();
            Facility facility = FacilityFactory.getFacility(choice);
            facility.setServiceName();
            facility.setUsableArea();
            facility.setCost();
            facility.setCustomerMax();
            facility.setRentingBy();
            if (facility instanceof Room) {
                ((Room) facility).setFreeServices();
                facilityList.put(facility, 0);
                ReadAndWriteFacility.writeFile(FILE_ROOM_PATH, facilityList, true);
                break;
            } else if (facility instanceof House) {
                ((House) facility).setRoomStandard();
                ((House) facility).setFloors();
                facilityList.put(facility, 0);
                ReadAndWriteFacility.writeFile(FILE_HOUSE_PATH, facilityList, true);
                break;
            } else {
                ((Villa) facility).setRoomStandard();
                ((Villa) facility).setPoolArea();
                ((Villa) facility).setFloors();
                facilityList.put(facility, 0);
                ReadAndWriteFacility.writeFile(FILE_VILLA_PATH, facilityList, true);
                break;
            }
        } while (true);
        display();
    }

    public void useFacilities(String serviceName) {
        if (serviceName.contains("VL")) {
            Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
            Set<Facility> keyVilla = villa.keySet();
            for (Facility key : keyVilla) {
                if (key.getServiceName().contains(serviceName)) {
                    villa.computeIfPresent(key, (k, v) -> v + 1);
                    ReadAndWriteFacility.writeFile(FILE_VILLA_PATH, villa, false);
                    break;
                }
            }

        } else if (serviceName.contains("HO")) {
            Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
            Set<Facility> keyHouse = house.keySet();
            for (Facility key : keyHouse) {
                if (key.getServiceName().contains(serviceName)) {
                    house.computeIfPresent(key, (k, v) -> v + 1);
                    ReadAndWriteFacility.writeFile(FILE_HOUSE_PATH, house, false);
                    break;
                }
            }
        } else {
            Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
            Set<Facility> keyRoom = room.keySet();
            for (Facility key : keyRoom) {
                if (key.getServiceName().contains(serviceName)) {
                    room.computeIfPresent(key, (k, v) -> v + 1);
                    ReadAndWriteFacility.writeFile(FILE_ROOM_PATH, room, false);
                    break;
                }
            }

        }
    }

    public void displayFacilityMaintenance() {
        Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        System.out.println("Villa Maintenance List: ");
        Set<Facility> keyVilla = villa.keySet();
        for (Facility key : keyVilla) {
            if (villa.get(key) >= 5) {
                System.out.println(key.toString() + " - Number of uses: " + villa.get(key));
            }
        }
        Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        System.out.println("House List: ");
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            if (house.get(key) >= 5) {
                System.out.println(key.toString() + house.get(key));
            }
        }
        Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        System.out.println("Room List: ");
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
            if (room.get(key) >= 5) {
                System.out.println(key.toString() + room.get(key));
            }
        }
    }


}
