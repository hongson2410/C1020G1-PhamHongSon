package bai15_exception_debug.bai_tap.illegaltriangleexception;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(){
        super("Không được nhập số âm!!");
    }

    public IllegalTriangleException(String msg){
        super(msg);
    }

}
