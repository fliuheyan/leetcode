package com.cloud.leetcode.twosum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] intArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    intArray[0] = i;
                    intArray[1] = j;
                }
            }
        }
        return intArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
};
