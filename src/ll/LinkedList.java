package ll;

// TODO - Also Do Doubly and Circular Linked List
public class LinkedList {

    public static void main(String[] args) {

        // TODO - Pass the list itself to the class to use the getSize()
        SinglyLinkedList list = new SinglyLinkedList();

        list.addNodeAtStart(20);
        list.addNodeAtStart(10);
        list.addNodeAtEnd(50);
        list.printList();

        list.addNodeAt(40, 3);
        list.printList();

        System.out.println("List Size = " + list.getSize());

        list.deleteNodeAtStart();
        list.printList();
        System.out.println("List Size = " + list.getSize());

        list.deleteNodeAtEnd();
        list.printList();

        list.deleteNodeAt(1);
        list.printList();

        list.deleteNodeAtStart();
        list.printList();

        list.deleteNodeAtEnd();
        list.printList();

    }

}
