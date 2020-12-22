package bai15_exception_debug.bai_tap.illegaltriangleexception;

import java.util.Scanner;

public class TriangleExample {

    public static void check(int a, int b, int c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException();
        }
        if ((a + b > c) && (a + c > b) && (c + b > a)) {
            System.out.println("Tam giác có độ dài 3 cạnh là: ");
            System.out.println("Cạnh thứ nhất: " + a);
            System.out.println("Cạnh thứ hai : " + b);
            System.out.println("Cạnh thứ ba  : " + c);
        } else {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại!!!");
        }
    }

    private static void test(int a, int b, int c) {
        try {
            check(a, b, c);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish programing.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập a: ");
        int a = scanner.nextInt();
        System.out.println("Hãy nhập b: ");
        int b = scanner.nextInt();
        System.out.println("Hãy nhập c: ");
        int c = scanner.nextInt();
        test(a, b, c);
    }
}
