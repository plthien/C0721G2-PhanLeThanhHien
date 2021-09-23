package services;

import models.Booking;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private static Set<Booking> bookings = new TreeSet<>(new BookingComparator());
    static Scanner sc = new Scanner(System.in);

    static {
        bookings.add(new Booking("B0001","Me0001","Room-01",10,4));
        bookings.add(new Booking("B0002","Me0002","Room-02",2,5));
        bookings.add(new Booking("B0003","Go0001","Villa-01",2,6));
        bookings.add(new Booking("B0004","Go0002","Villa-02",2,6));
    }



    @Override
    public void display() {
        System.out.println("Booking List: ");
        for (Booking booking:bookings) {
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
        bookings.add(new Booking(bookingCode,customerCode,serviceName,checkInDate,checkOutDate));
        display();
    }



}
