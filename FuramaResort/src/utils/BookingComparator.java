package utils;

import models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date checkInDate1 = new Date();
        Date checkOutDate1 = new Date();
        Date checkInDate2 = new Date();
        Date checkOutDate2 = new Date();
        try {
            checkInDate1 = df.parse(o1.getCheckInDate());
            checkOutDate1 = df.parse(o1.getCheckOutDate());
            checkInDate2 = df.parse(o2.getCheckInDate());
            checkOutDate2 = df.parse(o2.getCheckOutDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (checkInDate1.compareTo(checkInDate2) == 0) {
            if (checkOutDate1.compareTo(checkOutDate2) == 0) {
                return o1.getServiceName().compareTo(o2.getServiceName());
            } else {
                return checkOutDate1.compareTo(checkOutDate2);
            }
        } else {
            return checkInDate1.compareTo(checkInDate2);
        }
    }

}
