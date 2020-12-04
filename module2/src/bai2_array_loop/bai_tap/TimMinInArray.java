package bai2_array_loop.bai_tap;
import java.util.Scanner;
public class TimMinInArray {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int size;
        do {
            System.out.println("Enter the size");
            size=input.nextInt();
            if (size>20){
                System.out.println("Size should not exceed 20");
            }
        }while (size>20);

        int[]arr=new int[size];
        for (int i=0;i<arr.length;i++){
            System.out.print("Enter element" + (i + 1) + " : ");
            arr[i]=input.nextInt();
        }

        int min=arr[0];
        int index=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
                index=i;
            }
        }

        System.out.println("The smallest element in the array is: "+min+" ,at index "+index);
    }
}
