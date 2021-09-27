package services;

import models.Booking;
import utils.ReadAndWriteBooking;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src\\data\\booking.csv";

    @Override
    public void display() {
        Set<Booking> bookingSet;
        bookingSet = ReadAndWriteBooking.readFile(FILE_PATH);
        System.out.println("Booking List: ");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }

    }

    @Override
    public void add() {
        System.out.println("Enter Booking Code: ");
        String bookingCode = sc.nextLine();
        System.out.println("Enter Customer Code: ");
        String customerCode = sc.nextLine();
        System.out.println("Enter Service Name: ");
        String serviceName = sc.nextLine();
        System.out.println("Enter Checkin Date: ");
        int checkInDate = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Checkout Date: ");
        int checkOutDate = Integer.parseInt(sc.nextLine());
        Booking booking = new Booking(bookingCode, customerCode, serviceName, checkInDate, checkOutDate);
        ReadAndWriteBooking.writeFile(FILE_PATH, booking);

//        FacilityServiceImpl facilityService = new FacilityServiceImpl();
//        facilityService.useFacilities(serviceName);
    }

}
