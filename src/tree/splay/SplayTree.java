package tree.splay;

public class SplayTree {

    static class Node {
        int element;
        Node left, right, parent;

        Node() {
            this(0);
        }

        Node(int element) {
            this(element, null, null, null);
        }

        Node(int element, Node left, Node right, Node parent) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

}
