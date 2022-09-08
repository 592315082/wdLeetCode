package LeetCode;

import java.util.*;

public class Test264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber1(10));
    }

    public static int nthUglyNumber1(int n) {
        int[] factors = new int[]{2,3,5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        set.add(1L);
        int result = 0;
        for (int i = 0; i < n; i++) {
            long resultTemp = queue.poll();
            result = (int) resultTemp;
            for (int factor : factors) {
                long temp = resultTemp * factor;
                if (set.add(temp)) {
                    queue.offer(temp);
                }
            }
        }
        return result;
    }

    public int nthUglyNumber(int n) {
        List<Integer> list = new LinkedList<>();
        int count = 0;
        while (list.size() <= n) {
            if (isUgly(count)) {
                list.add(count);
            }
            count += 1;
        }
        return list.get(n-1);
    }

    public boolean isUgly(int n) {
        if (n == 0){
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 == 0) {
            return isUgly(n/2);
        } else if (n % 3 == 0) {
            return isUgly(n/3);
        } else if (n % 5 == 0) {
            return isUgly(n/5);
        } else {
            return false;
        }
    }

}
