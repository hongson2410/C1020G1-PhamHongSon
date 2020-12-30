package controllers;

import models.Customer;
import models.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    public void manipulationCustomer() {
        readFile();
        int index = 1;
        if (!listCustomer.isEmpty()) {
            for (Customer customer : listCustomer) {
                System.out.println(index + ". " + customer.showInfo());
                index++;
            }
        } else {
            System.out.println("Do not has customer in list");
        }
    }

    public Customer findCustomerCheck(String customerId) throws NullPointerException {
        Customer customer_1 = null;
        boolean check = false;
        for (Customer customer : listCustomer) {
            if (customerId.equals(customer.getIdCard())) {
                check = true;
                customer_1 = customer;
            }
        }
        if (!check) {
            throw new NullPointerException("Can't find it, just re-enter");
        }
        return customer_1;
    }

    public Customer findCustomer() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        boolean check;
        do {
            System.out.println("Selection Customer By Id: ");
            String customerId = scanner.nextLine();
            try {
                check = true;
                customer = findCustomerCheck(customerId);
            } catch (NullPointerException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        return customer;
    }
}
