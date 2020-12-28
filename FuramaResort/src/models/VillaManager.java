package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VillaManager {
    private static List<Villa> listVilla;

    public VillaManager() {
        listVilla=new ArrayList<>();
    }

    public void showVilla() {
        for (Villa villa : listVilla) {
            villa.showInfo();
        }
    }

    public void addVilla(Villa villa){
        listVilla.add(villa);
    }

    public void writeFileVilla() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/models/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
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
}
