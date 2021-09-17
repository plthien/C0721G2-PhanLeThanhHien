package _12_java_collection_framework.exercise.arraylist_linkedlist;

import java.util.Comparator;

public class SortAscending implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
