package demo.bai16_io_text_file;

import java.io.*;
import java.util.Scanner;

public class TestReadWriteFile {

    public static void main(String[] args) {

//        File file = new File("src/_16_io_text_file/test.c10");
//        file.createNewFile()
        try {
//            File file = new File("src/demo/bai16_io_text_file");
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("src/_16_io_text_file/test.c10")));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(new File("src/_16_io_text_file/test.c10"), true)
            );

            bufferedWriter.write("Le Van C,Female");
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
