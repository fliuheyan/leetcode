package com.cloud.leetcode.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 3; first++) {
            for (int second = first + 1; second < nums.length - 2; second++) {
                int fourth = nums.length - 1;
                int temp = target - (nums[first] + nums[second]);
                for (int third = second + 1; third < nums.length - 1; third++) {
                    if (nums[third] > temp || nums[fourth] + nums[third] < temp) continue;
                    while (nums[fourth] + nums[third] > temp && fourth != third) {
                        fourth--;
                    }
                    if(third == fourth) continue;
                    if (nums[fourth] + nums[third] == temp) {
                        System.out.println("######## first " + first + "###second " + second + "###third " + third
                                + "###fourth " + fourth + "####temp " + temp);
                        result.add(List.of(nums[first], nums[second], nums[third], nums[fourth]));
                    }
                }
            }
        }
        return result;
    }

    //1,-1,-2,2
    public static void main(String[] args) {

        //{-2,-1,0,0,1,2}
        // first 0 second 1 third 4 fourth 5
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : result) {
            System.out.println(list.stream().map(Objects::toString).collect(Collectors.joining(",")));
        }
        result.stream().map(list -> list.stream().map(Object::toString).collect(Collectors.joining("")))
                .peek(System.out::println);
    }
}
