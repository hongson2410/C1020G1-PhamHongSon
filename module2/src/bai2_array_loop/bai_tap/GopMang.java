package bai2_array_loop.bai_tap;
import java.util.Scanner;
public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size_1;
        do{
            System.out.println("Enter array size1: ");
            size_1 = input.nextInt();
            if (size_1>20){
                System.out.println("Size should not exceed 20");
            }
        } while (size_1 > 20);

        int[] array_1=new int[size_1];
        for (int i = 0; i < size_1; i ++){
            System.out.print("Enter the "+(i+1)+ " element: ");
            array_1[i] = input.nextInt();
        }

        int size_2;
        do{
            System.out.println("Enter array size2: ");
            size_2 = input.nextInt();
            if (size_2>20){
                System.out.println("Size should not exceed 20");
            }
        } while (size_2 > 20);

        int[]array_2=new int[size_2];
        for (int i = 0; i < size_2; i ++){
            System.out.print("Enter the "+(i+1)+ " element: ");
            array_2[i] = input.nextInt();
        }

        System.out.println("Array 1");
        for(int i = 0; i < array_1.length; i ++) {
            System.out.print(array_1[i] +"\t");
        }

        System.out.println("");

        System.out.println("Array 2");
        for(int i = 0; i < array_2.length; i ++) {
            System.out.print(array_2[i] +"\t");
        }

        System.out.println("");

        int size_3=size_1+size_2;
        int[] array_3= new int[size_3];
        for (int i=0;i<array_1.length;i++){
            array_3[i]=array_1[i];
        }
        for (int j=0;j<array_2.length;j++){
            array_3[array_1.length+j]=array_2[j];
        }

        System.out.println("Array 3");
        for (int i = 0; i < array_3.length; i++) {
            System.out.print(array_3[i] + "\t");
        }
    }
}
