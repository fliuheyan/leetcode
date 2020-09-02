package com.cloud.leetcode.letter.combinations.of.phone.number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int value = Character.getNumericValue(digits.charAt(i));
            if (value == 1) {
                continue;
            }
            if (value == 9) {
                temp.add(str.substring(24));
            } else {
                temp.add(str.substring((value - 2) * 3, (value - 2) * 3 + 3));
            }
        }
        String first = temp.get(0);
        String second = temp.get(1);
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                result.add(String.valueOf(first.charAt(i)) + String.valueOf(second.charAt(j)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "23";
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations(str);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
