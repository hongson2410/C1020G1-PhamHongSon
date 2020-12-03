package bai4_class_object.bai_tap.stop_watch;
import java.time.LocalTime;
public class StopWatch {
    private long startLong;
    private long endLong;



    public void start() {
        this.startLong=System.currentTimeMillis();
    }

    public void end() {
        this.endLong=System.currentTimeMillis();
    }

    public long getLongStartTime() {
        return this.startLong;
    }

    public long getLongEndTime() {
        return this.endLong;
    }

    public long getElapsedTime() {
        return getLongStartTime()-getLongEndTime();
    }
}
