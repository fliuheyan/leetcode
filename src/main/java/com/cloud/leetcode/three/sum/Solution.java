package com.cloud.leetcode.three.sum;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            int target = 0 - nums[first];
            int third = length - 1; // third的初始值为length-1, 对于有序的数组而言,当second增大的时候,third必然要减小
            for (int second = 0; second < length; second++) {

            }
        }
    }

    public static void main(String[] args) {
    }
}
