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
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void displayCustomerInYear() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);

        System.out.println("Enter year that you want to display: ");
        String year = sc.nextLine();
        int number = 1;
        System.out.println("Customer list used service in " + year + ":");
        for (Booking booking : bookingSet) {
            if (booking.getCheckInDate().contains(year)) {
                Customer customer = customerService.searchCustomerByCode(booking.getCustomerCode());
                System.out.println(number++ + ". "  + customer + ", Booking code: " + booking.getBookingCode());
            }
        }
    }

    @Override
    public void giveVoucher() {
        Stack<Customer> customerListInMonth = new Stack<>();
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        LocalDate date = LocalDate.now();
        int currentMonth = date.getMonthValue();
        for (Booking booking : bookingSet) {
            String monthBooking = booking.getCheckInDate().substring(3, 5);
            if (monthBooking.contains(String.valueOf(currentMonth))) {
                customerListInMonth.add(customerService.searchCustomerByCode(booking.getCustomerCode()));
            }
        }
        int numberOfVoucher = customerListInMonth.size();
        Map<String, Integer> voucherList = createVoucher(numberOfVoucher);
        while (!customerListInMonth.empty()) {
            Set<String> voucherName = voucherList.keySet();
            for (String key: voucherName) {
                while (voucherList.get(key) > 0) {
                    System.out.println("Give " + key + " for " + customerListInMonth.pop());
                    voucherList.computeIfPresent(key,(k,v)->v-1);
                }
            }
        }
    }

    public Map<String, Integer> createVoucher(int numberOfVoucher) {
        Map<String, Integer> voucherList = new LinkedHashMap<>();
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
                    System.out.println("Enter number of 20% voucher: ");
                    twelvePercentVoucher = Integer.parseInt(sc.nextLine());
                    if (numberOfVoucher < twelvePercentVoucher) {
                        throw new UserException("Only have " + numberOfVoucher + " voucher!");
                    } else {
                        numberOfVoucher = numberOfVoucher - twelvePercentVoucher;
                        break;
                    }

                } catch (UserException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println(" It is not a number!");
                }

            } while (true);
        }
        fiftyPercentVoucher = numberOfVoucher;
        System.out.println("Number of fifty percent voucher: " + fiftyPercentVoucher);
        voucherList.put("Voucher 10%", tenPercentVoucher);
        voucherList.put("Voucher 20%", twelvePercentVoucher);
        voucherList.put("Voucher 50%", fiftyPercentVoucher);
        return voucherList;
    }


}
