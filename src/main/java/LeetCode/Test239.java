package LeetCode;

import java.util.LinkedList;

public class Test239 {
    public static void main(String[] args) {
        int[] aa = new int[]{1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(aa, 3);
        System.out.println(111);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[] {};
        }
        int length = nums.length;
        if (k >= length) {
            int maxNum = nums[findMaxNum(nums, 0, length - 1)];
            return new int[] {maxNum};
        }
        if (k == 1) {
            return nums;
        }

        int resultArrayLength = length - k + 1;
        int[] result = new int[resultArrayLength];

        int left = 0;
        int right = k - 1;
        int maxIndex = findMaxNum(nums, left, right);
        int maxNum = nums[maxIndex];
        boolean containFlag = true;
        while (right <= length - 1) {

            if (!containFlag) {
                maxIndex = findMaxNum(nums, left, right);
                maxNum = nums[maxIndex];
                result[left] = maxNum;
                left = left + 1;
                right = right + 1;
                continue;
            }

            if (nums[right] >= maxNum) {
                maxIndex = right;
                maxNum = nums[maxIndex];
                result[left] = maxNum;
                left = left + 1;
                right = right + 1;
            } else {
                result[left] = maxNum;
                left = left + 1;
                right = right + 1;
                if (left > maxIndex) {
                    containFlag = false;
                }
            }


        }
        return result;
    }

    private static int findMaxNum(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

}
