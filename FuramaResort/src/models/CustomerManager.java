package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerManager {
    private static List<Customer> listCustomer;

    public CustomerManager() {
        listCustomer = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        listCustomer.add(customer);
        writeFile();
    }

    public void showInformationCustomers() {
        readFile();
        SortCustomer sortCustomer = new SortCustomer();
        Collections.sort(listCustomer, sortCustomer);
        for (Customer customer : listCustomer) {
            System.out.println(customer.showInfo());
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
                bufferedWriter.write(customer.toString());
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
        listCustomer.clear();
        BufferedReader bufferedReader = null;
        try {
            File file = new File("src/data/Customer.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
                listCustomer.add(customer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
