package bai1_introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");

        Scanner scanner= new Scanner(System.in);

        System.out.println("a: ");
        double a= scanner.nextDouble();

        System.out.println("b: ");
        double b= scanner.nextDouble();

        System.out.println("c: ");
        double c= scanner.nextDouble();

        if (a != 0) {
            double solution = (c-b)/a;

            System.out.println("Equation pass with x = \n" + solution);
        } else {
            if (b==c){
                System.out.println("The solution is all 'x'!");

            } else {
                System.out.println("Equation has no root!");

            }
        }
    }
}
