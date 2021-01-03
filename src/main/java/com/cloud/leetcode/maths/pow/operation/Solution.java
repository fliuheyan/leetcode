package com.cloud.leetcode.maths.pow.operation;

import com.google.common.base.Preconditions;

public class Solution {
    public double myPow1(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    //timeout
    public double myPow(double x, int n) {

        if (n == 1) return x;
        if (n == 0) return 1d;
        double result = 1d;
        int k = n > 0 ? n : -n;
        while (k > 0) {
            result *= x;
            k--;
        }
        return n > 0 ? result : 1 / result;
    }

    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        //如果n小于0，把它改为正数，并且把1/x提取出来一个
        if (n < 0)
            return 1 / x * myPow2(1 / x, -n - 1);
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println("#############");

        Solution solution = new Solution();

//        double result = solution.myPow(2.00000, 10);
//        double result1 = solution.myPow1(2.10000, 3);
        double result2 = solution.myPow2(2.00000, -10);
//        Preconditions.checkArgument(result == 1024.00000);
//        Preconditions.checkArgument(result1 == 9.26100);
//        Preconditions.checkArgument(result2 == 0.25000);
    }
}
