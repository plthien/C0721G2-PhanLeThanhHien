package services;

import models.Booking;

import java.util.Set;

public interface BookingService extends Service {
    void writeFile(String filePath, Booking bookings);
    Set<Booking> readFile(String filePath);

}
