package tree.redblack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RedBlackTree rbt = new RedBlackTree();
        Scanner sc = new Scanner(System.in);
        boolean isDone = false;

        while (!isDone) {
            System.out.println("1 - Insert\n2 - Delete\n4 - Print Tree\n7 - Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the key to be inserted: ");
                    rbt.insert(sc.nextInt());
                    rbt.printTree();
                }
                case 2 -> {
                    System.out.println("Enter the key to be deleted: ");
                    rbt.deleteNode(sc.nextInt());
                    rbt.printTree();
                }
                case 4 -> rbt.printTree();
                case 7 -> {
                    isDone = true;
                    System.out.println("Exiting the Red-Black Tree...");
                }
                default -> System.out.println("Invalid Choice");
            }
        }

    }

}
