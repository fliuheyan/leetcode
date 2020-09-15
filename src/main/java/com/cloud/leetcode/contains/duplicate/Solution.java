package com.cloud.leetcode.contains.duplicate;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Preconditions.checkArgument(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
        Preconditions.checkArgument(!solution.containsDuplicate(new int[]{1, 2, 3, 4}));
        Preconditions.checkArgument(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
