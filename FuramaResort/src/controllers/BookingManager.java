package controllers;

import models.Booking;
import models.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private static List<Booking> listBooking;

    public BookingManager() {
        listBooking= new ArrayList<>();
    }

    public void addBooking(Booking booking){
        listBooking.add(booking);
        writeFile();
    }

    private static void writeFile(){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Booking.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file,true)
            );

            for (Booking booking : listBooking) {
                bufferedWriter.write("Booking: ");
                bufferedWriter.newLine();
                bufferedWriter.write(booking.getCustomer().showInfo());
                bufferedWriter.newLine();
                bufferedWriter.write(booking.getServices().showInfo());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

//    public void readFile(){
//        listBooking.clear();
//        BufferedReader bufferedReader = null;
//        try {
//            File file = new File("src/data/Booking.csv");
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//            bufferedReader = new BufferedReader(new FileReader(file));
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] array = line.split(",");
//                Customer customer = new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7],array[8]);
//                listBooking.add(customer);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
