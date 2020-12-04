package demo.bai5;

public class Demo {
    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap_1(Student a, Student b){
        Student temp = a;
        a = b;
        b = temp;
    }

    public static void swap_2(Student a, Student b){
        String tempName = a.getName();
        a.setName(b.getName());
        b.setName(tempName);
    }


    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        swap(1,2);
        System.out.println(a);
        System.out.println(b);

        Student student_1 = new Student("Long", 8);
        Student student_2 = new Student("Thanh", 9);
        swap_1(student_1, student_2);
        System.out.println(student_1.getName()); //Long
        System.out.println(student_2.getName()); //Thanh

        swap_2(student_1, student_2);
        System.out.println(student_1.getName() +" " + student_1.getAge()); //Thanh 8
        System.out.println(student_2.getName() +" " + student_2.getAge()); //Long 9

    }
}
