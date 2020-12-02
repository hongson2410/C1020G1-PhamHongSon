package bai2_array_loop.thuc_hanh;

public class TimMin {
    public static int minValue(int[] array) {
        int min=array[0];
        int index_1=0;
        for (int i=0; i<array.length;i++){
            if (array[i]<min){
                min=array[i];
                index_1=i;
            }
        }
        return index_1;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("The smallest element in the array is: " + arr[minValue(arr)]);
    }
}
