package models;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

public class Regex {
    Scanner scanner = new Scanner(System.in);
    final double AREA_REGEX = 30;
    final String TYPE_REGEX = "[A-Z][a-z_0-9]+";

    public String regexIdService() {
        final String ID_SERVICE_REGEX = "(SV)(VL|HO|RO)[-]\\d{4}";
        String idService;
        do {
            System.out.println("Id Service: ");
            idService = scanner.nextLine();
            if (!idService.matches(ID_SERVICE_REGEX)) {
                System.out.println("Wrong Input Format!!!");
            }
        } while (!idService.matches(ID_SERVICE_REGEX));
        return idService;
    }

    public String regexNameService() {
        String nameService;
        do {
            System.out.println("Name Service: ");
            nameService = scanner.nextLine();
            if (!nameService.matches(TYPE_REGEX)) {
                System.out.println("Wrong Input Format!!!");
            }
        } while (!nameService.matches(TYPE_REGEX));
        return nameService;
    }

    public double regexAreaUsing() {
        double areaUsing;
        do {
            System.out.println("Area Using: ");
            areaUsing = Double.parseDouble(scanner.nextLine());
            if (areaUsing <= AREA_REGEX) {
                System.out.println("The Area Must Be Greater Than 30!!!");
            }
        } while (areaUsing <= AREA_REGEX);
        return areaUsing;
    }

    public double regexPoolArea() {
        double poolArea;
        do {
            System.out.println("Pool Area: ");
            poolArea = Double.parseDouble(scanner.nextLine());
            if (poolArea <= AREA_REGEX) {
                System.out.println("The Area Must Be Greater Than 30!!!");
            }
        } while (poolArea <= AREA_REGEX);
        return poolArea;
    }

    public int regexPrice() {
        int price;
        do {
            System.out.println("Price: ");
            price= Integer.parseInt(scanner.nextLine());
            if (price<=0){
                System.out.println("The Price Must Be A Positive Integer!!!");
            }
        } while (price<=0);
        return price;
    }

    public int regexNumberTenants() {
        int numberTenants;
        do {
            System.out.println("Number Tenants: ");
            numberTenants= Integer.parseInt(scanner.nextLine());
            if (numberTenants<=0 | numberTenants>=20){
                System.out.println("The maximum number of people must be> 0 and less than <20!!");
            }
        }while (numberTenants<=0 | numberTenants>=20);
        return numberTenants;
    }

    public String regexFreeService() {
        final String FREE_SERVICE_REGEX = "(massage|karaoke|food|drink|car)";
        String freeService;
        do {
            System.out.println("Free Service: ");
            freeService=scanner.nextLine();
            if (!freeService.matches(FREE_SERVICE_REGEX)){
                System.out.println("Wrong Input Format!!!");
            }
        } while (!freeService.matches(FREE_SERVICE_REGEX));
        return freeService;
    }

    public int regexFloors() {
        int floors;
        do {
            System.out.println("Floor: ");
            floors= Integer.parseInt(scanner.nextLine());
            if (floors<=0){
                System.out.println("The Floor Must Be A Positive Integer!!!");
            }
        } while (floors<=0);
        return floors;
    }

    public String  regexRentalType() {
        String rentalType;
        do {
            System.out.println("Rental Type: ");
            rentalType = scanner.nextLine();
            if (!rentalType.matches(TYPE_REGEX)) {
                System.out.println("Wrong Input Format!!!");
            }
        } while (!rentalType.matches(TYPE_REGEX));
        return rentalType;
    }

    public String regexRoomStandard() {
        String roomStandard;
        do {
            System.out.println("Room Standard: ");
            roomStandard = scanner.nextLine();
            if (!roomStandard.matches(TYPE_REGEX)) {
                System.out.println("Wrong Input Format!!!");
            }
        } while (!roomStandard.matches(TYPE_REGEX));
        return roomStandard;
    }

    public String regexRoomFurniture(){
        final String ROOM_FURNITURE_REGEX="(fully|not fully)";
        String roomFurniture;
        do {
            System.out.println("Room Furniture: ");
            roomFurniture=scanner.nextLine();
            if (!roomFurniture.matches(ROOM_FURNITURE_REGEX)){
                System.out.println("fully or not fully furnished!!!");
            }
        } while (!roomFurniture.matches(ROOM_FURNITURE_REGEX));
        return roomFurniture;
    }
    public void regexBirthday() {

    }
}
