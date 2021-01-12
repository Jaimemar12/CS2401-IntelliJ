package LinkedList;

public class FrontList {

    private Node head;

    private class Node {
        private int number;
        private Node next;

        private Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }
    }

    // Creates an empty FrontList.
    public FrontList() {
        this.head = null;
    }

    // Adds a new Node with a number equal to value to the front of the list.
    public void addFront(int value) {
        Node newNode = new Node(value, head);
        head = newNode;
    }

    // Removes the second Node from the list, if there is one.
    public void removeSecond() {
        if(head == null) {
            return;
        }
        if(head.next != null) {
            head.next = head.next.next;
        }
    }

    // Removes the first Node from the list, if there is one.
    public void removeFirst() {
        if(head != null) {
            head = head.next;
        }
    }

    // Performs the trickle operation as described in the MiniLab 7 PDF.
    public void trickle() {

        if(head == null) {
            return;
        }
        Node adder = head;
        while(adder.next != null) {
            adder.number += adder.next.number;
            adder = adder.next;
        }
    }

    public String toString() {
        String s = "";
        Node finder = head;
        while (finder != null) {
            s += finder.number + " -> ";
            finder = finder.next;
        }
        return s;
    }

    public static void main(String[] args) {
        // Show us that it works!
        FrontList test = new FrontList();
        test.addFront(-3);
        test.addFront(3);
        test.addFront(2);
        test.addFront(1);
        System.out.println(test);
        test.removeSecond();
        System.out.println(test);
        test.removeFirst();
        System.out.println(test);
        test.trickle();
        System.out.println(test);
    }
}