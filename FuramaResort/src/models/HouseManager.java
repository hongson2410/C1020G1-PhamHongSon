package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HouseManager {
    private static List<House>listHouse;

    public HouseManager() {
        listHouse=new ArrayList<>();
    }

    public void showHouse(){
        for (House house: listHouse){
            house.showInfo();
        }
    }

    public void addHouse(House house){
        listHouse.add(house);
    }

    public void writeFileHouse() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/models/House.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
            );

            for (House w : listHouse) {
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
