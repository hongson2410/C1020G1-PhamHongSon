package controllers.manager;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    boolean check = false;

    public int inputInt() {
        int input = 0;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (NumberFormatException e) {
                check = false;
                System.err.println(e.getMessage());
                System.err.println("replay input:");
            }
        } while (!check);
        return input;
    }

    public double inputDou() {
        double input = 0.0;
        do {
            try {
                input = Double.parseDouble(scanner.nextLine());
                check = true;
            } catch (NumberFormatException e) {
                check = false;
                System.err.println(e.getMessage());
            }
        } while (!check);
        return input;
    }

    public String inputString() {
        return scanner.nextLine();
    }
}
