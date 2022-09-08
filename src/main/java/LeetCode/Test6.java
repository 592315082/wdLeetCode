package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test6 {
    public static void main (String[] args){
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(heights));
    }


    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        int ans = 0;
        int nums = heights.length;
        int leftPoint = 0;
        int rightPoint = 0;
        for (int i = 0; i < nums; i++) {
            if (i == 0 || i == nums - 1) {
                ans = Math.max(ans, heights[i]);
            }
            leftPoint = i - 1;
            while (leftPoint >= 0) {
                ans = getLargestArea(i, leftPoint, heights, ans);
                leftPoint--;
            }
            rightPoint = i + 1;
            while (rightPoint <= nums - 1) {
                ans = getLargestArea(rightPoint, i, heights, ans);
                rightPoint++;
            }
        }
        return ans;
    }

    private static int getLargestArea(int rightElem, int leftElem, int[] heights, int ans) {
        int distance = rightElem - leftElem + 1;
        ans = Math.max(ans, heights[rightElem]);
        int min = Integer.MAX_VALUE;
        for (int i = rightElem; i >= leftElem; i--) {
            min = Math.min(min, heights[i]);
        }
        ans = Math.max(ans, distance*min);
        return ans;
    }

    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                System.out.println("i="+i+";heights[i]="+heights[i]);
                System.out.println("stack.peekLast()="+stack.peekLast()+";heights[stack.peekLast()]="+heights[stack.peekLast()]);
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                //System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

}