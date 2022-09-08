package kemu2;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledPoolException {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        schedule(executor);
        executor.shutdown();
    }

    static void schedule(ScheduledThreadPoolExecutor executor) {
        executor.schedule(() -> {
            int n = 1/0;
            System.out.println(n);
        }, 10, TimeUnit.NANOSECONDS);
    }
}

final class Test222 extends Thread {

    @Override
    public void run() {

    }
}
