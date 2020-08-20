package com.cloud.leetcode.longest.palindromic.substring;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //String.replace
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String temp = "";
        if (chars.length == 1) return s;
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < chars.length; j++) {
                list.add(chars[j]);
                if (isPalindrome(list)) {
                    if (list.size() > temp.length()) {
                        temp = list.stream().map(String::valueOf).collect(Collectors.joining());
                    }
                }
            }
        }
        return temp;
    }

    public boolean isPalindrome(List<Character> chars) {
        if (chars.size() == 1) return true;
        for (int i = 0, j = chars.size() - 1; j > i; i++, j--) {
            if (chars.get(i) != chars.get(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String babad = solution.longestPalindrome("babad");
        Preconditions.checkArgument(babad.equals("bab"));

        String cbbd = solution.longestPalindrome("cbbd");
        Preconditions.checkArgument(cbbd.equals("bb"));
    }
}
