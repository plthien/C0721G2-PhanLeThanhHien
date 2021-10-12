package _12_java_collection_framework.practice.hashmap_hashset;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Nam",25, "HN");
        Student student2 = new Student("Bao",21, "QN");
        Student student3 = new Student("Ha",24, "DN");
        Student student4 = new Student("Anh",22, "TN");
        Student student5 = new Student("Anh",26, "DL");

        Map<Student,Integer> studentMap = new LinkedHashMap<>();

        studentMap.put(student1,1);
        studentMap.put(student2,2);
        studentMap.put(student3,2);
        studentMap.put(student4,3);
        studentMap.put(student5,4);

        for (Map.Entry<Student,Integer> student:studentMap.entrySet()) {
//            System.out.println(student.getKey() + " "+student.getValue());
            System.out.println(student.getKey() + ": " + student.getValue());
        }

//        System.out.println("...........Set");
//        Set<Student> students = new LinkedHashSet<>();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);
//        for (Student student:students) {
//            System.out.println(student.toString());
//        }
    }
}
