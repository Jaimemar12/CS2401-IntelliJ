package Trees;

public class LRTree {

    private Node root;

    private class Node {
        private String data;
        private Node left;
        private Node right;

        private Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public LRTree() {
        this.root = new Node("-", null, null);
    }

    // Adds the string s to the tree in the proper location, as described in the PDF.
    // Also adds the necessary parent nodes, as described in the PDF.
    // If the string already exists in the tree, or if the string contains characters
    // that are not L or R, do nothing.
    public void add(String s) {

        Node pointer = root;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') {
                if(pointer.left != null) {
                    pointer = pointer.left;
                }else {
                    pointer.left = new Node(s.substring(0, i+1), null, null);
                    pointer = pointer.left;
                }
            }else if(s.charAt(i) == 'R') {
                if(pointer.right != null) {
                    pointer = pointer.right;
                }else{
                    pointer.right = new Node(s.substring(0, i+1), null, null);
                    pointer = pointer.right;
                }
            }
        }
    }

    // Returns whether or not the String s is found within the tree.
    public boolean contains(String s) {

        // This is just here so your code compiles.
        // You have to actually write this method.
        Node pointer = root;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L') {
                if(pointer.left != null) {
                    pointer = pointer.left;
                }else {
                    return false;
                }
            }else if(s.charAt(i) == 'R') {
                if(pointer.right != null) {
                    pointer = pointer.right;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    // Prints the tree in the sideways orientation described in the PDF.
    public void print() {
        printHelper(root, 0);
    }

    // Recursive helper method for print().
    public void printHelper(Node n, int depth) {
        if (n == null) {
            return;
        }

        printHelper(n.right, depth + 1);

        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "\t";
        }
        System.out.println(tabs + n.data);

        printHelper(n.left, depth + 1);
    }

    public static void main(String[] args) {
        // Show us that it works!!
        LRTree myTree = new LRTree();
        myTree.add("L");
        myTree.add("LL");
        myTree.add("L");
        myTree.add("RRR");
        myTree.add("RLL");
        myTree.add("RR");
        myTree.print();

        System.out.println(myTree.contains("RLR"));
        System.out.println(myTree.contains("RLL"));
        System.out.println(myTree.contains("LR"));
    }
}
