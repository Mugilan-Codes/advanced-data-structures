package queue;

public class Queue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public int size() {
        return count;
    }

    public Boolean isFull() {
        return size() == capacity;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int peek() {
        if(isEmpty()) {
            System.out.println("Underflow");
            System.exit(1);
        }
        return arr[front];
    }

    private void enqueue(int item) {

        if(isFull()) {
            System.out.println("Overflow");
            System.exit(1);
        }

        System.out.println("Inserting " + item);

        rear = (rear + 1) % capacity;
        System.out.println("Rear " + rear);
        arr[rear] = item;
        count++;

    }

    private void dequeue() {

        if(isEmpty()) {
            System.out.println("Underflow");
            System.exit(1);
        }

        System.out.println("Removing " + arr[front]);

        front = (front + 1) % capacity;
        System.out.println("Front " + front);
        count--;

    }

    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front Element is " + q.peek());
        q.dequeue();
        System.out.println("Front Element is " + q.peek());

        System.out.println("Queue Size is " + q.size());

        q.dequeue();
        q.dequeue();

        if(q.isEmpty()) {
            System.out.println("Queue Empty");
        } else {
            System.out.println("Queue Not Empty");
        }

    }

}
