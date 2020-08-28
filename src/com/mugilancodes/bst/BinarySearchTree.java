package com.mugilancodes.bst;

public class BinarySearchTree {

    private Node root = null;

    class Node {
        int data;
        Node left, right;

        Node(int temp) {
            data = temp;
            left = right = null;
        }
    }

    public void insert(int data) {

        if (root == null) {
            this.root = new Node(data);
            System.out.println(" -> Inserted " + data);
            return;
        }

        insertNode(root, data);
        System.out.println(" -> Inserted " + data);

    }

    private Node insertNode(Node root, int data) {
        Node temp = null;
        System.out.print(" -> " + root.data);
        if (root.data >= data) {
            System.out.print(" [L] ");
            if (root.left == null) {
                root.left = new Node(data);
                return root.left;
            } else {
                temp = root.left;
            }
        } else {
            System.out.print(" [R] ");
            if (root.right == null) {
                root.right = new Node(data);
                return root.right;
            } else {
                temp = root.right;
            }
        }

        return insertNode(temp, data);
    }

    public void traverse() {
        if (root == null) {
            System.out.println("Tree is Empty");
        }
        printTree(root, "", true);
        System.out.println("\nIn Order Traversal");
        inOrderTraversal(root);
        System.out.println("\nPre Order Traversal");
        preOrderTraversal(root);
        System.out.println("\nPost Order Traversal");
        postOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrderTraversal(root.left);
        }
        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

    private void postOrderTraversal(Node root) {
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        System.out.print(root.data + " ");
    }

    public void printTree(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R---");
                indent += "    ";
            } else {
                System.out.print("L---");
                indent += "|   ";
            }
            System.out.println(root.data);
            printTree(root.left, indent, false);
            printTree(root.right, indent, true);
        }
    }

}
