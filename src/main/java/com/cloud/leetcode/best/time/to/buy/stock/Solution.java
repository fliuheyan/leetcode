package com.cloud.leetcode.best.time.to.buy.stock;

import com.google.common.base.Preconditions;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < prices.length; i++) {
            int intervalMax = 0;
            for (int j = i; j < prices.length; j++) {
                int difference = prices[j] - prices[i];
                if (difference > intervalMax) {
                    intervalMax = difference;
                    temp1 = i;
                    temp2 = j;
                }
            }
            if (intervalMax > max)
                max = intervalMax;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        Preconditions.checkArgument(maxProfit == 5);
    }
}
