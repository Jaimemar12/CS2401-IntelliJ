package StacksQueues;

public class MyStack {

    public String[] a;
    public int top;

    public MyStack(int initialCapacity) {
        a = new String[initialCapacity];
    }

    public void push(String s) {
        a[top++] = s;
        if(top == a.length) {
            String[] newA = new String[a.length*2];
            for(int i = 0; i < a.length; i++) {
                newA[i] = a[i];
            }
            a = newA;
        }
    }

    public String pop() {
        // You have to write this method, this is just here so your code compiles.
        if(top != 0) {
            return a[--top];
        }

        return null;
    }

    public boolean empty() {
        // You have to write this method, this is just here so your code compiles.
        return top == 0;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(1);
        System.out.println(stack.pop());
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("Hello");
        stack.push("Hi");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}