package controllers.manager;

import commons.regular_expression.Regex;
import models.service.Villa;

import java.io.*;
import java.util.*;

public class VillaManager {
    private static List<Villa> listVilla;
    private Input input = new Input();

    public VillaManager() {
        listVilla = new ArrayList<>();
    }

    public void showVilla() {
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
        writeFileVilla(villa);
    }

    private static void writeFileVilla(Villa villa) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
            );
            bufferedWriter.write(villa.toString());
            bufferedWriter.newLine();
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

    private static void writeFileVilla(List<Villa> villaList) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Villa.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );
            for (Villa villa : villaList) {
                bufferedWriter.write(villa.toString());
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

    public static void readFileVilla() {
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
        Set<String> listNotDup = new TreeSet<>();
        for (Villa villa : listVilla) {
            listNotDup.add(villa.getNameService());
        }
        for (String villa : listNotDup) {
            System.out.println(villa);
        }
    }

    //ID tự tăng
    public String idVilla() {
        if (!listVilla.isEmpty()) {
            int temp = Integer.parseInt(listVilla.get(0).getIdService().substring(5, 9));
            String tempIdString = null;
            for (int index = 0; index < listVilla.size() - 1; index++) {
                if (Integer.parseInt(listVilla.get(index).getIdService().substring(5, 9)) < Integer.parseInt(listVilla.
                        get(index + 1).getIdService().substring(5, 9))) {
                    temp = Integer.parseInt(listVilla.get(index + 1).getIdService().substring(5, 9));
                }
            }
            temp++;
            if (temp > 1000) {
                tempIdString = "SVVL-" + temp;
            } else if (temp > 100) {
                tempIdString = "SVVL-0" + temp;
            } else if (temp > 10) {
                tempIdString = "SVVL-00" + temp;
            } else {
                tempIdString = "SVVL-000" + temp;
            }
            return tempIdString;
        } else {
            return "SVVL-0001";
        }
    }

    public static void containsVilla() {
        Scanner scanner = new Scanner(System.in);
        List<Villa> listTemp = new ArrayList<>();
        boolean check = false;
        int index = 1;
        do {
            System.out.println("Enter name Villa:");
            String name = scanner.nextLine();
            if (!listVilla.isEmpty()) {
                for (Villa villa : listVilla) {
                    if (villa.getNameService().contains(name)) {
                        listTemp.add(villa);
                        check = true;
                    }
                }
            }
            if (!check) {
                System.err.println("Villa not found!!");
            }
            if (!listTemp.isEmpty()) {
                for (Villa element : listTemp) {
                    System.out.println(index + "." + element.showInfo());
                    index++;
                }
                chooseVilla(listTemp);
            }
        } while (!check);
    }

    public static void chooseVilla(List<Villa> list) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                System.out.println("Choose Villa by index:");
                int choose = Integer.parseInt(scanner.nextLine());
                for (int index = 0; index < list.size(); index++) {
                    if (choose - 1 == index) {
                        System.out.println(list.get(index).showInfo());
                        check = true;
                    }
                }
                if (!check) {
                    System.out.println("Villa not found!!");
                }
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
    }

    public static void setVilla() {
        Scanner scanner = new Scanner(System.in);
        Regex regex = new Regex();
        boolean check = false;
        int index = 1;
        for (Villa villa : listVilla) {
            System.out.println(index + "." + villa.showInfo());
            index++;
        }
        do {
            System.out.println("Choose Villa you want set:");
            try {
                int choose = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < listVilla.size(); i++) {
                    if (choose - 1 == i) {
                        check = true;
                        do {
                            int choice = 0;
                            System.out.println("1. Set Name Service." + "\n" +
                                    "2. Set Area Using." + "\n" +
                                    "3. Set Price." + "\n" +
                                    "4. Set Number Tenants." + "\n" +
                                    "5. Set Rental Type." + "\n" +
                                    "6. Set Room Standard" + "\n" +
                                    "7. Set Room Furniture" + "\n" +
                                    "8. Set Pool Area." + "\n" +
                                    "9. Set Floors.");

                            System.out.println("Choice you want set:");
                            do {
                                try {
                                    check = true;
                                    choice = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    check = false;
                                    System.err.println(e.getMessage());
                                }
                            } while (!check);
                            switch (choice) {
                                case 1:
                                    listVilla.get(i).setNameService(regex.regexNameService());
                                    writeFileVilla(listVilla);
                                    if (!choose()) {
                                        setVilla();
                                    }
                                    break;
                                case 2:
                                    listVilla.get(i).setAreaUsing(regex.regexAreaUsing());
                                    writeFileVilla(listVilla);
                                    if (!choose()) {
                                        setVilla();
                                    }
                                    break;
                                default:
                                    System.out.println("Choice Not Found!!");
                                    break;
                            }
                        } while (true);
                    }
                }
                if (!check) {
                    System.err.println("Villa not found!!");
                }
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
    }

    private static boolean choose() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        boolean choose = false;
        do {
            try {
                System.out.println("1. Continue Set." + "\n" +
                        "2. Exit To List Villa.");
                int cc = Integer.parseInt(scanner.nextLine());
                if (cc == 1) {
                    check = true;
                    choose = true;
                } else if (cc == 2) {
                    check = true;
                    choose = false;
                }
                if (!check) {
                    System.err.println("choice not found!!");
                }
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        return choose;
    }

    public void removeVilla() {
        int index = 1;
        boolean check = false;
        for (Villa villa : listVilla) {
            System.out.println(index + "." + villa.showInfo());
            index++;
        }
        do {
            try {
                System.out.println("Choose Villa you want remove: ");
                int choose = input.inputInt();
                for (int i = 0; i < listVilla.size(); i++) {
                    if (choose - 1 == i) {
                        check = true;
                        listVilla.remove(i);
                    }
                }
                if (!check) {
                    System.err.println("Villa not found!!");
                }
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        writeFileVilla(listVilla);
    }
}
