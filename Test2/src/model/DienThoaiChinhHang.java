package model;

public class DienThoaiChinhHang extends DienThoai {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat,
                              int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return super.toString() + ',' +
                thoiGianBaoHanh + ',' +
                phamViBaoHanh;
    }

    @Override
    public String showInfo() {
        return "DienThoaiChinhHang{" + super.showInfo() +
                "thoiGianBaoHanh=" + thoiGianBaoHanh +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                '}';
    }
}
