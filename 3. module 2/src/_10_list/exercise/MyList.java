package _10_list.exercise;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);

    }

    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)){
                return false;
            }
        }
        elements[size++] = e;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        int i = size();
        while (index < i) {
            elements[i] = elements[i - 1];
            i--;
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        E temp = (E) elements[index];
        while (index < size() - 1) {
            elements[index] = elements[index + 1];
            index++;
        }
        size--;
        return temp;
    }

    public E clone() {
        if (size() == 0){
            throw new NullPointerException();
        }
        MyList<Object> clone = new MyList<>(size());
        for (int i = 0; i <size() ; i++) {
            clone.add(elements[i]);
        }
        return (E) clone;


    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }

    public boolean contains(E o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size= 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size()));
    }
}
