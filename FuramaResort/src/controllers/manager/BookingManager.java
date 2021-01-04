package controllers.manager;

import models.service.Booking;

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
        writeFile(booking);
    }

    private static void writeFile(Booking booking){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src/data/Booking.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedWriter = new BufferedWriter(
                    new FileWriter(file,true)
            );
                bufferedWriter.write("Booking: ");
                bufferedWriter.newLine();
                bufferedWriter.write(booking.getCustomer().showInfo());
                bufferedWriter.newLine();
                bufferedWriter.write(booking.getServices().showInfo());
                bufferedWriter.newLine();
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
}
