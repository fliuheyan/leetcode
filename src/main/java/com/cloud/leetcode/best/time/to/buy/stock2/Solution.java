package com.cloud.leetcode.best.time.to.buy.stock2;

import com.google.common.base.Preconditions;

public class Solution {
    int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minPrice = 0;
        int accumulateProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((i == 0 || prices[i - 1] > prices[i]) && (i == prices.length - 1 || prices[i + 1] > prices[i])) {
                minPrice = prices[i];
            }
            if (i > 0 && prices[i] > prices[i - 1] && (i == prices.length - 1 || prices[i + 1] < prices[i])) {
                accumulateProfit += prices[i] - minPrice;
            }
        }
        return accumulateProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {7, 1, 5, 3, 6, 4};
        int[] ints1 = {1, 2, 3, 4, 5};
        int[] ints2 = {7, 6, 4, 3, 1};

        int maxProfit = solution.maxProfit(ints);
        int maxProfit1 = solution.maxProfit(ints1);
        int maxProfit2 = solution.maxProfit(ints2);
        Preconditions.checkArgument(maxProfit == 7);
        Preconditions.checkArgument(maxProfit1 == 4);
        Preconditions.checkArgument(maxProfit2 == 0);
    }
}
