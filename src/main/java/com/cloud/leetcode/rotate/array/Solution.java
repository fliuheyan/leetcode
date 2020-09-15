package com.cloud.leetcode.rotate.array;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        return Arrays.stream(result).boxed().map(Object::toString).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Preconditions.checkArgument(solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)
                .equals("5,6,7,1,2,3,4"));

        Preconditions.checkArgument(solution.rotate(new int[]{-1,-100,3,99},
                2).equals("3,99,-1,-100"));
    }
}
