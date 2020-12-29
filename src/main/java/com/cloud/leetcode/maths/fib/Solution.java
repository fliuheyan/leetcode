package com.cloud.leetcode.maths.fib;

import com.google.common.base.Preconditions;

public class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.fib(2);
        int result1 = solution.fib(5);
        Preconditions.checkArgument(result == 1);
        Preconditions.checkArgument(result1 == 5);
    }
}
