package com.cloud.leetcode.single.number;

import com.google.common.base.Preconditions;

public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;
                    break;
                }
                if (j == nums.length - 1) return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Preconditions.checkArgument(solution.singleNumber(new int[]{2, 2, 1}) == 1);
        Preconditions.checkArgument(solution.singleNumber(new int[]{4, 1, 2, 1, 2}) == 4);
        Preconditions.checkArgument(solution.singleNumber(new int[]{1, 2, 1, 2, 4}) == 4);
    }
}
