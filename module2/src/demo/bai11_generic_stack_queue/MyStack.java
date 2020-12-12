package demo.bai11_generic_stack_queue;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

//        System.out.println(myStack.size());
//        System.out.println(myStack.peek());
//        System.out.println(myStack.size());
//
//        System.out.println(myStack.toString());

        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }
}
