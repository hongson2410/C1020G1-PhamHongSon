package demo.bai12_map_tree;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return o.getId() - this.id;
    }

//    @Override
//    public boolean equals(Object obj) {
//        Student otherStudent = (Student) obj;
//        if (this.id == otherStudent.getId() && this.name.equals(otherStudent.getName())) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return this.id;
//    }
}
