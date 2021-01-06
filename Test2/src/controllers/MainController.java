package controllers;

import commons.Input;
import commons.Regex;
import model.DienThoaiChinhHang;
import model.DienThoaiXachTay;
import model.QuanLyDienThoaiChinhHang;
import model.QuanLyDienThoaiXachTay;

public class MainController {
    private static Input input = new Input();
    private static QuanLyDienThoaiXachTay quanLyDienThoaiXachTay = new QuanLyDienThoaiXachTay();
    private static QuanLyDienThoaiChinhHang quanLyDienThoaiChinhHang = new QuanLyDienThoaiChinhHang();
    private static Regex regex = new Regex();

    static void menu() {
        int choice;
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục):" + "\n" +
                    "1. Thêm mới." + "\n" +
                    "2. Xóa." + "\n" +
                    "3. Xem danh sách điện thoại." + "\n" +
                    "4. Tìm kiếm." + "\n" +
                    "5. Thoát." + "\n" +
                    "Chọn chức năng");
            choice = input.inputInt();

            switch (choice) {
                case 1:
                    themMoi();
                    break;
                case 2:
                    xoa();
                    break;
                case 3:
                    xemDanhSachDienThoai();
                    break;
                case 4:
                    timKiem();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Choice not found!!!");
                    break;
            }
        } while (choice != 5);
    }

    static void themMoi() {
        int choice;
        System.out.println("1. Thêm điện thoại chính hãng." + "\n" +
                "2. Thêm điện thoại xách tay." + "\n" +
                "3. Trở về Menu." + "\n" +
                "4. Exit.");
        choice = input.inputInt();
        switch (choice) {
            case 1:
                themDtChinhHang();
                break;
            case 2:
                themDtXachTay();
                break;
            case 3:
                menu();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Lựa chọn không có trong trình đơn.");
        }
    }

    static void xoa() {
        int choice;
        System.out.println("1. Xóa điện thoại chính hãng." + "\n" +
                "2. Xóa điện thoại xách tay." + "\n" +
                "3. Trở về Menu." + "\n" +
                "4. Exit.");
        choice = input.inputInt();
        switch (choice) {
            case 1:
                quanLyDienThoaiChinhHang.xoaChinhHang();
                break;
            case 2:
                quanLyDienThoaiXachTay.xoaXachTay();
                break;
            case 3:
                menu();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Lựa chọn không có trong trình đơn.");
        }
    }

    static void xemDanhSachDienThoai() {
        int choice;
        System.out.println("1. Danh sách điện thoai chính hãng." + "\n" +
                "2. Danh sách điện thoại xách tay." + "\n" +
                "3. Trở về Menu" + "\n" +
                "4. Exit.");
        choice = input.inputInt();
        switch (choice) {
            case 1:
                quanLyDienThoaiChinhHang.xemDanhSach();
                break;
            case 2:
                quanLyDienThoaiXachTay.xemDanhSach();
                break;
            case 3:
                menu();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("lựa chọn ko có trong trình đơn");
        }
    }

    static void timKiem() {
        int choice;
        System.out.println("1. Tìm kiếm điện thoai chính hãng." + "\n" +
                "2. Tìm kiếm điện thoại xách tay." + "\n" +
                "3. Trở về Menu" + "\n" +
                "4. Exit.");
        choice = input.inputInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                menu();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("lựa chọn ko có trong trình đơn");
        }
    }

    private static void themDtChinhHang() {
        int id = quanLyDienThoaiChinhHang.idChinhHang();
        System.out.println("Tên Điện Thoại:");
        String tenDienThoai = input.inputString();
        double giaBan = regex.giaBan();
        int soLuong = regex.soLuong();
        System.out.println("Nhà Sản Xuất:");
        String nhaSanXuat = input.inputString();
        int baoHanh = regex.thoiGianBaoHanh();
        String phamVi = regex.phamViBaoHanh();

        quanLyDienThoaiChinhHang.themDienThoai(new DienThoaiChinhHang(id, tenDienThoai, giaBan, soLuong, nhaSanXuat, baoHanh, phamVi));
    }

    private static void themDtXachTay() {
        int id = quanLyDienThoaiXachTay.idXachTay();
        System.out.println("Tên Điện Thoại:");
        String tenDienThoai = input.inputString();
        double giaBan = regex.giaBan();
        int soLuong = regex.soLuong();
        System.out.println("Nhà Sản Xuất:");
        String nhaSanXuat = input.inputString();
        String quocGia = regex.quocGia();
        String trangThai = regex.trangThai();

        quanLyDienThoaiXachTay.themDienThoai(new DienThoaiXachTay(id, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGia, trangThai));
    }

    public static void main(String[] args) {
        QuanLyDienThoaiChinhHang.readFileChinhHang();
        QuanLyDienThoaiXachTay.readFileXachTay();
        menu();
    }
}
