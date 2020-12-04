package bai2_array_loop.bai_tap;
import java.util.Scanner;
public class TimPhanTuLonNhatMangHaiChieu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int size_1;
        do{
            System.out.println("Enter array size1: ");
            size_1 = input.nextInt();
            if (size_1> 5){
                System.out.println("Size should not exceed 20");
            }
        } while (size_1 > 5);

        int size_2;
        do{
            System.out.println("Enter array size2: ");
            size_2 = input.nextInt();
            if (size_2>5){
                System.out.println("Size should not exceed 20");
            }
        } while (size_2 > 5);

        int arr[][]=new int [size_1][size_2];
        for (int i=0;i<size_1;i++){
            for (int j=0;j<size_2;j++){
                System.out.print("Enter the element "+(i)+(j)+ " :");
                arr[i][j]=input.nextInt();
            }
        }
        double max=arr[0][0];
        int index1=0;
        int index2=0;

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j]>max){
                    max = arr[i][j];
                    index1=i;
                    index2=j;
                }
            }
        }
        System.out.println("the largest element in the array is");
        System.out.println("Max: "+max+" "+ "index: "+index1+" "+index2);
    }
}
