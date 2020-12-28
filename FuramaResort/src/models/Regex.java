package models;

import commons.BirthdayException;

import java.util.Date;
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
                System.err.println("Wrong Input Format!!!");
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
                System.err.println("Wrong Input Format!!!");
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
                System.err.println("The Area Must Be Greater Than 30!!!");
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
                System.err.println("The Area Must Be Greater Than 30!!!");
            }
        } while (poolArea <= AREA_REGEX);
        return poolArea;
    }

    public int regexPrice() {
        int price;
        do {
            System.out.println("Price: ");
            price = Integer.parseInt(scanner.nextLine());
            if (price <= 0) {
                System.err.println("The Price Must Be A Positive Integer!!!");
            }
        } while (price <= 0);
        return price;
    }

    public int regexNumberTenants() {
        int numberTenants;
        do {
            System.out.println("Number Tenants: ");
            numberTenants = Integer.parseInt(scanner.nextLine());
            if (numberTenants <= 0 | numberTenants >= 20) {
                System.err.println("The maximum number of people must be> 0 and less than <20!!");
            }
        } while (numberTenants <= 0 | numberTenants >= 20);
        return numberTenants;
    }

    public String regexFreeService() {
        final String FREE_SERVICE_REGEX = "(massage|karaoke|food|drink|car)";
        String freeService;
        do {
            System.out.println("Free Service: ");
            freeService = scanner.nextLine();
            if (!freeService.matches(FREE_SERVICE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!freeService.matches(FREE_SERVICE_REGEX));
        return freeService;
    }

    public int regexFloors() {
        int floors;
        do {
            System.out.println("Floor: ");
            floors = Integer.parseInt(scanner.nextLine());
            if (floors <= 0) {
                System.err.println("The Floor Must Be A Positive Integer!!!");
            }
        } while (floors <= 0);
        return floors;
    }

    public String regexRentalType() {
        String rentalType;
        do {
            System.out.println("Rental Type: ");
            rentalType = scanner.nextLine();
            if (!rentalType.matches(TYPE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
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
                System.err.println("Wrong Input Format!!!");
            }
        } while (!roomStandard.matches(TYPE_REGEX));
        return roomStandard;
    }

    public String regexRoomFurniture() {
        final String ROOM_FURNITURE_REGEX = "(fully|not fully)";
        String roomFurniture;
        do {
            System.out.println("Room Furniture: ");
            roomFurniture = scanner.nextLine();
            if (!roomFurniture.matches(ROOM_FURNITURE_REGEX)) {
                System.err.println("fully or not fully furnished!!!");
            }
        } while (!roomFurniture.matches(ROOM_FURNITURE_REGEX));
        return roomFurniture;
    }

    public String regexBirthday() throws BirthdayException {
        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        int monthNow = now.getMonth() + 1;
        int dayNow = now.getDate();
        String date;
        boolean check = false;
        do {
            System.out.println("Birthday: ");
            date = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(date);
            int yearCustomer;
            int dayCustomer;
            int monthCustomer;
            if (date.matches(regex)) {
                yearCustomer = Integer.parseInt(stringBuilder.substring(6));
                dayCustomer = Integer.parseInt(stringBuilder.substring(0, 2));
                monthCustomer = Integer.parseInt(stringBuilder.substring(3, 5));
                if ((yearNow - yearCustomer) < 18) {
                    throw new BirthdayException();
                }
                if (yearNow - yearCustomer == 18) {
                    if (monthNow < monthCustomer) {
                        throw new BirthdayException();
                    } else if (monthCustomer == monthNow) {
                        if (dayNow < dayCustomer) {
                            throw new BirthdayException();
                        }
                    }
                }
                if (yearCustomer < 1900) {
                    throw new BirthdayException();
                }
                if (monthCustomer > 12) {
                    System.err.println("Max months is 12!!");
                    check = true;
                }
                switch (monthCustomer) {
                    case 2:
                        if (checkLeapYear(yearCustomer)) {
                            if (dayCustomer > 29) {
                                System.err.println("Max days is 29!!");
                                check = true;
                            }
                        } else {
                            if (dayCustomer > 28) {
                                System.err.println("Max days is 28!!");
                                check = true;
                            }
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dayCustomer > 31) {
                            System.err.println("Max days is 31!!");
                            check = true;
                        }
                        break;
                    default:
                        if (dayCustomer > 30) {
                            System.err.println("Max days is 30!!");
                            check = true;
                        }
                }
            } else {
                throw new BirthdayException();
            }
        } while (check);
        return date;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }


}
