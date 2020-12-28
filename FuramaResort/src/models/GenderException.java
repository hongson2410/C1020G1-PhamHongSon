package models;

public class GenderException extends Exception {
    public GenderException(){
        super("must enter Male, Female or Unknown");
    }
}
