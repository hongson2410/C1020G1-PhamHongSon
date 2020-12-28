package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static List<Room>listRoom;
    private static List<String> list= new ArrayList<>();

    public RoomManager() {
        listRoom=new ArrayList<>();
    }

    public void showRoom(){
        readFileRoom();
        for (String room: list){
            System.out.println(room);
        }
    }

    public void addRoom(Room room){
        listRoom.add(room);
        writeFileRoom();
    }

    private static void writeFileRoom() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/models/Room.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
            );

            for (Room w : listRoom) {
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

    private static void readFileRoom(){
        try {
            list.clear();
            File file= new File("src/models/Room.csv");
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
            String line= null;
            while ((line= bufferedReader.readLine())!= null){
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
