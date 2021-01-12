package StacksQueues;

public class MyQueue {

    private MyStack inStack;
    private MyStack outStack;

    public MyQueue() {
        inStack = new MyStack(1);
        outStack = new MyStack(1);
    }

    public void enqueue(String s) {
        inStack.push(s);
    }

    public String dequeue() {
        // You have to write this method, this is just here so your code compiles.

        if(outStack.empty()) {
            while(!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public boolean empty() {
        // You have to write this method, this is just here so your code compiles.
        return inStack.empty() && outStack.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println(queue.empty());
        System.out.println(queue.dequeue());
        queue.enqueue("Hi");
        queue.enqueue("Hello");
        queue.enqueue("How");
        queue.enqueue("Are");
        queue.enqueue("You");
        System.out.println(queue.empty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("My");
        queue.enqueue("Name");
        queue.enqueue("Is");
        queue.enqueue("Jaime");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.empty());
    }
}