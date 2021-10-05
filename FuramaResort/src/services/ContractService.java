package services;

import models.Booking;

import java.util.Queue;

public interface ContractService extends Service{
    Queue<Booking> getBookingQueue();
}
