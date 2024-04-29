package paulomon;

import java.util.concurrent.TimeUnit;

public class SleepTimer {
    public void sleep(int mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
