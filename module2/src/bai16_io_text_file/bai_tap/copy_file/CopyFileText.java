package bai16_io_text_file.bai_tap.copy_file;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    List<String> list = new ArrayList<>();

    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    public void writeFileText(String filePath) {
        BufferedWriter bufferedWriter= null;
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (String w : list) {
                bufferedWriter.write(w);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        } finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        copyFileText.readFileText("src/bai16_io_text_file/bai_tap/folder_a/text_a.csv");
        copyFileText.writeFileText("src/bai16_io_text_file/bai_tap/folder_b/text_b.csv");
    }
}
