package demo.review_ep_kieu_du_lieu;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void showInfo(){
        System.out.println("Student:" + super.getName());
    }

    public void methodStudent(){
        System.out.println("day la method cua Student");
    }
    public void showInfo(String name){
        System.out.println("Name:" + name);
    }

//    public String showInfo(int age){
//        return "abg";
//    }

//    public void showInfo(){
//        System.out.println("Person: " + this.getName());
//    }

    public String showInfo(String name, int age){
        return "name " +name;
    }

    @Override
    protected void setName(String name) {
        System.out.println("name: "+name);
    }
}
