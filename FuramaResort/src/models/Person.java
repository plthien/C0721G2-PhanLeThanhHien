package models;

import libs.UserException;

import java.util.Scanner;

public abstract class Person {
    private String name;
    private String birthday;
    private boolean gender;
    private String personalID;
    private String phoneNumber;
    private String email;
    Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String name, String birthday, boolean gender, String personalID, String phoneNumber, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.personalID = personalID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.println("Enter name: ");
        this.name = sc.nextLine();
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(){
        boolean check = false;
        do {
            System.out.println("Enter birthday: ");
            this.birthday = sc.nextLine();
            try {
                check = UserException.checkBirthday(this.birthday);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);
    }

    public String isGender() {
        return this.gender ? "Male" : "Female";
    }

    public void setGender(){
        int choiceGender = 0;
        this.gender = true;
        do {
            try {
                System.out.println("Enter gender: 1. Male\t2. Female ");
                choiceGender = Integer.parseInt(sc.nextLine());
                if (choiceGender == 2) {
                    this.gender = false;
                } else if (choiceGender != 1) {
                    System.out.println("Your choice out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("It is not a number!");
            }

        } while (choiceGender != 1 && choiceGender != 2);
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID() {
        System.out.println("Enter Personal ID: ");
        this.personalID = sc.nextLine();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(){
        boolean check = false;
        do {
            try {
                System.out.println("Enter phone number: ");
                this.phoneNumber = sc.nextLine();
                check = UserException.checkPhoneNumber(this.phoneNumber);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail(){
        boolean check = false;
        do {
            try {
                System.out.println("Enter email: ");
                this.email = sc.nextLine();
                check = UserException.checkEmail(this.email);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);
    }

    public String getInfoToWrite() {
        return this.name + "," + this.birthday + "," + this.gender + "," +
                this.personalID + "," + this.phoneNumber + "," + this.email;
    }


}


