package com.cloud.leetcode.remove.duplicates.from.sorted.array;

import com.google.common.base.Preconditions;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int temp = 0, result = 0, curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                temp++;
            } else {
                result += temp;
                temp = 0;
                curr = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = new int[]{1, 1, 2};
        Preconditions.checkArgument(solution.removeDuplicates(nums1) == 1);

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Preconditions.checkArgument(solution.removeDuplicates(nums2) == 5);
    }
}
