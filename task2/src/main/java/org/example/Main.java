package org.example;

import javax.management.ObjectName;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Creating stacks
        Stack<Integer> javaStack = new Stack<>();
        MyStack<Integer> myStack = new MyStack<>();

        // Add some data into stacks
        for (int i = 0; i < 5; i++) {
            javaStack.push(i);
            myStack.push(i);
        }

        javaStack.toString();

        // Println stack data
        System.out.println("javaStack: " + javaStack);
        System.out.println("myStack: " + myStack);

        // Remove data from stacks
        int removedJavaStack = javaStack.pop();
        int removedMyStack = myStack.pop();

        System.out.println("Removed from javaStack: " + removedJavaStack);
        System.out.println("Removed from myStack: " + removedMyStack);

        // Println some edited stacks
        System.out.println("javaStack after pop: " + javaStack);
        System.out.println("myStack after pop: " + myStack);
    }
}