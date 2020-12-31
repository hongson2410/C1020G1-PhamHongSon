package controllers.manager;

import models.service.House;

import java.io.*;
import java.util.*;

public class HouseManager {
    private static List<House> listHouse;

    public HouseManager() {
        listHouse = new ArrayList<>();
    }

    public void showHouse() {
        if (!listHouse.isEmpty()) {
            for (House house : listHouse) {
                System.out.println(house.showInfo());
            }
        } else {
            System.out.println("Do Not House Has In List");
        }
    }

    public void addHouse(House house) {
        listHouse.add(house);
        writeFileHouse();
    }

    public static void writeFileHouse() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/House.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );

            for (House w : listHouse) {
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

    public static void readFileHouse() {
        try {
            listHouse.clear();
            File file = new File("src/data/House.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                House house = new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                        Integer.parseInt(array[4]), array[5], array[6], array[7], Integer.parseInt(array[8]));
                listHouse.add(house);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public House findHouseCheck(String idService) {
        House house_1 = null;
        boolean check = false;
        for (House house : listHouse) {
            if (idService.equals(house.getIdService())) {
                check = true;
                house_1 = house;
            }
        }
        if (!check) {
            throw new NullPointerException("Can't find it, just re-enter");
        }
        return house_1;
    }

    public House findHouse() {
        Scanner scanner = new Scanner(System.in);
        House house = null;
        boolean check = false;
        do {
            check = true;
            System.out.println("Selection House By Id: ");
            String serviceId = scanner.nextLine();
            try {
                house = findHouseCheck(serviceId);
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        return house;
    }

    public void showHouseNotDup() {
        Set<String> listNotDup = new TreeSet<>();
        for (House house : listHouse) {
            listNotDup.add(house.getNameService());
        }
        for (String house : listNotDup) {
            System.out.println(house);
        }
    }

}
