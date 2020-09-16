package com.cloud.leetcode.intersection.of.two.arrays.two;

import com.google.common.base.Preconditions;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.max(nums1.length, nums2.length)];
        int k = 0;
        for (int value : nums1) {
            if (contains(nums2, value)) {
                temp[k++] = value;
            }
        }
        int[] result = new int[k];
        if (result.length >= 0) System.arraycopy(temp, 0, result, 0, result.length);
        return result;
    }

    private boolean contains(int[] nums, int num) {
        for (int value : nums) {
            if (value == num) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result1 = solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int haha : result1) {
            System.out.println(haha);
        }
        Preconditions.checkArgument(result1[0] == 4);
        Preconditions.checkArgument(result1[1] == 9);

        int[] result2 = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});

        Preconditions.checkArgument(result2[0] == 2);
        Preconditions.checkArgument(result2[1] == 2);
    }
}
