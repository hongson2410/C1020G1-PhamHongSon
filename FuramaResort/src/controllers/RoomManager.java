package controllers;

import models.Room;
import models.Villa;

import java.io.*;
import java.util.*;

public class RoomManager {
    private static List<Room> listRoom;

    public RoomManager() {
        listRoom = new ArrayList<>();
    }

    public void showRoom() {
        readFileRoom();
        if (!listRoom.isEmpty()) {
            for (Room room : listRoom) {
                System.out.println(room.showInfo());
            }
        } else {
            System.out.println("Do Not Has Room In List");
        }
    }

    public void addRoom(Room room) {
        listRoom.add(room);
        writeFileRoom();
    }

    private static void writeFileRoom() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Room.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );

            for (Room w : listRoom) {
                bufferedWriter.write(w.toString());
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

    private static void readFileRoom() {
        try {
            listRoom.clear();
            File file = new File("src/data/Room.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                Room room = new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                        Integer.parseInt(array[4]), array[5], array[6]);
                listRoom.add(room);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room findRoomCheck(String serviceId) {
        readFileRoom();
        Room room_1 = null;
        boolean check = false;
        for (Room room : listRoom) {
            if (serviceId.equals(room.getIdService())) {
                check = true;
                room_1 = room;
            }
        }
        if (!check) {
            throw new NullPointerException("Can't find it, just re-enter");
        }
        return room_1;
    }

    public Room findRoom() {
        Scanner scanner = new Scanner(System.in);
        Room room = null;
        boolean check = false;
        do {
            check = true;
            System.out.println("Selection Room By Id: ");
            String serviceId = scanner.nextLine();
            try {
                room = findRoomCheck(serviceId);
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        return room;
    }

    public void showRoomNotDup() {
        readFileRoom();
        Set<String> listNotDup = new TreeSet<>();
        for (Room room : listRoom) {
            listNotDup.add(room.getNameService());
        }
        for (String room : listNotDup) {
            System.out.println(room);
        }
    }
}
