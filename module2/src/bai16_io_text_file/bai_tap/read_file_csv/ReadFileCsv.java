package bai16_io_text_file.bai_tap.read_file_csv;

import java.io.*;

public class ReadFileCsv {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("src/bai16_io_text_file/bai_tap/read_file_csv/country.csv")));

            String line = null;
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                System.out.println(arr[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
