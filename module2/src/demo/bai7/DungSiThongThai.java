package demo.bai7;

public class DungSiThongThai extends DungSi implements IVuKhi,IGiap {
    public DungSiThongThai(String ten) {
        super(ten);
    }

    @Override
    public void nhiemVu(String nhiemVu) {
        System.out.println("Dung si [" + getTen() + "] dang lam nhiem vu: " + nhiemVu);
    }

    @Override
    public void getVuKi(String tenVuKhi) {
        System.out.println("Dung si ["+getTen()+"] duoc trang bi vu khi: "+tenVuKhi);
    }

    @Override
    public void getGiap(String tenGiap) {
        System.out.println("Dung si ["+getTen()+"] duoc trang bi giap: "+tenGiap);
    }
}
