package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static List<Room>listRoom;

    public RoomManager() {
        listRoom=new ArrayList<>();
    }

    public void showRoom(){
        for (Room room: listRoom){
            room.showInfo();
        }
    }

    public void addRoom(Room room){
        listRoom.add(room);
    }

    public void writeFileRoom() {
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
}
