package tree.splay;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SplayTree tree = new SplayTree();
        Scanner input = new Scanner(System.in);
        boolean isDone = false;
        while (!isDone) {
            System.out.println("1 - Insert\n2 - Remove\n3 - Search\n4 - Count" +
                    " Nodes\n5 - Clear Tree\n6 - Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key to be inserted: ");
                    int insertKey = input.nextInt();
                    tree.insert(insertKey);
                    tree.display();
                    break;
                case 2:
                    System.out.print("Enter key to be removed: ");
                    int removeKey = input.nextInt();
                    tree.remove(removeKey);
                    tree.display();
                    break;
                case 3:
                    System.out.print("Enter key to be searched: ");
                    int searchKey = input.nextInt();
                    System.out.println("Search Result: " + tree.search(searchKey));
                    tree.display();
                    break;
                case 4:
                    tree.countNodes();
                    break;
                case 5:
                    tree.clear();
                    tree.display();
                    break;
                case 6:
                    isDone = true;
                    System.out.println("Exiting the Splay Tree");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }

}
