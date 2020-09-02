package stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(4);

        stack.pop();
        stack.pop();

        stack.push(7);
        stack.push(5);
        stack.push(3);

        System.out.println("Top Element is " + stack.peek());
        System.out.println("Stack size is " + stack.size());

        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("Stack Empty");
        } else {
            System.out.println("Stack Not Empty");
        }
    }

}
