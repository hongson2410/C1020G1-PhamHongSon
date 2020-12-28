package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HouseManager {
    private static List<House>listHouse;
    private static List<String> list= new ArrayList<>();

    public HouseManager() {
        listHouse=new ArrayList<>();
    }

    public void showHouse(){
        readFileHouse();
        for (String house: list){
            System.out.println(house);
        }
    }

    public void addHouse(House house){
        listHouse.add(house);
        writeFileHouse();
    }

    public static void writeFileHouse() {
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

    private static void readFileHouse(){
        try {
            list.clear();
            File file= new File("src/models/House.csv");
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
            String line= null;
            while ((line=bufferedReader.readLine())!=null){
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
