public class BinaryTree {
    int value;
    BinaryTree left, right;

    // This is the constructor to create new node
    public BinaryTree(int value) {
        this.value = value;
        left = right = null;
    }

    // To insert a new node in the binary tree
    public BinaryTree insert(BinaryTree root, int value) {
        if (root == null) {
            return new BinaryTree(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // The Inorder traversal of the tree.
    public void inOrderTraversal(BinaryTree root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    // Define a main method to test the binary tree
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);  // root node

        // Insert nodes into the binary tree
        tree.insert(tree, 5);
        tree.insert(tree, 1);
        tree.insert(tree, 4);
        tree.insert(tree, 3);
        tree.insert(tree, 2);

        // Print in-order traversal of the tree
        System.out.println("Inorder Traversal of the Trees are");
        tree.inOrderTraversal(tree);
        System.out.println();
    }
}
