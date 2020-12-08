package demo.bai7;

public class NhiemVu {
    public static void main(String[] args) {
        DungSiDepTrai dsLong = new DungSiDepTrai("Long");
        dsLong.nhiemVu("diet soi");

        DungSiThongThai dsThongThai = new DungSiThongThai("Hung");
        dsThongThai.getVuKi("Kiem Lua");
        dsThongThai.getGiap("giap thien than");
        dsThongThai.nhiemVu("diet rong");

    }
}
