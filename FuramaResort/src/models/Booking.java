package models;

public class Booking{
    private String bookingCode;
    private String customerCode;
    private String serviceId;
    private String checkInDate;
    private String checkOutDate;
    private static int code = 1000;

    public Booking() {
    }

    public Booking(String customerCode, String serviceId, String checkInDate, String checkOutDate) {
        this.customerCode = customerCode;
        this.serviceId = serviceId;
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

    public static void setCode(int nextCode){
        code = nextCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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
                ", Service Id: " + this.serviceId +
                ", Checkin Date: " + this.checkInDate +
                ", checkout Date: " + this.checkOutDate +
                '}';
    }

    public String getInfoToWrite(){
        return this.bookingCode + "," + this.customerCode + "," + this.serviceId + "," + this.checkInDate + "," + this.checkOutDate + "," + code;
    }
}
