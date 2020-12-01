package demo.bai2;

public class MyArray {
    static String a[];
    static int[] b = {1, 2, 3, 4}; //2,3,4,0
    static int[] c = new int[b.length * 2];


    public static void main(String[] args) {

//        System.out.println(b.length);
//        a = new String[5];
//        a[0] = "1.1";
//        a[a.length -1] = "1.2";
//
//        System.out.println(a[0]);
//        System.out.println(a[a.length - 1]);

        int myArray[] = {1,2,3,4,5};
        for (int index = 0; index < myArray.length; index++) {
            System.out.print(myArray[index] +"\t");
            if(index == 2){
                break;
            }
        }

        System.out.println();
        System.out.println("-------------------------");

        for (int element : myArray){
            System.out.print(element + "\t");
        }

        System.out.println();
        System.out.println("-------------------------");

        int index = 0;
        while (index < myArray.length){
            if(index == 2) {
                index++;
                continue;
            }
            System.out.print(myArray[index] + "\t");
            index++;
        }

        System.out.println();
        System.out.println("-------------------------");

        int index_2 = 0;
        do {
            System.out.print(myArray[index_2] +"\t");
            index_2++;

        } while (index_2 < myArray.length);

    }
}
