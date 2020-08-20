package com.cloud.leetcode.container.with.most.water;

import com.google.common.base.Preconditions;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 2; i++) {
            for (int j = height.length - 1; i < j; j--) {
                int temp = (j - i) * (Math.min(height[i], height[j]));
                if (temp > max) max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(ints);
        Preconditions.checkArgument(result == 49);
    }
}
