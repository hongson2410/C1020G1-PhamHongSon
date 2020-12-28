package demo.bai19_solid.open_close_principle.true_design;

/**
 * ta thêm interface IShape và chuyển phần tính chu vi, diện tích vào cho các hình
 * như vậy khi thêm 1 lớp mới ta chỉ cần thực thi trong lớp đó mà không ảnh hưởng
 * đến các lớp khác
 */
public interface IShape {
    double area();
}
