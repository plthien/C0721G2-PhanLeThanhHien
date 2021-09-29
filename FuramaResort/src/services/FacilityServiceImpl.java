package services;

import libs.MenuException;
import libs.UserException;
import models.*;
import utils.ReadAndWriteFacility;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_HOUSE_PATH = "src\\data\\house.csv";
    private final String FILE_VILLA_PATH = "src\\data\\villa.csv";
    private final String FILE_ROOM_PATH = "src\\data\\room.csv";

    public ArrayList<String> display() {
        Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
        ArrayList<String> serviceNameList = new ArrayList<>();
        int number = 1;
        System.out.println("Facility List: ");
        Set<Facility> keyVilla = villa.keySet();
        for (Facility key : keyVilla) {
            System.out.println(number++ + ". " + key);
            serviceNameList.add(key.getServiceName());
        }
        Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
        Set<Facility> keyHouse = house.keySet();
        for (Facility key : keyHouse) {
            System.out.println(number++ + ". " + key);
            serviceNameList.add(key.getServiceName());
        }
        Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
        Set<Facility> keyRoom = room.keySet();
        for (Facility key : keyRoom) {
            System.out.println(number++ + ". " + key);
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
            boolean check = false;
            String serviceName = "";
            do {
                try {
                    System.out.println("Enter Service Name: ");
                    serviceName = sc.nextLine();
                    check = checkServiceName(serviceName, choice);
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }

            } while (!check);

            double usableArea = 0;
            do {
                try {
                    System.out.println("Enter Usable Area: ");
                    usableArea = Double.parseDouble(sc.nextLine());
                    if (usableArea < 30) {
                        throw new UserException("The usable area is invalid. It is greater than 30!");
                    }
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("It is not a number!");
                }
            } while (usableArea < 30);

            double cost = 0;
            do {
                try {
                    System.out.println("Enter Cost: ");
                    cost = Double.parseDouble(sc.nextLine());
                    if (cost <= 0) {
                        throw new UserException("The cost is grater than 0!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("It is not a number");
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
            } while (cost <= 0);

            int customerMax = 0;
            do {
                try {
                    System.out.println("Enter Customer Maximum: ");
                    customerMax = Integer.parseInt(sc.nextLine());
                    if (customerMax <= 0 || customerMax >= 20) {
                        throw new UserException("The customer maximum is grater than 0 and less than 20!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("It is not a number");
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
            } while (customerMax <= 0 || customerMax >= 20);

            check = false;
            String rentingBy = "";
            do {
                try {
                    System.out.println("Enter Renting by: ");
                    rentingBy = sc.nextLine();
                    check = checkRoomStandardAndRentingBy(rentingBy);
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
            } while (!check);

            Facility facility = FacilityFactory.getFacility(choice, serviceName, usableArea, cost, customerMax, rentingBy);
            if (choice == 3) {
                System.out.println("Enter Free Services: ");
                String freeServices = sc.nextLine();
                Map<Facility, Integer> facilities = new LinkedHashMap<>();
                ((Room) facility).setFreeServices(freeServices);
                facilities.put(facility, 0);
                ReadAndWriteFacility.writeFile(FILE_ROOM_PATH, facilities, true);
                break;
            } else {
                check = false;
                String roomStandard = "";
                do {
                    try {
                        System.out.println("Enter Room Standard: ");
                        roomStandard = sc.nextLine();
                        check = checkRoomStandardAndRentingBy(roomStandard);
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }

                } while (!check);

                int floors = 0;
                do {
                    try {
                        System.out.println("Enter Number of floors: ");
                        floors = Integer.parseInt(sc.nextLine());
                        if (floors <= 0) {
                            throw new UserException("The floors is grater than 0!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("It is not a number");
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                } while (floors <= 0);

                if (choice == 2) {
                    Map<Facility, Integer> facilities = new LinkedHashMap<>();
                    ((House) facility).setRoomStandard(roomStandard);
                    ((House) facility).setFloors(floors);
                    facilities.put(facility, 0);
                    ReadAndWriteFacility.writeFile(FILE_HOUSE_PATH, facilities, true);
                    break;
                } else {
                    double poolArea = 0;
                    do {
                        try {
                            System.out.println("Enter Pool Area: ");
                            poolArea = Double.parseDouble(sc.nextLine());
                            if (poolArea < 30) {
                                throw new UserException("The usable area is invalid. It is greater than 30!");
                            }
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("It is not a number!");
                        }
                    } while (poolArea < 30);

                    Map<Facility, Integer> facilities = new LinkedHashMap<>();
                    ((Villa) facility).setRoomStandard(roomStandard);
                    ((Villa) facility).setPoolArea(poolArea);
                    ((Villa) facility).setFloors(floors);
                    facilities.put(facility, 0);
                    ReadAndWriteFacility.writeFile(FILE_VILLA_PATH, facilities, true);
                    break;
                }
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
                System.out.println(key.toString() + villa.get(key));
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

    public boolean checkServiceName(String serviceName, int choice) throws UserException {
        String regex;
        if (choice == 1) {
            regex = "SVVL-\\d{4}";
        } else if (choice == 2) {
            regex = "SVHO-\\d{4}";
        } else {
            regex = "SVRO-\\d{4}";
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serviceName);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Service name invalid!");
        }
        return check;
    }

    public boolean checkRoomStandardAndRentingBy(String str) throws UserException {
        String regex = "[A-Z][a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Service name invalid!");
        }
        return check;
    }
}
