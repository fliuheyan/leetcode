package com.cloud.leetcode.move.zeros;

import com.cloud.leetcode.helper.DisplayHelper;
import com.google.common.base.Preconditions;

public class Solution {
//    public int[] moveZeroes(int[] nums) {
//        int k = nums.length - 1;
//        for (int i = 0; i < k; i++) {
//            while (nums[k] == 0 && k > 0) k--;
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[k];
//                nums[k--] = temp;
//            }
//        }
//        return nums;
//    }

    public int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            if (nums[i] != 0) {
                result[k++] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.moveZeroes(new int[]{0, 1, 0, 3, 12});

        DisplayHelper.displayIntArray(result);

        Preconditions.checkArgument(result[3] == 0);
        Preconditions.checkArgument(result[4] == 0);
    }
}
