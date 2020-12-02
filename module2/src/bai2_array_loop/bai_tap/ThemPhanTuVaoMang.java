package bai2_array_loop.bai_tap;
import java.util.Scanner;
public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Enter array size: ");
            size = input.nextInt();
            if (size>20){
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array=new int[size];
        for (int i = 0; i < size; i ++){
            System.out.print("Enter the "+(i+1)+ " element: ");
            array[i] = input.nextInt();
        }

        for(int i = 0; i < array.length; i ++) {
            System.out.print(array[i] +"\t");
        }

        System.out.println("");

        System.out.print("Enter the element add: ");
        int element = input.nextInt();

        System.out.print("Enter the element index: ");
        int index = input.nextInt();

        if((index >= array.length-1) || (index <= 1)){
            System.out.println("Cant not insert this value");
        }else {
            for (int i = size; i > index ; i--) {
                array[i-1] = array[i - 2];
            }
            array[index] = element;

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
        }
    }
}
