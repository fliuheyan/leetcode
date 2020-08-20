package com.cloud.leetcode.longest.substring.without.repeating.characters;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = new ArrayList<>();
            list.add(chars[i]);
            for (int j = i + 1; j < chars.length && !list.contains(chars[j]); j++) {
                list.add(chars[j]);
            }
            if (list.size() > temp) {
                temp = list.size();
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
        Preconditions.checkArgument(abcabcbb == 3);

        int bbbbbb = solution.lengthOfLongestSubstring("bbbbbb");
        Preconditions.checkArgument(bbbbbb == 1);

        int pwwkew = solution.lengthOfLongestSubstring("pwwkew");
        Preconditions.checkArgument(pwwkew == 3);
    }
}
