package _17_io_binary_file_serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManage {
    private final String FILE_PATH = "src\\_17_io_binary_file_serialization\\exercise\\product.txt";
    Scanner sc = new Scanner(System.in);

    public void writeProductToFile(ArrayList<Product> products) {
        File file = new File(FILE_PATH);
        if (file.length() > 0) {
            products.addAll(readProductFromFile());

        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> readProductFromFile() {
        File file = new File(FILE_PATH);
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }

    public void addNewProduct() {
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("Enter id: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter brand: ");
        String brand = sc.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        products.add(new Product(id, name, brand, price));
        writeProductToFile(products);

    }

    public void displayProduct() {
        ArrayList<Product> products = readProductFromFile();
        System.out.println("Product List: ");
        for (Product product : products) {
            System.out.println(product);
        }

    }

    public void searchProduct() {
        System.out.println("Enter name of Product: ");
        String name = sc.nextLine();
        ArrayList<Product> products = readProductFromFile();
        boolean flag = true;
        for (Product product : products) {
            if (product.getName().contains(name)) {
                System.out.println(product);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Product does not exist!");
        }

    }
}
