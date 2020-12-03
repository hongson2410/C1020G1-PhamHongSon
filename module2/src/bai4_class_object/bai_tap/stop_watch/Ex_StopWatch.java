package bai4_class_object.bai_tap.stop_watch;

public class Ex_StopWatch {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        for (int i=1; i<1000000000; i++) {
            for (int j=1; j<1000000000; j++) {
            }
        }
        stopWatch.end();
        System.out.println( stopWatch.getElapsedTime());
    }
}
