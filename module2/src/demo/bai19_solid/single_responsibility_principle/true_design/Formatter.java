package demo.bai19_solid.single_responsibility_principle.true_design;

/**
 * Class Formatter nhận nhiệm vụ hiển thị cho student
 */
public class Formatter {
    public String formatStudentText(Student std) {
        return "Name: " + std.getName() + ". Age: " + std.getAge();
    }
    public String formatStudentHtml(Student std) {
        return "<span>" + std.getName() + " " + std.getAge() + "</span>";
    }
}
