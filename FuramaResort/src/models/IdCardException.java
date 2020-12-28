package models;

public class IdCardException extends Exception {
    public IdCardException(){
        super("Id Card must have 9 digits and be in format XXX XXX XXX");
    }
}
