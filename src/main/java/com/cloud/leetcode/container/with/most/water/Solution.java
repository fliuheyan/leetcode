package com.cloud.leetcode.container.with.most.water;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; i++, j--) {
            int temp = (j - i) * (Math.min(height[i], height[j]));
            if (temp > max) max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(ints);
//        assertThat();
    }
}
