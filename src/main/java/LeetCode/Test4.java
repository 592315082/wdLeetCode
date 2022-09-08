package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Test4 {
    public static void main (String[] args){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(300, 3001);
        System.out.println(map.containsKey(300));
        for (int key : map.keySet()) {
            System.out.println(key);
        }

        Solution4 solution4 = new Solution4();
        int[][] matrix = new int[20][20];
        int result = solution4.maxSumSubmatrix(matrix, -100);
        System.out.print(result);
    }
}

class Solution4 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 固定列，进行二维数组压缩
        for (int i = 0; i < columns; i++) {
            int[] rowSum = new int[rows];
            for (int j = i; j < columns; j++) {
                for (int l = 0; l < rows; l++) {
                    rowSum[l] += matrix[l][j];
                }

                // 求rowSum连续子串的和，不大于k的和
                max = Math.max(max, getRowSumMax(rowSum, k));
            }
        }
        return max;
    }

    private int getRowSumMax(int[] rowSums, int k) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : rowSums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}