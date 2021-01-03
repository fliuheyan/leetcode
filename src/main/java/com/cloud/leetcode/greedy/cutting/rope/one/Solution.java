package com.cloud.leetcode.greedy.cutting.rope.one;

import com.google.common.base.Preconditions;

import java.util.function.Predicate;

public class Solution {
    public int cuttingRope3(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        // 3x + y
        // y =1做特殊处理 Math.pow(3, 3x-1) * 4
        double result = 0;
        if (n % 3 == 0) {
            result = Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            result = Math.pow(3, (n / 3) - 1) * 4;
        } else {
            result = Math.pow(3, n / 3) * 2;
        }
        return Double.valueOf(result).intValue();
    }

    //每次剪绳子的时候，都会出现两个选择
    //1. i * F(n-i) 剩下的部分继续递归剪绳子
    //2. i * (n-i)  剩下的部分不再递归
    public int cuttingRopeRecursive(int n) {
        if (n == 2) return 1;
        int result = 0;

        for (int index = 2; index < n; index++) {
            int current = Math.max(index * (n - index), index * cuttingRopeRecursive(n - index));
            result = Math.max(current, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.cuttingRope(2);
        Preconditions.checkArgument(result1 == 1);

        int result2 = solution.cuttingRope(10);
        Preconditions.checkArgument(result2 == 36);

        int result3 = solution.cuttingRopeRecursive(2);
        Preconditions.checkArgument(result3 == 1);

        int result4 = solution.cuttingRopeRecursive(10);
        Preconditions.checkArgument(result4 == 36);

    }
}
