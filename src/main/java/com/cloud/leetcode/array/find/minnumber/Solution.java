package com.cloud.leetcode.array.find.minnumber;

import com.google.common.base.Preconditions;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findMin(new int[]{3, 4, 5, 1, 2});
        Preconditions.checkArgument(result == 1);

        int result1 = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        Preconditions.checkArgument(result1 == 0);

        int result2 = solution.findMin(new int[]{1});
        Preconditions.checkArgument(result2 == 1);
    }
}
