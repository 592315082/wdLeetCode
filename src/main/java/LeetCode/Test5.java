package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Test5 {
    public static void main(String[] args){
        int[] height = {0,0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    // 接雨水 傻逼栈
    public static int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            if (current == 8) {
                System.out.println("111");
            }
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }


    // 接雨水 nice方法
    public static int trap2(int[] height) {
        if (height == null || height.length <= 0) {
            return 0;
        }
        int length = height.length;
        int ans = 0;
        int[] arrayLeft = new int[length];
        arrayLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            arrayLeft[i] = Math.max(height[i], arrayLeft[i-1]);
        }
        int[] arrayRight = new int[length];
        arrayRight[length-1] = height[length-1];
        for (int i = length-2; i >= 0; i--) {
            arrayRight[i] = Math.max(height[i], arrayRight[i+1]);
        }
        for (int i = 0; i < length; i++) {
            ans += Math.min(arrayLeft[i], arrayRight[i]) - height[i];
        }
        return ans;
    }
}
