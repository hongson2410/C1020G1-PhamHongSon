package demo.bai19_solid.single_responsibility_principle.true_design;

/**
 * Class Store nhận nhiệm vụ lưu trữ dữ liệu
 */
public class Store {
    public void saveToDatabase(Student std) {
        System.out.println("Code lưu trữ dữ liệu vào database");
    }
    public void saveToFile(Student std) {
        System.out.println("Code lưu trữ dữ liệu vào File");
    }
}
