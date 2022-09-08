package LeetCode;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test3 implements Serializable{
    private transient double from;
    private transient double to;
    private String id;
    private volatile double to1;
    public static void main (String[] args){
        List<String> list1 = new LinkedList<String>(){{
            add("a");
        }};
        System.out.print(6 / -132);


        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
/*
        System.out.println("使用关键字synchronized");
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();

        System.out.println(5 % 6);
        System.out.println("====================");
       char[] aa = new char[]{'A','C','Z'};
        System.out.println(aa[0]-'A');
        System.out.println(aa[1]-'A');
        System.out.println(aa[2]-'A');
        System.out.println("====================");

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        int k = queue.size();
        for (int i = 0; i < k; i++) {
            System.out.print(queue.poll());
        }*/

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.print("max : " + max + "; min : " + min);
    }

}

class SyncThread implements Runnable{
    private static int count;
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名：" + Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Solution3 {
    public int maxArea(int[] height) {
        int result = 0;
        int length = height.length;
        if (length == 0 || length == 1){
            return result;
        }

        int area = 0;
        int high = 0;
        for (int i = 0; i < length - 2; i++){
            for (int j = i + 1; j < length; j++){
                high = Math.min(height[i], height[j]);
                area = high * (j - i);
                System.out.println(height[i] + " " + height[j] + " " + (j-i) + " " + area);
                result = Math.max(result, area);
            }
        }
        return result;
    }
}