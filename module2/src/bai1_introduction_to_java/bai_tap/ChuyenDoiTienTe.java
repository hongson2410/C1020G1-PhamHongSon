package bai1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int rate=23000;
        System.out.println("Enter USD");
        int usd=input.nextInt();

        System.out.println("VND is: "+(usd*rate));
    }
}
