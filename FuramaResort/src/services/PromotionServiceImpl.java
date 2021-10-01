package services;

import libs.UserException;
import models.Booking;
import models.Customer;
import models.Person;
import utils.ReadAndWriteBooking;
import utils.ReadAndWritePerson;

import java.time.LocalDate;
import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_BOOKING_PATH = "src\\data\\booking.csv";
    private final String FILE_CUSTOMER_PATH = "src\\data\\customer.csv";

    @Override
    public void displayCustomerByYear() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        ArrayList<Person> customerList = ReadAndWritePerson.readFile(FILE_CUSTOMER_PATH);
        System.out.println("Enter year that you want to display: ");
        String year = sc.nextLine();
        int number = 1;
        System.out.println("Customer list used service in " + year + ":");
        for (Booking booking : bookingSet) {
            if (booking.getCheckInDate().contains(year)) {
                for (Person customer : customerList) {
                    if (((Customer) customer).getCustomerCode().contains(booking.getCustomerCode())) {
                        System.out.println(number++ + ". " + "Customer code: " + ((Customer) customer).getCustomerCode() +
                                ", Customer name: " + customer.getName() + ", Booking code: " + booking.getBookingCode());
                    }
                }
            }
        }


    }

    @Override
    public void giveVoucher() {
        Stack<Booking> bookingListInMonth = new Stack<>();
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        for (Booking booking : bookingSet) {
            String monthBooking = booking.getCheckInDate().substring(3, 5);
            if (monthBooking.contains(String.valueOf(currentMonth))) {
                bookingListInMonth.add(booking);
            }
        }
        int numberOfVoucher = bookingListInMonth.size();


    }
    public Map<String,Integer> createVoucher(int numberOfVoucher){
        Map<String,Integer> voucherList = new LinkedHashMap<>();
        int tenPercentVoucher = 0;
        int twelvePercentVoucher = 0;
        int fiftyPercentVoucher = 0;
        System.out.println("Total voucher is: " + numberOfVoucher);
        do {
            try {
                System.out.println("Enter number of 10% voucher: ");
                tenPercentVoucher = Integer.parseInt(sc.nextLine());
                if (numberOfVoucher < tenPercentVoucher) {
                    throw new UserException("Only have " + numberOfVoucher + " voucher!");
                } else {
                    numberOfVoucher = numberOfVoucher - tenPercentVoucher;
                    break;
                }

            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(" It is not a number!");
            }

        } while (true);
        if (numberOfVoucher > 0) {
            System.out.println("Number of voucher: " + numberOfVoucher);
            do {
                try {
                    System.out.println("Enter number of 10% voucher: ");
                    tenPercentVoucher = Integer.parseInt(sc.nextLine());
                    if (numberOfVoucher < tenPercentVoucher) {
                        throw new UserException("Only have " + numberOfVoucher + " voucher!");
                    } else {
                        numberOfVoucher = numberOfVoucher - tenPercentVoucher;
                        break;
                    }

                } catch (UserException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println(" It is not a number!");
                }

            } while (true);
        }
    }


}
