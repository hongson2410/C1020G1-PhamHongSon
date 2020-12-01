package bai2_array_loop.thuc_hanh;

import java.util.Scanner;

public class LaiSuatNganHang {
    public static void main(String[] args) {
        double money =1.0;
        int month= 1;
        double intersetRate =1.0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter investment amount:");
        money= input.nextDouble();

        System.out.println("Enter number of months: ");
        month = input.nextInt();

        System.out.println("Enter annual interest rate in percentage: ");
        intersetRate = input.nextDouble();

        double totalInterset = 0;
        for (int i=0; i<month;i++){
            totalInterset += money*((intersetRate/100)/12);
        }

        System.out.println("Total of interset: " + totalInterset);
    }
}
