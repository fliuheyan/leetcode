package com.cloud.leetcode.best.time.to.buy.stock;

import com.google.common.base.Preconditions;

public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int intervalMax = 0;
            for (int j = i; j < prices.length; j++) {
                int difference = prices[j] - prices[i];
                if (difference > intervalMax) {
                    intervalMax = difference;
                }
            }
            if (intervalMax > max)
                max = intervalMax;
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price - minPrice > max) {
                max = price - prices[minPrice];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        Preconditions.checkArgument(maxProfit == 5);

        int maxProfit2 = solution.maxProfit2(prices);
        System.out.println(maxProfit2);
        Preconditions.checkArgument(maxProfit2 == 5);
    }
}
