package demo.bai15_exception_debug;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestCheckedException {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("D:/abc.txt");


        } catch (FileNotFoundException e) {
            System.out.println();
        }
    }
}
