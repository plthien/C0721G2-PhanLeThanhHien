package _10_list.exercise;

import com.sun.xml.internal.ws.util.xml.CDATA;
import org.w3c.dom.CDATASection;

import java.util.Arrays;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {

    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public int size() {
        return numNodes;
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;

    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        Object data;
        if (index == 0) {
            data = temp.getData();
            head = head.next;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.getData();
            temp.next = temp.next.next;
        }
        numNodes--;
        return (E) data;
    }

    public boolean remove(E o) {
        if (head.getData().equals(o)) {
            remove(o);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.getData().equals(o)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public E clone() {
        if (numNodes == 0) {
            throw new NullPointerException();
        }
        MyLinkedList<Object> temp = new MyLinkedList<>();
        Node tempNode = head;
        temp.addFirst(tempNode.getData());
        tempNode = tempNode.next;
        while (tempNode != null) {
            temp.addLast(tempNode.getData());
            tempNode = tempNode.next;
        }
        return (E) temp;
    }


}
