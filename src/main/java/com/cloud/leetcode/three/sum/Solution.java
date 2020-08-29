package com.cloud.leetcode.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //TODO 去重
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = 0 - nums[first];
            int third = length - 1; // third的初始值为length-1, 对于有序的数组而言,当second增大的时候,third必然要减小
            for (int second = first + 1; second < length-2; second++) {
                while (third - 1 > second && nums[third] == nums[third - 1]) {
                    third--;
                }
                while (nums[second] + nums[third] > target && third-1>second) {
                    third--;
                }
                if (third == second) break;
                if (nums[second] + nums[third] == target) {
                    result.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {// 总时间复杂度：O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    ans.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;
                    right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] sums = new int[]{-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();

//        List<List<Integer>> lists1 = solution.threeSum(sums);
//        List<String> strList1 = lists1.stream().map(list -> list.stream().map(Object::toString).collect(Collectors.joining(","))).collect(Collectors.toList());
//        for (String str : strList1) {
//            System.out.println(str);
//        }

        List<List<Integer>> lists = solution.threeSum(sums);
        List<String> strList = lists.stream().map(list -> list.stream().map(Object::toString).collect(Collectors.joining(","))).collect(Collectors.toList());
        for (String str : strList) {
            System.out.println(str);
        }

//        BigDecimal add = bigDecimal1.add(bigDecimal2);
//        System.out.println(bigDecimal1.divide(bigDecimal2, 4, RoundingMode.CEILING));
//        System.out.println(add.toString());
    }
}
