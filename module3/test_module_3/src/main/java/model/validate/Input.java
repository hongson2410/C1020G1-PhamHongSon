package model.validate;

public class Input {

    public boolean inputString(String string) {
        return !string.equals("");
    }

    public boolean inputInt(String num) throws NullPointerException{
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public boolean inputDouble(String num) throws NullPointerException{
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
