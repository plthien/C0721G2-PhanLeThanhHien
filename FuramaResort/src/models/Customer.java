package models;


public class Customer extends Person {
    private int customerTypes;
    private String address;
    private String customerCode;
    private static int code = 1000;

    public Customer() {
    }

    public Customer(String name, String birthDay, boolean gender, String personalID, String phoneNumber, String email,
                    int customerTypes, String address) {
        super(name, birthDay, gender, personalID, phoneNumber, email);
        this.customerTypes = customerTypes;
        this.address = address;
    }

    public int getCustomerTypes() {
        return customerTypes;
    }

    public String getStringCustomerTypes() {
        switch (this.customerTypes) {
            case 1:
                return "Member";
            case 2:
                return "Silver";
            case 3:
                return "Gold";
            case 4:
                return "Platinium";
            case 5:
                return "Diamond";
            default:
                return "";
        }
    }

    public void setCustomerTypes() {
        do {
            try {
                System.out.println("Enter customer types: 1.Member\t2.Silver\t3.Gold\t4.Platinium\t5.Diamond ");
                this.customerTypes = Integer.parseInt(sc.nextLine());
                if (this.customerTypes < 1 || this.customerTypes > 5) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }
        } while (this.customerTypes < 1 || this.customerTypes > 5);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.println("Enter address: ");
        this.address = sc.nextLine();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode() {
        code++;
        this.customerCode = this.customerTypes + "" + code;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public static void setCode(int nextCode) {
        code = nextCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " Customer Code: " + this.getCustomerCode() +
                ", Name: " + super.getName() +
                ", BirthDay: " + super.getBirthday() +
                ", Gender: " + super.isGender() +
                ", Personal ID: " + super.getPersonalID() +
                ", Phone Number: " + super.getPhoneNumber() +
                ", Email: " + super.getEmail() +
                ", Customer Types: " + this.getStringCustomerTypes() +
                ", Address: " + this.getAddress() + '}';
    }

    @Override
    public String getInfoToWrite() {
        return super.getInfoToWrite() + "," + this.customerTypes + "," + this.address + "," + this.customerCode + "," + code;
    }

}
