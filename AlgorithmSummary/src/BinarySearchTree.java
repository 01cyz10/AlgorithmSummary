public class BinarySearchTree {

    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node); // node for entire tree
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node); //
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    public boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (root.data > data) {
            return searchHelper(root.left, data);
        }
        else {
            return searchHelper(root.right, data);
        }
    }

    public void remove(int data) {

        if (search(data)) {
            removeHelper(root, data);
        }
        else {
            System.out.println(data + " Not Be Found");
        }
    }

    private Node removeHelper(Node root, int data) {

        if (root == null) {
            return root;
        }
        else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        }
        else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        }
        else {
            // node found
            if (root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) {
                // find a successdor tp replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) {
        // find the least value below the right child of this root node
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        // find the least value below the left child of this root node
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
