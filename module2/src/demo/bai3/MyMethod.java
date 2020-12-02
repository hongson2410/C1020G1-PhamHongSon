package demo.bai3;

import java.util.Arrays;

public class MyMethod {

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }

    public static void sum_2(int a, int b) {
        int result = a + b;
        System.out.println("Result: " + result);
    }

    public static void div(int a, int b, int c) {
        System.out.println(sum(a, b) / c);
    }

    public int sum_3(int a, int b) {
        return a + b;
    }

    public void div_2(int a, int b, int c) {
        System.out.println(sum_3(a, b) / c);
    }

    public static int[] cloneArray(int[] array) {
        int[] newArray = new int[array.length * 2];
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int b[] = cloneArray(a);

        System.out.println(Arrays.toString(b));
//        for (int element : b) {
//            System.out.print(element + "\t");
//        }

//        int c = sum(5, 6);
//        System.out.println(c);
//        sum_2(5, 6);
//        div(2, 2, 1);
//
//        int z = 5;
//
//        String a = new String("1");
//        String b = new String("1");
//
//
//        if (a.equals(b)) {
//            System.out.println("OK");
//        } else {
//            System.out.println("NG");
//        }
//
//        MyMethod object = new MyMethod();
//        System.out.println("ababa" + object.sum(5, 6));
    }
}
