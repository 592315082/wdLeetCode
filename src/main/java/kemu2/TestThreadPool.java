package kemu2;

import javafx.concurrent.ScheduledService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        es.shutdown();

        //ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        //ses.schedule(new Task("one-time"), 1 , TimeUnit.SECONDS);
        //ses.scheduleAtFixedRate(new Task("fixed-rate"), 2 ,3, TimeUnit.SECONDS);
        //ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
        //ses.shutdown();
    }
}

class Task implements Runnable {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}
