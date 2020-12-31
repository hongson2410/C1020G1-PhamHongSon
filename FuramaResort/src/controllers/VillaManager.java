package controllers;

import models.Villa;

import java.io.*;
import java.util.*;

public class VillaManager {
    private static List<Villa> listVilla;

    public VillaManager() {
        listVilla = new ArrayList<>();
    }

    public void showVilla() {
        readFileVilla();
        if (!listVilla.isEmpty()) {
            for (Villa villa : listVilla) {
                System.out.println(villa.showInfo());
            }
        } else {
            System.out.println("Do not has Villa in List");
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

    private static void readFileVilla() {
        try {
            listVilla.clear();
            File file = new File("src/data/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                Villa villa = new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]),
                        Integer.parseInt(array[4]), array[5], array[6], array[7], Double.parseDouble(array[8]), Integer.parseInt(array[9]));
                listVilla.add(villa);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Villa findVillaCheck(String idService) {
        readFileVilla();
        Villa villa_1 = null;
        boolean check = false;
        for (Villa villa : listVilla) {
            if (idService.equals(villa.getIdService())) {
                check = true;
                villa_1 = villa;
            }
        }
        if (!check) {
            throw new NullPointerException("Can't find it, just re-enter");
        }
        return villa_1;
    }

    public Villa findVilla() {
        Scanner scanner = new Scanner(System.in);
        Villa villa = null;
        boolean check = false;
        do {
            check = true;
            System.out.println("Selection Villa By Id: ");
            String serviceId = scanner.nextLine();
            try {
                villa = findVillaCheck(serviceId);
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        return villa;
    }

    public void showVillaNotDup() {
        readFileVilla();
        Set<String> listNotDup = new TreeSet<>();
        for (Villa villa : listVilla) {
            listNotDup.add(villa.getNameService());
        }
        for (String villa : listNotDup) {
            System.out.println(villa);
        }
    }
}
