package demo.bai15_exception_debug.user_exception;

import java.util.Scanner;

public class TestUserException {

    public static void checkEvenNumber(int number) throws CheckedEvenNumberException {

        if (number % 2 != 0) {
            throw new CheckedEvenNumberException();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");
        int a  = scanner.nextInt();

        try {
            checkEvenNumber(a);
        } catch (CheckedEvenNumberException e) {
            e.printStackTrace();
        }
    }
}
