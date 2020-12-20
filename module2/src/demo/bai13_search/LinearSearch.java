package demo.bai13_search;

public class LinearSearch {

    public static int search(int[] array, int value){
        for(int index = 0; index < array.length; index++){
            if(value == array[index]){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = {8,9,2,4,0,11,23};
        System.out.println(search(myArray, 0));
    }
}
