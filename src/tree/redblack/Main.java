package tree.redblack;

public class Main {

    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree();

        rbt.insert(45);
        rbt.printTree();
        rbt.insert(65);
        rbt.printTree();
        rbt.insert(55);
        rbt.printTree();
        rbt.insert(35);
        rbt.printTree();
        rbt.insert(25);
        rbt.printTree();
        rbt.insert(75);
        rbt.printTree();

    }

}
