package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Test200 {
    public static void main(String[] args) {
        char[] char0 = new char[]{'1','1','1','1','0'};
        char[] char1 = new char[]{'1','1','0','1','0'};
        char[] char2 = new char[]{'1','1','0','0','0'};
        char[] char3 = new char[]{'0','0','0','0','0'};
        char[][] grid = new char[4][5];
        grid[0] = char0;
        grid[1] = char1;
        grid[2] = char2;
        grid[3] = char3;
        int result = numIslands(grid);
        System.out.println(result);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                findArea(i, j, grid);
                result += 1;
            }
        }
        return result;
    }

    private static void findArea(int row, int column, char[][] grid) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
            return;
        }
        if (grid[row][column] == '0') {
           return;
        }
        grid[row][column] = '0';
        findArea(row-1, column, grid);
        findArea(row+1, column, grid);
        findArea(row, column+1, grid);
        findArea(row, column-1, grid);
    }
}
