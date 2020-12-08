package demo.bai6;

public class Student extends Person {

    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void showInfo(){
        System.out.println("Name:" + super.getName());
    }

    public void showInfo(String name){
        System.out.println("Name:" + name);
    }

    public String showInfo(String name, int age){
        return "name " +name;
    }

    @Override
    protected void setName(String name) {
        System.out.println("name: "+name);
    }
}
