package com.cloud.leetcode.valid.anagram;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);
        if (schars.length != tchars.length) return false;
        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result1 = solution.isAnagram("anagram", "nagaram");
        Preconditions.checkArgument(result1);

        boolean result2 = solution.isAnagram("rat", "cat");
        Preconditions.checkArgument(!result2);
    }
}
