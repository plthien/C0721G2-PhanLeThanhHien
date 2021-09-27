package services;

import models.Booking;

import java.util.Queue;

public interface ContractService extends Service{
    void editContract(String contractNumber);
    Queue<Booking> getBookingQueue();
}
