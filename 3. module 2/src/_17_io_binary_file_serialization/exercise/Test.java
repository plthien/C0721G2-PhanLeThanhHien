package _17_io_binary_file_serialization.exercise;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:\t 1. Add New Product\t 2. Display Products List\t 3. Search Product\t 4. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            ProductManage productManage = new ProductManage();
            switch (choice) {
                case 1:
                    productManage.addNewProduct();
                    break;
                case 2:
                    productManage.displayProduct();
                    break;
                case 3:
                    productManage.searchProduct();
                    break;
            }
        } while (choice != 4);
    }
}
