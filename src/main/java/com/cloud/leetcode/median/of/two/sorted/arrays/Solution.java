package com.cloud.leetcode.median.of.two.sorted.arrays;

import com.google.common.base.Preconditions;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0d;
        }
        if (nums1.length == 0) {
            return findMidValueFromArray(nums2);
        }
        if (nums2.length == 0) {
            return findMidValueFromArray(nums1);
        }
        int[] nums = mergeTwoSortedArrays(nums1, nums2);
        return findMidValueFromArray(nums);
    }

    private int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int left = 0, right = 0, i = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                nums[i++] = nums1[left++];
            } else {
                nums[i++] = nums2[right++];
            }
        }
        while (left < nums1.length) {
            nums[i++] = nums1[left++];
        }
        while (right < nums2.length) {
            nums[i++] = nums2[right++];
        }
        return nums;
    }

    private double findMidValueFromArray(int[] nums) {
        if (nums.length % 2 == 0) {
            return (double) (nums[(nums.length / 2) - 1] + nums[nums.length / 2]) / 2;
        } else {
            return (double) (nums[nums.length / 2]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};

        Preconditions.checkArgument(solution.findMedianSortedArrays(nums1, nums2) == 2.0000d);

        int[] nums3 = new int[]{1, 2};
        int[] nums4 = new int[]{3, 4};

        Preconditions.checkArgument(solution.findMedianSortedArrays(nums3, nums4) == 2.5000d);

        int[] nums5 = new int[]{0, 0};
        int[] nums6 = new int[]{0, 0};
        Preconditions.checkArgument(solution.findMedianSortedArrays(nums5, nums6) == 0.0000d);

        int[] nums7 = new int[]{};
        int[] nums8 = new int[]{1};
        Preconditions.checkArgument(solution.findMedianSortedArrays(nums7, nums8) == 1.0000d);

        int[] nums9 = new int[]{2};
        int[] nums10 = new int[]{};
        Preconditions.checkArgument(solution.findMedianSortedArrays(nums9, nums10) == 2.0000d);
    }
}
