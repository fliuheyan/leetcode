package com.cloud.leetcode.maths.printNumbers;

import com.google.common.base.Preconditions;

public class Solution {
    public int[] printNumbers(int n) {
        int max = Double.valueOf(Math.pow(10, n)).intValue() - 1;
        int[] result = new int[max];
        for (int index = 0; index < max; index++) {
            result[index] = index + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.printNumbers(1);
        System.out.println(result.length);
        Preconditions.checkArgument(result.length == 9);
        Preconditions.checkArgument(result[8] == 9);
        Preconditions.checkArgument(result[0] == 1);
    }
}
