package demo.bai5;

public class Student {
    public String name;
    private int age;

    public Student() {
//        this("no name", 18);
        this("no name");
        System.out.println("da goi vao day");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }


//    public void Student(String str){
//        System.out.println(str);
//    }

    //alt + insert
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

//    public static void main(String[] args) {
//        Student student_1 = new Student();
//        student_1.name = "Long";
//
//        System.out.println(student_1.name);
//    }

}
