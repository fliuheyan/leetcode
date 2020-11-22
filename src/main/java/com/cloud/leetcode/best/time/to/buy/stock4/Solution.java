package com.cloud.leetcode.best.time.to.buy.stock4;

import com.google.common.base.Preconditions;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        return dfs(prices, 0, 0, 0, k);
    }

    private int dfs(int[] prices, int index, int status, int times, int maxTimes) {
        if (index == prices.length || times > maxTimes) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        //没买
        if (status == 0) {
            //买入
            b = dfs(prices, index + 1, 1, times, maxTimes) - prices[index];
        } else if (status == 1) {
            //卖出
            c = dfs(prices, index + 1, 0, times + 1, maxTimes) + prices[index];
        }
        a = dfs(prices, index + 1, status, times, maxTimes);
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {2, 4, 1};
        int result = solution.maxProfit(2, input1);
        Preconditions.checkArgument(result == 2);

        int[] input2 = {3, 2, 6, 5, 0, 3};
        int result2 = solution.maxProfit(2, input2);
        Preconditions.checkArgument(result2 == 7);
    }
}
