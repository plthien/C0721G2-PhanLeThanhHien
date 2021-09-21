package models;

public class Booking {
    private String bookingCode;
    private int checkInDate;
    private int checkOutDate;
    private Customer customer;
    private Facility facility;

    public Booking(String bookingCode, int checkInDate, int checkOutDate, Customer customer, Facility facility) {
        this.bookingCode = bookingCode;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customer = customer;
        this.facility = facility;
    }
}
