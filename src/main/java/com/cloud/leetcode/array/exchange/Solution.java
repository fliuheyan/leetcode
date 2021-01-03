package com.cloud.leetcode.array.exchange;

public class Solution {
    public int[] exchange(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            while (!isEven(nums[begin]) && begin < end) begin++;
            while (isEven(nums[end]) && begin < end) end--;
            if (begin < end) {
                int temp = 0;
                temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }

    //TODO 快慢指针

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
