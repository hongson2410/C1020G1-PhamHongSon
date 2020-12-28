package demo.bai19_solid.single_responsibility_principle.wrong_design;


/**
 * Một class có quá nhiều chức năng sẽ trở nên cồng kềnh và phức tạp
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentInfoText(){
        return "Name: " + name + ". Age: " + age;
    }

    public String getStudentInfoHTML() {
        return "<span>" + name + " " + age + "</span>";
    }

    // Lưu trữ xuống database, xuống file
    public void saveToDatabase() {
        System.out.println("code lưu dữ liệu xuống database");
    }
    public void saveToFile() {
        System.out.println("code lưu dữ liệu xuống file");
    }

    /**
     * Class Student chứa quá nhiều chức năng: thông tin student, format hiển thị thông tin, lưu trữ thông tin
     * Khi code lớn dần, có nhiều chức năng hơn, class Student sẽ trở nên rất phức tạp, gây khó khăn cho việc bảo trì
     * phát triển ứng dụng. Chưa kể nếu thêm các class khác như Person, Teacher ...đoạn code hiển thị thông tin, lưu trữ
     * dữ liệu sẽ nằm rải rác ở tất cả các class làm cho vấn đề càng thêm phức tạp
     */
}
