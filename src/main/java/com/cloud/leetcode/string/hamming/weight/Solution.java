package com.cloud.leetcode.string.hamming.weight;

import com.google.common.base.Preconditions;

public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) result += 1;
            n >>>= 1;
        }
        return result;
    }

    // n & (n-1)

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.hammingWeight(00000000000000000000000000001011);
        int result1 = solution.hammingWeight(00000000000000000000000010000000);
//        int result2 = solution.hammingWeight(11111111111111111111111111111101);

        Preconditions.checkArgument(result == 3);
        Preconditions.checkArgument(result1 == 1);
    }
}
