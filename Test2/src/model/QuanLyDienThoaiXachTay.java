package model;

import commons.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDienThoaiXachTay {
    private static List<DienThoaiXachTay> dienThoaiXachTays;
    private static Input input = new Input();

    public QuanLyDienThoaiXachTay() {
        dienThoaiXachTays = new ArrayList<>();
    }

    public void xemDanhSach() {
        if (!dienThoaiXachTays.isEmpty()) {
            for (DienThoaiXachTay dienthoai : dienThoaiXachTays) {
                System.out.println(dienthoai.showInfo());
            }
        } else {
            System.out.println("Không có điện thoại nào!");
        }
    }

    public void themDienThoai(DienThoaiXachTay dienThoaiXachTay) {
        dienThoaiXachTays.add(dienThoaiXachTay);
        writeFileXachTay(dienThoaiXachTay);
    }

    private static void writeFileXachTay(DienThoaiXachTay dienThoaiXachTay) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/DienThoaiXachTay.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
            );
            bufferedWriter.write(dienThoaiXachTay.toString());
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

    private static void writeFileXachTay(List<DienThoaiXachTay> dienThoaiXachTays) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/DienThoaiXachTay.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );
            for (DienThoaiXachTay dienthoai : dienThoaiXachTays) {
                bufferedWriter.write(dienthoai.toString());
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

    public static void readFileXachTay() {
        try {
            dienThoaiXachTays.clear();
            File file = new File("src/data/DienThoaiXachTay.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(Integer.parseInt(array[0]), array[1],
                        Double.parseDouble(array[2]), Integer.parseInt(array[3]), array[4], array[5], array[6]);
                dienThoaiXachTays.add(dienThoaiXachTay);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int idXachTay() {
        if (!dienThoaiXachTays.isEmpty()) {
            int temp = dienThoaiXachTays.get(0).getId();
            for (int index = 0; index < dienThoaiXachTays.size() - 1; index++) {
                if (dienThoaiXachTays.get(index).getId() < dienThoaiXachTays.get(index + 1).getId()) {
                    temp = dienThoaiXachTays.get(index + 1).getId();
                }
            }
            temp++;
            return temp;
        } else {
            return 1;
        }
    }

    public void xoaXachTay() {
        boolean check = false;
        for (DienThoaiXachTay dienthoai : dienThoaiXachTays) {
            System.out.println(dienthoai.showInfo());

        }
        do {
            try {
                System.out.println("Chọn id để xóa: ");
                int choose = input.inputInt();
                for (int i = 0; i < dienThoaiXachTays.size(); i++) {
                    if (choose == dienThoaiXachTays.get(i).getId()) {
                        check = true;
                        dienThoaiXachTays.remove(choose-1);
                    }
                }
                if (!check) {
                    System.err.println("Không tìm thấy!!");
                }
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        writeFileXachTay(dienThoaiXachTays);
    }
}
