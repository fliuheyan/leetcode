package com.cloud.leetcode.set.matrix.zeroes;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] setZeroes(int[][] matrix) {
        List<Integer> rowList = new ArrayList<Integer>();
        List<Integer> columnList = new ArrayList<Integer>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    rowList.add(row);
                    columnList.add(column);
                }
            }
        }
        for (Integer row : rowList) {
            setRowZero(row, matrix);
        }
        for (Integer column : columnList) {
            setColumnZero(column, matrix);
        }
        return matrix;
    }

    private void setColumnZero(Integer column, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][column] = 0;
        }
    }

    private void setRowZero(Integer row, int[][] matrix) {
        for (int column = 0; column < matrix[row].length; column++) {
            matrix[row][column] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result1 = solution.setZeroes(matrix1);
        Preconditions.checkArgument(result1.length == 3);
        Preconditions.checkArgument(result1[0][0] == 1);
        Preconditions.checkArgument(result1[0][1] == 0);
        Preconditions.checkArgument(result1[0][2] == 1);
        Preconditions.checkArgument(result1[1][0] == 0);
        Preconditions.checkArgument(result1[1][1] == 0);
        Preconditions.checkArgument(result1[1][2] == 0);
        Preconditions.checkArgument(result1[2][0] == 1);
        Preconditions.checkArgument(result1[2][1] == 0);
        Preconditions.checkArgument(result1[2][2] == 1);

        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] result2 = solution.setZeroes(matrix2);
        Preconditions.checkArgument(result2.length == 3);
        Preconditions.checkArgument(result2[0][0] == 0);
        Preconditions.checkArgument(result2[0][1] == 0);
        Preconditions.checkArgument(result2[0][2] == 0);
        Preconditions.checkArgument(result2[0][3] == 0);
        Preconditions.checkArgument(result2[1][0] == 0);
        Preconditions.checkArgument(result2[1][1] == 4);
        Preconditions.checkArgument(result2[1][2] == 5);
        Preconditions.checkArgument(result2[1][3] == 0);
        Preconditions.checkArgument(result2[2][0] == 0);
        Preconditions.checkArgument(result2[2][1] == 3);
        Preconditions.checkArgument(result2[2][2] == 1);
        Preconditions.checkArgument(result2[2][3] == 0);
    }
}
