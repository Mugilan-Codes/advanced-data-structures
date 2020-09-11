package tree.redblack;

public class RedBlackTree {

    class Node {
        int key, color;
        Node left, right, parent;
    }

    private Node root;
    private Node TNULL; // hides null leaves

    RedBlackTree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    private void rightRotate(Node x) {
        System.out.println("Right Rotate");
        Node y = x.left;
        x.left = y.right;
        if(y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null) {
            this.root = y;
        } else if(x == x.parent.right) {
            x.parent.right = y;
        } else{
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
//        printTree();
    }

    private void leftRotate(Node x) {
        System.out.println("Left Rotate");
        Node y = x.right;
        x.right = y.left;
        if(y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null) {
            this.root = y;
        } else if(x == x.parent.left) {
            x.parent.left = y;
        } else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
//        printTree();
    }

    private void fixInsert(Node node) {
        System.out.println("Fixing Insert");
        Node temp;
        Node Parent = node.parent;
        Node GrandParent = Parent.parent;
        while(Parent.color == 1) {
            if(Parent== GrandParent.right) {
                temp = GrandParent.left;
                if(temp.color == 1) {
                    temp.color = 0;
                    Parent.color = 0;
                    GrandParent.color = 1;
                    node = GrandParent;
                } else {
                    if(node == Parent.left) {
                        node = Parent;
                        rightRotate(node);
                    }
                    Parent.color = 0;
                    GrandParent.color = 1;
                    leftRotate(GrandParent);
                }
            } else {
                temp = GrandParent.right;
                if(temp.color == 1) {
                    temp.color = 0;
                    Parent.color = 0;
                    GrandParent.color = 1;
                    node = GrandParent;
                } else {
                    if (node == Parent.right) {
                        node = Parent;
                        leftRotate(node);
                    }
                    Parent.color = 0;
                    GrandParent.color = 1;
                    rightRotate(GrandParent);
                }
            }
            if(node == root) {
                break;
            }
        }
        root.color = 0;
    }

    public void insert(int key) {
        System.out.println("Inserting -> " + key);
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
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    private void printHelper(Node root, String indent, boolean last) {
        if(root != TNULL) {
            System.out.print(indent);
            if(last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "RED":"BLACK";
            System.out.println(root.key + "("+sColor+")");
            printHelper(root.left,indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public void printTree() {
        printHelper(this.root, "", true);
        System.out.println();
    }

}
