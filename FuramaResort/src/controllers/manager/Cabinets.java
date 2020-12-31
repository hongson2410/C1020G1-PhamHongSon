package controllers.manager;

import models.person.Employee;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Cabinets {
    private  static Stack<Employee> myStack;

    public Cabinets() {
        myStack=new Stack<>();
    }

    public void showStackEmployee(){
        Scanner scanner= new Scanner(System.in);
        boolean check= false;
        do {
            System.out.println("Enter Id Employee: ");
            String id = scanner.nextLine();
            for (Employee employee : myStack) {
                if (id.equals(employee.getId())) {
                    check=true;
                    System.out.println(employee.toString());
                    System.out.println();
                }
            }
            if (!check){
                System.err.println("Can't find it, just re-enter");
            }
        }while (!check);
    }

    public static void readFile(){
        File file= new File("src/data/Employee.csv");
        BufferedReader bufferedReader=null;
        try {
            myStack.clear();
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            bufferedReader= new BufferedReader(new FileReader(file));
            String line=null;
            while ((line = bufferedReader.readLine()) != null) {
                String [] array= line.split(",");
                myStack.push(new Employee(array[1],array[2],Integer.parseInt(array[3]),array[4]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
