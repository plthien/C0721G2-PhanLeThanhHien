package services;

import models.Booking;
import models.Contract;
import utils.ReadAndWriteBooking;
import utils.ReadAndWriteContract;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    Scanner sc = new Scanner(System.in);
    private final String FILE_BOOKING_PATH = "src\\data\\booking.csv";
    private final String FILE_CONTRACT_PATH = "src\\data\\contract.csv";


    @Override
    public Queue<Booking> getBookingQueue() {
        Set<Booking> bookingSet = ReadAndWriteBooking.readFile(FILE_BOOKING_PATH);
        Queue<Booking> bookingQueue = new LinkedList<>();
        ArrayList<Contract> contracts = ReadAndWriteContract.readFile(FILE_CONTRACT_PATH);

        for (Booking booking : bookingSet) {
            boolean flag = true;
            for (int i = 0; i < contracts.size(); i++) {
                if (booking.getBookingCode().contains(contracts.get(i).getBookingCode())) {
                    flag = false;
                    break;
                }
            }
            if (flag && (booking.getServiceName().contains("VL") || booking.getServiceName().contains("HO"))) {
                bookingQueue.add(booking);
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
            System.out.println("Enter deposit: ");
            double deposit = Double.parseDouble(sc.nextLine());
            System.out.println("Enter payment: ");
            double payment = Double.parseDouble(sc.nextLine());
            ArrayList<Contract> contracts = new ArrayList<>();
            Contract contract = new Contract(bookingCode, customerCode, deposit, payment);
            contract.setContractNumbers();
            contracts.add(contract);
            ReadAndWriteContract.writeFile(FILE_CONTRACT_PATH, contracts, true);
            bookingQueue.remove();
        }
    }


    public void display() {
        ArrayList<Contract> contracts = ReadAndWriteContract.readFile(FILE_CONTRACT_PATH);
        for (int i = 0; i < contracts.size() ; i++) {
            System.out.println((i+1) + ". " + contracts.get(i));
        }

    }

    @Override
    public void editContract(String contractNumber) {
        ArrayList<Contract> contracts = ReadAndWriteContract.readFile(FILE_CONTRACT_PATH);
        boolean flag = true;
        for (Contract contract : contracts) {
            if (contract.getContractNumbers().contains(contractNumber)) {
                System.out.println(contract);
                int choice;
                do {
                    System.out.println("Menu: " +
                            "1. Contract number \t" +
                            "2. Booking code \t" +
                            "3. Customer code \t" +
                            "4. Deposit \t" +
                            "5. Payment \t" +
                            "6. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Enter contract number: ");
                            String newContractNumber = sc.nextLine();
                            contract.setContractNumbers(newContractNumber);
                            break;
                        case 2:
                            System.out.println("Enter booking code: ");
                            String bookingCode = sc.nextLine();
                            contract.setBookingCode(bookingCode);
                            break;
                        case 3:
                            System.out.println("Enter customer code: ");
                            String customerCode = sc.nextLine();
                            contract.setCustomerCode(customerCode);
                            break;
                        case 4:
                            System.out.println("Enter deposit: ");
                            double deposit = Double.parseDouble(sc.nextLine());
                            contract.setDeposit(deposit);
                            break;
                        case 5:
                            System.out.println("Enter payment: ");
                            double payment = Double.parseDouble(sc.nextLine());
                            contract.setPayment(payment);
                            break;
                    }

                } while (choice != 6);
                flag = false;
                break;

            }
        }
        if (flag) {
            System.out.println("Contract does not exist!");
        } else {
            ReadAndWriteContract.writeFile(FILE_CONTRACT_PATH, contracts, false);
            display();
        }
    }
}
