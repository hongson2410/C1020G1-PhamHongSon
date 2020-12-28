package demo.bai19_solid.open_close_principle.wong_design;

/**
 * Nguyên lý open-close principle Có thể  mở rộng 1 class, nhưng không được sửa đổi bên trong class đó
 */
public class Geometry {
    private final double PI = 3.141592653589793;

    public double area(Object shape)
    {
        // Dùng if để kiểm tra hình và cho ra diện tích tương ứng
        if (shape instanceof Square) {
            Square s = (Square)shape;
            return s.getSide() * s.getSide();
        }
        else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle)shape;
            return r.getHeight() * r.getHeight();
        }
        else{
            Circle c = (Circle)shape;
            return PI * c.getRadius() * c.getRadius();
        }

    }
    /**
     * Dễ thấy nếu trong tương lại ta thêm nhiều class nữa hoặc muốn tính diện tích của nó ta lại phải
     * sửa class Geometry, viết thêm chừng đó hàm if nữa.
     * Sau khi chỉnh sửa, ta phải compile và deploy lại class Geometry.
     * Điều này là sai trong việc thiết kế ứng dụng
     */
}

