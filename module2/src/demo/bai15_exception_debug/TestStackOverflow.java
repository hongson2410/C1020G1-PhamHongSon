package demo.bai15_exception_debug;

public class TestStackOverflow {

    public static void callMain() {
        main(new String[]{});
    }


    public static void main(String[] args) {
        callMain();
    }
}
