package models;

import libs.UserException;

import java.util.Scanner;

public abstract class Facility {
    protected String serviceName;
    protected double usableArea;
    protected double cost;
    protected int customerMax;
    protected String rentingBy;
    Scanner sc = new Scanner(System.in);

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double cost, int customerMax, String rentingBy) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.cost = cost;
        this.customerMax = customerMax;
        this.rentingBy = rentingBy;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName() {
        boolean check = false;
        do {
            try {
                System.out.println("Enter Service Name: ");
                this.serviceName = sc.nextLine();
                check = UserException.checkServiceName(this.serviceName, this);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }

        } while (!check);
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea() {
        do {
            try {
                System.out.println("Enter Usable Area: ");
                this.usableArea = Double.parseDouble(sc.nextLine());
                if (this.usableArea < 30) {
                    throw new UserException("The usable area is invalid. It is greater than 30!");
                }
            } catch (UserException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.usableArea < 30);
    }

    public double getCost() {
        return cost;
    }

    public void setCost() {
        do {
            try {
                System.out.println("Enter Cost: ");
                this.cost = Double.parseDouble(sc.nextLine());
                if (this.cost <= 0) {
                    throw new UserException("The cost is grater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (this.cost <= 0);
    }

    public int getCustomerMax() {
        return customerMax;
    }

    public void setCustomerMax() {
        do {
            try {
                System.out.println("Enter Customer Maximum: ");
                this.customerMax = Integer.parseInt(sc.nextLine());
                if (this.customerMax <= 0 || this.customerMax >= 20) {
                    throw new UserException("The customer maximum is grater than 0 and less than 20!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (this.customerMax <= 0 || this.customerMax >= 20);
    }

    public String getRentingBy() {
        return rentingBy;
    }

    public void setRentingBy() {
        boolean check = false;
        do {
            try {
                System.out.println("Enter Renting by: ");
                this.rentingBy = sc.nextLine();
                check = UserException.checkNoun(this.rentingBy);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);
    }

    public String getInfoToWrite(){
        return this.getServiceName() + "," + this.getUsableArea() + "," + this.getCost() + "," +
                this.getCustomerMax() + "," + this.getRentingBy();
    }
}