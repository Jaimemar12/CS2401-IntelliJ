package Trees;

public class BST {

    private Node root;

    private class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BST() {
        this.root = null;
    }

    public BST(int[] a) {
        for (int i = 0; i < a.length; i++) {
            add(a[i]);
        }
    }

    public void add(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            Node finder = root;
            boolean addedNode = false;
            while (!addedNode) {
                if (x <= finder.data) {
                    if (finder.left == null) {
                        finder.left = new Node(x);
                        addedNode = true;
                    } else {
                        finder = finder.left;
                    }
                } else {
                    if (finder.right == null) {
                        finder.right = new Node(x);
                        addedNode = true;
                    } else {
                        finder = finder.right;
                    }
                }
            }
        }
    }

    public String toString() {
        return toStringHelper(root, 0);
    }

    public String toStringHelper(Node n, int depth) {
        String ret = "";
        if (n == null) {
            return ret;
        }

        ret += toStringHelper(n.right, depth + 1);

        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "\t";
        }
        ret += tabs + n.data + "\n";

        ret += toStringHelper(n.left, depth + 1);

        return ret;
    }

    // YOU DO NOT NEED TO MODIFY ANYTHING ABOVE THIS LINE

    // You need to write this method. I'm just returning -1 so the code compiles.
    public int nearest(int x) {
        Node finder = root;
        int closest = root.data;
        int min = Math.abs(x - root.data);

        while(finder != null) {

            if(Math.abs(x-finder.data) < min) {
                min = Math.abs(x-finder.data);
                closest = finder.data;
            }


            if(x < finder.data) {
                finder = finder.left;
            }else if(x > finder.data) {
                finder = finder.right;
            }else {
                return finder.data;
            }
        }


        return closest;
    }

    // You need to write this method.
    public void removeRoot() {
        Node pointer = root;

        if(pointer.left == null) {
            root = root.right;
        }else if(pointer.left.right == null) {
            root.data = root.left.data;
            root.left = root.left.left;
        }else {
            pointer = pointer.left;

            while(pointer.right.right != null) {
                pointer = pointer.right;
            }

            root.data = pointer.right.data;
            pointer.right = pointer.right.left;
        }
    }

    public static void main(String[] args) {

        // Here's one BST, you can (and should!) create others to test your methods.
        int[] nums = {15, 13, 20, 18, 17, 13, 9, 22, 12, 6, 14, 14, 15, 15};
        BST bst = new BST(nums);
        //System.out.println(bst);

        int[] nums2 = {3,4,5, 1};
        BST bst2 = new BST(nums2);

        int[] nums3 = {1,2,3,4,5};
        BST bst3 = new BST(nums3);


        System.out.println(bst);
        bst.removeRoot();
        System.out.println("\n\n\n\n\n");
        System.out.println(bst);
        System.out.println("\n\n\n\n\n");


        System.out.println(bst2);
        bst2.removeRoot();
        System.out.println("\n\n\n\n\n");
        System.out.println(bst2);

        System.out.println("\n\n\n\n\n");
        System.out.println(bst3);
        bst3.removeRoot();
        System.out.println("\n\n\n\n\n");
        System.out.println(bst3);
    }
}
