package models;

import java.util.Scanner;

public class Contract {
    private String contractNumbers;
    private String bookingCode;
    private String customerCode;
    private double deposit;
    private double payment;
    private static int code = 1000;
    Scanner sc = new Scanner(System.in);

    public Contract() {
    }

    public Contract(String bookingCode, String customerCode, double deposit, double payment) {
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

    public void setContractNumbers() {
        code++;
        this.contractNumbers = this.bookingCode + code;
    }

    public static void setCode(int nextCode){
        code = nextCode;
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

    public void setDeposit() {
        this.deposit = -1;
        do {
            try {
                System.out.println("Enter deposit: ");
                this.deposit = Double.parseDouble(sc.nextLine());
                if (this.deposit < 0) {
                    System.out.println("The deposit is greater than 0 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.deposit < 0);
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment() {
        this.payment = -1;
        do {
            try {
                System.out.println("Enter payment: ");
                this.payment = Double.parseDouble(sc.nextLine());
                if (this.payment < 0) {
                    System.out.println("The payment is greater than 0 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.payment < 0);
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
        return this.contractNumbers + "," + this.bookingCode + "," + this.customerCode + "," + this.deposit + "," + this.payment + "," + code;
    }
}
