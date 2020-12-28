package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VillaManager {
    private static List<Villa> listVilla;
    private static List<String> list = new ArrayList<>();
    public VillaManager() {
        listVilla = new ArrayList<>();
    }

    public void showVilla() {
        readFileVilla();
        for (String villa : list) {
            System.out.println(villa);
        }
    }

    public void addVilla(Villa villa) {
        listVilla.add(villa);
        writeFileVilla();
    }

    private static void writeFileVilla() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );

            for (Villa w : listVilla) {
                bufferedWriter.write(w.showInfo());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFileVilla() {
        try {
            list.clear();
            File file = new File("src/data/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
