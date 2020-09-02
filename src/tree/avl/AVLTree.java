package tree.avl;

// Explanation for Rotations
// https://www.freecodecamp.org/news/avl-tree-insertion-rotation-and-balance
// -factor/

public class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Balance Factor (k) = height (right(k)) - height (left(k))
    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }

    private Node reBalance(Node node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            System.out.println("Performing Rotation...");
            // Check for RL Rotation
            if (height(node.right.right) <= height(node.right.left)) {
                System.out.print("R");
                node.right = rotateRight(node.right);
            }
            // Perform L Rotation
            System.out.print("L");
            node = rotateLeft(node);
            System.out.print(" Rotation\n");
        } else if (balance < -1) {
            System.out.println("Performing Rotation...");
            // Check for LR Rotation
            if (height(node.left.left) <= height(node.left.right)) {
                System.out.print("L");
                node.left = rotateLeft(node.left);
            }
            // Perform R Rotations
            System.out.print("R");
            node = rotateRight(node);
            System.out.print(" Rotation\n");
        }
        return node;
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            System.out.println("Duplicate Key: " + key);
            System.out.println("Cannot be inserted");
        }
        return reBalance(node);
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            System.out.println("Deletion Not Possible");
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = reBalance(node);
        }
        return node;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        if (current != null) {
            System.out.println("Key found: " + current.key);
        } else {
            System.out.println(key + " Key Not found");
        }
        return current;
    }

    public void insert(int key) {
        System.out.println("Inserting -> " + key);
        root = insert(root, key);
    }

    public void delete(int key) {
        System.out.println("Deleting -> " + key);
        if (find(key) == null) {
            System.out.println("Deletion not Possible");
        } else {
            root = delete(root, key);
            System.out.println(key + " Deleted");
        }
    }

    private Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private void printTree(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R---");
                indent += "    ";
            } else {
                System.out.print("L---");
                indent += "|   ";
            }
            System.out.println(root.key);
            printTree(root.left, indent, false);
            printTree(root.right, indent, true);
        }
    }

    public void display() {
        Node root = getRoot();
        if (root == null) {
            System.out.println("Tree is Empty");
        } else {
            System.out.println("Root Node Key = " + root.key);
            printTree(root, "", true);
        }
    }

}
