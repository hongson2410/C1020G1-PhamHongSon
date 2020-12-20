package bai14_sorting_algorithm.bai_tap;

public class InsertionSort {
    static int[] list = {1, 9, 4, 6, 5, -4};
    public static void insertionSort (int[] list){
        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (int a : list){
            System.out.print(a+"\t");
        }
    }
}
