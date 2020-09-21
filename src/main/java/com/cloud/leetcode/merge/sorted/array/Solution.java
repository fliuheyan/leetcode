package com.cloud.leetcode.merge.sorted.array;

import com.google.common.base.Preconditions;

public class Solution {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        for (int index2 = 0; index2 < n; index2++) {
            while (nums2[index2] > nums1[index1] && nums1[index1] != 0) index1++;
            if (nums1[index1] != 0) {
                for (int k = m + index2; k > index1; k--) {
                    nums1[k] = nums1[k - 1];
                }
            }
            nums1[index1++] = nums2[index2];
        }
        return nums1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        Preconditions.checkArgument(result.length == 6);
        Preconditions.checkArgument(result[0] == 1);
        Preconditions.checkArgument(result[1] == 2);
        Preconditions.checkArgument(result[2] == 2);
        Preconditions.checkArgument(result[3] == 3);
        Preconditions.checkArgument(result[4] == 5);
        Preconditions.checkArgument(result[5] == 6);
    }
}
