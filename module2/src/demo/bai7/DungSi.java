package demo.bai7;

public abstract class DungSi {
    private String ten;

    public DungSi(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public abstract void nhiemVu(String nhiemVu);
}
