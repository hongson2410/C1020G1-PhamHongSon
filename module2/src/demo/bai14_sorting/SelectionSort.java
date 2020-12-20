package demo.bai14_sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] a = {2, 7, 8, 9, 1, -5};

        for (int i = 0; i < a.length - 1; i++) {
            int iMin = i;

            // find min
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            }

            System.out.println("Min: " + a[iMin]);

            if (iMin != i) {
                int tmp = a[i];
                a[i] = a[iMin];
                a[iMin] = tmp;
            }

            System.out.println(Arrays.toString(a));
        }

    }
}
