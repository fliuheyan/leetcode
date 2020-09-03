package com.cloud.leetcode.letter.combinations.of.phone.number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int value = Character.getNumericValue(digits.charAt(i));
            if (value == 1) {
                continue;
            }
            if (value == 9) {
                temp.add(str.substring(24));
            } else {
                temp.add(str.substring((value - 1) * 3, (value - 1) * 3 + 2));
            }
        }
        for(int i=0;i<temp.size();i++) {
            
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "23";

        System.out.println(new BigDecimal("0.000").compareTo(BigDecimal.ZERO) == 0);
    }
}