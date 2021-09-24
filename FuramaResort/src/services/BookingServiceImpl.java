package services;

import models.Booking;

import java.io.*;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src\\data\\booking.csv";

    @Override
    public void display() {
        Set<Booking> bookingSet = readFile(FILE_PATH);
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
        writeFile(FILE_PATH, booking);

        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.useFacilities(serviceName);
    }

    @Override
    public void writeFile(String filePath, Booking booking) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(booking.getInfoToWrite());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Booking> readFile(String filePath) {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                bookingSet.add(new Booking(array[0], array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4])));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookingSet;
    }
}
