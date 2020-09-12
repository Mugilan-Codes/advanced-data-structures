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

    private void rbTransplant(Node x, Node y) {
        if(x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.parent = x.parent;
    }

    private Node minimum(Node node) {
        while(node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    private void fixDelete(Node node) {
        Node temp;
        while(node != root && node.color == 0) {
            if(node == node.parent.left) {
                temp = node.parent.right;
                if(temp.color == 1) {
                    temp.color = 0;
                    node.parent.color = 1;
                    leftRotate(node.parent);
                    temp = node.parent.right;
                }

                if(temp.left.color == 0  && temp.right.color == 0) {
                    temp.color = 1;
                    node = node.parent;
                } else {
                    if(temp.right.color == 0) {
                        temp.left.color = 0;
                        temp.color = 1;
                        rightRotate(temp);
                        temp = node.parent.right;
                    }

                    temp.color = node.parent.color;
                    node.parent.color = 0;
                    temp.right.color = 0;
                    leftRotate(node.parent);
                    node = root;
                }
            } else {
                temp = node.parent.left;
                if(temp.color == 1) {
                    temp.color = 0;
                    node.parent.color = 1;
                    rightRotate(node.parent);
                    temp = node.parent.left;
                }

                if(temp.left.color == 0 && temp.right.color == 0) {
                    temp.color = 1;
                    node = node.parent;
                } else {
                    if(temp.left.color == 0) {
                        temp.right.color = 0;
                        temp.color = 1;
                        leftRotate(temp);
                        temp = node.parent.left;
                    }

                    temp.color = node.parent.color;
                    node.parent.color = 0;
                    temp.left.color = 0;
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }
        node.color = 0;
    }

    private void deleteNodeHelper(Node node, int key) {
        Node z = TNULL;
        Node x, y;
        while (node != TNULL) {
            if(node.key == key) {
                z = node;
            }

            if(node.key <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if(z == TNULL) {
            System.out.println("Key " + key + " not found");
            return;
        }

        y =z;
        int yOriginalColor = y.color;
        if(z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if(z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if(y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(z, y);
                y.left = z.left;
                y.left.parent = y;
                y.color = z.color;
            }

            if(yOriginalColor == 0) {
                fixDelete(x);
            }
        }
    }

    public void deleteNode(int key) {
        deleteNodeHelper(this.root, key);
    }

}
