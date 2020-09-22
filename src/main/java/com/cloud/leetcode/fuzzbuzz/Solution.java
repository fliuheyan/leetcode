package com.cloud.leetcode.fuzzbuzz;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            String result = "";
            if (i % 3 == 0) {
                result += "Fizz";
            }
            if (i % 5 == 0) {
                result += "Buzz";
            }
            if (result.isEmpty()) {
                list.add(String.valueOf(i));
            } else {
                list.add(result);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.fizzBuzz(15);
        String result = strings.stream().collect(Collectors.joining(","));
        String expect = String.join(",", List.of("1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"));
        Preconditions.checkArgument(result.equals(expect));
    }
}
