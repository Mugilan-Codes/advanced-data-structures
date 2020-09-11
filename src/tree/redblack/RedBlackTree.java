package tree.redblack;

public class RedBlackTree {

    class Node {
        int key, color;
        Node left, right, parent;
    }

    private Node root;
    private Node TNULL;

    RedBlackTree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void insert(int key) {
        Node node = new Node();
        node.parent = null;
        node.key = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if(node.key < x.key) {
                x = x.left;
            } else {
                x=x.right;
            }
        }
    }

}
