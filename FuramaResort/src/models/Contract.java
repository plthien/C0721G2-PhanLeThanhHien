package models;

public class Contract {
    private String contractNumbers;
    private String bookingCode;
    private String customerCode;
    private double deposit;
    private double payment;

    public Contract(String contractNumbers, String bookingCode, String customerCode, double deposit, double payment) {
        this.contractNumbers = contractNumbers;
        this.bookingCode = bookingCode;
        this.customerCode = customerCode;
        this.deposit = deposit;
        this.payment = payment;
    }

    public String getContractNumbers() {
        return contractNumbers;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setContractNumbers(String contractNumbers) {
        this.contractNumbers = contractNumbers;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "Contract Numbers: " + this.contractNumbers +
                ", Booking Code: " + this.bookingCode +
                ", Customer Code: " + this.customerCode +
                ", Deposit: " + this.deposit +
                ", Payment: " + this.payment +
                '}';
    }

    public String getInfoToWrite() {
        return this.contractNumbers + "," + this.bookingCode + "," + this.customerCode + "," + this.deposit + "," + this.payment;
    }
}
