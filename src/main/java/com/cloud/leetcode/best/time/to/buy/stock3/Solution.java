package com.cloud.leetcode.best.time.to.buy.stock3;

import com.google.common.base.Preconditions;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        return dfs(prices, 0, 0, 0);
    }

    //status 0没买, status 1买入
    //优化对于dfs(prices, index, status, times)的值进行缓存
    private int dfs(int[] prices, int index, int status, int times) {
        if (index == prices.length || times == 2) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        //不动
        if (status == 0) {
            //买入，减去当前的值
            a = dfs(prices, index + 1, 1, times) - prices[index];
        } else if (status == 1) {
            //卖出
            b = dfs(prices, index + 1, 0, times + 1) + prices[index];
        }
        //不动
        //当层节点下的不动都是一样的
        c = dfs(prices, index + 1, status, times);
        return Math.max(a, Math.max(b, c));
    }

    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int[] firstTransactionProfit = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            firstTransactionProfit[i] = prices[i] - minPrice;
        }

        int maxPrice = 0;
        int totalProfit = 0;
        for (int j = prices.length - 1; j > 0; j--) {
            maxPrice = Math.max(maxPrice, prices[j]);
            //注意这里为j-1,因为不能当天买当天卖
            totalProfit = Math.max(totalProfit, firstTransactionProfit[j - 1] + maxPrice - prices[j]);
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int result = solution.maxProfit2(prices);
        Preconditions.checkArgument(result == 6);

        int result1 = solution.maxProfit(prices);
        Preconditions.checkArgument(result1 == 6);
    }
}
