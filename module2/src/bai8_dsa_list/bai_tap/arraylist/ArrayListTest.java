package bai8_dsa_list.bai_tap.arraylist;

public class ArrayListTest {
    private static void displayArray(ArrayList<Integer> arrays) {
        for (int i = 0; i < arrays.size(); i++) {
            System.out.print(arrays.get(i) + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrays = new ArrayList<>();
        arrays.add(1);
        arrays.add(2);
        arrays.add(3);
        arrays.add(5);
        arrays.add(6);
        arrays.add(7);

        displayArray(arrays);

        arrays.add(0,1);
        arrays.add(7);
        arrays.add(8);
        arrays.add(9);
        arrays.add(10);
        arrays.add(11);
        arrays.add(13);
        arrays.add(15);

        displayArray(arrays);

        arrays.remove(4);
        displayArray(arrays);

        arrays.clone();
        displayArray(arrays);

        System.out.println(arrays.indexOf(6));
        System.out.println(arrays.indexOf(12));
        System.out.println(arrays.contains(15));
        System.out.println(arrays.contains(4));

        arrays.clear();
        displayArray(arrays);
    }
}
