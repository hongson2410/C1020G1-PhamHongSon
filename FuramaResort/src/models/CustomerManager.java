package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static List<Customer> listCustomer;
    private static List<String> list = new ArrayList<>();

    public CustomerManager() {
        listCustomer = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        listCustomer.add(customer);
        writeFile();
    }

    public void showInformationCustomers() {
        readFile();
        for (String customer : list) {
            System.out.println(customer);
        }
    }

    private static void writeFile() {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Customer.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Customer customer : listCustomer) {
                bufferedWriter.write(customer.showInfo());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFile() {
        list.clear();
        BufferedReader bufferedReader = null;
        try {
            File file = new File("src/data/Customer.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
