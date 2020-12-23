package demo.bai17_io_binary_file;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Long", "23/12/2020");
        Student student2 = new Student(2, "Nguyen Van A", "22/12/2020");

        try {
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
//                    new FileOutputStream("src/_17_io_binary_file/student_list.io")
//            );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("src/_17_io_binary_file/student_list.io")
            );

            objectOutputStream.writeObject(student1);
            objectOutputStream.writeObject(student2);
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("src/_17_io_binary_file/student_list.io")
            );

            Student student = null;
            do {
                student = (Student) objectInputStream.readObject();
                System.out.println(student);
            } while (student != null);
//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student);
//            Student studentA = (Student) objectInputStream.readObject();
//            System.out.println(studentA);
        } catch (EOFException e) {
            System.out.println("Da het file roi");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
