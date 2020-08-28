package com.cloud.leetcode.three.sum;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < length-3; first++) {
            int target = 0 - nums[first];
            int third = length - 1; // third的初始值为length-1, 对于有序的数组而言,当second增大的时候,third必然要减小
            for (int second = first + 1; second < length-2; second++) {
                while (third - 1 > second && nums[third] == nums[third - 1]) {
                    third--;
                }
                while (nums[second] + nums[third] > target && third-1>second) {
                    third--;
                }
                if (third < second) continue;
                if (nums[second] + nums[third] == target) {
                    result.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] sums = new int[]{-1, 0, 1, 2, -1, -4};
//        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.threeSum1(sums);
//        List<String> strList = lists.stream().map(list -> list.stream().map(Object::toString).collect(Collectors.joining(","))).collect(Collectors.toList());
//        strList.stream().peek(System.out::println);
//        BigDecimal bigDecimal2 = new BigDecimal(10);

        List.of("123123","112313").stream().peek(a -> System.out.println(a));
System.out.println("#############");
        List<String> l = List.of("A", "B", "C", "D");

        long count = l.stream().peek(System.out::println).count();
//        BigDecimal add = bigDecimal1.add(bigDecimal2);
//        System.out.println(bigDecimal1.divide(bigDecimal2, 4, RoundingMode.CEILING));
//        System.out.println(add.toString());
    }
}
