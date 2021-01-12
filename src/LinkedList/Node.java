package LinkedList;

public class Node {
    private int dataVal;         // Node data
    private Node nextNodePtr; // Reference to the next node

    public Node() {
        dataVal = 0;
        nextNodePtr = null;
    }

    // Constructor
    public Node(int dataInit) {
        this.dataVal = dataInit;
        this.nextNodePtr = null;
    }

    // Constructor
    public Node(int dataInit, Node nextLoc) {
        this.dataVal = dataInit;
        this.nextNodePtr = nextLoc;
    }

    /* Insert node after this node.
     Before: this -- next
     After:  this -- node -- next
     */
    public void insertAfter(Node nodeLoc) {
        Node tmpNext;

        tmpNext = this.nextNodePtr;
        this.nextNodePtr = nodeLoc;
        nodeLoc.nextNodePtr = tmpNext;
    }

    // Get location pointed by nextNodePtr
    public Node getNext() {
        return this.nextNodePtr;
    }

    public void printNodeData() {
        System.out.println(this.dataVal);
    }
}