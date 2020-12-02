package bai2_array_loop.bai_tap;
import java.util.Scanner;
public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {9, 8, 12, 16, 74, 3, 5};
        System.out.println("Array before!");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
        System.out.print("Enter element you want delete: ");
        int del = input.nextInt();

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == del) {
                index += i;
                break;
            }
        }
        if (index == 0) {
            System.out.println("False!!");
        } else {
            for (int j = index; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = 0;

            System.out.println("Array after!");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
        }
    }
}
