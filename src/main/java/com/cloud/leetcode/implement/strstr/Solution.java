package com.cloud.leetcode.implement.strstr;

import com.google.common.base.Preconditions;

public class Solution {
    public int strStr(String haystack, String needle) {
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (haystack.charAt(i + j) == needle.charAt(j) && j == needle.length() - 1) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.strStr("hello", "ll");
        Preconditions.checkArgument(result1 == 2);

        int result2 = solution.strStr("aaaa", "bba");
        Preconditions.checkArgument(result2 == -1);
    }
}
