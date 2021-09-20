package models;

import java.util.ArrayList;

public class Employee extends Person {
    private ArrayList<String> degree = new ArrayList<>();
    private ArrayList<String> office = new ArrayList<>();
    private double salary;

    public Employee(String code, String name, String birthDay, boolean gender, String id, String phoneNumber, String email, ArrayList<String> degree, ArrayList<String> office, double salary) {
        super(code, name, birthDay, gender, id, phoneNumber, email);
        this.degree = degree;
        this.office = office;
        this.salary = salary;
    }
}
