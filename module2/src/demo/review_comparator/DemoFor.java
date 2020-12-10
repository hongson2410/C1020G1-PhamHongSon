package demo.review_comparator;

public class DemoFor {
    public static void main(String[] args) {
//        String a = "9";
//        int b = 5;
//        System.out.println(Integer.parseInt(a) + b); //95
//        System.out.println(b + a); //59

        for_1:
        for (int i = 0; i < 5; i++) {
            for_2:
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break for_2;
                }
                System.out.print("a" + i + j + "\t");
            }
            System.out.println();
        }
    }
}
