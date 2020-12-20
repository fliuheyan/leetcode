package com.cloud.leetcode.array.find.number.in.twod.array;

import com.google.common.base.Preconditions;

public class Solution {
    //int[outer][inner]
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int outer = 0; outer < matrix.length; outer++) {
            for (int inner = 0; inner < matrix[outer].length; inner++) {
                if (matrix[outer][inner] == target) return true;
            }
        }
        return false;
    }

    //以二维数组右上角为root，可以将其看成binary search tree
    //int[row][column]
    //从int[0][column]位置开始，如果目标值大于当前，则向下搜索，小于则向
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column > 0) {
            if (matrix[row][column] == target)
                return true;
            else if (target > matrix[row][column])
                row++;
            else column--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        Solution solution = new Solution();
        boolean result1 = solution.findNumberIn2DArray(matrix, 5);
        boolean result2 = solution.findNumberIn2DArray(matrix, 20);

        Preconditions.checkArgument(result1);
        Preconditions.checkArgument(!result2);

        boolean result3 = solution.findNumberIn2DArray1(matrix, 5);
        boolean result4 = solution.findNumberIn2DArray1(matrix, 20);
        Preconditions.checkArgument(result3);
        Preconditions.checkArgument(!result4);

    }
}
