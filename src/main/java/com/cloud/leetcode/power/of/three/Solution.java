package com.cloud.leetcode.power.of.three;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n % 3 != 0) return false;
        if (n == 3) return true;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Preconditions.checkArgument(solution.isPowerOfThree(27));

        Preconditions.checkArgument(!solution.isPowerOfThree(0));

        Preconditions.checkArgument(solution.isPowerOfThree(9));

        Preconditions.checkArgument(!solution.isPowerOfThree(45));
    }
}
