package com.mugilancodes.ll;

public class SinglyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    void addNodeAtStart(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addNodeAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // TODO - The position must not be more the size
    void addNodeAt(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            addNodeAtStart(newNode.data);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    void deleteNodeAtStart() {
        if (isEmpty()) {
            System.out.println("Cannot Delete as the List is empty;");
        } else {
            Node temp = head;
            head = head.next;
            System.out.println(temp.data + " Deleted");
        }
    }

    void deleteNodeAtEnd() {
        if (isEmpty()) {
            System.out.println("Cannot Delete as the List is empty;");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            System.out.println(temp.next.data + " Deleted");
            temp.next = null;
        }
    }

    // TODO - The position must not be more the size
    void deleteNodeAt(int position) {
        if (position == 0) {
            head = head.next;
        } else {
            Node temp1 = head;
            Node temp2 = null;
            for (int i = 0; i < position - 1; i++) {
                temp1 = temp1.next;
            }
            temp2 = temp1.next;
            temp1.next = temp2.next;
            System.out.println(temp2.data + " Deleted");
        }
    }

    void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is Empty");
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    int getSize() {
        Node temp = head;
        int count = 0;
        if (temp != null) {
            while (temp != null) {
                temp = temp.next;
                count++;
            }
        }
        return count;
    }
}
