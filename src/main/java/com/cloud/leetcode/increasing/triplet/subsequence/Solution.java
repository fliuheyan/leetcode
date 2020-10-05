package com.cloud.leetcode.increasing.triplet.subsequence;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        /*
        好吧，这里不要求这个递增序列是连续的
         */
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.increasingTriplet(new int[]{1, 3, 2, 5});
        Preconditions.checkArgument(result);

        boolean result2 = solution.increasingTriplet(new int[]{5, 4, 3, 2, 1});
        Preconditions.checkArgument(!result2);
    }
}
