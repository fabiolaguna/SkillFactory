package net.skillfactory;

public class App {

    public static void main( String[] args ) {

        Stack<Integer> stack = new Stack<>();

        if (stack.pop() == null){
            System.out.println("Empty stack\n");
        } else {
            System.out.println("Top: " + stack.getTop() + "\n");
        }

        if (stack.pop() == null){
            System.out.println("Empty stack\n");
        } else {
            System.out.println("Removed: " + stack.pop() + "\n");
        }

        stack.push(3);
        stack.push(43);
        stack.push(7);

        System.out.println("Stack size: " + stack.size());

        Integer removed = stack.pop();

        System.out.println("\nStack size: " + stack.size());
        System.out.println("\nRemoved: " + removed);
    }
}
