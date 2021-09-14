package _10_list.exercise;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        System.out.println(listInteger);
        listInteger.add(4,5);
        System.out.println(listInteger);
        System.out.println(listInteger.add(5));
        System.out.println(listInteger);
        listInteger.remove(1);
        System.out.println(listInteger);
        System.out.println(listInteger.contains(1));
        System.out.println(listInteger.contains(6));
        System.out.println(listInteger.indexOf(1));
        System.out.println(listInteger.indexOf(6));
//        listInteger.clear();
//        System.out.println(listInteger);

        System.out.println(listInteger.clone());

    }
}
