package services;

import libs.UserException;
import models.Booking;
import models.Customer;
import models.Person;
import utils.ReadAndWriteBooking;
import utils.ReadAndWritePerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src\\data\\booking.csv";
    private final String FILE_CUSTOMER_PATH = "src\\data\\customer.csv";


    public void display() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_PATH);
        System.out.println("Booking List: ");
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }

    }

    @Override
    public void add() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("Choose customer: ");
        ArrayList<String> customerCodeList = customerService.display();
        String customerCode = "";
        int choice;
        do {
            System.out.println("Enter number of customer: ");
            choice = Integer.parseInt(sc.nextLine());
            try {
                customerCode = customerCodeList.get(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your choice out of range");
            }

        } while (choice - 1 < 0 || choice - 1 >= customerCodeList.size());

        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        System.out.println("Choose service name: ");
        ArrayList<String> serviceNameList = facilityService.display();
        String serviceName = "";
        do {
            System.out.println("Enter number of Service Name: ");
            choice = Integer.parseInt(sc.nextLine());
            try {
                serviceName = serviceNameList.get(choice - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your choice out of range");
            }
        } while (choice - 1 < 0 || choice - 1 >= serviceNameList.size());

        String checkInDate, checkOutDate;
        boolean flag;
        do {
            System.out.println("Enter Checkin Date: ");
            checkInDate = sc.nextLine();
            System.out.println("Enter Checkout Date: ");
            checkOutDate = sc.nextLine();
            flag = checkDate(checkInDate, checkOutDate);
        } while (!flag);


        Booking booking = new Booking(customerCode, serviceName, checkInDate, checkOutDate);
        booking.setBookingCode();
        ReadAndWriteBooking.writeFile(FILE_PATH, booking);

        facilityService.useFacilities(serviceName);
    }

    public boolean checkDate(String checkInDate, String checkOutDate) {
        String regex = "^(?=\\d{2}([\\/])\\d{2}\\/\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(checkInDate);
        Matcher matcher2 = pattern.matcher(checkOutDate);

        if (!matcher1.matches()) {
            System.out.println("The checkin date is invalid!");
            return false;
        }
        if (!matcher2.matches()) {
            System.out.println("The checkout date is invalid!");
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date checkInDateNew = new Date();
        Date checkOutDateNew = new Date();
        try {
            checkInDateNew = df.parse(checkInDate);
            checkOutDateNew = df.parse(checkOutDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return checkOutDateNew.compareTo(checkInDateNew) > 0;

    }
}
