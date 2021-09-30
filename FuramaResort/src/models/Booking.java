package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking{
    private String bookingCode;
    private String customerCode;
    private String serviceName;
    private String checkInDate;
    private String checkOutDate;
    private static int code = 1000;


    public Booking(String customerCode, String serviceName, String checkInDate, String checkOutDate) {
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

    public void setBookingCode() {
        code++;
        this.bookingCode = this.customerCode + code;
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

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
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
