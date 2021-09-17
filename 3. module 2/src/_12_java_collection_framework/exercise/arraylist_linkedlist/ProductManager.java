package _12_java_collection_framework.exercise.arraylist_linkedlist;

import java.util.*;

public class ProductManager {
    //    private static ArrayList<Product> products = new ArrayList<>();
    private static LinkedList<Product> products = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        products.add(new Product("Ip13", "Iphone 13 Pro Max", 3000));
        products.add(new Product("Ip12", "Iphone 12 Pro Max", 2700));
        products.add(new Product("Ssa50", "Samsung A50", 1000));
        products.add(new Product("Bp3", "Bphone 3", 1000));
    }

    public static void displayProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void addProduct(Product product) {
        products.add(product);
        displayProducts();
    }

    public static int searchProductById(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void editProductById(int index) {
        if (index != -1) {
            System.out.println(products.get(index).toString());
            System.out.println("Enter new Id: ");
            String id = sc.nextLine();
            System.out.println("Enter new Name: ");
            String name = sc.nextLine();
            System.out.println("Enter new Price: ");
            double price = Double.parseDouble(sc.nextLine());
            products.get(index).setId(id);
            products.get(index).setName(name);
            products.get(index).setPrice(price);
            displayProducts();
        } else {
            System.out.println("Id is not exist");
        }
    }

    public static void deleteProductById(int index) {
        if (index != -1) {
            products.remove(index);
            displayProducts();
        } else {
            System.out.println("Id is not exist");
        }
    }

    public static void searchProductByName(String name) {
        boolean flag = true;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                System.out.println(products.get(i).toString());
                flag = false;

            }
        }
        if (flag) {
            System.out.println("Product is not exist");
        }
    }

    public static void sortAscending() {
        Collections.sort(products, new SortAscending());
        displayProducts();
    }

    public static void sortDescending() {
        Collections.sort(products, new SortDescending());
        displayProducts();
    }


}
