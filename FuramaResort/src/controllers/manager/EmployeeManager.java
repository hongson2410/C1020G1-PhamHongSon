package controllers.manager;

import models.person.Employee;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeManager {
    private static Map<String, Employee> myMap;

    public EmployeeManager() {
        myMap = new TreeMap<>();
    }

    public void showEmployee() {
        for (String key : myMap.keySet()) {
            System.out.println(myMap.get(key).toString());
        }
    }

    public static void readFile() {
        BufferedReader bufferedReader = null;
        try {
            myMap.clear();
            File file = new File("src/data/Employee.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                Employee employee = new Employee(array[1], array[2], Integer.parseInt(array[3]), array[4]);
                myMap.put(array[0], employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
