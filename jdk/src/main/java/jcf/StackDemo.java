package jcf;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(null);
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println(stack.size());
        System.out.println(Thread.currentThread().getStackTrace());

    }
}
