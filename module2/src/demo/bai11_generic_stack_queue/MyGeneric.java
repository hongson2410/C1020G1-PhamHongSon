package demo.bai11_generic_stack_queue;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {
    private static void printElement(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + "\t");
        }
    }

    public static <T> void printElement_3(T[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + "\t");
        }
    }

    public static void printElement_4(List<? extends Number> array) {
        for (int index = 0; index < array.size(); index++) {
            System.out.print(array.get(index) + "\t");
        }
    }

    private static void printElement2(Object[] objectsArray) {
        for (Object element : objectsArray) {
            System.out.print(element + "\t");
        }
    }

    public static void main(String[] args) {
//        Integer[] intArr = {1, 2, 3, 4};
//        Double[] doubleArr = {1.1, 2.2, 3.3, 4.4};
//        String[] stringArr = {"one", "two", "three"};
        List<Integer> intArr = new ArrayList<>();
        intArr.add(1);
        intArr.add(2);
        intArr.add(3);

        List<Double> doubleArr = new ArrayList<>();
        doubleArr.add(1.1);
        doubleArr.add(2.2);
        doubleArr.add(3.3);

        List<String> stringArr = new ArrayList<>();
        stringArr.add("one");
        stringArr.add("two");


//        List object = new ArrayList<>();
//        object.add("aa");
//        object.add("bbb");


        printElement_4(intArr);
        System.out.println();
        printElement_4(doubleArr);
        System.out.println();
        //printElement_4(stringArr);
//        System.out.println();
//        printElement_4(object);


//        ArrayList<Integer> myArray = new ArrayList();
//        myArray.add(1);
//        //myArray.add("hello world");
//        //myArray.add(true);
//
//        System.out.println(myArray.get(1));
//        Integer z = myArray.get(1);
//        String x = (String) myArray.get(1);
//        Integer y = (Integer) myArray.get(0);
    }
}
