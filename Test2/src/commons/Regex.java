package commons;

import com.sun.org.apache.regexp.internal.RE;

public class Regex {
    private static Input input = new Input();
    private static boolean status = true;

    public double giaBan() {
        double price = 0;
        do {
            System.out.println("Giá bán: ");
            price = input.inputDou();
            if (price <= 0) {
                System.err.println("Phải là số dương!!!");
            }
        } while (price <= 0);
        return price;
    }

    public int soLuong() {
        int soLuong = 0;
        do {
            System.out.println("Số lượng: ");
            soLuong = input.inputInt();
            if (soLuong <= 0) {
                System.err.println("Phải là số dương!!!");
            }
        } while (soLuong <= 0);
        return soLuong;
    }

    public int thoiGianBaoHanh() {
        int date;
        do {
            System.out.println("Thời gian bảo hành: ");
            date = input.inputInt();
            if (date <= 0 | date >= 730) {
                status = false;
                System.err.println("Là số dương, không quá 720 ngày.");
            }
        } while (!status);
        return date;
    }

    public String phamViBaoHanh() {
        final String REGEX = "(Toan Quoc|Quoc Te)";
        String phamVi;
        do {
            System.out.println("Phạm vi bảo hành: ");
            phamVi = input.inputString();
            if (!phamVi.matches(REGEX)) {
                System.err.println("Toan Quoc hoặc Quoc Te!!!");
            }
        } while (!phamVi.matches(REGEX));
        return phamVi;
    }

    public String quocGia() {
        final String REGEX = "(Viet Nam)";
        String quocGia;
        do {
            System.out.println("Quốc Gia: ");
            quocGia = input.inputString();
            if (quocGia.matches(REGEX)) {
                status = false;
                System.err.println("Không được là Việt Nam");
            }else {
                status=true;
            }
        } while (!status);
        return quocGia;
    }

    public String trangThai() {
        final String REGEX = "(Da sua chua|Chua sua chua)";
        String trangThai;
        do {
            System.out.println("Trạng thái:");
            trangThai = input.inputString();
            if (!trangThai.matches(REGEX)) {
                System.err.println("Da sua chua hoặc Chua sua chua!!!");
            }
        } while (!trangThai.matches(REGEX));
        return trangThai;
    }
}
