package services;

import libs.UserException;
import models.Booking;
import utils.ReadAndWriteBooking;

import java.util.*;


public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_BOOKING_PATH = "src\\data\\booking.csv";


    public void display() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        System.out.println("Booking List: ");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }

    }

    @Override
    public void edit(String bookingCode) {
        //bo sung sau
    }

    @Override
    public void delete() {
        //bo sung sau
    }

    @Override
    public void add() {
        ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("Choose customer: ");
        customerService.display();
        ArrayList<String> customerCodeList = customerService.getCustomerCodeList();
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
        facilityService.display();
        ArrayList<String> idServiceList = facilityService.getIdServiceList();
        String serviceName = "";
        do {
            System.out.println("Enter number of Service: ");
            choice = Integer.parseInt(sc.nextLine());
            try {
                serviceName = idServiceList.get(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your choice out of range");
            }
        } while (choice - 1 < 0 || choice - 1 >= idServiceList.size());

        String checkInDate, checkOutDate;
        boolean flag;
        do {
            System.out.println("Enter Checkin Date: ");
            checkInDate = sc.nextLine();
            System.out.println("Enter Checkout Date: ");
            checkOutDate = sc.nextLine();
            flag = UserException.checkDate(checkInDate, checkOutDate);
        } while (!flag);

        Booking booking = new Booking(customerCode, serviceName, checkInDate, checkOutDate);
        booking.setBookingCode();
        ReadAndWriteBooking.writeFile(FILE_BOOKING_PATH, booking);
        facilityService.useFacilities(serviceName);
    }

}
