package bai4_class_object.bai_tap.quadratic_equation;
import bai4_class_object.bai_tap.quadratic_equation.QuadraticEquation;

import java.util.Scanner;
public class Ex_QuadraticEquation {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.println("Enter a: ");
        double a = input.nextDouble();
        System.out.println("Enter b: ");
        double b = input.nextDouble();
        System.out.println("Enter c: ");
        double c = input.nextDouble();

        QuadraticEquation quadraticEquation= new QuadraticEquation(a,b,c);

        System.out.print("the solution of the equation is: ");
        System.out.println(quadraticEquation.getCheck());
    }
}
