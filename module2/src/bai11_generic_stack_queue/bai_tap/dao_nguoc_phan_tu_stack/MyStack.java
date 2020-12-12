package bai11_generic_stack_queue.bai_tap.dao_nguoc_phan_tu_stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {

        Stack<Integer> emptyStack= new Stack<>();

        emptyStack.push(5);
        emptyStack.push(4);
        emptyStack.push(3);
        emptyStack.push(2);
        emptyStack.push(1);

        System.out.print("Array is:");
        System.out.println(emptyStack.toString());

        Stack<Integer> emptyStack_2= new Stack<>();

        int tempt= emptyStack.size();

        for (int index = 0 ; index < tempt; index++){
            emptyStack_2.push(emptyStack.pop());
        }

        System.out.print("Array after reversing:");
        System.out.println(emptyStack_2.toString());

        String text= "State of Divinity"; //Tiếu Ngạo Giang Hồ!!!
        Stack<String> arrays = new Stack<>();



        for (String w: text.split("\\s")){
            arrays.push(w);
        }

        System.out.println("");
        System.out.print("Array string is: ");
        System.out.println(arrays.toString());

        Stack<String> arrays_2= new Stack<>();
        int tempt_2= arrays.size();

        for (int index=0; index<tempt_2; index++){
            arrays_2.push(arrays.pop());
        }

        System.out.print("Array string after reversing: ");
        System.out.println(arrays_2.toString());
    }
}
