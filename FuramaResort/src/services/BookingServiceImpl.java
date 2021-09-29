package services;

import models.Booking;
import models.Customer;
import models.Person;
import utils.ReadAndWriteBooking;
import utils.ReadAndWritePerson;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src\\data\\booking.csv";
    private final String FILE_CUSTOMER_PATH = "src\\data\\customer.csv";


    public void display() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_PATH);
        System.out.println("Booking List: ");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }

    }

    @Override
    public void add() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("Choose customer: ");
        ArrayList<String> customerCodeList = customerService.display();
        String customerCode = "";
        int choice;
        do {
            System.out.println("Enter number of customer: ");
            choice = Integer.parseInt(sc.nextLine());
            try {
                customerCode = customerCodeList.get(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your choice out of range");
            }

        } while (choice - 1 < 0 || choice - 1 >= customerCodeList.size());

        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        System.out.println("Choose service name: ");
        ArrayList<String> serviceNameList = facilityService.display();
        String serviceName = "";
        do {
            System.out.println("Enter number of Service Name: ");
            choice = Integer.parseInt(sc.nextLine());
            try {
                serviceName = serviceNameList.get(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your choice out of range");
            }
        } while (choice - 1 < 0 || choice - 1 >= serviceNameList.size());

        System.out.println("Enter Checkin Date: ");
        int checkInDate = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Checkout Date: ");
        int checkOutDate = Integer.parseInt(sc.nextLine());
        Booking booking = new Booking(customerCode, serviceName, checkInDate, checkOutDate);
        booking.setBookingCode();
        ReadAndWriteBooking.writeFile(FILE_PATH, booking);

        facilityService.useFacilities(serviceName);
    }

}
