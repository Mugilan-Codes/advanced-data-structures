package tree.avl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        Scanner input = new Scanner(System.in);

        boolean isDone = false;
        while (!isDone) {
            System.out.println("1 - Insert\n2 - Delete\n3 - Find\n4 - Height\n5 -" +
                    " Display\n6 - Exit");
            // TODO - Stop exiting when non-integer is entered.
            System.out.print("Enter your Choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter a Key to be inserted: ");
                    int insertKey = input.nextInt();
                    tree.insert(insertKey);
                    break;
                case 2:
                    System.out.print("Enter a Key to be deleted: ");
                    int deleteKey = input.nextInt();
                    tree.delete(deleteKey);
                    break;
                case 3:
                    System.out.print("Enter a Key to be inserted: ");
                    int findKey = input.nextInt();
                    tree.find(findKey);
                    break;
                case 4:
                    System.out.println("Height of the tree is " + tree.height());
                    break;
                case 5:
                    tree.display();
                    break;
                case 6:
                    isDone = true;
                    System.out.println("Exiting the AVL Tree...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }

}
