package demo.review_ep_kieu_du_lieu;

public class Demo1 {
    public static void main(String[] args) {
//        byte b = 127;
//        short s = b;
//        System.out.println(++s); //128
//
//        byte z = (byte) s;
//        System.out.println(z); //-128
//
//        double d = 9.9;
//        int y = (int) d;
//        System.out.println(y);

        Person person = new Human("A", 20);
        Student student = new Student("B", 22);
        Human human = new Human("C", 55);

//        person = student;
        //student = (Student) person;
        human = (Human) person;

        System.out.println(person.getName());
    }
}
