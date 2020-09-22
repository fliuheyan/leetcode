package com.cloud.leetcode.count.primes;

import com.google.common.base.Preconditions;

public class Solution {
    public int countPrimes(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) result++;
        }
        return result;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && i != n) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int primes = solution.countPrimes(10);
        Preconditions.checkArgument(primes == 4);
    }
}
