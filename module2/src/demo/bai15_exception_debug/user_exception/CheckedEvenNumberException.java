package demo.bai15_exception_debug.user_exception;

public class CheckedEvenNumberException extends Exception {

    public CheckedEvenNumberException() {
        super("Day khong phai la so chan!!!");
//        System.err.println("Test error");
    }

    public CheckedEvenNumberException(String msg) {
        super(msg);
    }
}
