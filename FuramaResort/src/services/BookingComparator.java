package services;

import models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getCheckInDate() == o2.getCheckInDate()) {
            if (o1.getCheckOutDate() == o2.getCheckOutDate()) {
                return o1.getServiceName().compareTo(o2.getServiceName());
            } else {
                return o1.getCheckOutDate().compareTo(o2.getCheckOutDate()) ;
            }
        } else {
            return o1.getCheckInDate().compareTo(o2.getCheckInDate());
        }
    }

}
