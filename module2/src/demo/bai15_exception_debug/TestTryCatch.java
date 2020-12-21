package demo.bai15_exception_debug;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Hay nhap a: ");
            int a = scanner.nextInt();

            System.out.println("Hay nhap b: ");
            int b = scanner.nextInt();

            System.out.println("Thuong la: " + a/b);

        } catch (InputMismatchException e) {
            System.err.println("Ban hay nhap so!");
        } catch (Exception e) {
            System.err.println("Xu ly all exception!");
        } finally {
            System.out.println("Finally, xu ly gi thi xu ly di!");
        }

        System.out.println("Finish programming.");
    }
}
