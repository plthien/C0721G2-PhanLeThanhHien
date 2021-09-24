package services;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import models.Booking;
import models.Contract;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PATH = "src\\data\\booking.csv";
    ArrayList<Contract> contracts = new ArrayList<>();

    @Override
    public Queue<Booking> getBookingQueue() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        Set<Booking> bookingSet = bookingService.readFile(FILE_PATH);
        Queue<Booking> bookingQueue = new LinkedList<>();

        for (Booking booking : bookingSet) {
            if (contracts.size() == 0) {
                if (booking.getServiceName().contains("Villa") || booking.getServiceName().contains("House")) {
                    bookingQueue.add(booking);
                }
            } else {
                for (int i = 0; i < contracts.size(); i++) {
                    System.out.println("TEST1");
                    if (!booking.getBookingCode().contains(contracts.get(i).getBookingCode())) {
                        System.out.println("TEST2");
                        if (booking.getServiceName().contains("Villa") || booking.getServiceName().contains("House")) {
                            bookingQueue.add(booking);
                        }
                    }
                }

            }

        }
        return bookingQueue;
    }

    @Override
    public void add() {
        Queue<Booking> bookingQueue = getBookingQueue();
        if (bookingQueue.size() == 0) {
            System.out.println("There are not any Booking at this time!");
        } else {
            System.out.println(bookingQueue.peek());
            System.out.println("Creat new Contract for Booking that has Booking code: " + bookingQueue.peek().getBookingCode());
            String bookingCode = bookingQueue.peek().getBookingCode();
            String customerCode = bookingQueue.peek().getCustomerCode();
            System.out.println("Enter Contract number: ");
            String contractNumbers = sc.nextLine();
            System.out.println("Enter deposit: ");
            double deposit = Double.parseDouble(sc.nextLine());
            System.out.println("Enter payment: ");
            double payment = Double.parseDouble(sc.nextLine());
            contracts.add(new Contract(contractNumbers, bookingCode, customerCode, deposit, payment));
            bookingQueue.remove();
        }
    }

    @Override
    public void display() {
        for (Contract contract : contracts) {
            System.out.println(contract);
        }

    }

    @Override
    public void editContract() {

    }


}
