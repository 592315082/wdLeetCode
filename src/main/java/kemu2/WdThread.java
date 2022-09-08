package kemu2;

public class WdThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");



/*        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        System.out.println("1111111111111");
        Thread t2 = new Thread(() -> {
            System.out.println("inner thread : start new thread");
        });
        t2.start();
        t2.join();*/

        System.out.println("1111111111111");
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();

/*        System.out.println("1111111111111");
        Hello2Thread hello2Thread = new Hello2Thread();
        hello2Thread.start();
        Thread.sleep(100);
        hello2Thread.running = false;*/

        System.out.println("main end");
    }
}
//================================================================
class MyThread extends Thread {
    //对目标线程调用interrupt()方法可以请求中断一个线程，目标线程通过检测isInterrupted()标志获取自身是否已中断。
    // 如果目标线程处于等待状态，该线程会捕获到InterruptedException；
    @Override
    public void run() {
        System.out.println("MyThread : start new thread");
        HelloThread helloThread = new HelloThread();

        helloThread.start();
        try {
            helloThread.join();
        } catch (InterruptedException e) {
            System.out.println("helloThread : interrupted");
        }
        helloThread.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("HelloThread : start new thread");
        int n = 0;
        while (! isInterrupted()) {
            n++;
            System.out.println( n + " : HelloThread!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("666666666666");
                break;
            }
        }

    }
}
//=============================================================
class Hello2Thread extends Thread {

    public volatile boolean running = true;

    @Override
    public void run() {
        System.out.println("Hello2Thread : new thread");
        int n = 0;
        while (running) {
            n++;
            System.out.println( n + " : Hello2Thread !");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello2Thread : end");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable : start new thread");
        //int i = 2 / 0;
    }
}