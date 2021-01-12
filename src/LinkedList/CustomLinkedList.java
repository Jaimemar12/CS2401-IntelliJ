package LinkedList;

public class CustomLinkedList {
    public static void main(String[] args) {
        Node headObj;  // Create Node reference variables
        Node nodeObj1;
        Node nodeObj2;
        Node nodeObj3;
        Node currObj;

        // Front of nodes list
        headObj = new Node(-1);

        // Insert more nodes
        nodeObj1 = new Node(555);
        headObj.insertAfter(nodeObj1);

        nodeObj2 = new Node(999);
        nodeObj1.insertAfter(nodeObj2);

        nodeObj3 = new Node(777);
        nodeObj1.insertAfter(nodeObj3);

        // Print linked list
        currObj = headObj;
        while (currObj != null) {
            currObj.printNodeData();
            currObj = currObj.getNext();
        }
    }
}