package utils;

import models.Contract;
import models.Customer;
import models.Employee;
import models.Person;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWritePerson {
    public static void writeFile(String filePath, ArrayList<Person> personArrayList, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Person person : personArrayList) {
                bufferedWriter.write(person.getInfoToWrite());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Person> readFile(String filePath) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 10) {
                    Customer customer = new Customer(array[0], array[1], Boolean.parseBoolean(array[2]), array[3],
                            array[4], array[5], Integer.parseInt(array[6]), array[7]);
                    customer.setCustomerCode(array[8]);
                    Customer.setCode(Integer.parseInt(array[9]));
                    personArrayList.add(customer);
                } else {
                    Employee employee = new Employee(array[0], array[1], Boolean.parseBoolean(array[2]), array[3],
                            array[4], array[5], Integer.parseInt(array[6]), Integer.parseInt(array[7]), Double.parseDouble(array[8]));
                    Employee.setCode(Integer.parseInt(array[10]));
                    employee.setEmployeeCode(array[9]);
                    personArrayList.add(employee);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personArrayList;
    }
}
