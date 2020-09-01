package com.cloud.leetcode.three.sum.closest;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int first = 0; first < nums.length; first++) {
            int third = nums.length - 1;
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < third; second++) {
                int total = nums[first] + nums[second] + nums[third];
                if (Math.abs(total - target)
                        < Math.abs(sum - target)) {
                    sum = total;
                }
                if (total < target) {
                    break;
                }
                if (total > target && third != second) {
                    third--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        int result = solution.threeSumClosest(nums, 1);
        System.out.println(result);
        Preconditions.checkArgument(result == 2);
    }
}
