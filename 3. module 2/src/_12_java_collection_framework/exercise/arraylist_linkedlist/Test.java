package _12_java_collection_framework.exercise.arraylist_linkedlist;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice_1;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Add new Product");
            System.out.println("2. Edit Product by Id");
            System.out.println("3. Delete Product by Id");
            System.out.println("4. Display Product list");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Sort Product");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            choice_1 = Integer.parseInt(sc.nextLine());
            switch (choice_1) {
                case 1: {
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    ProductManager.addProduct(new Product(id, name, price));
                    break;
                }

                case 2: {
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    ProductManager.editProductById(ProductManager.searchProductById(id));
                    break;
                }

                case 3: {
                    System.out.println("Enter id: ");
                    String id = sc.nextLine();
                    ProductManager.deleteProductById(ProductManager.searchProductById(id));
                    break;
                }

                case 4: {
                    ProductManager.displayProducts();
                    break;
                }

                case 5: {
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    ProductManager.searchProductByName(name);
                    break;
                }

                case 6: {
                    int choice_2;
                    do {
                        System.out.println("Menu: ");
                        System.out.println("1. Sort Ascending");
                        System.out.println("2. Sort Descending");
                        System.out.println("3. Exit");
                        System.out.println("Enter your choice: ");
                        choice_2 = Integer.parseInt(sc.nextLine());
                        switch (choice_2) {
                            case 1:
                                ProductManager.sortAscending();
                                break;
                            case 2:
                                ProductManager.sortDescending();
                                break;
                        }
                    }
                    while (choice_2 != 3);
                    break;
                }


            }
        }
        while (choice_1 != 7);

    }
}
