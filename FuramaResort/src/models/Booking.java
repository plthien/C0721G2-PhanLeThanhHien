package models;

import java.util.Objects;

public class Booking {
    private String bookingCode;
    private String customerCode;
    private String serviceName;
    private int checkInDate;
    private int checkOutDate;


    public Booking(String bookingCode, String customerCode, String serviceName, int checkInDate, int checkOutDate) {
        this.bookingCode = bookingCode;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Booking Code: " + this.bookingCode +
                ", Customer Code: " + this.customerCode +
                ", Service Name: " + this.serviceName +
                ", Checkin Date: " + this.checkInDate +
                ", checkout Date: " + this.checkOutDate +
                '}';
    }

    public String getInfoToWrite(){
        return this.bookingCode + "," + this.customerCode + "," + this.serviceName + "," + this.checkInDate + "," + this.checkOutDate;
    }
}
