package services;

import models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getCheckInDate() == o2.getCheckInDate()) {
            return o1.getCheckOutDate() - o2.getCheckOutDate();
        } else {
            return o1.getCheckInDate() - o2.getCheckInDate();
        }
    }

}
