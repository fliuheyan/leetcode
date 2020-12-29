package com.cloud.leetcode.matrix.robot.moving.count;

import com.google.common.base.Preconditions;

public class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] box = new int[m][n];
        return dfs(0, 0, k, box);
    }

    private int dfs(int row, int column, int target, int[][] box) {
        if (row < 0 || row > box.length - 1
                || column < 0 || column > box[row].length - 1
                || calculate(row, column) > target
                //not visited before
                || box[row][column] == -1) return 0;
        box[row][column] = -1;
        int result = 1;
        result += dfs(row - 1, column, target, box)
                + dfs(row + 1, column, target, box)
                + dfs(row, column - 1, target, box)
                + dfs(row, column + 1, target, box);
        return result;
    }

    public int calculateNumberByNumber(int number) {
        int result = 0;
        String numString = String.valueOf(number);
        for (int i = 0; i < numString.length(); i++) {
            result += Integer.parseInt(String.valueOf(numString.charAt(i)));
        }
        return result;
    }

    private int calculate(int row, int column) {
        return calculateNumberByNumber(row) + calculateNumberByNumber(column);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int result1 = solution.movingCount(2, 3, 1);
        Preconditions.checkArgument(result1 == 3);

        int result2 = solution.movingCount(3, 1, 0);
        Preconditions.checkArgument(result2 == 1);
    }
}
