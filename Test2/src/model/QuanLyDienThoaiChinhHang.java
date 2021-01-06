package model;

import commons.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDienThoaiChinhHang {
    private static List<DienThoaiChinhHang> dienThoaiChinhHangs;
    private static Input input = new Input();

    public QuanLyDienThoaiChinhHang() {
        dienThoaiChinhHangs = new ArrayList<>();
    }

    public void xemDanhSach() {
        if (!dienThoaiChinhHangs.isEmpty()) {
            for (DienThoaiChinhHang dienthoai : dienThoaiChinhHangs) {
                System.out.println(dienthoai.showInfo());
            }
        } else {
            System.out.println("Không có điện thoại nào!");
        }
    }

    public void themDienThoai(DienThoaiChinhHang dienThoaiChinhHang) {
        dienThoaiChinhHangs.add(dienThoaiChinhHang);
        writeFileChinhHang(dienThoaiChinhHang);
    }

    private static void writeFileChinhHang(DienThoaiChinhHang dienThoaiChinhHang) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/DienThoaiChinhHang.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file, true)
            );
            bufferedWriter.write(dienThoaiChinhHang.toString());
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

    private static void writeFileChinhHang(List<DienThoaiChinhHang> dienThoaiChinhHang) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/DienThoaiChinhHang.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file)
            );
            for (DienThoaiChinhHang dienthoai : dienThoaiChinhHang) {
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

    public static void readFileChinhHang() {
        try {
            dienThoaiChinhHangs.clear();
            File file = new File("src/data/DienThoaiChinhHang.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(Integer.parseInt(array[0]), array[1],
                        Double.parseDouble(array[2]), Integer.parseInt(array[3]), array[4],
                        Integer.parseInt(array[5]), array[6]);
                dienThoaiChinhHangs.add(dienThoaiChinhHang);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int idChinhHang() {
        if (!dienThoaiChinhHangs.isEmpty()) {
            int temp = dienThoaiChinhHangs.get(0).getId();
            for (int index = 0; index < dienThoaiChinhHangs.size() - 1; index++) {
                if (dienThoaiChinhHangs.get(index).getId() < dienThoaiChinhHangs.get(index + 1).getId()) {
                    temp = dienThoaiChinhHangs.get(index + 1).getId();
                }
            }
            temp++;
            return temp;
        } else {
            return 1;
        }
    }

    public void xoaChinhHang() {
        boolean check = false;
        for (DienThoaiChinhHang dienthoai : dienThoaiChinhHangs) {
            System.out.println(dienthoai.showInfo());
        }
        do {
            try {
                System.out.println("Chọn id để xóa: ");
                int choose = input.inputInt();
                for (int i = 0; i < dienThoaiChinhHangs.size(); i++) {
                    if (choose == dienThoaiChinhHangs.get(i).getId()) {
                        check = true;
                        dienThoaiChinhHangs.remove(choose-1);
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
        writeFileChinhHang(dienThoaiChinhHangs);
    }

    public void timKiem(){

    }
}