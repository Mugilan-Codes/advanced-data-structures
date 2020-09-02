package tree.bs;

public class SearchTree {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(32);
        bst.insert(40);
        bst.insert(21);
        bst.insert(85);
        bst.insert(12);
        bst.insert(1);
        bst.insert(65);
        bst.insert(43);
        bst.insert(123);

        bst.traverse();

    }

}
