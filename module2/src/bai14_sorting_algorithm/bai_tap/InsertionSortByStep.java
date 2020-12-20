package bai14_sorting_algorithm.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    static int size;
    static int[] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list size: ");
        size = scanner.nextInt();
        list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < size; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int w : list) {
            System.out.print(w + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] list) {
        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int temp = list[i];
            int j = i - 1; 

            while (j >= 0 && list[j] > temp) {
                System.out.println("assign "+ list[j+1]+ " with "+ list[j]);
                list[j + 1] = list[j];
                j = j - 1;
            }
            if(temp != list[j+1]) {
                System.out.println("assign " + list[j + 1] + " with " + temp);
                list[j + 1] = temp;
            }
            System.out.print("List after the  " + i + " sort: ");
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k] + "\t");
            }
            System.out.println();
        }
    }
}
