package _05_access_modifier_static.exercise;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Hung");
        student.setClasses("C03");
        System.out.println(student.toString());
    }
}
