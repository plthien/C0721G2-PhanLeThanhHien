package _12_java_collection_framework.practice.hashmap_hashset;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String address;

    public Student(){}

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", address='" + this.address + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        Student student = (Student) o;
//        return Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
////        return  11;
//        return Objects.hash(name);
//    }
}
