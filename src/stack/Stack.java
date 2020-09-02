package stack;

public class Stack {

    private final int[] arr;
    private int top;
    private final int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }

        return -1;
    }

    public void push(int x) {
        if(isFull()) {
            System.out.println("Overflow");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Underflow");
            System.exit(1);
        }

        System.out.println("Removing " + peek());
        --top;
    }

}
