package bai4_class_object.bai_tap.stop_watch;
import java.time.LocalTime;
public class StopWatch {
    private long startTime;
    private long endTime;

    public void start() {
        this.startTime=System.currentTimeMillis();
    }

    public void end() {
        this.endTime=System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getElapsedTime() {
        return getEndTime()-getStartTime();
    }
}
