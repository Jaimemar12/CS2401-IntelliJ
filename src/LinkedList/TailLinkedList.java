package LinkedList;

public class TailLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private T data;
        private Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public TailLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    // Adds a new element with the given data at the given index, if it
    // is within the range determined by the list's size.
    public void add(T data, int index) {
        if(index > size || index < 0) {
            return;
        }

        Node nodeToAdd = new Node(data, null);
        Node pointer = head;

        if(head == null) {
            nodeToAdd.next = head;
            head = nodeToAdd;
            tail = nodeToAdd;
        }else if(index == 0) {
            nodeToAdd.next = head;
            head = nodeToAdd;
        }else if(index == size) {
            tail.next = nodeToAdd;
            tail = nodeToAdd;
        }else {

            for(int i = 0; i < index - 1; i++) {
                pointer = pointer.next;
            }

            nodeToAdd.next = pointer.next;
            pointer.next = nodeToAdd;
        }

        size++;
    }

    // Removes the element at the given index, if it is within the range
    // determined by the list's size.
    public void remove(int index) {
        if(index > size-1 || index < 0) {
            return;
        }

        Node pointer = head;

        if(index == 0) {
            head = head.next;
        }else {
            for(int i = 0; i < index - 1; i++) {
                pointer = pointer.next;
            }

            pointer.next = pointer.next.next;
        }

        size--;

        if(index == size) {
            tail = pointer;
        }
    }

    // Adds all elements from other to the end of this list,
    // then makes other completely empty.
    public void append(TailLinkedList<T> other) {
        if(head == null || other.head == null || head == other.head) {
            return;
        }

        this.tail.next = other.head;
        this.tail = other.tail;
        size = this.size + other.size;
        other.head = null;
        other.tail = null;
        other.size = 0;
    }

    public String toString() {
        String result = "";

        Node finder = this.head;
        while (finder != null) {
            result += finder.data + " -> ";
            finder = finder.next;
        }

        return result;
    }

    public static void test(TailLinkedList<String> myList) {

        if(myList.head == null) {
            System.out.println("Cannot be done");
            System.out.println();
            return;
        }
        System.out.println(myList);
        System.out.println("Size: " + myList.size);
        System.out.println("Head: " + myList.head.data);
        System.out.println("Tail: " + myList.tail.data);
        System.out.println();
    }

    public static void main(String[] args) {
        TailLinkedList<String> myList = new TailLinkedList<String>();
        TailLinkedList<String> other = new TailLinkedList<String>();
        myList.add("help", 0);
        test(myList);
        myList.add("me", 1);
        test(myList);
        myList.add("por", 2);
        test(myList);
        other.add("favor", 0);
        test(other);
        other.add("pretty", 1);
        test(other);
        other.add("pls", 2);
        test(other);
        other.append(myList);
        test(myList);
        test(other);
        other.remove(5);
        test(other);
        other.remove(0);
        test(other);
        other.remove(1);
        test(other);
        other.remove(2);
        test(other);
        other.remove(1);
        test(other);
        other.remove(0);
        test(other);

    }
}