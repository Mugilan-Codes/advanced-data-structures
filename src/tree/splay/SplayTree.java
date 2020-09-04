package tree.splay;

public class SplayTree {

    class Node {
        int key;
        Node left, right, parent;

        Node() {
            this(0);
        }

        Node(int key) {
            this(key, null, null, null);
        }

        Node(int key, Node left, Node right, Node parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    private Node root;
    private int count = 0;

    private void makeLeftChildParent(Node xNode, Node yNode) {
        if (xNode == null || yNode == null || yNode.left != xNode || xNode.parent != yNode) {
            throw new RuntimeException("Wrong");
        }

        if (yNode.parent != null) {
            if(yNode==yNode.parent.left) {
                yNode.parent.left = xNode;
            } else {
                yNode.parent.right = xNode;
            }
        }

        if(xNode.right != null) {
            xNode.right.parent = yNode;
        }

        xNode.parent = yNode.parent;
        yNode.parent = xNode;
        yNode.left = xNode.right;
        xNode.right = yNode;
    }

    private void makeRightChildParent(Node xNode, Node yNode) {
        if (xNode == null || yNode == null || yNode.right != xNode || xNode.parent != yNode) {
            throw new RuntimeException("Wrong");
        }

        if (yNode.parent != null) {
            if(yNode==yNode.parent.left) {
                yNode.parent.left = xNode;
            } else {
                yNode.parent.right = xNode;
            }
        }

        if(xNode.left != null) {
            xNode.left.parent = yNode;
        }

        xNode.parent = yNode.parent;
        yNode.parent = xNode;
        yNode.right = xNode.left;
        xNode.left = yNode;
    }

    private void splay(Node node) {
        while (node.parent != null) {
            Node Parent = node.parent;
            Node GrandParent = Parent.parent;

            if (GrandParent == null) {
                if (node == Parent.left) {
                    System.out.println("Zig Rotation");
                    makeLeftChildParent(node, Parent);
                } else {
                    System.out.println("Zag Rotation");
                    makeRightChildParent(node, Parent);
                }
            } else {
                if (node == Parent.left) {
                    if (Parent == GrandParent.left) {
                        System.out.println("Zig-Zig Rotation");
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(node, Parent);
                    } else {
                        System.out.println("Zig-Zag Rotation");
                        makeLeftChildParent(node, node.parent);
                        makeRightChildParent(node, node.parent);
                    }
                } else {
                    if (Parent == GrandParent.left) {
                        System.out.println("Zag-Zig Rotation");
                        makeRightChildParent(node, node.parent);
                        makeLeftChildParent(node, node.parent);
                    } else {
                        System.out.println("Zag-Zag Rotation");
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(node, Parent);
                    }
                }
            }
        }

        root = node;
    }

    public void insert(int key) {
        System.out.println("Inserting -> " + key);

        Node x = root;
        Node y = null;

        while (x != null) {
            y = x;
            if(key > y.key) {
                x = x.right;
            } else {
                x = x.left;
            }
        }

        x = new Node();
        x.key = key;
        x.parent = y;
        if(y == null ) {
            root = x;
        } else if(key > y.key) {
            y.right = x;
        } else {
            y.left = x;
        }

        splay(x);
        count++;
    }

    private void remove(Node node) {
        System.out.println("Removing -> " + node);
        if (node == null) {
            return;
        }

        splay(node);

        if(node.left != null && node.right != null) {
            Node min = node.left;
            while(min.right != null) {
                min = min.right;
            }
            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        } else if(node.right != null) {
            node.right.parent = null;
            root = node.right;
        } else if (node.left != null) {
            node.left.parent = null;
            root = node.left;
        }else {
            root = null;
        }

        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }

    private Node findNode(int key) {
        Node prevNode = null;
        Node x = root;
        while (x != null) {
            prevNode = x;
            if(key > x.key) {
                x = x.right;
            } else if(key < x.key) {
                x = x.left;
            } else if(key == x.key) {
                splay(x);
                return x;
            }
        }

        if(prevNode != null) {
            splay(prevNode);
            return null;
        }
        return null;
    }

    public void remove(int key) {
        Node node = findNode(key);
        remove(node);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
        count = 0;
    }


}
