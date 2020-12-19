package com.cloud.leetcode.array.find.repeat.number;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public class Solution {

    //空间o(n)
    public int findRepeatNumber(int[] nums) {
        int result = -1;
        //用一个新的数据，原数组的值，指向新数组的下标
        int[] temp = new int[nums.length];
        for (int num : nums) {
            //找到一个nums数组中的值，对应temp下标的值+1，如果temp对应下标的值>1说明有重复
            temp[num]++;
            if (temp[num] > 1) return num;
        }
        return result;
    }

    //空间o(1)
    //先排序
    //之后比较index和当前数组的值是否一样，不一样则交换，然后判断与要交换的值是否相同
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                if (nums[index] == nums[nums[index]]) return nums[index];
                int temp = nums[nums[index]];
                nums[nums[index]] = nums[index];
                nums[index] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 0, 2, 5, 3};
        Solution solution = new Solution();
        int result = solution.findRepeatNumber(input);
        Preconditions.checkArgument(result == 2 || result == 3);

        int result1 = solution.findRepeatNumber1(input);
        Preconditions.checkArgument(result1 == 2 || result1 == 3);
    }
}
