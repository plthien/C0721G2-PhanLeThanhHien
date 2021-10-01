package utils;

import models.Booking;
import services.BookingComparator;
import services.BookingServiceImpl;

import java.io.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteBooking {
    public static void writeFile(String filePath, Booking booking) {
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

    public static Set<Booking> readFile(String filePath) {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Booking booking = new Booking(array[1], array[2], array[3] , array[4]);
                booking.setBookingCode(array[0]);
                bookingSet.add(booking);
                Booking.setCode(Integer.parseInt(array[5]));//get nextcode to generate next bookingcode

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookingSet;
    }

}
