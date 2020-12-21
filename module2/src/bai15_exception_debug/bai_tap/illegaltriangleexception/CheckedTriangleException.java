package bai15_exception_debug.bai_tap.illegaltriangleexception;

public class CheckedTriangleException extends Exception {

    public CheckedTriangleException(){
        super("Không được nhập số âm!!");
    }

    public CheckedTriangleException(String msg){
        super(msg);
    }

}
